package codyhuh.unusualfishmod.common.entity.util.base;

import codyhuh.unusualfishmod.common.entity.util.goal.FollowSchoolLeaderGoal;
import codyhuh.unusualfishmod.common.entity.util.misc.IVariant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public abstract class BucketableSchoolingWaterAnimal extends BucketableWaterAnimal implements IVariant {
    @Nullable
    private BucketableSchoolingWaterAnimal leader;
    private int schoolSize = 1;

    public BucketableSchoolingWaterAnimal(EntityType<? extends BucketableSchoolingWaterAnimal> p_27523_, Level p_27524_) {
        super(p_27523_, p_27524_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new FollowSchoolLeaderGoal(this));
    }

    public int getMaxSpawnClusterSize() {
        return this.getMaxSchoolSize();
    }

    public int getMaxSchoolSize() {
        return super.getMaxSpawnClusterSize();
    }

    protected boolean canRandomSwim() {
        return !this.isFollower();
    }

    public boolean isFollower() {
        return this.leader != null && this.leader.isAlive();
    }

    public BucketableSchoolingWaterAnimal startFollowing(BucketableSchoolingWaterAnimal p_27526_) {
        this.leader = p_27526_;
        p_27526_.addFollower();
        return p_27526_;
    }

    public void stopFollowing() {
        this.leader.removeFollower();
        this.leader = null;
    }

    private void addFollower() {
        ++this.schoolSize;
    }

    private void removeFollower() {
        --this.schoolSize;
    }

    public boolean canBeFollowed() {
        return this.hasFollowers() && this.schoolSize < this.getMaxSchoolSize();
    }

    public void tick() {
        super.tick();
        if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
            List<? extends WaterAnimal> list = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
            if (list.size() <= 1) {
                this.schoolSize = 1;
            }
        }
    }

    public boolean hasFollowers() {
        return this.schoolSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.distanceToSqr(this.leader) <= 121.0D;
    }

    public void pathToLeader() {
        if (this.isFollower()) {
            this.getNavigation().moveTo(this.leader, 1.0D);
        }
    }

    @Override
    public boolean hasVariant() {
        return false;
    }

    @Override
    public int getVariantN() {
        return 0;
    }


    public void addFollowers(Stream<? extends BucketableSchoolingWaterAnimal> p_27534_) {
        p_27534_.limit(this.getMaxSchoolSize() - this.schoolSize).filter((p_27538_) -> {
            return p_27538_ != this;
        }).forEach((p_27536_) -> {
            if (hasVariant()) {
                if (this.getVariantN() == p_27536_.getVariantN()) {
                    p_27536_.startFollowing(this);
                }
            }
            else {
                p_27536_.startFollowing(this);
            }
        });
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_27528_, DifficultyInstance p_27529_, MobSpawnType p_27530_, @Nullable SpawnGroupData p_27531_, @Nullable CompoundTag p_27532_) {
        super.finalizeSpawn(p_27528_, p_27529_, p_27530_, p_27531_, p_27532_);
        if (p_27531_ == null) {
            p_27531_ = new BucketableSchoolingWaterAnimal.SchoolSpawnGroupData(this);
        } else {
            this.startFollowing(((BucketableSchoolingWaterAnimal.SchoolSpawnGroupData)p_27531_).leader);
        }

        return p_27531_;
    }

    public static class SchoolSpawnGroupData implements SpawnGroupData {
        public final BucketableSchoolingWaterAnimal leader;

        public SchoolSpawnGroupData(BucketableSchoolingWaterAnimal p_27553_) {
            this.leader = p_27553_;
        }
    }

}
