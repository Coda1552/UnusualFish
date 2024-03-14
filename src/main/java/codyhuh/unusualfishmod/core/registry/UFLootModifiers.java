package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.loot.BuriedTreasureLootModifier;
import codyhuh.unusualfishmod.common.loot.UnderwaterRuinsLootModifier;
import codyhuh.unusualfishmod.common.loot.UnusualCatchLootModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UFLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UnusualFishMod.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> UNUSUAL_CATCH_LOOT_MODIFIER = LOOT_MODIFIERS.register("unusual_catch_glm", UnusualCatchLootModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> UNDERWATER_RUINS_LOOT_MODIFIER = LOOT_MODIFIERS.register("underwater_ruins_glm", UnderwaterRuinsLootModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> BURIED_TREASURE_LOOT_MODIFIER = LOOT_MODIFIERS.register("buried_treasure_glm", BuriedTreasureLootModifier.CODEC);
}
