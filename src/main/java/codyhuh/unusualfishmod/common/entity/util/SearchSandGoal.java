package codyhuh.unusualfishmod.common.entity.util;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.SeaPancake;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.StructureTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class SearchSandGoal extends Goal {
    public static final ResourceLocation LOOT = new ResourceLocation(UnusualFishMod.MOD_ID, "gameplay/sea_pancake_search");
    private final SeaPancake fish;
    private boolean stuck;

    public SearchSandGoal(SeaPancake p_28402_) {
        this.fish = p_28402_;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean isInterruptable() {
        return false;
    }

    public boolean canUse() {
        return this.fish.gotFish() && this.fish.getAirSupply() >= 100;
    }

    public boolean canContinueToUse() {
        BlockPos blockpos = this.fish.getTreasurePos();
        return !(new BlockPos(blockpos.getX(), this.fish.getY(), blockpos.getZ())).closerToCenterThan(this.fish.position(), 4.0D) && !this.stuck && this.fish.getAirSupply() >= 100;
    }

    public void start() {
        if (this.fish.level instanceof ServerLevel level) {
            this.stuck = false;
            this.fish.getNavigation().stop();
            BlockPos blockpos = genSeafloorPos(fish.blockPosition());
            BlockPos blockpos1 = level.findNearestMapStructure(StructureTags.DOLPHIN_LOCATED, blockpos, 50, false);

            if (blockpos1 != null) {
                this.fish.setTreasurePos(blockpos);
                level.broadcastEntityEvent(this.fish, (byte)38);
            }
            else {
                this.stuck = true;
            }
        }
    }

    public void stop() {
        BlockPos blockpos = this.fish.getTreasurePos();
        if ((new BlockPos(blockpos.getX(), this.fish.getY(), blockpos.getZ())).closerToCenterThan(this.fish.position(), 4.0D) || this.stuck) {
            this.fish.setGotFish(false);
        }

    }

    public void tick() {
        Level level = this.fish.level;
        if (this.fish.closeToNextPos() || this.fish.getNavigation().isDone()) {
            Vec3 vec3 = Vec3.atCenterOf(this.fish.getTreasurePos());
            Vec3 vec31 = DefaultRandomPos.getPosTowards(this.fish, 16, 1, vec3, ((float)Math.PI / 8F));
            if (vec31 == null) {
                vec31 = DefaultRandomPos.getPosTowards(this.fish, 8, 4, vec3, ((float)Math.PI / 2F));
            }

            if (vec31 != null) {
                BlockPos blockpos = new BlockPos(vec31);
                if (!level.getFluidState(blockpos).is(FluidTags.WATER) || !level.getBlockState(blockpos).isPathfindable(level, blockpos, PathComputationType.WATER)) {
                    vec31 = DefaultRandomPos.getPosTowards(this.fish, 8, 5, vec3, ((float)Math.PI / 2F));
                }
            }

            if (vec31 == null) {
                this.stuck = true;
                return;
            }

            this.fish.getLookControl().setLookAt(vec31.x, vec31.y, vec31.z, (float)(this.fish.getMaxHeadYRot() + 20), (float)this.fish.getMaxHeadXRot());
            this.fish.getNavigation().moveTo(vec31.x, vec31.y, vec31.z, 1.3D);
            if (level.random.nextInt(this.adjustedTickDelay(80)) == 0) {
                level.broadcastEntityEvent(this.fish, (byte)38);
            }
        }
    }

    // From Alex's Mobs
    private BlockPos genSeafloorPos(BlockPos parent) {
        LevelAccessor world = fish.level;
        final RandomSource random = this.fish.getRandom();
        int range = 15;
        for (int i = 0; i < 15; i++) {
            BlockPos seafloor = parent.offset(random.nextInt(range) - range / 2, 0, random.nextInt(range) - range / 2);
            while (world.getFluidState(seafloor).is(FluidTags.WATER) && seafloor.getY() > 1) {
                seafloor = seafloor.below();
            }
            BlockState state = world.getBlockState(seafloor);
            if (state.is(BlockTags.SAND)) {
                return seafloor;
            }
        }
        return null;
    }
}
