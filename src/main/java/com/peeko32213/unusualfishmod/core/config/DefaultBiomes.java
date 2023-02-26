package com.peeko32213.unusualfishmod.core.config;

import com.peeko32213.unusualfishmod.core.config.util.BiomeEntryType;
import com.peeko32213.unusualfishmod.core.config.util.SpawnBiomeData;

public class DefaultBiomes {
    public static final SpawnBiomeData EMPTY = new SpawnBiomeData();

    public static final SpawnBiomeData COLD_FRESHWATER = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:frozen_river", 0);

//Working, increase spawns for Blackcap Snails, Triple Twirl Plecos, Rhino Tetras and etc
    public static final SpawnBiomeData WARM_FRESHWATER = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:river", 0);


    public static final SpawnBiomeData SWAMP = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:swamp", 0);


    public static final SpawnBiomeData UNDERGROUND = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_DICT, false, "overworld", 0);

    //Working
    public static final SpawnBiomeData LUSH_CAVE = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:lush_caves", 0);

    //Working
    public static final SpawnBiomeData BEACH = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:beach", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:stony_shore", 1)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:snowy_beach", 2);

    public static final SpawnBiomeData JUNGLE = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:jungle", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:sparse_jungle", 1)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:bamboo_jungle", 2);
    public static final SpawnBiomeData WARM_OCEAN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:warm_ocean", 0);

    public static final SpawnBiomeData LUKEWARM_OCEAN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:lukewarm_ocean", 0);

    public static final SpawnBiomeData OCEAN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:ocean", 0);

    public static final SpawnBiomeData COLD_OCEAN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:cold_ocean", 0);

    public static final SpawnBiomeData FROZEN_OCEAN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:frozen_ocean", 0);

    public static final SpawnBiomeData MUSHROOM = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:mushroom_fields", 0);

    public static final SpawnBiomeData DEEP = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_ocean", 0);

    public static final SpawnBiomeData DEEP_WARM = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_lukewarm_ocean", 0);

    public static final SpawnBiomeData DEEP_COLD = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_cold_ocean", 0);

    public static final SpawnBiomeData DEEP_FROZEN = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_frozen_ocean", 0);

}
