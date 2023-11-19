package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.common.entity.util.BottomStrollGoal;
import codyhuh.unusualfishmod.common.entity.util.SearchSandGoal;
import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
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
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SeaPancake extends WaterAnimal {
	private static final EntityDataAccessor<BlockPos> TREASURE_POS = SynchedEntityData.defineId(SeaPancake.class, EntityDataSerializers.BLOCK_POS);
	private static final EntityDataAccessor<Boolean> GOT_FISH = SynchedEntityData.defineId(SeaPancake.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DIGGING = SynchedEntityData.defineId(SeaPancake.class, EntityDataSerializers.BOOLEAN);
	protected int attackCooldown = 0;

	public SeaPancake(EntityType<? extends WaterAnimal> entityType, Level level) {
		super(entityType, level);
		this.moveControl = new SmoothSwimmingMoveControl(this, 45, 10, 0.02F, 0.1F, true);
		this.lookControl = new SmoothSwimmingLookControl(this, 10);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.ATTACK_DAMAGE, 5.0D);
	}

	@Override
	public void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 3.0D, true));
		this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
		this.goalSelector.addGoal(1, new SearchSandGoal(this));
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
		this.goalSelector.addGoal(3, new BottomStrollGoal(this, 0.8F, 7));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TropicalFish.class, false));
	}

	public void tick() {
		super.tick();

		if (this.attackCooldown > 0) {
			this.attackCooldown--;
		}
	}

	public boolean closeToNextPos() {
		BlockPos blockpos = this.getNavigation().getTargetPos();
		return blockpos != null && blockpos.closerToCenterThan(this.position(), 2.0D);
	}

	protected InteractionResult mobInteract(Player p_28359_, InteractionHand p_28360_) {
		ItemStack itemstack = p_28359_.getItemInHand(p_28360_);
		if (!itemstack.isEmpty() && itemstack.is(UFItems.RAW_LOBSTER.get())) {
			if (!this.level.isClientSide) {
				this.playSound(SoundEvents.DOLPHIN_EAT, 1.0F, 1.0F);
			}

			this.setGotFish(true);
			if (!p_28359_.getAbilities().instabuild) {
				itemstack.shrink(1);
			}

			return InteractionResult.sidedSuccess(this.level.isClientSide);
		} else {
			return super.mobInteract(p_28359_, p_28360_);
		}
	}

	public boolean requiresCustomPersistence() {
		return true;
	}

	public void aiStep() {
		if (!this.isInWater() && this.onGround && this.verticalCollision) {
			this.setDeltaMovement(this.getDeltaMovement().add(((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4F, ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
			this.onGround = false;
			this.hasImpulse = true;
			this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
		}

		super.aiStep();
	}

	public void setTreasurePos(BlockPos p_28385_) {
		this.entityData.set(TREASURE_POS, p_28385_);
	}

	public BlockPos getTreasurePos() {
		return this.entityData.get(TREASURE_POS);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TREASURE_POS, BlockPos.ZERO);
		this.entityData.define(GOT_FISH, false);
		this.entityData.define(DIGGING, false);
	}

	public boolean isDigging() {
		return this.entityData.get(DIGGING);
	}

	public void setDigging(boolean digging) {
		this.entityData.set(DIGGING, digging);
	}

	public boolean gotFish() {
		return this.entityData.get(GOT_FISH);
	}

	public void setGotFish(boolean p_28394_) {
		this.entityData.set(GOT_FISH, p_28394_);
	}


	public void addAdditionalSaveData(CompoundTag p_28364_) {
		super.addAdditionalSaveData(p_28364_);
		p_28364_.putInt("TreasurePosX", this.getTreasurePos().getX());
		p_28364_.putInt("TreasurePosY", this.getTreasurePos().getY());
		p_28364_.putInt("TreasurePosZ", this.getTreasurePos().getZ());
		p_28364_.putBoolean("GotFish", this.gotFish());
	}

	public void readAdditionalSaveData(CompoundTag p_28340_) {
		int i = p_28340_.getInt("TreasurePosX");
		int j = p_28340_.getInt("TreasurePosY");
		int k = p_28340_.getInt("TreasurePosZ");
		this.setTreasurePos(new BlockPos(i, j, k));
		super.readAdditionalSaveData(p_28340_);
		this.setGotFish(p_28340_.getBoolean("GotFish"));
	}


	protected PathNavigation createNavigation(Level p_27480_) {
		return new WaterBoundPathNavigation(this, p_27480_);
	}

	protected SoundEvent getAmbientSound() {
		return UFSounds.LARGE_FISH.get();
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

	@Override
	public void playerTouch(Player entity) {
		super.playerTouch(entity);
		if (!entity.isCreative() && this.attackCooldown == 0 && entity.level.getDifficulty() != Difficulty.PEACEFUL) {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3, false, false));
			entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 100, 2, false, false));
			this.attackCooldown = 80;
		}
	}

	public static boolean canSpawn(EntityType<SeaPancake> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}
}
