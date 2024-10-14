package codyhuh.unusualfishmod.common.entity.util.misc;

import software.bernie.geckolib.core.animation.RawAnimation;

public class UFAnimations {
    public static final RawAnimation WALK = RawAnimation.begin().thenLoop("walk");
    public static final RawAnimation SWIM = RawAnimation.begin().thenLoop("swim");
    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    public static final RawAnimation FLOP = RawAnimation.begin().thenLoop("flop");
    public static final RawAnimation ACTION = RawAnimation.begin().thenLoop("action");
}
