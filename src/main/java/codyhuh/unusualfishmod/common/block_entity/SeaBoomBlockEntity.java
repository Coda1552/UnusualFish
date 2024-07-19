package codyhuh.unusualfishmod.common.block_entity;

import codyhuh.unusualfishmod.common.block.SeaBoomBlock;
import codyhuh.unusualfishmod.common.entity.item.SeaSpike;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import codyhuh.unusualfishmod.core.registry.UFBlocks;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SeaBoomBlockEntity extends BlockEntity {

    public SeaBoomBlockEntity(BlockPos pos, BlockState state) {
        super(UFBlockEntities.SEA_BOOM.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SeaBoomBlockEntity voltDetector) {
        AABB aabb = new AABB(pos);
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, aabb.inflate(2.0D), e -> !level.getBlockState(pos).getValue(SeaBoomBlock.HOSTILE_ONLY) || e instanceof Monster);

        if (level.hasChunksAt(pos, pos) && state.is(UFBlocks.SEA_BOOM.get()) && !level.getBlockState(pos).isAir() && !entities.isEmpty() && level.getBlockState(pos).getValue(SeaBoomBlock.LOADED)) {
            level.setBlock(pos, state.setValue(SeaBoomBlock.LOADED, false), 3);

            for (Direction dir : Direction.Plane.HORIZONTAL) {
                for (int d = 0; d < 3; d++) {
                    for (int c = 0; c < 2; c++) {
                        double[] angle = {-0.5D, 0.5D, 1.0D};

                        Vec3 arrowPos = Vec3.atCenterOf(pos.relative(dir, 1));

                        SeaSpike spike = new SeaSpike(UFEntities.SEA_SPIKE.get(), arrowPos.x(), arrowPos.y(), arrowPos.z(), level);

                        spike.pickup = AbstractArrow.Pickup.DISALLOWED;

                        Vec3 arrowMovement = Vec3.ZERO.add(dir.getStepX() * 0.5D, 0.5D * angle[d], dir.getStepZ() * 0.5D);

                        if (c == 1) arrowMovement = arrowMovement.yRot(45.0F);

                        spike.hostileOnly = level.getBlockState(pos).getValue(SeaBoomBlock.HOSTILE_ONLY);
                        spike.setDeltaMovement(arrowMovement);
                        level.addFreshEntity(spike);
                    }
                }
            }
        }
    }
}
