package codyhuh.unusualfishmod.common.item;

import codyhuh.unusualfishmod.common.entity.item.FallingTreeBlockEntity;
import codyhuh.unusualfishmod.common.entity.util.misc.MovingBlockData;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import codyhuh.unusualfishmod.core.registry.UFTags;
import codyhuh.unusualfishmod.core.registry.UFTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

// Tree chopping code adapted from Alex's Caves (licensed under GNU GPLv3)
public class RipsawItem extends AxeItem implements Vanishable {

    public RipsawItem(Properties p_41383_) {
        super(UFTiers.RIPPER_SAW, 7.0F, -1.0F, p_41383_);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.BRUSH;
    }

    @Override
    public InteractionResult useOn(UseOnContext cntxt) {
        Player player = cntxt.getPlayer();
        Level level = cntxt.getLevel();
        BlockPos blockPos = cntxt.getClickedPos();
        BlockState state = cntxt.getLevel().getBlockState(blockPos);

        if (!player.isShiftKeyDown() && state.is(BlockTags.LOGS) && !level.getBlockState(blockPos.below()).is(BlockTags.LOGS)) {
            player.startUsingItem(cntxt.getHand());
            return InteractionResult.SUCCESS;
        }
        return super.useOn(cntxt);
    }

    public void gatherAttachedBlocks(LivingEntity player, BlockPos origin, BlockPos pos, List<BlockPos> list) {
        if (list.size() < 300) {
            if (!list.contains(pos)) {
                list.add(pos);
                for (BlockPos blockpos1 : BlockPos.betweenClosed(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) {
                    if (!blockpos1.equals(pos) && pos.distToCenterSqr(origin.getX(), pos.getY(), origin.getZ()) < 10) {
                        if (isTreePart(player, blockpos1)) {
                            gatherAttachedBlocks(player, origin, blockpos1.immutable(), list);
                        }
                    }
                }
            }
        }
    }

    public boolean isTreePart(LivingEntity player, BlockPos pos) {
        BlockState state = player.level().getBlockState(pos);
        if (state.isAir() || state.is(UFTags.UNCHOPPABLE)) {
            return false;
        } else {
            return state.is(BlockTags.LOGS) || state.is(BlockTags.LEAVES);
        }
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> componentList, TooltipFlag p_41424_) {
        componentList.add(Component.translatable("tooltip.ripsaw").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
    }

    @Override
    public void onUseTick(Level level, LivingEntity user, ItemStack stack, int remainingUseDuration) {
        if (user instanceof Player player) {
            HitResult hitResult = calculateHitResult(player);

            if (hitResult instanceof BlockHitResult blockHitResult && hitResult.getType() == HitResult.Type.BLOCK) {
                BlockState state = level.getBlockState(blockHitResult.getBlockPos());
                BlockPos blockPos = blockHitResult.getBlockPos();
                Direction face = blockHitResult.getDirection();
                int i = this.getUseDuration(stack) - remainingUseDuration + 1;

                if (state.is(BlockTags.LOGS) && !level.getBlockState(blockPos.below()).is(BlockTags.LOGS)) {
                    List<BlockPos> gathered = new ArrayList<>();
                    gatherAttachedBlocks(player, blockPos, blockPos, gathered);

                    level.destroyBlockProgress(user.getId(), blockPos, i);

                    if (i >= getDestroySpeed(stack, state) * 1.65F && !gathered.isEmpty()) {
                        Vec3 basePos = blockPos.getCenter();
                        double x = basePos.x() + (face.getStepX() * 0.75D);
                        double y = basePos.y();
                        double z = basePos.z() + (face.getStepZ() * 0.75D);

                        level.destroyBlockProgress(user.getId(), blockPos, -1);

                        for (int j = 0; j < 20; j++) {
                            int negative = level.random.nextBoolean() ? -1 : 1;

                            level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, state), x, y, z, face.getStepZ() * level.random.nextFloat() * negative, 0.0F, face.getStepX() * level.random.nextFloat() * negative);
                        }

                        List<MovingBlockData> allData = new ArrayList<>();
                        for (BlockPos pos : gathered) {
                            BlockState moveState = player.level().getBlockState(pos);
                            BlockEntity te = player.level().getBlockEntity(pos);
                            BlockPos offset = pos.subtract(blockPos);
                            MovingBlockData data = new MovingBlockData(moveState, moveState.getShape(player.level(), pos), offset, te == null ? null : te.saveWithoutMetadata());
                            player.level().removeBlockEntity(pos);
                            allData.add(data);
                        }
                        for (BlockPos pos : gathered) {
                            player.level().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                        }

                        FallingTreeBlockEntity fallingTree = UFEntities.FALLING_TREE.get().create(player.level());
                        fallingTree.moveTo(Vec3.atCenterOf(blockPos));
                        fallingTree.setAllBlockData(FallingTreeBlockEntity.createTagFromData(allData));
                        fallingTree.setPlacementCooldown(1);
                        Vec3 vec3 = Vec3.atCenterOf(blockPos).subtract(player.position());
                        float f = -((float) Mth.atan2(vec3.x, vec3.z)) * 180.0F / (float) Math.PI;
                        fallingTree.setFallDirection(Direction.fromYRot(f));
                        player.level().addFreshEntity(fallingTree);

                        stack.hurtAndBreak(allData.stream().filter(e -> e.getState().is(BlockTags.LOGS)).toList().size(), player, (p_40992_) -> {
                            p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                        });
                    }
                }

            }

            if (remainingUseDuration % 15 == 0) {
                player.playSound(UFSounds.SAWING.get());
            }

            EntityHitResult entityResult = getLookAtEntity(player, player.level(), player.getEntityReach() + 1.0D);
            if (entityResult != null && entityResult.getEntity() instanceof LivingEntity living) {
                if (living.hurt(player.damageSources().playerAttack(player), getAttackDamage())) {
                    stack.hurtAndBreak(1, player, (p_40665_) -> {
                        p_40665_.broadcastBreakEvent(living.getUsedItemHand());
                    });
                }
            }
        }

    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return false;
    }

    private HitResult calculateHitResult(Player pPlayer) {
        return ProjectileUtil.getHitResultOnViewVector(pPlayer, p_281111_ -> !p_281111_.isSpectator() && p_281111_.isPickable(), pPlayer.getBlockReach());
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
