package codyhuh.unusualfishmod.common.entity.hostile;

import codyhuh.unusualfishmod.common.entity.ai.CustomMeleeAttackGoal;
import codyhuh.unusualfishmod.core.registry.UFSounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import net.minecraft.util.RandomSource;
import java.util.function.Predicate;

public class Tribble extends WaterAnimal {

    public Tribble(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new Tribble.MoveHelperController(this);
        this.maxUpStep = 1.0f;
    }

    private static final Predicate<LivingEntity> INJURED_PREDICATE = (mob) -> mob.getHealth() <= mob.getMaxHealth() / 2D;

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.4F).add(Attributes.ARMOR, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
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
        return UFSounds.SMALL_ENEMY.get();
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_28281_) {
        return SoundEvents.COD_HURT;
    }

    protected void playStepSound(BlockPos p_33804_, BlockState p_33805_) {
        this.playSound(UFSounds.CRAB_SCUTTLING.get(), 0.15F, 1.0F);
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    public static boolean canSpawn(EntityType<Tribble> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return reason == MobSpawnType.SPAWNER || iServerWorld.getBlockState(pos).getMaterial() == Material.WATER && iServerWorld.getBlockState(pos.above()).getMaterial() == Material.WATER && isLightLevelOk(pos, iServerWorld);
    }

    private static boolean isLightLevelOk(BlockPos pos, ServerLevelAccessor iServerWorld) {
        float time = iServerWorld.getTimeOfDay(1.0F);
        int light = iServerWorld.getMaxLocalRawBrightness(pos);
        return light <= 4 && time > 0.27F && time <= 0.8F;
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
}
