package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.core.registry.UFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class TigerJungleShark extends WaterAnimal {
    protected int attackCooldown = 0;
    private int attackAnimationTick;

    public TigerJungleShark(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 3.0D, true) {
            @Override
            public boolean canUse() {
                return super.canUse() && attackCooldown == 0;
            }
        });
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
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

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TigerJungleShark.class, false));
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        float f = this.getAttackDamage();
        float f1 = (int)f > 0 ? f / 2.0F + (float)this.random.nextInt((int)f) : f;
        boolean flag = entityIn.hurt(damageSources().mobAttack(this), f1);
        if (flag) {
            entityIn.setDeltaMovement(entityIn.getDeltaMovement().add(0.0D, 0.4D, 0.0D));
            this.doEnchantDamageEffects(this, entityIn);
        }
        return flag;
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public void tick() {
        super.tick();

        if (this.attackCooldown > 0) {
            this.attackCooldown--;
        }

        if (getTarget() != null && !getTarget().isAlive()) {
            attackCooldown = 20 * 60 * 5; // 5 minutes
        }
    }

    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4D, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.setOnGround(false);
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }

        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }

        super.aiStep();
    }

    public void handleEntityEvent(byte p_28844_) {
        if (p_28844_ == 4) {
            this.attackAnimationTick = 10;
        }
        super.handleEntityEvent(p_28844_);
    }

    public int getAttackAnimationTick() {
        return this.attackAnimationTick;
    }

    protected PathNavigation createNavigation(Level p_27480_) {
        return new WaterBoundPathNavigation(this, p_27480_);
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

    public static boolean canSpawn(EntityType<TigerJungleShark> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
        return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
    }
}
