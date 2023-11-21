package codyhuh.unusualfishmod.common.entity.util;

import codyhuh.unusualfishmod.common.block.SquidEggsBlock;
import codyhuh.unusualfishmod.core.registry.UFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

public class SquidLayEggsGoal extends MoveToBlockGoal {
    private final BreedableWaterAnimal squid;
    private final Block eggsBlock;

    public SquidLayEggsGoal(BreedableWaterAnimal squid, Block eggsBlock) {
        super(squid, 1.0D, 24, 24);
        this.squid = squid;
        this.eggsBlock = eggsBlock;
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    @Override
    public boolean canUse() {
        return squid.isGravid() && super.canUse();
    }

    @Override
    public double acceptedDistance() {
        return 1.5D;
    }

    @Override
    public void tick() {
        super.tick();

        if (!squid.isGravid()) {
            squid.setGravid(true);
        }

        if (isReachedTarget()) {
            squid.level.setBlock(getMoveToTarget().below(), eggsBlock.defaultBlockState().setValue(SquidEggsBlock.FACING, Direction.UP), 2);
            squid.playSound(SoundEvents.FROG_LAY_SPAWN);
            squid.setGravid(false);
            stop();
        }

    }

    @Override
    protected boolean isValidTarget(LevelReader level, BlockPos blockPos) {
        return !level.getBlockState(blockPos).is(UFTags.SQUID_EGGS) && level.isWaterAt(blockPos) && level.getBlockState(blockPos.below()).canOcclude();
    }

    @Override
    public void stop() {
        blockPos = BlockPos.ZERO;
    }
}
