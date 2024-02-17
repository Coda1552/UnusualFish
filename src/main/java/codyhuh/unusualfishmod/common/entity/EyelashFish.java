package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.BucketableSchoolingWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.FollowSchoolLeaderGoal;
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
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.Path;

import javax.annotation.Nullable;

public class EyelashFish extends BucketableSchoolingWaterAnimal {
	private static final EntityDataAccessor<Boolean> ESCAPING = SynchedEntityData.defineId(EyelashFish.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(EyelashFish.class, EntityDataSerializers.INT);
	private boolean isSchool = true;
	private static Path path;

	public EyelashFish(EntityType<? extends BucketableSchoolingWaterAnimal> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.05F, 0.1F, true);
		this.lookControl = new SmoothSwimmingLookControl(this, 10);
	}

	@Override
	public ItemStack getBucketStack() {
		return new ItemStack(UFItems.EYELASH_FISH_BUCKET.get());
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0D, 1) {
			@Override
			public boolean canUse() {
				return super.canUse() && isInWater();
			}
		});
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FollowSchoolLeaderGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
	}

	@Override
	public boolean hurt(DamageSource p_21016_, float p_21017_) {
		if (!isEscaping() && isInWater()) {
			setEscaping(true);
			path = getNavigation().createPath(blockPosition().relative(getDirection(), 10), 1);
		}
		return super.hurt(p_21016_, p_21017_);
	}

	public void aiStep() {
		if (!this.isInWater() && this.onGround() && this.verticalCollision) {
			this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4F, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
			this.setOnGround(false);
			this.hasImpulse = true;
			this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
		}

		if (isEscaping()) {
			if (getNavigation().moveTo(path, 1.0D)) {
				setSpeed(5.0F);

				if (path.isDone()) {
					setEscaping(false);
					setSpeed(1.0F);
				}
			}
		}

		super.aiStep();
	}

	public int getMaxSpawnClusterSize() {
		return 8;
	}

	public boolean isMaxGroupSizeReached(int p_30035_) {
		return !this.isSchool;
	}

	public int getMaxSchoolSize() {
		return 10;
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new WaterBoundPathNavigation(this, p_27480_);
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
	public void saveToBucketTag(ItemStack bucket) {
		CompoundTag compoundnbt = bucket.getOrCreateTag();
		compoundnbt.putInt("Variant", this.getVariant());
		if (this.hasCustomName()) {
			bucket.setHoverName(this.getCustomName());
		}
		compoundnbt.putFloat("Health", this.getHealth());
	}

	@Override
	public void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VARIANT, 0);
		this.entityData.define(ESCAPING, false);
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
			setVariant(random.nextInt(15));
		} else {
			if (dataTag.contains("Variant", 11)){
				this.setVariant(dataTag.getInt("Variant"));
			}
		}
		return spawnDataIn;
	}

	private boolean isEscaping() {
		return this.entityData.get(ESCAPING);
	}

	public void setEscaping(boolean escaping) {
		this.entityData.set(ESCAPING, escaping);
	}

	public static boolean canSpawn(EntityType<EyelashFish> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}

}
