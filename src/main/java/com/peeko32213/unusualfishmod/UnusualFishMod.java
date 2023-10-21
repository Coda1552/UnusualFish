package com.peeko32213.unusualfishmod;

import com.peeko32213.unusualfishmod.core.init.*;
import com.peeko32213.unusualfishmod.core.network.UnusualFishNetworkHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(UnusualFishMod.MOD_ID)
public class UnusualFishMod {
	public static final String MOD_ID = "unusualfishmod";
	public static final List<Runnable> CALLBACKS = new ArrayList<>();

	public UnusualFishMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		UnusualFishItems.ITEMS.register(bus);
		UnusualFishEntities.ENTITIES.register(bus);
		UnusualFishBlocks.BLOCKS.register(bus);
		UnusualFishEnchantments.ENCHANTMENTS.register(bus);
		UnusualFishSounds.SOUND_EVENTS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new UnusualFishCapabilities());
	}

	public static final CreativeModeTab UNUSUAL_TAB = new CreativeModeTab(MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return UnusualFishItems.RAW_RHINO_TETRA.get().getDefaultInstance();
		}
	};

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(UnusualFishNetworkHandler::register);
	}
}
