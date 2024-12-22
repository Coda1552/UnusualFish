package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class UFTags {
    public static final TagKey<EntityType<?>> TIGER_PUFFER_PREY = entityTag("tiger_puffer_prey");
    public static final TagKey<EntityType<?>> SNAILS = entityTag("snails");
    public static final TagKey<EntityType<?>> VOLT_UNDETECTED = entityTag("volt_undetected");
    public static final TagKey<Item> RAW_UNUSUAL_FISH = itemTag("raw_unusual_fish");
    public static final TagKey<Item> UNUSUAL_CATCH_ITEMS = itemTag("unusual_catch");
    public static final TagKey<Block> SQUID_EGGS = blockTag("squid_eggs");
    public static final TagKey<Block> UNCHOPPABLE = blockTag("unchoppable");

    private static TagKey<EntityType<?>> entityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(UnusualFishMod.MOD_ID, path));
    }

    private static TagKey<Item> itemTag(String path) {
        return ItemTags.create(new ResourceLocation(UnusualFishMod.MOD_ID, path));
    }

    private static TagKey<Block> blockTag(String path) {
        return BlockTags.create(new ResourceLocation(UnusualFishMod.MOD_ID, path));
    }
}
