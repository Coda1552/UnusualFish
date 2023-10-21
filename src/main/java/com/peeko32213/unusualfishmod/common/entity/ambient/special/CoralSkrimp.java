package com.peeko32213.unusualfishmod.common.entity.ambient.special;



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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import net.minecraft.util.RandomSource;

public class CoralSkrimp extends WaterAnimal implements Bucketable{
	private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(CoralSkrimp.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(CoralSkrimp.class, EntityDataSerializers.INT);

	public CoralSkrimp(EntityType<? extends CoralSkrimp> type, Level world) {
		super(type, world);
		this.moveControl = new CoralSkrimp.MoveHelperController(this);
		this.maxUpStep = 1.5f;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.5F);
	}


	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.5F));
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.5F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new GroundPathNavigation(this, level);
	}

	@Override
	public float getWaterSlowDown() {
		return 0.9f;
	}

	@Override
	public void handleAirSupply(int p_209207_1_) {
	}

	protected SoundEvent getAmbientSound() {
		return UnusualFishSounds.CRAB_CHATTER.get();
	}
	protected SoundEvent getDeathSound() {
		return SoundEvents.COD_DEATH;
	}

	protected SoundEvent getHurtSound(DamageSource p_28281_) {
		return SoundEvents.COD_HURT;
	}

	protected void playStepSound(BlockPos p_33804_, BlockState p_33805_) {
		this.playSound(UnusualFishSounds.CRAB_SCUTTLING.get(), 0.15F, 1.0F);
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
		this.entityData.define(FROM_BUCKET, false);
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
		compound.putBoolean("FromBucket", this.isFromBucket());
		compound.putBoolean("Bucketed", this.fromBucket());
		compound.putInt("Variant", getVariant());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		setVariant(compound.getInt("Variant"));
		this.setFromBucket(compound.getBoolean("FromBucket"));
		this.setFromBucket(compound.getBoolean("Bucketed"));
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		if (dataTag == null) {
			setVariant(random.nextInt(3));
		} else {
			if (dataTag.contains("Variant", 3)){
				this.setVariant(dataTag.getInt("Variant"));
			}
		}
		return spawnDataIn;
	}


	@Override
	public boolean fromBucket() {
		return this.entityData.get(FROM_BUCKET);
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
		return new ItemStack(UnusualFishItems.CORAL_SKRIMP_BUCKET.get());
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

	public static boolean canSpawn(EntityType<CoralSkrimp> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}
}



