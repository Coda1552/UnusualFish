package codyhuh.unusualfishmod.common.entity.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class SeaSpike extends AbstractArrow {

    public SeaSpike(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
    }

    public SeaSpike(EntityType<? extends AbstractArrow> p_36711_, double p_36712_, double p_36713_, double p_36714_, Level p_36715_) {
        this(p_36711_, p_36715_);
        this.setPos(p_36712_, p_36713_, p_36714_);
        this.setBaseDamage(5.0D);
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
    protected void onHitBlock(BlockHitResult p_36755_) {
        discard();
        super.onHitBlock(p_36755_);
    }
}
