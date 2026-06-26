package codyhuh.unusualfishmod.common.entity.item;

import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class ThrownPrismarineSpear extends AbstractArrow {
    private ItemStack spearItem = new ItemStack(UFItems.PRISMARINE_SPEAR.get());
    private boolean dealtDamage;

    public ThrownPrismarineSpear(EntityType<? extends ThrownPrismarineSpear> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownPrismarineSpear(Level level, double x, double y, double z, ItemStack pickupItemStack) {
        super(UFEntities.PRISMARINE_SPEAR.get(), level);
        this.setPos(x, y, z);
        this.spearItem = pickupItemStack.copy();
    }

    public ThrownPrismarineSpear(EntityType<? extends ThrownPrismarineSpear> entityType, double x, double y, double z, Level level) {
        this(entityType, level);
        this.setPos(x, y, z);

    }

    public ThrownPrismarineSpear(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(UFEntities.PRISMARINE_SPEAR.get(), level);
        this.spearItem = itemStack.copy();
        this.setOwner(livingEntity);
        this.setPos(livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ());
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        super.tick();
    }

    protected ItemStack getPickupItem() {
        if (this.spearItem == null) {
            return new ItemStack(UFItems.PRISMARINE_SPEAR.get());
        }
        return this.spearItem.copy();
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        if (this.spearItem == null) {
            return new ItemStack(UFItems.PRISMARINE_SPEAR.get());
        }
        return this.spearItem.copy();
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
        return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
    }

    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        float f = 5.0F;
        if (entity instanceof LivingEntity livingentity && this.level() instanceof net.minecraft.server.level.ServerLevel serverLevel) {
            DamageSource damageSource = this.damageSources().mobAttack((LivingEntity) this.getOwner());
            f = EnchantmentHelper.modifyDamage(serverLevel, this.spearItem, livingentity, damageSource, (float) this.getBaseDamage());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = damageSources().trident(this, entity1 == null ? this : entity1);
        this.dealtDamage = true;

        if (entity.hurt(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingentity1 && entity1 instanceof LivingEntity livingentityAttacker) {
                if (this.level() instanceof ServerLevel serverLevel) {
                    EnchantmentHelper.doPostAttackEffects(serverLevel, livingentity1, this.damageSources().mobAttack(livingentityAttacker));
                }
                this.doPostHurtEffects(livingentity1);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;

        this.playSound(SoundEvents.TRIDENT_HIT, f1, 1.0F);
    }

    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public void playerTouch(Player p_37580_) {
        if (this.ownedBy(p_37580_) || this.getOwner() == null) {
            super.playerTouch(p_37580_);
        }
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Trident", 10)) {
            this.spearItem = ItemStack.parseOptional(this.level().registryAccess(), tag.getCompound("Trident"));
        }
        this.dealtDamage = tag.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("Trident", this.spearItem.save(this.level().registryAccess()));
        tag.putBoolean("DealtDamage", this.dealtDamage);
    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }
}