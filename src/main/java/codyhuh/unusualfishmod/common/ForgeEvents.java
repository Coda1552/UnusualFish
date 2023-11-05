package codyhuh.unusualfishmod.common;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block.VoltDetectorBlock;
import codyhuh.unusualfishmod.common.entity.VoltAngler;
import codyhuh.unusualfishmod.core.registry.UFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    // Probably not very optimized. If anyone can give me pointers on how to improve this, I'd love some help.
    @SubscribeEvent
    public static void livingTick(LivingEvent.LivingTickEvent e) {
        LivingEntity entity = e.getEntity();
        Level level = e.getEntity().getLevel();

        AABB aabb = entity.getBoundingBox();
        BlockPos blockpos = new BlockPos(aabb.minX - 0.5D, aabb.minY - 0.5D, aabb.minZ - 0.5D);
        BlockPos blockpos1 = new BlockPos(aabb.maxX + 0.5D, aabb.maxY + 0.5D, aabb.maxZ + 0.5D);

        if (level.hasChunksAt(blockpos, blockpos1)) {
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for(int i = blockpos.getX(); i <= blockpos1.getX(); ++i) {
                for(int j = blockpos.getY(); j <= blockpos1.getY(); ++j) {
                    for(int k = blockpos.getZ(); k <= blockpos1.getZ(); ++k) {
                        mutablePos.set(i, j, k);
                        BlockState blockstate = level.getBlockState(mutablePos);

                        if (blockstate.is(UFBlocks.SEA_BOOM.get())) {
                            for (Direction dir : Direction.Plane.HORIZONTAL) {
                                Vec3 arrowPos = Vec3.atCenterOf(mutablePos.relative(dir, 1));

                                Arrow arrow = new Arrow(level, arrowPos.x(), arrowPos.y(), arrowPos.z());

                                arrow.pickup = AbstractArrow.Pickup.DISALLOWED;

                                Vec3 arrowMovement = Vec3.ZERO.add(dir.getStepX() * 0.5D, 0.5D, dir.getStepZ() * 0.5D);

                                arrow.setDeltaMovement(arrowMovement);
                                level.addFreshEntity(arrow);
                            }
                        }

                        if (blockstate.is(UFBlocks.VOLT_DETECTOR.get()) && entity instanceof VoltAngler) {
                            int anglers = blockstate.getValue(VoltDetectorBlock.ANGLERS);

                            if (anglers < 5) {
                                blockstate.setValue(VoltDetectorBlock.ANGLERS, anglers + 1);
                            }
                        }
                    }
                }
            }
        }

    }

}
