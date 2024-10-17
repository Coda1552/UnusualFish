package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.base.BucketableWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.misc.UFAnimations;
import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import codyhuh.unusualfishmod.core.registry.UFTags;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FreshwaterMantis extends BucketableWaterAnimal implements GeoEntity {

	public FreshwaterMantis(EntityType<? extends FreshwaterMantis> type, Level world) {
		super(type, world);
		this.moveControl = new FreshwaterMantis.MoveHelperController(this);
		this.setMaxUpStep(1.1F);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.5D, false));
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 1.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, true, e -> e.getType().is(UFTags.SNAILS)));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AeroMono.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SneepSnorp.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, RhinoTetra.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SailorBarb.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Silverfish.class, true));
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new GroundPathNavigation(this, level());
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
				this.hurt(damageSources().dryOut(), 1.0F);
			}
		} else {
			this.setAirSupply(this.getMaxAirSupply());
		}
	}

	public int getMaxAirSupply() {
		return 6000;
	}

	@Override
	public ItemStack getBucketStack() {
		return new ItemStack(UFItems.FRESHWATER_MANTIS_BUCKET.get());
	}

	public static boolean canSpawn(EntityType<FreshwaterMantis> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<GeoEntity>(this, "controller", 2, this::predicate));
	}

	private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {
		if (isInWater()) {
			if (event.isMoving()) {
				event.setAnimation(UFAnimations.WALK);
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
}



