package com.peeko32213.unusualfishmod.common.entity.ambient.special;

import com.peeko32213.unusualfishmod.common.entity.ambient.small.BeakedHerring;
import com.peeko32213.unusualfishmod.core.config.UnusualFishConfig;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import com.peeko32213.unusualfishmod.core.init.UnusualFishItems;
import com.peeko32213.unusualfishmod.core.init.UnusualFishSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Random;

public class BaskingTiamatBaby extends WaterAnimal implements Bucketable {

    private static final TargetingConditions PLAYER_PREDICATE = TargetingConditions.forNonCombat().range(24.0D).ignoreLineOfSight();
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(BaskingTiamatBaby.class, EntityDataSerializers.BOOLEAN);


    public BaskingTiamatBaby(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.MOVEMENT_SPEED, 1.0D);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 3.0D, true));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BeakedHerring.class, false));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new BaskingTiamatBaby.SwimWithPlayerGoal(this, 4.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.8D, 1) {
            @Override
            public boolean canUse() {
                return super.canUse() && isInWater();
            }
        });
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8D, 15) {
            @Override
            public boolean canUse() {
                return !this.mob.isInWater() && super.canUse();
            }
        });
    }

    public void tick() {
        super.tick();

        if (this.level.isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03D) {
            Vec3 vec3 = this.getViewVector(0.0F);
            float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
            float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;

        }

    }

    public void aiStep() {
        if (!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), (double)0.4F, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }

        super.aiStep();
    }

    static class SwimWithPlayerGoal extends Goal {
        private final BaskingTiamatBaby snek;
        private final double speed;
        private Player targetPlayer;

        SwimWithPlayerGoal(BaskingTiamatBaby snekIn, double speedIn) {
            this.snek = snekIn;
            this.speed = speedIn;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.targetPlayer = this.snek.level.getNearestPlayer(BaskingTiamatBaby.PLAYER_PREDICATE, this.snek);
            if (this.targetPlayer == null) {
                return false;
            } else {
                return this.targetPlayer.isSwimming() && this.snek.getTarget() != this.targetPlayer;
            }
        }

        public boolean canContinueToUse() {
            return this.targetPlayer != null  && this.snek.getTarget() != this.targetPlayer && this.targetPlayer.isSwimming() && this.snek.distanceToSqr(this.targetPlayer) < 256.0D;
        }

        public void start() {
        }

        public void stop() {
            this.targetPlayer = null;
            this.snek.getNavigation().stop();
        }

        public void tick() {
            this.snek.getLookControl().setLookAt(this.targetPlayer, (float) (this.snek.getMaxHeadYRot() + 20), (float) this.snek.getMaxHeadXRot());
            if (this.snek.distanceToSqr(this.targetPlayer) < 10D) {
                this.snek.getNavigation().stop();
            } else {
                this.snek.getNavigation().moveTo(this.targetPlayer, this.speed);
            }

        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
        compound.putBoolean("Bucketed", this.fromBucket());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
        this.setFromBucket(compound.getBoolean("Bucketed"));
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void saveToBucketTag(ItemStack bucket) {
        CompoundTag compoundnbt = bucket.getOrCreateTag();
        compoundnbt.putFloat("Health", this.getHealth());

    }

    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.fromBucket();
    }

    public boolean removeWhenFarAway(double p_213397_1_) {
        return !this.fromBucket() && !this.hasCustomName();
    }

    private boolean isFromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean p_203706_1_) {
        this.entityData.set(FROM_BUCKET, p_203706_1_);
    }


    @Override
    public void loadFromBucketTag(CompoundTag p_148832_) {

    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_EMPTY_FISH;
    }

    protected InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
        return Bucketable.bucketMobPickup(p_27477_, p_27478_, this).orElse(super.mobInteract(p_27477_, p_27478_));
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(UnusualFishItems.BASKING_TIAMAT_BUCKET.get());
    }

    protected PathNavigation createNavigation(Level p_27480_) {
        return new WaterBoundPathNavigation(this, p_27480_);
    }

    protected SoundEvent getAmbientSound() {
        return UnusualFishSounds.MEDIUM_FISH.get();
    }
    public SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    public SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COD_HURT;
    }

    public SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    public static <T extends Mob> boolean canSpawn(EntityType<BaskingTiamatBaby> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, Random p_223364_4_) {
        return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, p_223364_4_);
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return UnusualFishEntities.rollSpawn(UnusualFishConfig.baskingTiamaitBabySpawnRolls, this.getRandom(), spawnReasonIn);
    }

}
