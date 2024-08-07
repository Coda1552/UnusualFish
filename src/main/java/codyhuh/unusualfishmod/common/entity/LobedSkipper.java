package codyhuh.unusualfishmod.common.entity;

import codyhuh.unusualfishmod.core.registry.UFItems;
import codyhuh.unusualfishmod.core.registry.UFSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class LobedSkipper extends PathfinderMob implements Bucketable {
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(LobedSkipper.class, EntityDataSerializers.BOOLEAN);

    public LobedSkipper(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.jumpControl = new SkipperJumpController();
        this.moveControl = new SkipperMoveController();
        this.setMovementSpeed(0.0D);
        this.setMaxUpStep(1.1F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 5.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.5D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 0.5F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Nonnull
    @Override
    public MoveControl getMoveControl() {
        return moveControl;
    }

    @Nonnull
    @Override
    public JumpControl getJumpControl() {
        return jumpControl;
    }

    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource source) {
        return false;
    }

    @Override
    protected float getStandingEyeHeight(@Nonnull Pose pose, EntityDimensions size) {
        return 0.2f * size.height;
    }

    @Override
    public void tick() {

        if (this.jumpTicks != this.jumpDuration) ++this.jumpTicks;
        else if (this.jumpDuration != 0) {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);

        }

        super.tick();

        this.yRotO = this.yHeadRotO;
        this.setYRot(this.yHeadRot);
    }

    @Override
    protected float getJumpPower() {
        float motion = super.getJumpPower();
            return motion;
    }

    private int jumpTicks;
    private int jumpDuration;
    private boolean wasOnGround;
    private int currentMoveTypeDuration;

    @Override
    public void customServerAiStep() {
        if (this.currentMoveTypeDuration > 0) --this.currentMoveTypeDuration;

        if (this.onGround()) {
            if (!this.wasOnGround) {
                this.setJumping(false);
                this.checkLandingDelay();
            }

            SkipperJumpController jumpHelper = (SkipperJumpController) this.jumpControl;

            if (!jumpHelper.getIsJumping()) {
                if (this.moveControl.hasWanted() && this.currentMoveTypeDuration == 0) {
                    Path path = this.navigation.getPath();
                    Vec3 Vector3d = new Vec3(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());

                    if (path != null && path.getNextNodeIndex() < path.getNodeCount())
                        Vector3d = path.getNextEntityPos(this);

                    this.calculateRotationYaw(Vector3d.x, Vector3d.z);
                    this.startJumping();
                }
            } else if (!jumpHelper.canJump()) this.enableJumpControl();
        }

        this.wasOnGround = this.onGround();
    }

    @Override
    public boolean canSpawnSprintParticle() {
        return false;
    }

    private void calculateRotationYaw(double x, double z) {
        Vec3 pos = position();
        setYRot((float) (Mth.atan2(z - pos.z, x - pos.x) * (180D / Math.PI)) - 90.0F);
    }

    private void enableJumpControl() {
        ((SkipperJumpController) this.jumpControl).setCanJump(true);
    }

    private void disableJumpControl() {
        ((SkipperJumpController) this.jumpControl).setCanJump(false);
    }

    private void updateMoveTypeDuration() {
        if (this.moveControl.getSpeedModifier() < 2.2D)
            this.currentMoveTypeDuration = 10;
        else
            this.currentMoveTypeDuration = 1;
    }

    private void checkLandingDelay() {
        this.updateMoveTypeDuration();
        this.disableJumpControl();
    }

    @Override
    protected void jumpFromGround() {
        super.jumpFromGround();
        double d0 = this.moveControl.getSpeedModifier();

        if (d0 > 0.0D) {
            Vec3 motion = getDeltaMovement();
            double d1 = motion.x * motion.x + motion.z * motion.z;

            if (d1 < 0.01) {
                this.moveRelative(0.1F, new Vec3(0.0F, 0.0F, 1.0F));
            }
        }

        if (!this.level().isClientSide)
            this.level().broadcastEntityEvent(this, (byte) 1);
    }

    public void setMovementSpeed(double newSpeed) {
        this.getNavigation().setSpeedModifier(newSpeed);
        this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), newSpeed);
    }

    @Override
    public void setJumping(boolean jumping) {
        super.setJumping(jumping);
    }

    public void startJumping() {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        if (id == 1) {
            this.jumpDuration = 10;
            this.jumpTicks = 0;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Nonnull
    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public class SkipperJumpController extends JumpControl {
        private boolean canJump;

        public SkipperJumpController() {
            super(LobedSkipper.this);
        }

        public boolean getIsJumping() {
            return this.jump;
        }

        public boolean canJump() {
            return this.canJump;
        }

        public void setCanJump(boolean canJumpIn) {
            this.canJump = canJumpIn;
        }

        @Override
        public void tick() {
            if (this.jump) {
                startJumping();
                this.jump = false;
            }
        }
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
        return new ItemStack(UFItems.SKIPPER_BUCKET.get());
    }

    public static boolean canSpawn(EntityType type, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return worldIn.getBlockState(pos.below()).canOcclude();
    }

    public class SkipperMoveController extends MoveControl {
        private double nextJumpSpeed;

        public SkipperMoveController() {
            super(LobedSkipper.this);
        }

        @Override
        public void tick() {
            if (onGround() && !jumping && !((SkipperJumpController) jumpControl).getIsJumping())
                setMovementSpeed(0.0D);
            else if (this.hasWanted()) setMovementSpeed(this.nextJumpSpeed);

            super.tick();
        }

        @Override
        public void setWantedPosition(double x, double y, double z, double speedIn) {
            if (isInWater()) speedIn = 1.5D;

            super.setWantedPosition(x, y, z, speedIn);

            if (speedIn > 0.0D) this.nextJumpSpeed = speedIn;
        }
    }
}
