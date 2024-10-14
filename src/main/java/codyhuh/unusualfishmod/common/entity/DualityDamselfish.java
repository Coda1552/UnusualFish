package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.base.BucketableSchoolingWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.goal.FollowSchoolLeaderGoal;
import codyhuh.unusualfishmod.common.entity.util.misc.IVariant;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class DualityDamselfish extends BucketableSchoolingWaterAnimal implements GeoEntity, IVariant {
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(DualityDamselfish.class, EntityDataSerializers.INT);
	private boolean isSchool = true;

	public DualityDamselfish(EntityType<? extends BucketableSchoolingWaterAnimal> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
		this.lookControl = new SmoothSwimmingLookControl(this, 10);
	}

	@Override
	public ItemStack getBucketStack() {
		return new ItemStack(UFItems.DUALITY_DAMSELFISH_BUCKET.get());
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(4, new FollowSchoolLeaderGoal(this));
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

	public void aiStep() {
		if (!this.isInWater() && this.onGround() && this.verticalCollision) {
			this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4D, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
			this.setOnGround(false);
			this.hasImpulse = true;
			this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
		}

		super.aiStep();
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new WaterBoundPathNavigation(this, p_27480_);
	}

	public int getMaxSpawnClusterSize() {
		return 1;
	}

	public boolean isMaxGroupSizeReached(int p_30035_) {
		return !this.isSchool;
	}

	public int getMaxSchoolSize() {
		return 2;
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

	public static boolean canSpawn(EntityType<DualityDamselfish> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}

	@Override
	public void saveToBucketTag(ItemStack bucket) {
		CompoundTag tag = bucket.getOrCreateTag();
		tag.putInt("Variant", this.getVariant());
		super.saveToBucketTag(bucket);
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
	}

	@Override
	public boolean hasVariant() {
		return true;
	}

	@Override
	public int getVariantN() {
		return getVariant();
	}

	public int getVariant() {
		return this.entityData.get(VARIANT);
	}

	private void setVariant(int variant) {
		this.entityData.set(VARIANT, variant);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Variant", getVariant());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		setVariant(compound.getInt("Variant"));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		if (dataTag == null) {
			setVariant(random.nextInt(2));
		} else {
			if (dataTag.contains("Variant", 3)){
				this.setVariant(dataTag.getInt("Variant"));
			}
		}
		return spawnDataIn;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<GeoEntity>(this, "controller", 2, this::predicate));
	}

	private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {
		if (event.isMoving()) {
		//	event.setAnimation(UFAnimations.SWIM);
		}
		else {
		//	event.setAnimation(UFAnimations.IDLE);
		}

		return PlayState.CONTINUE;
	}

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}
