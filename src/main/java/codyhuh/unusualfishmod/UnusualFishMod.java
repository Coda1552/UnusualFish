package codyhuh.unusualfishmod;

import codyhuh.unusualfishmod.core.registry.*;
import net.minecraft.core.MappedRegistry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(UnusualFishMod.MOD_ID)
public class UnusualFishMod {
	public static final String MOD_ID = "unusualfishmod";
	public UnusualFishMod(IEventBus bus, ModContainer modContainer) {

		UFSounds.SOUND_EVENTS.register(bus);
		UFBlocks.BLOCKS.register(bus);
		UFBlockEntities.BLOCK_ENTITIES.register(bus);
		UFEntities.ENTITIES.register(bus);
		UFItems.ITEMS.register(bus);
		UFTabs.CREATIVE_TABS.register(bus);
		UFLootModifiers.LOOT_MODIFIERS.register(bus);

//		NeoForge.EVENT_BUS.register(this);
	}

	public static ResourceLocation loc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
