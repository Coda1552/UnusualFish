package codyhuh.unusualfishmod.common.entity.util;

import codyhuh.unusualfishmod.common.entity.CrimsonshellSquid;
import codyhuh.unusualfishmod.common.entity.TrumpetSquid;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class BreedableWaterAnimal extends WaterAnimal {
    private static final EntityDataAccessor<Boolean> DATA_BABY_ID = SynchedEntityData.defineId(BreedableWaterAnimal.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_GRAVID = SynchedEntityData.defineId(BreedableWaterAnimal.class, EntityDataSerializers.BOOLEAN);
    protected int age;
    protected int forcedAge;
    protected int forcedAgeTimer;
    private int inLove;
    @Nullable
    private UUID loveCause;

    protected BreedableWaterAnimal(EntityType<? extends WaterAnimal> p_146738_, Level p_146739_) {
        super(p_146738_, p_146739_);
    }

    public boolean isGravid() {
        return this.entityData.get(DATA_GRAVID);
    }

    public void setGravid(boolean gravid) {
        this.entityData.set(DATA_GRAVID, gravid);
    }

    @Nullable
    public abstract BreedableWaterAnimal getBreedOffspring(ServerLevel p_146743_, BreedableWaterAnimal p_146744_);

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_BABY_ID, false);
        this.entityData.define(DATA_GRAVID, false);
    }

    public int getAge() {
        if (this.level().isClientSide) {
            return this.entityData.get(DATA_BABY_ID) ? -1 : 1;
        } else {
            return this.age;
        }
    }

    public void ageUp(int p_146741_, boolean p_146742_) {
        int i = this.getAge();
        i += p_146741_ * 20;
        if (i > 0) {
            i = 0;
        }

        int j = i - i;
        this.setAge(i);
        if (p_146742_) {
            this.forcedAge += j;
            if (this.forcedAgeTimer == 0) {
                this.forcedAgeTimer = 40;
            }
        }

        if (this.getAge() == 0) {
            this.setAge(this.forcedAge);
        }

    }

    public void ageUp(int p_146759_) {
        this.ageUp(p_146759_, false);
    }

    public void setAge(int p_146763_) {
        int i = this.getAge();
        this.age = p_146763_;
        if (i < 0 && p_146763_ >= 0 || i >= 0 && p_146763_ < 0) {
            this.entityData.set(DATA_BABY_ID, p_146763_ < 0);
            this.ageBoundaryReached();
        }

    }

    protected void customServerAiStep() {
        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        super.customServerAiStep();
    }

    public boolean hurt(DamageSource p_27567_, float p_27568_) {
        if (this.isInvulnerableTo(p_27567_)) {
            return false;
        } else {
            this.inLove = 0;
            return super.hurt(p_27567_, p_27568_);
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Age", this.getAge());
        tag.putInt("ForcedAge", this.forcedAge);
        tag.putInt("InLove", this.inLove);
        if (this.loveCause != null) {
            tag.putUUID("LoveCause", this.loveCause);
        }
        tag.putBoolean("Gravid", isGravid());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setAge(tag.getInt("Age"));
        this.forcedAge = tag.getInt("ForcedAge");
        this.inLove = tag.getInt("InLove");
        this.loveCause = tag.hasUUID("LoveCause") ? tag.getUUID("LoveCause") : null;
        setGravid(tag.getBoolean("Gravid"));
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_146754_) {
        if (DATA_BABY_ID.equals(p_146754_)) {
            this.refreshDimensions();
        }

        super.onSyncedDataUpdated(p_146754_);
    }

    public void aiStep() {
        super.aiStep();
        if (this.level().isClientSide) {
            if (this.forcedAgeTimer > 0) {
                if (this.forcedAgeTimer % 4 == 0) {
                    this.level().addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
                }

                --this.forcedAgeTimer;
            }
        } else if (this.isAlive()) {
            int i = this.getAge();
            if (i < 0) {
                ++i;
                this.setAge(i);
            } else if (i > 0) {
                --i;
                this.setAge(i);
            }
        }

        if (this.getAge() != 0) {
            this.inLove = 0;
        }

        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        }

    }

    protected void ageBoundaryReached() {
    }

    public boolean isBaby() {
        return this.getAge() < 0;
    }

    public void setBaby(boolean p_146756_) {
        this.setAge(p_146756_ ? -24000 : 0);
    }

    public static int getSpeedUpSecondsWhenFeeding(int p_216968_) {
        return (int)((float)(p_216968_ / 20) * 0.1F);
    }

    public void handleEntityEvent(byte p_27562_) {
        if (p_27562_ == 18) {
            for(int i = 0; i < 7; ++i) {
                double d0 = this.random.nextGaussian() * 0.02D;
                double d1 = this.random.nextGaussian() * 0.02D;
                double d2 = this.random.nextGaussian() * 0.02D;
                this.level().addParticle(ParticleTypes.HEART, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        } else {
            super.handleEntityEvent(p_27562_);
        }

    }

    protected void usePlayerItem(Player p_148715_, InteractionHand p_148716_, ItemStack p_148717_) {
        if (!p_148715_.getAbilities().instabuild) {
            p_148717_.shrink(1);
        }

    }

    public boolean canFallInLove() {
        return this.inLove <= 0;
    }

    public void setInLove(@Nullable Player p_27596_) {
        this.inLove = 600;
        if (p_27596_ != null) {
            this.loveCause = p_27596_.getUUID();
        }

        this.level().broadcastEntityEvent(this, (byte)18);
    }

    @Nullable
    public ServerPlayer getLoveCause() {
        if (this.loveCause == null) {
            return null;
        } else {
            Player player = this.level().getPlayerByUUID(this.loveCause);
            return player instanceof ServerPlayer ? (ServerPlayer)player : null;
        }
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    public boolean removeWhenFarAway(double p_27598_) {
        return false;
    }

    public int getExperienceReward() {
        return 1 + this.level().random.nextInt(3);
    }

    public boolean isFood(ItemStack p_27600_) {
        return p_27600_.is(Items.WHEAT);
    }

    public InteractionResult mobInteract(Player p_27584_, InteractionHand p_27585_) {
        ItemStack itemstack = p_27584_.getItemInHand(p_27585_);
        if (this.isFood(itemstack)) {
            int i = this.getAge();
            if (!this.level().isClientSide && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(p_27584_, p_27585_, itemstack);
                this.setInLove(p_27584_);
                return InteractionResult.SUCCESS;
            }

            if (this.isBaby()) {
                this.usePlayerItem(p_27584_, p_27585_, itemstack);
                this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
        }

        return super.mobInteract(p_27584_, p_27585_);
    }

    public boolean isInLove() {
        return this.inLove > 0;
    }

    public void resetLove() {
        this.inLove = 0;
    }

    public boolean canMate(BreedableWaterAnimal p_27569_) {
        if (p_27569_ == this) {
            return false;
        } else if (p_27569_.getClass() != this.getClass()) {
            return false;
        } else {
            return this.isInLove() && p_27569_.isInLove();
        }
    }

    public void spawnChildFromBreeding(ServerLevel p_27564_, BreedableWaterAnimal animal) {
        BreedableWaterAnimal ageable = this.getBreedOffspring(p_27564_, animal);

        if (animal instanceof CrimsonshellSquid || animal instanceof TrumpetSquid) {
            //Reset the "inLove" state for the animals
            this.setAge(6000);
            animal.setAge(6000);
            this.resetLove();
            animal.resetLove();

            animal.setGravid(true);
            return;
        }

        if (ageable != null) {
            ServerPlayer serverplayer = this.getLoveCause();
            if (serverplayer == null && animal.getLoveCause() != null) {
                serverplayer = animal.getLoveCause();
            }

            if (serverplayer != null) {
                serverplayer.awardStat(Stats.ANIMALS_BRED);
            }

            this.setAge(6000);
            animal.setAge(6000);
            this.resetLove();
            animal.resetLove();
            ageable.setBaby(true);
            ageable.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            p_27564_.addFreshEntityWithPassengers(ageable);
            p_27564_.broadcastEntityEvent(this, (byte)18);
            if (p_27564_.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
                p_27564_.addFreshEntity(new ExperienceOrb(p_27564_, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
            }

        }
    }

    public static class AgeableWaterAnimalGroupData implements SpawnGroupData {
        private int groupSize;
        private final boolean shouldSpawnBaby;
        private final float babySpawnChance;

        private AgeableWaterAnimalGroupData(boolean p_146775_, float p_146776_) {
            this.shouldSpawnBaby = p_146775_;
            this.babySpawnChance = p_146776_;
        }

        public AgeableWaterAnimalGroupData(boolean p_146773_) {
            this(p_146773_, 0.05F);
        }

        public AgeableWaterAnimalGroupData(float p_146771_) {
            this(true, p_146771_);
        }

        public int getGroupSize() {
            return this.groupSize;
        }

        public void increaseGroupSizeByOne() {
            ++this.groupSize;
        }

        public boolean isShouldSpawnBaby() {
            return this.shouldSpawnBaby;
        }

        public float getBabySpawnChance() {
            return this.babySpawnChance;
        }
    }
}
