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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class DeepCrawler extends BucketableWaterAnimal implements GeoEntity {

	public DeepCrawler(EntityType<? extends DeepCrawler> type, Level world) {
		super(type, world);
		this.moveControl = new DeepCrawler.MoveHelperController(this);
		this.setMaxUpStep(1.0F);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.5F).add(Attributes.ARMOR, 10.0D);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8F));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.8F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new AvoidEntityGoal(this, Player.class, 8, 1.3D, 1.0D));
	}

	protected PathNavigation createNavigation(Level p_27480_) {
		return new GroundPathNavigation(this, level());
	}

	@Override
	public void handleAirSupply(int p_209207_1_) {
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
	public ItemStack getBucketStack() {
		return new ItemStack(UFItems.DEEP_CRAWLER_BUCKET.get());
	}

	public static boolean canSpawn(EntityType<DeepCrawler> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return reason == MobSpawnType.SPAWNER || iServerWorld.getBlockState(pos).is(Blocks.WATER) && iServerWorld.getBlockState(pos.above()).is(Blocks.WATER) && pos.getY() <= 20 && iServerWorld.getLightEmission(pos) < 8;
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



