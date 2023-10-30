package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block.CopperSpotlightBlock;
import codyhuh.unusualfishmod.common.block.NauticalLampBlock;
import codyhuh.unusualfishmod.common.block.VoltDetectorBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class UFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnusualFishMod.MOD_ID);

    public static final RegistryObject<Block> COPPER_SPOTLIGHT = registerBlock("copper_spotlight", () -> new CopperSpotlightBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.METAL).noOcclusion().instabreak().lightLevel(state -> 15).dynamicShape()), UnusualFishMod.TAB);
    public static final RegistryObject<Block> VOLT_DETECTOR = registerBlock("volt_detector", () -> new VoltDetectorBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.METAL).lightLevel(state -> 10)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> NAUTICAL_LAMP = registerBlock("nautical_lamp", () -> new NauticalLampBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.METAL).lightLevel(state -> 15)), UnusualFishMod.TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return UFItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
