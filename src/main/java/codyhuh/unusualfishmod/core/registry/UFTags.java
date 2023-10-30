package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class UFTags {
    public static final TagKey<EntityType<?>> TIGER_PUFFER_PREY = entityTag("tiger_puffer_prey");
    public static final TagKey<EntityType<?>> SNAILS = entityTag("snails");

    private static TagKey<EntityType<?>> entityTag(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(UnusualFishMod.MOD_ID, path));
    }
}
