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

public class PorcupineLobster extends BucketableWaterAnimal implements GeoEntity {
    protected int attackCooldown = 0;

    public PorcupineLobster(EntityType<? extends PorcupineLobster> type, Level world) {
        super(type, world);
        this.moveControl = new PorcupineLobster.MoveHelperController(this);
        this.setMaxUpStep(1.5F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.5F).add(Attributes.ARMOR, (double) 7.0F).add(Attributes.ATTACK_DAMAGE, (double) 3.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.5F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.5F));
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
            entity.hurt(damageSources().mobAttack(this), 3.0F);
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
        this.playSound(UFSounds.CRAB_CHATTER.get(), 0.15F, 1.0F);
    }

    @Override
    public ItemStack getBucketStack() {
        return new ItemStack(UFItems.PORCUPINE_LOBSTA_BUCKET.get());
    }

    public static boolean canSpawn(EntityType<PorcupineLobster> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
        return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
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

    static class MoveHelperController extends MoveControl {
        private final Mob lobsta;

        MoveHelperController(Mob lobsta) {
            super(lobsta);
            this.lobsta = lobsta;
        }

        public void tick() {
            if (this.lobsta.isEyeInFluid(FluidTags.WATER)) {
                this.lobsta.setDeltaMovement(this.lobsta.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }

            if (this.operation == MoveControl.Operation.MOVE_TO && !this.lobsta.getNavigation().isDone()) {
                double d0 = this.wantedX - this.lobsta.getX();
                double d1 = this.wantedY - this.lobsta.getY();
                double d2 = this.wantedZ - this.lobsta.getZ();
                double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
                d1 = d1 / d3;
                float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.lobsta.yRot = this.rotlerp(this.lobsta.yRot, f, 90.0F);
                this.lobsta.yBodyRot = this.lobsta.yRot;
                float f1 = (float) (this.speedModifier * this.lobsta.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.lobsta.setSpeed(Mth.lerp(0.125F, this.lobsta.getSpeed(), f1));
                this.lobsta.setDeltaMovement(this.lobsta.getDeltaMovement().add(0.0D, (double) this.lobsta.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.lobsta.setSpeed(0.0F);
            }
        }
}
}
