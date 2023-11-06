package codyhuh.unusualfishmod.common.entity.util;

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
            squid.level.setBlock(getMoveToTarget(), eggsBlock.defaultBlockState(), 2);
            squid.playSound(SoundEvents.FROG_LAY_SPAWN);
            squid.setGravid(false);
            stop();
        }

        System.out.println(getMoveToTarget());
    }

    @Override
    protected boolean isValidTarget(LevelReader level, BlockPos blockPos) {
        Vec3 pos = Vec3.atCenterOf(blockPos);
        Direction dir = Direction.getNearest(pos.x, pos.y, pos.z);

        // todo - fix squids not selecting a valid target
        return level.isWaterAt(blockPos) && level.getBlockState(blockPos).isFaceSturdy(level, blockPos, dir);
    }

    @Override
    public void stop() {
        blockPos = BlockPos.ZERO;
    }
}
