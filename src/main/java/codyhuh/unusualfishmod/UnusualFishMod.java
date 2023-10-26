package codyhuh.unusualfishmod;

import codyhuh.unusualfishmod.core.registry.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;

@Mod(UnusualFishMod.MOD_ID)
public class UnusualFishMod {
	public static final String MOD_ID = "unusualfishmod";
	public static final List<Runnable> CALLBACKS = new ArrayList<>();
	public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return UnusualFishItems.RAW_RHINO_TETRA.get().getDefaultInstance();
		}
	};

	public UnusualFishMod() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		UnusualFishItems.ITEMS.register(bus);
		UFEntities.ENTITIES.register(bus);
		UFBlocks.BLOCKS.register(bus);
		UFEnchantments.ENCHANTMENTS.register(bus);
		UnusualFishSounds.SOUND_EVENTS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}
}
