package com.peeko32213.unusualfishmod;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;

import static com.peeko32213.unusualfishmod.UnusualFishMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public void init() {
    }

    public void clientInit() {
    }
    public Player getClientSidePlayer() {
        return null;
    }

}
