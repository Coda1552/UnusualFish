package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class UFBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(UnusualFishMod.MOD_ID);

    public static final DeferredBlock<VoltDetectorBlock> VOLT_DETECTOR = registerBlock("volt_detector", () -> new VoltDetectorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).sound(SoundType.METAL).randomTicks().lightLevel(state -> 10)));

     public static final DeferredBlock<NauticalLampBlock> NAUTICAL_LAMP = registerBlock("nautical_lamp", () -> new NauticalLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN)));
     public static final DeferredBlock<SeaBoomBlock> SEA_BOOM = registerBlock("sea_boom", () -> new SeaBoomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE).sound(SoundType.METAL).randomTicks()));
     public static final DeferredBlock<SquidEggsBlock> CRIMSON_EGGS = registerBlock("crimson_eggs", () -> new SquidEggsBlock(UFEntities.CRIMSONSHELL_SQUID::get, BlockBehaviour.Properties.ofFullCopy(Blocks.FROGSPAWN)));
     public static final DeferredBlock<SquidEggsBlock> RELUCENT_EGGS = registerBlock("relucent_eggs", () -> new SquidEggsBlock(UFEntities.TRUMPET_SQUID::get, BlockBehaviour.Properties.ofFullCopy(Blocks.FROGSPAWN)));
     public static final DeferredBlock<CopperAntennaBlock> COPPER_ANTENNA = registerBlock("copper_antenna", () -> new CopperAntennaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHTNING_ROD)));

     public static final DeferredBlock<Block> CHISELED_CRIMSON_BRICKS = registerBlock("chiseled_crimson_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_BRICKS = registerBlock("crimson_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_BRICK_STAIRS = registerBlock("crimson_brick_stairs", () -> new StairBlock(UFBlocks.CRIMSON_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_BRICK_SLAB = registerBlock("crimson_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_BRICK_WALL = registerBlock("crimson_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_TILES = registerBlock("crimson_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_TILE_STAIRS = registerBlock("crimson_tile_stairs", () -> new StairBlock(UFBlocks.CRIMSON_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_TILE_SLAB = registerBlock("crimson_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> CRIMSON_TILE_WALL = registerBlock("crimson_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

     public static final DeferredBlock<Block> CHISELED_RELUCENT_BRICKS = registerBlock("chiseled_relucent_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_BRICKS = registerBlock("relucent_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_BRICK_STAIRS = registerBlock("relucent_brick_stairs", () -> new StairBlock(UFBlocks.RELUCENT_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_BRICK_SLAB = registerBlock("relucent_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_BRICK_WALL = registerBlock("relucent_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_TILES = registerBlock("relucent_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_TILE_STAIRS = registerBlock("relucent_tile_stairs", () -> new StairBlock(UFBlocks.RELUCENT_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_TILE_SLAB = registerBlock("relucent_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));
     public static final DeferredBlock<Block> RELUCENT_TILE_WALL = registerBlock("relucent_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block) {
        return UFItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
