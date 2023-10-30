package codyhuh.unusualfishmod.common.entity.util;

import codyhuh.unusualfishmod.common.entity.Rootball;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class CustomSwellGoal extends Goal {
    private final Rootball rootball;

    @Nullable
    private LivingEntity target;

    public CustomSwellGoal(Rootball p_25919_) {
        this.rootball = p_25919_;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.rootball.getTarget();
        return this.rootball.getSwellDir() > 0 || livingentity != null && this.rootball.distanceToSqr(livingentity) < 9.0D;
    }

    public void start() {
        this.rootball.getNavigation().stop();
        this.target = this.rootball.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.rootball.setSwellDir(-1);
        } else if (this.rootball.distanceToSqr(this.target) > 49.0D) {
            this.rootball.setSwellDir(-1);
        } else if (!this.rootball.getSensing().hasLineOfSight(this.target)) {
            this.rootball.setSwellDir(-1);
        } else {
            this.rootball.setSwellDir(1);
        }
    }
}
