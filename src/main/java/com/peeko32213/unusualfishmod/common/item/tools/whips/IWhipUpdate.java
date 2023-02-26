package com.peeko32213.unusualfishmod.common.item.tools.whips;

public interface IWhipUpdate {

    int getTicksSinceAttack();

    void setTicksSinceAttack(int ticksSinceAttack);

    boolean getAttacking();

    void setAttacking(boolean attacking);

    boolean getCharging();

    void setCharging(boolean charging);

}
