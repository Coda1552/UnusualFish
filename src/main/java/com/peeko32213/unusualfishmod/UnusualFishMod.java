package com.peeko32213.unusualfishmod;

import com.peeko32213.unusualfishmod.core.config.BiomeConfig;
import com.peeko32213.unusualfishmod.core.config.ConfigHolder;
import com.peeko32213.unusualfishmod.core.config.UnusualFishConfig;
import com.peeko32213.unusualfishmod.core.event.CommonForgeEvents;
import com.peeko32213.unusualfishmod.core.init.*;


import com.peeko32213.unusualfishmod.core.network.UnusualFishNetworkHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(UnusualFishMod.MODID)
public class UnusualFishMod {
public static final Logger LOGGER = LogManager.getLogger();
public static final String MODID = "unusualfishmod";
public static final List<Runnable> CALLBACKS = new ArrayList<>();
public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);


public UnusualFishMod() {

	var bus = FMLJavaModLoadingContext.get().getModEventBus();
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onModConfigEvent);
	UnusualFishItems.ITEMS.register(bus);
	UnusualFishEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	UnusualFishBlocks.BLOCKS.register(bus);
	UnusualFishEnchantments.ENCHANTMENTS.register(bus);

	MinecraftForge.EVENT_BUS.register(this);


	final ModLoadingContext modLoadingContext = ModLoadingContext.get();
	modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "unusualfishmod.toml");
	PROXY.init();

}

	@SubscribeEvent
	public void onModConfigEvent(final ModConfigEvent event) {
		final ModConfig config = event.getConfig();
		if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
			UnusualFishConfig.bake(config);
		}
		BiomeConfig.init();
	}

public static final CreativeModeTab UNUSUAL_TAB = new CreativeModeTab(MODID) {
	@Override
	public ItemStack makeIcon() {
		return UnusualFishItems.RAW_RHINO_TETRA.get().getDefaultInstance();
	}
};



	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(UnusualFishNetworkHandler::register);
	}

	private void setupClient(FMLClientSetupEvent event) {
		PROXY.clientInit();
	}

	@SubscribeEvent
	public void onBiomeLoadFromJSON(BiomeLoadingEvent event) {
		CommonForgeEvents.onBiomesLoad(event);
	}

}
 