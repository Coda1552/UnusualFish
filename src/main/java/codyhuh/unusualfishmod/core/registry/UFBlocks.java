package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class UFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UnusualFishMod.MOD_ID);

    public static final RegistryObject<Block> VOLT_DETECTOR = registerBlock("volt_detector", () -> new VoltDetectorBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.METAL).randomTicks().lightLevel(state -> 10)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> NAUTICAL_LAMP = registerBlock("nautical_lamp", () -> new NauticalLampBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> SEA_BOOM = registerBlock("sea_boom", () -> new SeaBoomBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE).sound(SoundType.METAL).randomTicks()), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_EGGS = registerBlock("crimson_eggs", () -> new SquidEggsBlock(UFEntities.CRIMSONSHELL_SQUID::get, BlockBehaviour.Properties.copy(Blocks.FROGSPAWN)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_EGGS = registerBlock("relucent_eggs", () -> new SquidEggsBlock(UFEntities.TRUMPET_SQUID::get, BlockBehaviour.Properties.copy(Blocks.FROGSPAWN)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> COPPER_ANTENNA = registerBlock("copper_antenna", () -> new CopperAntennaBlock(BlockBehaviour.Properties.copy(Blocks.LIGHTNING_ROD)), UnusualFishMod.TAB);

    public static final RegistryObject<Block> CHISELED_CRIMSON_BRICKS = registerBlock("chiseled_crimson_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_BRICKS = registerBlock("crimson_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_STAIRS = registerBlock("crimson_brick_stairs", () -> new StairBlock(() -> CRIMSON_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_SLAB = registerBlock("crimson_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_BRICK_WALL = registerBlock("crimson_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_TILES = registerBlock("crimson_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_TILE_STAIRS = registerBlock("crimson_tile_stairs", () -> new StairBlock(() -> CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_TILE_SLAB = registerBlock("crimson_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> CRIMSON_TILE_WALL = registerBlock("crimson_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);

    public static final RegistryObject<Block> CHISELED_RELUCENT_BRICKS = registerBlock("chiseled_relucent_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_BRICKS = registerBlock("relucent_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_BRICK_STAIRS = registerBlock("relucent_brick_stairs", () -> new StairBlock(() -> RELUCENT_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_BRICK_SLAB = registerBlock("relucent_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_BRICK_WALL = registerBlock("relucent_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_TILES = registerBlock("relucent_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_TILE_STAIRS = registerBlock("relucent_tile_stairs", () -> new StairBlock(() -> RELUCENT_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_TILE_SLAB = registerBlock("relucent_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);
    public static final RegistryObject<Block> RELUCENT_TILE_WALL = registerBlock("relucent_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)), UnusualFishMod.TAB);

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
