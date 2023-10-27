package codyhuh.unusualfishmod.common.entity.ulitity;


import codyhuh.unusualfishmod.common.entity.ai.SemiAquatic;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import codyhuh.unusualfishmod.common.entity.ambient.small.AeroMono;
import codyhuh.unusualfishmod.common.entity.ambient.small.RhinoTetra;
import codyhuh.unusualfishmod.common.entity.ambient.small.SailorBarb;
import codyhuh.unusualfishmod.common.entity.ambient.small.SneepSnorp;

import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.util.RandomSource;

public class FreshwaterMantis extends WaterAnimal implements Bucketable, SemiAquatic {
	private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(FreshwaterMantis.class, EntityDataSerializers.BOOLEAN);


	public FreshwaterMantis(EntityType<? extends FreshwaterMantis> type, Level world) {
		super(type, world);
		this.moveControl = new FreshwaterMantis.MoveHelperController(this);
		this.maxUpStep = 1.1f;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.25D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.5D, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BlackCapSnail.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AeroMono.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SneepSnorp.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, RhinoTetra.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SailorBarb.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Silverfish.class, true));
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 1.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		boolean flag = entityIn.hurt(DamageSource.mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new GroundPathNavigation(this, level);
	}


	protected SoundEvent getAmbientSound() {
		return UFSounds.CRAB_CHATTER.get();
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
	public float getWaterSlowDown() {
		return 0.9f;
	}

	public void baseTick() {
		int i = this.getAirSupply();
		super.baseTick();
		if (!this.isNoAi()) {
			this.handleAirSupply(i);
		}
	}

	protected void handleAirSupply(int p_149194_) {
		if (this.isAlive() && !this.isInWaterRainOrBubble()) {
			this.setAirSupply(p_149194_ - 1);
			if (this.getAirSupply() == -20) {
				this.setAirSupply(0);
				this.hurt(DamageSource.DRY_OUT, 1.0F);
			}
		} else {
			this.setAirSupply(this.getMaxAirSupply());
		}
	}

	public int getMaxAirSupply() {
		return 5000;
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
		return new ItemStack(UFItems.FRESHWATER_MANTIS_BUCKET.get());
	}

	@Override
	public boolean shouldEnterWater() {
		return false;
	}

	@Override
	public boolean shouldLeaveWater() {
		return false;
	}

	@Override
	public boolean shouldStopMoving() {
		return false;
	}

	@Override
	public int getWaterSearchRange() {
		return 0;
	}


	static class MoveHelperController extends MoveControl {
		private final Mob mantis;

		MoveHelperController(Mob mantis) {
			super(mantis);
			this.mantis = mantis;
		}

		public void tick() {
			if (this.mantis.isEyeInFluid(FluidTags.WATER)) {
				this.mantis.setDeltaMovement(this.mantis.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
			}

			if (this.operation == Operation.MOVE_TO && !this.mantis.getNavigation().isDone()) {
				double d0 = this.wantedX - this.mantis.getX();
				double d1 = this.wantedY - this.mantis.getY();
				double d2 = this.wantedZ - this.mantis.getZ();
				double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
				d1 = d1 / d3;
				float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.mantis.yRot = this.rotlerp(this.mantis.yRot, f, 90.0F);
				this.mantis.yBodyRot = this.mantis.yRot;
				float f1 = (float) (this.speedModifier * this.mantis.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.mantis.setSpeed(Mth.lerp(0.125F, this.mantis.getSpeed(), f1));
				this.mantis.setDeltaMovement(this.mantis.getDeltaMovement().add(0.0D, (double) this.mantis.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.mantis.setSpeed(0.0F);
			}
		}
	}

	public static <T extends Mob> boolean canSpawn(EntityType<FreshwaterMantis> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}
}



