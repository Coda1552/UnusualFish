package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.loot.BuriedTreasureLootModifier;
import codyhuh.unusualfishmod.common.loot.UnderwaterRuinsLootModifier;
import codyhuh.unusualfishmod.common.loot.UnusualCatchLootModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class UFLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UnusualFishMod.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<UnusualCatchLootModifier>> UNUSUAL_CATCH_LOOT_MODIFIER = LOOT_MODIFIERS.register("unusual_catch_glm", () -> UnusualCatchLootModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<UnderwaterRuinsLootModifier>> UNDERWATER_RUINS_LOOT_MODIFIER = LOOT_MODIFIERS.register("underwater_ruins_glm", () -> UnderwaterRuinsLootModifier.CODEC);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<BuriedTreasureLootModifier>> BURIED_TREASURE_LOOT_MODIFIER = LOOT_MODIFIERS.register("buried_treasure_glm", () -> BuriedTreasureLootModifier.CODEC);
}