package codyhuh.unusualfishmod.common.entity.util.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class BottomStrollGoal extends RandomStrollGoal {

    public BottomStrollGoal(PathfinderMob p_i48937_1_, double p_i48937_2_, int p_i48937_4_) {
        super(p_i48937_1_, p_i48937_2_, p_i48937_4_);
    }

    @Nullable
    protected Vec3 getPosition() {
        Vec3 vec = DefaultRandomPos.getPos(this.mob, 10, 7);

        for(int var2 = 0; vec != null && !this.mob.level().getBlockState(new BlockPos(new Vec3i((int)vec.x, (int)vec.y, (int)vec.z))).isPathfindable(this.mob.level(), new BlockPos(new Vec3i((int)vec.x, (int)vec.y, (int)vec.z)), PathComputationType.WATER) && var2++ < 10; vec = DefaultRandomPos.getPos(this.mob, 10, 7)) {
        }
        int yDrop = 1 + this.mob.getRandom().nextInt(3);
        if(vec != null){
            BlockPos pos = new BlockPos(new Vec3i((int)vec.x, (int)vec.y, (int)vec.z));
            while(this.mob.level().getFluidState(pos).is(FluidTags.WATER) && this.mob.level().getBlockState(pos).isPathfindable(this.mob.level(), pos, PathComputationType.WATER) && pos.getY() > 1){
                pos = pos.below();
            }
            pos = pos.above();
            int yUp = 0;
            while(this.mob.level().getFluidState(pos).is(FluidTags.WATER) && this.mob.level().getBlockState(pos).isPathfindable(this.mob.level(), pos, PathComputationType.WATER) && yUp < yDrop){
                pos = pos.above();
                yUp++;
            }
            return Vec3.atCenterOf(pos);
        }

        return vec;
    }
}
