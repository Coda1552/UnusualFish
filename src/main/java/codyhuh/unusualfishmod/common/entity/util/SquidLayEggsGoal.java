package codyhuh.unusualfishmod.common.entity.util;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;

public class SquidLayEggsGoal extends MoveToBlockGoal {
    private final AgeableWaterAnimal squid;
    private final Block eggsBlock;

    public SquidLayEggsGoal(AgeableWaterAnimal squid, Block eggsBlock) {
        super(squid, 1.0D, 24, 12);
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
    protected boolean isValidTarget(LevelReader level, BlockPos pos) {
        return level.isWaterAt(pos);
    }

    @Override
    public void stop() {
        blockPos = BlockPos.ZERO;
    }
}
