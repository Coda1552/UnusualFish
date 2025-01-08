package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.goal.FollowSchoolLeaderGoal;
import codyhuh.unusualfishmod.common.entity.util.base.BucketableSchoolingWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.misc.UFAnimations;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.UUID;

public class RhinoTetra extends BucketableSchoolingWaterAnimal implements GeoEntity, NeutralMob {
	private static final EntityDataAccessor<Integer> REMAINING_ANGER_TIME = SynchedEntityData.defineId(RhinoTetra.class, EntityDataSerializers.INT);
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(15, 29);
	@Nullable
	private UUID persistentAngerTarget;
	public int stunnedTick;
	private boolean isSchool = true;

	public RhinoTetra(EntityType<? extends BucketableSchoolingWaterAnimal> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.2F, 0.1F, true);
		this.lookControl = new SmoothSwimmingLookControl(this, 10);
	}

	@Override
	public ItemStack getBucketStack() {
		return ItemStack.EMPTY;
	}

	protected InteractionResult mobInteract(Player p_27477_, InteractionHand p_27478_) {
		return InteractionResult.PASS;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.ATTACK_KNOCKBACK, 3.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 5.0D, 1) {
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
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FollowSchoolLeaderGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.targetSelector.addGoal(1, new ResetUniversalAngerTargetGoal<>(this, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false, this::isAngryAt));
	}

	public void aiStep() {
		if (!this.isInWater() && this.onGround() && this.verticalCollision) {
			this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4D, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
			this.setOnGround(false);
			this.hasImpulse = true;
			this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
		}

		super.aiStep();

		if (isAlive()) {
			if (this.stunnedTick > 0) {
				--this.stunnedTick;
				this.stunEffect();
				if (this.stunnedTick == 0) {
					this.playSound(SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, 1.0F, 0.7F);
				}
			}
		}
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (super.hurt(source, amount) && source.getEntity() instanceof LivingEntity living) {
			setAggressive(true);
			setTarget(living);
		}

		return super.hurt(source, amount);
	}

	protected void blockedByShield(LivingEntity p_33361_) {
		if (this.random.nextFloat() > 0.25F) {
			this.stunnedTick = 80;
			this.playSound(SoundEvents.COD_HURT, 1.0F, 0.5F);
			this.level().broadcastEntityEvent(this, (byte)39);
			p_33361_.push(this);
			setAggressive(false);
			setTarget(null);
		}

		p_33361_.hurtMarked = true;
	}

	@Override
	public void tick() {
		super.tick();

		if (isInWater() && getTarget() != null && isAggressive() && level() instanceof ServerLevel serverLevel && stunnedTick <= 0) {
			Vec3 pos = getYawVec(yHeadRot, 0.0D, -1.25D).add(position());

			setDeltaMovement(calculateViewVector(this.getXRot(), this.getYRot()).scale(0.5D));

			for (int i = 0; i < 5; i++) {
				serverLevel.sendParticles(ParticleTypes.BUBBLE, pos.x(), pos.y() + 0.4F, pos.z(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	private void stunEffect() {
		Vec3 pos = getYawVec(yBodyRot, 0.0D, 0.85D).add(0.0D, 0.85D, 0.0D);

		this.level().addParticle(ParticleTypes.CRIT, pos.x + getRandomX(0.5D), pos.y + position().y, pos.z + getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
	}

	private static Vec3 getYawVec(float yaw, double xOffset, double zOffset) {
		return new Vec3(xOffset, 0, zOffset).yRot(-yaw * ((float) Math.PI / 180f));
	}

	public void handleEntityEvent(byte p_33335_) {
		if (p_33335_ == 39) {
			this.stunnedTick = 80;
		}

		super.handleEntityEvent(p_33335_);
	}

	@Override
	protected boolean isImmobile() {
		return super.isImmobile() || this.stunnedTick > 0;
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new WaterBoundPathNavigation(this, p_27480_);
	}

	public int getMaxSpawnClusterSize() {
		return 5;
	}

	public boolean isMaxGroupSizeReached(int p_30035_) {
		return !this.isSchool;
	}

	public int getMaxSchoolSize() {
		return 7;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.COD_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource p_28281_) {
		return SoundEvents.COD_HURT;
	}

	protected SoundEvent getFlopSound() {
		return SoundEvents.COD_FLOP;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(REMAINING_ANGER_TIME, 0);
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.stunnedTick = compound.getInt("StunTick");
		readPersistentAngerSaveData(level(), compound);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("StunTick", this.stunnedTick);
		addPersistentAngerSaveData(compound);
	}

	@Override
	public void saveToBucketTag(ItemStack bucket) {
		CompoundTag compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putFloat("Health", this.getHealth());
		if (this.hasCustomName()) {
			bucket.setHoverName(this.getCustomName());
		}
	}

	public static boolean canSpawn(EntityType<RhinoTetra> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(REMAINING_ANGER_TIME);
	}

	@Override
	public void setRemainingPersistentAngerTime(int p_21673_) {
		this.entityData.set(REMAINING_ANGER_TIME, p_21673_);
	}

	@Nullable
	@Override
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID p_27791_) {
		this.persistentAngerTarget = p_27791_;
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<GeoEntity>(this, "controller", 2, this::predicate));
	}

	private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {
		if (isInWater()) {
			if (event.isMoving()) {
				event.setAnimation(UFAnimations.SWIM);
			} else {
				event.setAnimation(UFAnimations.IDLE);
			}
		}
		else {
			event.setAnimation(UFAnimations.FLOP);
		}
		return PlayState.CONTINUE;
	}

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
