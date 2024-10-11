package codyhuh.unusualfishmod.common.entity;


import codyhuh.unusualfishmod.common.entity.util.BucketableWaterAnimal;
import codyhuh.unusualfishmod.common.entity.util.SnailMoveControl;
import codyhuh.unusualfishmod.core.registry.UFItems;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MuddytopSnail extends BucketableWaterAnimal {
    protected int attackCooldown = 0;

    public MuddytopSnail(EntityType<? extends MuddytopSnail> type, Level world) {
        super(type, world);
        this.moveControl = new SnailMoveControl(this);
        this.setMaxUpStep(1.0F);
    }

    @Override
    public ItemStack getBucketStack() {
        return new ItemStack(UFItems.MUDDYTOP_SNAIL_BUCKET.get());
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
        return new GroundPathNavigation(this, level());
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
        if (!entity.isCreative() && this.attackCooldown == 0 && entity.level().getDifficulty() != Difficulty.PEACEFUL) {
            entity.hurt(damageSources().mobAttack(this), 2.0F);
            this.attackCooldown = 80;
        }
    }

    protected SoundEvent getAmbientSound() {
        return isInWater() ? SoundEvents.BUBBLE_COLUMN_UPWARDS_AMBIENT : SoundEvents.EMPTY;
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
