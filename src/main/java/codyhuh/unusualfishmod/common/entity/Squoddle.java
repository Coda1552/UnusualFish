package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.base.BucketableWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.misc.UFAnimations;
import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
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
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
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

public class Squoddle extends BucketableWaterAnimal implements GeoEntity {
	protected int attackCooldown = 0;

	public Squoddle(EntityType<? extends Squoddle> type, Level world) {
		super(type, world);
		this.moveControl = new Squoddle.MoveHelperController(this);
		this.setMaxUpStep(1.5F);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.4D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.0F));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.4F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
	}

	@Override
	public void tick() {
		super.tick();
		if (this.attackCooldown > 0) {
			this.attackCooldown--;
		}
	}

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		if (!entity.isCreative() && this.attackCooldown == 0 && entity.level().getDifficulty() != Difficulty.PEACEFUL) {
			entity.hurt(damageSources().mobAttack(this), 2.0F);
			this.playSound(SoundEvents.PUFFER_FISH_STING, 1.0F, 1.0F);
			this.attackCooldown = 80;
		}
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new GroundPathNavigation(this, level());
	}

	@Override
	public float getWaterSlowDown() {
		return 0.9f;
	}

	@Override
	public void handleAirSupply(int p_209207_1_) {
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
	public ItemStack getBucketStack() {
		return new ItemStack(UFItems.SQUODDLE_BUCKET.get());
	}

	public static boolean canSpawn(EntityType<Squoddle> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
		controllerRegistrar.add(new AnimationController<GeoEntity>(this, "controller", 2, this::predicate));
	}

	private <E extends GeoEntity> PlayState predicate(AnimationState<E> event) {
		if (event.isMoving()) {
			event.setAnimation(UFAnimations.WALK);
		} else {
			event.setAnimation(UFAnimations.IDLE);
		}
		return PlayState.CONTINUE;
	}

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}

	static class MoveHelperController extends MoveControl {

		private final Mob squoddle;

		MoveHelperController(Mob squoddle) {
			super(squoddle);
			this.squoddle = squoddle;
		}
		public void tick() {
			if (this.squoddle.isEyeInFluid(FluidTags.WATER)) {
				this.squoddle.setDeltaMovement(this.squoddle.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
			}

			if (this.operation == Operation.MOVE_TO && !this.squoddle.getNavigation().isDone()) {
				double d0 = this.wantedX - this.squoddle.getX();
				double d1 = this.wantedY - this.squoddle.getY();
				double d2 = this.wantedZ - this.squoddle.getZ();
				double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
				d1 = d1 / d3;
				float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.squoddle.yRot = this.rotlerp(this.squoddle.yRot, f, 90.0F);
				this.squoddle.yBodyRot = this.squoddle.yRot;
				float f1 = (float) (this.speedModifier * this.squoddle.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.squoddle.setSpeed(Mth.lerp(0.125F, this.squoddle.getSpeed(), f1));
				this.squoddle.setDeltaMovement(this.squoddle.getDeltaMovement().add(0.0D, (double) this.squoddle.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.squoddle.setSpeed(0.0F);
			}
		}
	}
}



