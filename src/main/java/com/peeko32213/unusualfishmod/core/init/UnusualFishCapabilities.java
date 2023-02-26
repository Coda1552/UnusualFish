package com.peeko32213.unusualfishmod.core.init;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.item.tools.whips.IWhipUpdate;
import com.peeko32213.unusualfishmod.common.item.tools.whips.UnusualFishWhipItem;
import com.peeko32213.unusualfishmod.common.item.tools.whips.WhipUpdate;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UnusualFishCapabilities {

    public static final Capability<IWhipUpdate> WHIP_UPDATE = CapabilityManager.get(new CapabilityToken<>() {
    });

    @SubscribeEvent
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IWhipUpdate.class);
    }

    @SubscribeEvent
    public void onItemAttach(final AttachCapabilitiesEvent<ItemStack> event) {
        if (!(event.getObject().getItem() instanceof UnusualFishWhipItem)) return;

        WhipUpdate whipUpdate = new WhipUpdate();
        LazyOptional<IWhipUpdate> optionalWhipUpdate = LazyOptional.of(() -> whipUpdate);

        ICapabilityProvider provider = new ICapabilityProvider() {
            @Nonnull
            @Override
            public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
                if (capability == WHIP_UPDATE) {
                    return optionalWhipUpdate.cast();
                }

                return LazyOptional.empty();
            }
        };

        event.addCapability(new ResourceLocation(UnusualFishMod.MODID, "whip_update"), provider);
        event.addListener(optionalWhipUpdate::invalidate);
    }


}
