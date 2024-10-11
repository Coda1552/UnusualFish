package codyhuh.unusualfishmod.common.entity.util;

import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class SnailMoveControl extends MoveControl {
    private final Mob snail;

    public SnailMoveControl(Mob snail) {
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