package com.peeko32213.unusualfishmod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

public class ClientProxy extends CommonProxy {

    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }

}
