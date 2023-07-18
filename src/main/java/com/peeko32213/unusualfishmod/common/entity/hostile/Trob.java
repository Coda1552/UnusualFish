package com.peeko32213.unusualfishmod.common.entity.hostile;

import com.peeko32213.unusualfishmod.core.config.UnusualFishConfig;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import com.peeko32213.unusualfishmod.core.init.UnusualFishSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class Trob extends WaterAnimal implements NeutralMob {
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    public static final int REINFORCEMENT_ATTEMPTS = 100;
    public static final int REINFORCEMENT_RANGE_MAX = 20;
    public static final int REINFORCEMENT_RANGE_MIN = 3;
    private int remainingPersistentAngerTime;
    @javax.annotation.Nullable
    private UUID persistentAngerTarget;
    private static final int ALERT_RANGE_Y = 10;
    private static final UniformInt ALERT_INTERVAL = TimeUtil.rangeOfSeconds(4, 6);
    private int ticksUntilNextAlert;

    public Trob(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new Trob.MoveHelperController(this);
        this.maxUpStep = 1.0f;
    }

    private static final Predicate<LivingEntity> INJURED_PREDICATE = (mob) -> {
        return mob.getHealth() <= mob.getMaxHealth() / 2D;
    };

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ARMOR, 12.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.6F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.6F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
    }



    public void remove(Entity.RemovalReason p_149847_) {
        if (!this.level.isClientSide && this.isDeadOrDying()) {
            Component component = this.getCustomName();
            boolean flag = this.isNoAi();
            float f = (float) 4.0F;
            int j =  2;
            int k = 2 + this.random.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float)(l % 2) - 0.5F) * f;
                float f2 = ((float)(l / 2) - 0.5F) * f;
                Tribble sporpaEntity = UnusualFishEntities.TRIBBLE.get().create(level);
                if (this.isPersistenceRequired()) {
                    sporpaEntity.setPersistenceRequired();
                }

                sporpaEntity.setCustomName(component);
                sporpaEntity.setNoAi(flag);
                sporpaEntity.setInvulnerable(this.isInvulnerable());
                sporpaEntity.moveTo(this.getX() + (double)f1, this.getY() + 0.5D, this.getZ() + (double)f2, this.random.nextFloat() * 360.0F, 0.0F);
                this.level.addFreshEntity(sporpaEntity);
            }
        }

        super.remove(p_149847_);
    }

    protected PathNavigation createNavigation(Level p_27480_) {
        return new GroundPathNavigation(this, level);
    }

    @Override
    public void handleAirSupply(int p_209207_1_) {
    }

    protected SoundEvent getAmbientSound() {
        return UnusualFishSounds.EVIL_CHATTERING.get();
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_28281_) {
        return SoundEvents.COD_HURT;
    }

    protected void playStepSound(BlockPos p_33804_, BlockState p_33805_) {
        this.playSound(UnusualFishSounds.EVIL_SCUTTLING.get(), 0.15F, 1.0F);
    }

    public void addAdditionalSaveData(CompoundTag p_34458_) {
        super.addAdditionalSaveData(p_34458_);
        this.addPersistentAngerSaveData(p_34458_);
    }

    public void readAdditionalSaveData(CompoundTag p_34446_) {
        super.readAdditionalSaveData(p_34446_);
        this.readPersistentAngerSaveData(this.level, p_34446_);
    }

    public boolean causeFallDamage(float distance, float damageMultiplier) {
        return false;
    }

    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        fallDistance = 0;
    }

    public void setRemainingPersistentAngerTime(int p_34448_) {
        this.remainingPersistentAngerTime = p_34448_;
    }

    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    protected void randomizeReinforcementsChance() {
        this.getAttribute(Attributes.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(3.0D);
    }

    @javax.annotation.Nullable
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    public void setPersistentAngerTarget(@Nullable UUID p_34444_) {
        this.persistentAngerTarget = p_34444_;
    }

    public boolean isPreventingPlayerRest(Player p_34475_) {
        return this.isAngryAt(p_34475_);
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    static class MoveHelperController extends MoveControl {
        private final Mob spider;

        MoveHelperController(Mob spider) {
            super(spider);
            this.spider = spider;
        }

        public void tick() {
            if (this.spider.isEyeInFluid(FluidTags.WATER)) {
                this.spider.setDeltaMovement(this.spider.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }

            if (this.operation == Operation.MOVE_TO && !this.spider.getNavigation().isDone()) {
                double d0 = this.wantedX - this.spider.getX();
                double d1 = this.wantedY - this.spider.getY();
                double d2 = this.wantedZ - this.spider.getZ();
                double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
                d1 = d1 / d3;
                float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.spider.yRot = this.rotlerp(this.spider.yRot, f, 90.0F);
                this.spider.yBodyRot = this.spider.yRot;
                float f1 = (float) (this.speedModifier * this.spider.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.spider.setSpeed(Mth.lerp(0.125F, this.spider.getSpeed(), f1));
                this.spider.setDeltaMovement(this.spider.getDeltaMovement().add(0.0D, (double) this.spider.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.spider.setSpeed(0.0F);
            }
        }
    }

    public static boolean canSpawn(EntityType<Trob> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, Random random) {
        return reason == MobSpawnType.SPAWNER || iServerWorld.getBlockState(pos).getMaterial() == Material.WATER && iServerWorld.getBlockState(pos.above()).getMaterial() == Material.WATER && isLightLevelOk(pos, iServerWorld);
    }

    private static boolean isLightLevelOk(BlockPos pos, ServerLevelAccessor iServerWorld) {
        float time = iServerWorld.getTimeOfDay(1.0F);
        int light = iServerWorld.getMaxLocalRawBrightness(pos);
        return light <= 4 && time > 0.27F && time <= 0.8F;
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return UnusualFishEntities.rollSpawn(UnusualFishConfig.trobSpawnRolls, this.getRandom(), spawnReasonIn);
    }

}
