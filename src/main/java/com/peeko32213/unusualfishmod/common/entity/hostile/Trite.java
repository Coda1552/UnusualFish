package com.peeko32213.unusualfishmod.common.entity.hostile;

import com.peeko32213.unusualfishmod.common.entity.ai.CustomMeleeAttackGoal;
import com.peeko32213.unusualfishmod.core.config.UnusualFishConfig;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import com.peeko32213.unusualfishmod.core.init.UnusualFishSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.Random;
import java.util.function.Predicate;

public class Trite extends WaterAnimal {
    public Trite(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new Trite.MoveHelperController(this);
        this.maxUpStep = 1.0f;
    }

    private static final Predicate<LivingEntity> INJURED_PREDICATE = (mob) -> {
        return mob.getHealth() <= mob.getMaxHealth() / 2D;
    };

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 25.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ARMOR, 15.0D).add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.5D, false));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.6F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.6F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(2, new CustomMeleeAttackGoal(this, LivingEntity.class, 50, false, true, INJURED_PREDICATE));
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

    public void remove(Entity.RemovalReason p_149847_) {
        if (!this.level.isClientSide && this.isDeadOrDying()) {
            Component component = this.getCustomName();
            boolean flag = this.isNoAi();
            float f = (float) 4.0F;
            int j =  2;
            int k = 2 + this.random.nextInt(3);

            for(int l = 0; l < k; ++l) {
                float f1 = ((float)(l % 1) - 0.5F) * f;
                float f2 = ((float)(l / 1) - 0.5F) * f;
                Trob sporpaEntity = UnusualFishEntities.TROB.get().create(level);
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

    public static boolean canSpawn(EntityType<Trite> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, Random random) {
        return reason == MobSpawnType.SPAWNER || iServerWorld.getBlockState(pos).getMaterial() == Material.WATER && iServerWorld.getBlockState(pos.above()).getMaterial() == Material.WATER && isLightLevelOk(pos, iServerWorld);
    }

    private static boolean isLightLevelOk(BlockPos pos, ServerLevelAccessor iServerWorld) {
        float time = iServerWorld.getTimeOfDay(1.0F);
        int light = iServerWorld.getMaxLocalRawBrightness(pos);
        return light <= 4 && time > 0.27F && time <= 0.8F;
    }

    public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return UnusualFishEntities.rollSpawn(UnusualFishConfig.triteSpawnRolls, this.getRandom(), spawnReasonIn);
    }

}
