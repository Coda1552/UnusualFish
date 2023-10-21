package com.peeko32213.unusualfishmod.common.entity.ulitity;

import com.peeko32213.unusualfishmod.common.entity.ai.SemiAquatic;

import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import com.peeko32213.unusualfishmod.core.init.UnusualFishSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.IForgeShearable;

import java.util.Collections;
import java.util.List;

import net.minecraft.util.RandomSource;

import javax.annotation.Nonnull;

public class SmelterSnail extends WaterAnimal implements SemiAquatic, Shearable, IForgeShearable {

    private static final EntityDataAccessor<Integer> GROWTH = SynchedEntityData.defineId(SmelterSnail.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> SHEARED = SynchedEntityData.defineId(SmelterSnail.class, EntityDataSerializers.BOOLEAN);
    private int growthTime = 0;


    public SmelterSnail(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new SmelterSnail.MoveHelperController(this);
        this.maxUpStep = 1.1f;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.1D).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.ARMOR, 15.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 1.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHEARED, Boolean.valueOf(false));
    }

    public int getGrowth() {
        return this.entityData.get(GROWTH).intValue();
    }

    public void setGrowth(int growth) {
        this.entityData.set(GROWTH, Integer.valueOf(growth));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Sheared", this.isSheared());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setSheared(compound.getBoolean("Sheared"));
    }



    protected PathNavigation createNavigation(Level p_27480_) {
        return new GroundPathNavigation(this, level);
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

    public int getMaxAirSupply() {
        return 5000;
    }

    @Override
    public boolean shouldEnterWater() {
        return true;
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

    public boolean readyForShearing() {
        return this.isAlive() && this.getGrowth() > 0;
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, Level world, BlockPos pos) {
        return readyForShearing();
    }

    public boolean isSheared() {
        return this.entityData.get(SHEARED);
    }

    public void setSheared(boolean b) {
        this.entityData.set(SHEARED, b);
    }

    @Override
    public void shear(SoundSource category) {
        level.playSound(null, this, SoundEvents.SHEEP_SHEAR, category, 1.0F, 1.0F);
        if (!level.isClientSide()) {
                 {
                this.spawnAtLocation(Items.RAW_IRON_BLOCK);
                 }
            this.setGrowth(0);
        }
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@javax.annotation.Nullable Player player, @Nonnull ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide()) {
            {
                this.setGrowth(0);
                return Collections.singletonList(new ItemStack(Items.RAW_IRON_BLOCK));
            }
        }
        return java.util.Collections.emptyList();
    }

    public static boolean canSpawn(EntityType<SmelterSnail> entityType, ServerLevelAccessor iServerWorld, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return reason == MobSpawnType.SPAWNER || iServerWorld.getBlockState(pos).is(Blocks.WATER) && pos.getY() <= -10;
    }

}
