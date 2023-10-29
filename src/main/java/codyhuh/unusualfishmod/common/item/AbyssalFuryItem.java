package codyhuh.unusualfishmod.common.item;

import codyhuh.unusualfishmod.common.entity.item.AbyssalBlast;
import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import com.mojang.math.Vector3f;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public class AbyssalFuryItem extends Item {
    public static final Predicate<ItemStack> GLOGEL = (stack) -> stack.is(UFItems.GLO_GEL.get());

    public AbyssalFuryItem(Item.Properties properties) {
        super(properties);
    }

    public int getUseDuration(ItemStack stack) {
        return isUsable(stack) ? Integer.MAX_VALUE : 0;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamageValue() < stack.getMaxDamage() - 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        playerIn.startUsingItem(handIn);

        if(!isUsable(itemstack)){
            ItemStack ammo = findAmmo(playerIn);
            boolean flag = playerIn.isCreative();
            if(!ammo.isEmpty()){
                ammo.shrink(1);
                flag = true;
            }
            if(flag){
                itemstack.setDamageValue(0);
            }
        }

        return InteractionResultHolder.consume(itemstack);
    }

    public ItemStack findAmmo(Player entity) {
        if(entity.isCreative()){
            return ItemStack.EMPTY;
        }
        for(int i = 0; i < entity.getInventory().getContainerSize(); ++i) {
            ItemStack itemstack1 = entity.getInventory().getItem(i);
            if (GLOGEL.test(itemstack1)) {
                return itemstack1;
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return !oldStack.sameItem(newStack);
    }

    public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
        if(isUsable(stack)) {
            if (count % 30 == 0) {
                boolean left = false;
                if (livingEntityIn.getUsedItemHand() == InteractionHand.OFF_HAND && livingEntityIn.getMainArm() == HumanoidArm.RIGHT || livingEntityIn.getUsedItemHand() == InteractionHand.MAIN_HAND && livingEntityIn.getMainArm() == HumanoidArm.LEFT) {
                    left = true;
                }
                AbyssalBlast blast = new AbyssalBlast(worldIn, livingEntityIn, !left);
                Vec3 vector3d = livingEntityIn.getViewVector(1.0F);
                Vector3f vector3f = new Vector3f(vector3d);
                RandomSource rand = livingEntityIn.getRandom();
                livingEntityIn.playSound(UFSounds.ABYSSAL_BLAST.get(),1.0F, 0.5F + (rand.nextFloat() - rand.nextFloat()) * 0.2F);
                blast.shoot(vector3f.x(), vector3f.y(), vector3f.z(), 0.6F, 1);
                if (!worldIn.isClientSide) {
                    worldIn.addFreshEntity(blast);
                }
                stack.hurtAndBreak(1, livingEntityIn, (player) -> {
                    player.broadcastBreakEvent(livingEntityIn.getUsedItemHand());
                });
            }
        }
        else {
            if(livingEntityIn instanceof Player){
                ItemStack ammo = findAmmo((Player)livingEntityIn);
                boolean flag = ((Player) livingEntityIn).isCreative();
                if(!ammo.isEmpty()){
                    ammo.shrink(1);
                    flag = true;
                }
                if(flag){
                    ((Player) livingEntityIn).getCooldowns().addCooldown(this, 20);
                    stack.setDamageValue(0);
                }
                livingEntityIn.stopUsingItem();
            }
        }
    }
}
