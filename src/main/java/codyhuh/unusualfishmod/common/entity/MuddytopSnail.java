package codyhuh.unusualfishmod.common.entity;


import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
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
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MuddytopSnail extends WaterAnimal{
    protected int attackCooldown = 0;

    public MuddytopSnail(EntityType<? extends MuddytopSnail> type, Level world) {
        super(type, world);
        this.moveControl = new MuddytopSnail.MoveHelperController(this);
        this.maxUpStep = 1.0f;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.ARMOR, (double) 8.0F);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.3F));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.3F));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
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


    @Override
    public void playerTouch(Player entity) {
        super.playerTouch(entity);
        if (!entity.isCreative() && this.attackCooldown == 0 && entity.level.getDifficulty() != Difficulty.PEACEFUL) {
            entity.hurt(DamageSource.mobAttack(this), 2.0F);
            this.attackCooldown = 80;
        }
    }

    static class MoveHelperController extends MoveControl {
        private final Mob snail;

        MoveHelperController(Mob snail) {
            super(snail);
            this.snail = snail;
        }

        public void tick() {
            if (this.snail.isEyeInFluid(FluidTags.WATER)) {
                this.snail.setDeltaMovement(this.snail.getDeltaMovement().add(0.0D, 0.0D, 0.0D));
            }

            if (this.operation == Operation.MOVE_TO && !this.snail.getNavigation().isDone()) {
                double d0 = this.wantedX - this.snail.getX();
                double d1 = this.wantedY - this.snail.getY();
                double d2 = this.wantedZ - this.snail.getZ();
                double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
                d1 = d1 / d3;
                float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.snail.yRot = this.rotlerp(this.snail.yRot, f, 90.0F);
                this.snail.yBodyRot = this.snail.yRot;
                float f1 = (float) (this.speedModifier * this.snail.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.snail.setSpeed(Mth.lerp(0.125F, this.snail.getSpeed(), f1));
                this.snail.setDeltaMovement(this.snail.getDeltaMovement().add(0.0D, (double) this.snail.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.snail.setSpeed(0.0F);
            }
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BUBBLE_COLUMN_UPWARDS_AMBIENT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_28281_) {
        return SoundEvents.COD_HURT;
    }

    public static boolean canSpawn(EntityType<MuddytopSnail> p_223364_0_, LevelAccessor p_223364_1_, MobSpawnType reason, BlockPos p_223364_3_, RandomSource random) {
        return WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_223364_0_, p_223364_1_, reason, p_223364_3_, random);
    }
}
