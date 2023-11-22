package codyhuh.unusualfishmod.common.item;

import codyhuh.unusualfishmod.core.registry.UFSounds;
import codyhuh.unusualfishmod.core.registry.UFTiers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class RipsawItem extends AxeItem implements Vanishable {

    public RipsawItem(Properties p_41383_) {
        super(UFTiers.RIPPER_SAW, 5.0F, -1.0F, p_41383_);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.BOW;
    }

    @Override
    public void onUseTick(Level level, LivingEntity user, ItemStack stack, int count) {
        if (user instanceof Player player) {
            EntityHitResult result = getLookAtEntity(player, player.level(), player.getEntityReach() + 1.0D);
            CompoundTag tag = stack.getOrCreateTag();

            float i = count % 10;
            float progress = i / 10;

            tag.putFloat("SawingProgress", progress);

            if (result != null && result.getEntity() instanceof LivingEntity living) {
                if (count % 15 == 0) {
                    player.playSound(UFSounds.SAWING.get());
                }

                if (living.hurt(player.damageSources().playerAttack(player), getAttackDamage())) {
                    stack.hurtAndBreak(1, player, (p_40665_) -> {
                        p_40665_.broadcastBreakEvent(living.getUsedItemHand());
                    });
                }
            }
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, Level p_41405_, Entity p_41406_, int p_41407_, boolean held) {
        if (!held) {
            stack.getOrCreateTag().putFloat("SawingProgress", 0.0F);
        }
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide()) {
            player.startUsingItem(hand);
        }

        return super.use(level, player, hand);
    }

    @Override
    public int getUseDuration(ItemStack p_41454_) {
        return 72000;
    }

    public static EntityHitResult getLookAtEntity(Player player, Level level, double range) {
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 viewVec = player.getViewVector(1.0F);
        Vec3 endVec = eyePos.add(viewVec.x * range, viewVec.y * range, viewVec.z * range);

        return ProjectileUtil.getEntityHitResult(level, player, eyePos, endVec, player.getBoundingBox().inflate(range), e -> e instanceof LivingEntity);
    }

}
