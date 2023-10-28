package codyhuh.unusualfishmod.common.item;

import codyhuh.unusualfishmod.core.registry.UFTiers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
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

// todo - fix
public class RipsawItem extends AxeItem implements Vanishable {

    public RipsawItem(Properties p_41383_) {
        super(UFTiers.RIPPER_SAW, 5.0F, -1.0F, p_41383_);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.BOW;
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity user, int count) {
        if (user instanceof Player player) {
            if (count % 10 == 0) {
                EntityHitResult result = getLookAtEntity(player, player.level, player.getReachDistance());

                if (result != null && result.getEntity() instanceof LivingEntity living) {
                    living.hurt(DamageSource.playerAttack(player), getAttackDamage());

                    stack.hurtAndBreak(1, player, (p_40665_) -> {
                        p_40665_.broadcastBreakEvent(living.getUsedItemHand());
                    });
                }
            }
        }

    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return super.use(level, player, hand);
    }

    public static EntityHitResult getLookAtEntity(Player player, Level level, double range) {
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 viewVec = player.getViewVector(1.0F);
        Vec3 endVec = eyePos.add(viewVec.x * range, viewVec.y * range, viewVec.z * range);

        return ProjectileUtil.getEntityHitResult(level, player, eyePos, endVec, player.getBoundingBox().inflate(range), e -> e instanceof LivingEntity);
    }

}
