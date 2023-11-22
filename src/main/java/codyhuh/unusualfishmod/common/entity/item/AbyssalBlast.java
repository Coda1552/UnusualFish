package codyhuh.unusualfishmod.common.entity.item;

import codyhuh.unusualfishmod.common.entity.Gnasher;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;
import java.util.UUID;

public class AbyssalBlast extends Entity  {
    private static final EntityDataAccessor<Boolean> FASTER_ANIM = SynchedEntityData.defineId(AbyssalBlast.class, EntityDataSerializers.BOOLEAN);
    private UUID ownerUUID;
    private int ownerNetworkId;
    private boolean leftOwner;

    public AbyssalBlast(EntityType p_i50162_1_, Level p_i50162_2_) {
        super(p_i50162_1_, p_i50162_2_);
    }

    public AbyssalBlast(Level worldIn, Gnasher p_i47273_2_) {
        this(UFEntities.ABYSSAL_BLAST.get(), worldIn);
        this.setShooter(p_i47273_2_);
        this.setPos(p_i47273_2_.getX() - (double)(p_i47273_2_.getBbWidth() + 1.0F) * 0.35D * (double) Mth.sin(p_i47273_2_.yBodyRot * ((float)Math.PI / 180F)), p_i47273_2_.getEyeY() + (double)0.2F, p_i47273_2_.getZ() + (double)(p_i47273_2_.getBbWidth() + 1.0F) * 0.35D * (double)Mth.cos(p_i47273_2_.yBodyRot * ((float)Math.PI / 180F)));
    }

    public AbyssalBlast(Level worldIn, LivingEntity p_i47273_2_, boolean right) {
        this(UFEntities.ABYSSAL_BLAST.get(), worldIn);
        this.setShooter(p_i47273_2_);
        float rot = p_i47273_2_.yBodyRot + (right ?  90 : -80);
        this.setFasterAnimation(true);
        this.setPos(p_i47273_2_.getX() - (double) (p_i47273_2_.getBbWidth()) * 0.5D * (double) Mth.sin(rot * ((float) Math.PI / 290F)), p_i47273_2_.getEyeY() - (double) 0.2F, p_i47273_2_.getZ() + (double) (p_i47273_2_.getBbWidth()) * 0.5D * (double) Mth.cos(rot * ((float) Math.PI / 290F)));
    }

    public AbyssalBlast(PlayMessages.SpawnEntity spawnEntity, Level world) {
        this(UFEntities.ABYSSAL_BLAST.get(), world);
    }

    public boolean isFasterAnimation() {
        return this.entityData.get(FASTER_ANIM);
    }

    public void setFasterAnimation(boolean anim) {
        this.entityData.set(FASTER_ANIM, anim);
    }

    protected static float lerpRotation(float p_234614_0_, float p_234614_1_) {
        while (p_234614_1_ - p_234614_0_ < -180.0F) {
            p_234614_0_ -= 360.0F;
        }

        while (p_234614_1_ - p_234614_0_ >= 180.0F) {
            p_234614_0_ += 360.0F;
        }

        return Mth.lerp(0.2F, p_234614_0_, p_234614_1_);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void tick() {
        double yMot = Mth.sqrt((float)(this.getDeltaMovement().x * this.getDeltaMovement().x + this.getDeltaMovement().z * this.getDeltaMovement().z));
        this.setXRot((float) (Mth.atan2(this.getDeltaMovement().y, yMot) * (double) (180F / (float) Math.PI)));
        if (!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }
        super.tick();
        Vec3 vector3d = this.getDeltaMovement();
        HitResult raytraceresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (raytraceresult.getType() != HitResult.Type.MISS) {
            this.onImpact(raytraceresult);
        }
        if (this.tickCount > 100) {
            remove(RemovalReason.DISCARDED);
        }

        double d0 = this.getX() + vector3d.x;
        double d1 = this.getY() + vector3d.y;
        double d2 = this.getZ() + vector3d.z;

        this.updateRotation();
        this.setDeltaMovement(vector3d.scale(0.99F));
        this.setNoGravity(true);
        this.setPos(d0, d1, d2);
        this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI)) - 90);
    }

    protected void onEntityHit(EntityHitResult p_213868_1_) {
        Entity entity = p_213868_1_.getEntity();
        Entity entity1 = this.getOwner();
        LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
        entity.hurt(damageSources().mobProjectile(this, livingentity), 5.0F);
    }

    protected void onHitBlock(BlockHitResult p_230299_1_) {

        if (!this.level().isClientSide) {
            this.remove(RemovalReason.DISCARDED);
        }
    }

    protected void defineSynchedData() {
        this.entityData.define(FASTER_ANIM, false);
    }

    public void setShooter(@Nullable Entity entityIn) {
        if (entityIn != null) {
            this.ownerUUID = entityIn.getUUID();
            this.ownerNetworkId = entityIn.getId();
        }

    }

    @Nullable
    public Entity getOwner() {
        if (this.ownerUUID != null && this.level() instanceof ServerLevel) {
            return ((ServerLevel) this.level()).getEntity(this.ownerUUID);
        } else {
            return this.ownerNetworkId != 0 ? this.level().getEntity(this.ownerNetworkId) : null;
        }
    }

    protected void addAdditionalSaveData(CompoundTag compound) {
        if (this.ownerUUID != null) {
            compound.putUUID("Owner", this.ownerUUID);
        }

        if (this.leftOwner) {
            compound.putBoolean("LeftOwner", true);
        }
    }

    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.hasUUID("Owner")) {
            this.ownerUUID = compound.getUUID("Owner");
        }
        this.leftOwner = compound.getBoolean("LeftOwner");
    }

    private boolean checkLeftOwner() {
        Entity entity = this.getOwner();
        if (entity != null) {
            for (Entity entity1 : this.level().getEntities(this, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0D), (p_234613_0_) -> {
                return !p_234613_0_.isSpectator() && p_234613_0_.isPickable();
            })) {
                if (entity1.getRootVehicle() == entity.getRootVehicle()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        Vec3 vector3d = (new Vec3(x, y, z)).normalize().add(this.random.nextGaussian() * (double) 0.0075F * (double) inaccuracy, this.random.nextGaussian() * (double) 0.0075F * (double) inaccuracy, this.random.nextGaussian() * (double) 0.0075F * (double) inaccuracy).scale(velocity);
        this.setDeltaMovement(vector3d);
        float f = Mth.sqrt((float) horizontalMag(vector3d));
        this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI)));
        this.setXRot((float) (Mth.atan2(vector3d.y, f) * (double) (180F / (float) Math.PI)));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    private double horizontalMag(Vec3 vector3d) {
        return vector3d.x * vector3d.x + vector3d.z * vector3d.z;
    }

    protected void onImpact(HitResult result) {
        HitResult.Type raytraceresult$type = result.getType();
        if (raytraceresult$type == HitResult.Type.ENTITY) {
            this.onEntityHit((EntityHitResult) result);
        } else if (raytraceresult$type == HitResult.Type.BLOCK) {
            this.onHitBlock((BlockHitResult) result);
        }

    }

    public void lerpMotion(double x, double y, double z) {
        this.setDeltaMovement(x, y, z);
        if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
            float f = Mth.sqrt((float)(x * x + z * z));
            this.setXRot((float) (Mth.atan2(y, f) * (double) (180F / (float) Math.PI)));
            this.setYRot((float) (Mth.atan2(x, z) * (double) (180F / (float) Math.PI)));
            this.xRotO = this.getXRot();
            this.yRotO = this.getYRot();
            this.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
        }

    }

    protected boolean canHitEntity(Entity p_230298_1_) {
        if (!p_230298_1_.isSpectator() && p_230298_1_.isAlive() && p_230298_1_.isPickable()) {
            Entity entity = this.getOwner();
            return (entity == null || this.leftOwner || !entity.isPassengerOfSameVehicle(p_230298_1_));
        } else {
            return false;
        }
    }

    protected void updateRotation() {
        Vec3 vector3d = this.getDeltaMovement();
        float f = Mth.sqrt((float)horizontalMag(vector3d));
        this.setXRot(lerpRotation(this.xRotO, (float) (Mth.atan2(vector3d.y, f) * (double) (180F / (float) Math.PI))));
        this.setYRot(lerpRotation(this.yRotO, (float) (Mth.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI))));
    }

}
