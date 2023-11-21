package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.util.BottomStrollGoal;
import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

public class SeaPancake extends WaterAnimal {
	public static final ResourceLocation FEED_REWARD = new ResourceLocation(UnusualFishMod.MOD_ID, "gameplay/sea_pancake_search");
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
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8D, 15) {
			@Override
			public boolean canUse() {
				return !this.mob.isInWater() && super.canUse();
			}
		});
		this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.8D, 1) {
			@Override
			public boolean canUse() {
				return super.canUse() && isInWater();
			}
		});
		this.goalSelector.addGoal(3, new BottomStrollGoal(this, 0.8F, 7));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, TropicalFish.class, false));
	}

	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);

		if (stack.is(UFItems.RAW_LOBSTER.get()) && level instanceof ServerLevel serverLevel) {
			LootTable loottable = serverLevel.getServer().getLootTables().get(FEED_REWARD);
			List<ItemStack> list = loottable.getRandomItems((new LootContext.Builder((ServerLevel) level)).withParameter(LootContextParams.ORIGIN, position()).withParameter(LootContextParams.THIS_ENTITY, this).withRandom(random).create(LootContextParamSets.PIGLIN_BARTER));

			if (!list.isEmpty() && random.nextBoolean()) {
				ItemEntity item = EntityType.ITEM.create(level);

				item.setItem(list.get(0));
				item.moveTo(position());

				level.addFreshEntity(item);

				playSound(SoundEvents.ITEM_PICKUP, 1.0F, 1.0F);
			}

			if (!player.getAbilities().instabuild) {
				stack.shrink(1);
			}

			serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack), getRandomX(1.0D), position().y - 0.25D, getRandomZ(1.0D), 1, 0.0D, 0.0D, 0.0D, 0.0D);
			playSound(SoundEvents.DOLPHIN_EAT, 1.0F, 1.0F);
		}

		return super.mobInteract(player, hand);
	}

	public void tick() {
		super.tick();

		if (this.attackCooldown > 0) {
			this.attackCooldown--;
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
	public void playerTouch(Player entity) { // todo - remove
		super.playerTouch(entity);
	}

	public static boolean canSpawn(EntityType<SeaPancake> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
		return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
	}
}
