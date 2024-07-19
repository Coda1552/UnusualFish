package codyhuh.unusualfishmod.common.entity.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class SeaSpike extends AbstractArrow {
    public boolean hostileOnly;

    public SeaSpike(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        hostileOnly = false;
    }

    public SeaSpike(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        this(p_36711_, p_36715_);
        this.setPos(p_36712_, p_36713_, p_36714_);
        this.setBaseDamage(5.0D);
    }

    @Override
    public void tick() {
        super.tick();

        LivingEntity target = level().getNearestEntity(LivingEntity.class, TargetingConditions.forCombat().selector(e -> !hostileOnly || e instanceof Monster), null, getX(), getY(), getZ(), getBoundingBox().inflate(5.0D));

        if (target != null) {
            Vec3 t = target.position();
            Vec3 s = position();

            setDeltaMovement(new Vec3(t.x - s.x, t.y - s.y, t.z - s.z).scale(0.15F));
        }
    }

    @Override
    protected float getWaterInertia() {
        return 1.0F;
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHit(HitResult p_37260_) {
        super.onHit(p_37260_);
        //discard();
    }
}
