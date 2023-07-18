package com.peeko32213.unusualfishmod.common.item.tools.whips;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.peeko32213.unusualfishmod.core.init.UnusualFishCapabilities;
import com.peeko32213.unusualfishmod.core.init.UnusualFishItems;
import com.peeko32213.unusualfishmod.core.init.UnusualFishSounds;
import com.peeko32213.unusualfishmod.core.network.UnusualFishNetworkHandler;
import com.peeko32213.unusualfishmod.core.network.WhipReachPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;
import java.awt.*;

public class UnusualFishWhipItem extends TieredItem implements Vanishable {
    private final float attackDamage;
    private final float attackSpeed;
    private LazyOptional<IWhipUpdate> whipUpdate = LazyOptional.empty();

    public UnusualFishWhipItem(Tier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builderIn){
        super(tier, builderIn);
        this.attackDamage = attackDamageIn + tier.getAttackDamageBonus();
        this.attackSpeed = attackSpeedIn;
    }

    @Override
    public void fillItemCategory (CreativeModeTab tab, NonNullList< ItemStack > items){
        if (this.allowdedIn(tab)) {
            ItemStack itemStack = new ItemStack(this);
            if (itemStack.is(UnusualFishItems.TENDRIL_WHIP.get())) {
                itemStack.enchant(Enchantments.SHARPNESS, 1);
            }

            items.add(itemStack);
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        stack.serializeNBT();
        stack.enchant(Enchantments.SHARPNESS, 1);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return false;
    }

    @Override
    public void releaseUsing (ItemStack stack, Level worldIn, LivingEntity entityLiving, int timeLeft){
        if (entityLiving instanceof Player player) {
            setCharging(stack, false);

            int ticksSinceStart = this.getUseDuration(stack) - timeLeft;

            if (ticksSinceStart < 0 || getTicksSinceAttack(stack) < 15) {
                setTicksSinceAttack(stack, 0);
                return;
            } else {
                setAttacking(stack, true);
                setTicksSinceAttack(stack, 18);
            }

            worldIn.playSound(player, player.getX(), player.getY(), player.getZ(), UnusualFishSounds.WHIP_CRACK.get(), SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F));
            player.awardStat(Stats.ITEM_USED.get(this));

            if (!worldIn.isClientSide()) {
                UnusualFishNetworkHandler.sendToServer(new WhipReachPacket(player.getUUID()));
            }
        }
    }

    @Override
    public UseAnim getUseAnimation (ItemStack stack){
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration (ItemStack stack){
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use (Level worldIn, Player playerIn, InteractionHand handIn){
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (handIn.equals(InteractionHand.MAIN_HAND)) {
            playerIn.startUsingItem(handIn);
        }
        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void onUsingTick (ItemStack stack, LivingEntity player,int count){
        if (getAttacking(stack)) {
            setTicksSinceAttack(stack, 0);
            setAttacking(stack, false);
        }

        setCharging(stack, true);
    }

    @Override
    public void inventoryTick (ItemStack stack, Level level, Entity entity, int itemSlot, boolean isSelected){
        if ((getCharging(stack) && getTicksSinceAttack(stack) <= 15) || getAttacking(stack)) {
            setTicksSinceAttack(stack, getTicksSinceAttack(stack) + 1);
        }

        if (getTicksSinceAttack(stack) >= 30 || (!isSelected && entity instanceof Player player && player.getOffhandItem() != stack)) {
            setTicksSinceAttack(stack, 0);
            setAttacking(stack, false);
            setCharging(stack, false);
        }
    }

    @Override
    public boolean canAttackBlock (BlockState state, Level worldIn, BlockPos pos, Player player){
        return !player.isCreative();
    }

    @Override
    public boolean hurtEnemy (ItemStack stack, LivingEntity target, LivingEntity attacker){
        super.hurtEnemy(stack, target, attacker);
        stack.hurtAndBreak(1, attacker, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean mineBlock (ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving){
        if (state.getDestroySpeed(worldIn, pos) != 0.0F) {
            stack.hurtAndBreak(2, entityLiving, (entity) -> entity.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        }

        return true;
    }

    @Override
    public float getDestroySpeed (ItemStack stack, BlockState state) {
        Material material = state.getMaterial();
        return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !state.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : 1.5F;
    }

    @Override
    public boolean canApplyAtEnchantingTable (ItemStack stack, Enchantment enchantment) {
        return enchantment.category == (EnchantmentCategory.WEAPON);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers (EquipmentSlot equipmentSlot, ItemStack itemStack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
        attributeBuilder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        attributeBuilder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
        Multimap<Attribute, AttributeModifier> attributes = attributeBuilder.build();
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributes : super.getAttributeModifiers(equipmentSlot, itemStack);
    }

    private LazyOptional<IWhipUpdate> getWhipUpdate (ItemStack itemStack){
        if (!whipUpdate.isPresent()) {
            whipUpdate = itemStack.getCapability(UnusualFishCapabilities.WHIP_UPDATE);
            whipUpdate.addListener(self -> LazyOptional.empty());
        }

        return whipUpdate;
    }

    public void setTicksSinceAttack (ItemStack itemStack,int ticksSinceAttack){
        getWhipUpdate(itemStack).ifPresent(whipUpdate -> whipUpdate.setTicksSinceAttack(ticksSinceAttack));
    }

    public int getTicksSinceAttack (ItemStack itemStack){
        IWhipUpdate whipUpdate = getWhipUpdate(itemStack).orElse(null);
        return whipUpdate.getTicksSinceAttack();
    }

    public void setAttacking (ItemStack itemStack,boolean attacking){
        getWhipUpdate(itemStack).ifPresent(whipUpdate -> whipUpdate.setAttacking(attacking));
    }

    public boolean getAttacking (ItemStack itemStack){
        IWhipUpdate whipUpdate = getWhipUpdate(itemStack).orElse(null);
        return whipUpdate.getAttacking();
    }

    public void setCharging (ItemStack itemStack,boolean charging){
        getWhipUpdate(itemStack).ifPresent(whipUpdate -> whipUpdate.setCharging(charging));
    }

    public boolean getCharging (ItemStack itemStack){
        IWhipUpdate whipUpdate = getWhipUpdate(itemStack).orElse(null);
        return whipUpdate.getCharging();
    }

}

