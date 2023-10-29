package codyhuh.unusualfishmod.common.entity.item;

import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.nbt.CompoundTag;
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

    public ThrownPrismarineSpear(EntityType<? extends AbstractArrow> p_37561_, Level p_37562_) {
        super(p_37561_, p_37562_);
    }

    public ThrownPrismarineSpear(Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
        super(UFEntities.PRISMARINE_SPEAR.get(), p_37570_, p_37569_);
        this.spearItem = p_37571_.copy();
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        super.tick();
    }

    protected ItemStack getPickupItem() {
        return this.spearItem.copy();
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
        return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
    }

    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        float f = 8.0F;
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getDamageBonus(this.spearItem, livingentity.getMobType());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = DamageSource.trident(this, entity1 == null ? this : entity1);
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
        if (entity.hurt(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingentity1) {
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingentity1);
                }

                this.doPostHurtEffects(livingentity1);
            }
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;

        this.playSound(soundevent, f1, 1.0F);
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

    public void readAdditionalSaveData(CompoundTag p_37578_) {
        super.readAdditionalSaveData(p_37578_);
        if (p_37578_.contains("Trident", 10)) {
            this.spearItem = ItemStack.of(p_37578_.getCompound("Trident"));
        }

        this.dealtDamage = p_37578_.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag p_37582_) {
        super.addAdditionalSaveData(p_37582_);
        p_37582_.put("Trident", this.spearItem.save(new CompoundTag()));
        p_37582_.putBoolean("DealtDamage", this.dealtDamage);
    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }
}