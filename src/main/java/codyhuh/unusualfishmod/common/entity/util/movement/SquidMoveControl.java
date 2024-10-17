package codyhuh.unusualfishmod.common.entity.util.movement;

import codyhuh.unusualfishmod.common.entity.util.base.BreedableWaterAnimal;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class SquidMoveControl extends MoveControl {
    public final BreedableWaterAnimal fish;

    public SquidMoveControl(BreedableWaterAnimal fish) {
        super(fish);
        this.fish = fish;
    }

    public void tick() {
        if (this.fish.isEyeInFluid(FluidTags.WATER)) {
            this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
        }

        if (this.operation == Operation.MOVE_TO && !this.fish.getNavigation().isDone()) {
            float f = (float) (this.speedModifier * this.fish.getAttributeValue(Attributes.MOVEMENT_SPEED));
            this.fish.setSpeed(Mth.lerp(0.125F, this.fish.getSpeed(), f));
            double d0 = this.wantedX - this.fish.getX();
            double d1 = this.wantedY - this.fish.getY();
            double d2 = this.wantedZ - this.fish.getZ();
            if (d1 != 0.0D) {
                double d3 = Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
                this.fish.setDeltaMovement(this.fish.getDeltaMovement().add(0.0D, (double) this.fish.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
            }

            if (d0 != 0.0D || d2 != 0.0D) {
                float f1 = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.fish.yRot = this.rotlerp(this.fish.yRot, f1, 90.0F);
                this.fish.yBodyRot = this.fish.yRot;
            }

        } else {
            this.fish.setSpeed(0.0F);
        }
    }

}