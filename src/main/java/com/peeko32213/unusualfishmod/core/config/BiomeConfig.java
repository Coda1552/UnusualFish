package com.peeko32213.unusualfishmod.core.config;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.core.config.util.SpawnBiomeConfig;
import com.peeko32213.unusualfishmod.core.config.util.SpawnBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BiomeConfig {
    public static Pair<String, SpawnBiomeData> aero_mono = Pair.of("unusualfishmod:aero_mono_spawns", DefaultBiomes.COLD_FRESHWATER);
    public static Pair<String, SpawnBiomeData> ahmar_idol = Pair.of("unusualfishmod:ahmar_idol_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> bark_angel = Pair.of("unusualfishmod:bark_angel_spawns", DefaultBiomes.JUNGLE);
    public static Pair<String, SpawnBiomeData> basking_tiamat_baby = Pair.of("unusualfishmod:basking_tiamat_baby_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> basking_tiamat = Pair.of("unusualfishmod:basking_tiamat_spawns", DefaultBiomes.COLD_OCEAN);
    public static Pair<String, SpawnBiomeData> beaked_herring = Pair.of("unusualfishmod:beaked_herring_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> blackcap_snail = Pair.of("unusualfishmod:blackcap_snail_spawns", DefaultBiomes.WARM_FRESHWATER);
    public static Pair<String, SpawnBiomeData> blizzardfin_tuna = Pair.of("unusualfishmod:blizzardfin_tuna_spawns", DefaultBiomes.FROZEN_OCEAN);
    public static Pair<String, SpawnBiomeData> brick_snail = Pair.of("unusualfishmod:brick_snail_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> bumpface = Pair.of("unusualfishmod:bumpface_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> cave_loach = Pair.of("unusualfishmod:cave_loach_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> celestial_fish = Pair.of("unusualfishmod:celestial_fish_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> circus_fish = Pair.of("unusualfishmod:circus_fish_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> clownthorn_shark = Pair.of("unusualfishmod:clownthorn_shark_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> copperflame_anthias = Pair.of("unusualfishmod:copperflame_anthias_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> coral_skrimp = Pair.of("unusualfishmod:coral_skrimp_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> deep_crawler = Pair.of("unusualfishmod:deep_crawler_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> demon_herring = Pair.of("unusualfishmod:demon_herring_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> prawn = Pair.of("unusualfishmod:prawn_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> dragon_bichir = Pair.of("unusualfishmod:dragon_bichir_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> duality_damselfish = Pair.of("unusualfishmod:duality_damselfish_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> false_swordfish = Pair.of("unusualfishmod:false_swordfish_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> fork_fish = Pair.of("unusualfishmod:fork_fish_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> freshwater_mantis = Pair.of("unusualfishmod:freshwater_mantis_spawns", DefaultBiomes.JUNGLE);
    public static Pair<String, SpawnBiomeData> gnasher = Pair.of("unusualfishmod:gnasher_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> gravel_flounder = Pair.of("unusualfishmod:gravel_flounder_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> handy_gourami = Pair.of("unusualfishmod:handy_gourami_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> hatchet_fish = Pair.of("unusualfishmod:hatchet_fish_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> humpback_poggling = Pair.of("unusualfishmod:humpback_poggling_spawns", DefaultBiomes.COLD_OCEAN);
    public static Pair<String, SpawnBiomeData> kalappa = Pair.of("unusualfishmod:kalappa_spawns", DefaultBiomes.MUSHROOM);
    public static Pair<String, SpawnBiomeData> lobed_skipper = Pair.of("unusualfishmod:lobed_skipper_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> mana_jelly = Pair.of("unusualfishmod:mana_jelly_spawns", DefaultBiomes.OCEAN);
    public static Pair<String, SpawnBiomeData> mossthorn = Pair.of("unusualfishmod:mossthorn_spawns", DefaultBiomes.LUSH_CAVE);
    public static Pair<String, SpawnBiomeData> mudpig = Pair.of("unusualfishmod:mudpig_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> picklefish = Pair.of("unusualfishmod:picklefish_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> porcupine_lobster = Pair.of("unusualfishmod:porcupine_lobster_spawns", DefaultBiomes.DEEP_WARM);
    public static Pair<String, SpawnBiomeData> red_giant_seastar = Pair.of("unusualfishmod:red_giant_seastar_spawns", DefaultBiomes.COLD_OCEAN);
    public static Pair<String, SpawnBiomeData> rhino_tetra = Pair.of("unusualfishmod:rhino_tetra_spawns", DefaultBiomes.WARM_FRESHWATER);
    public static Pair<String, SpawnBiomeData> ripper = Pair.of("unusualfishmod:ripper_spawns", DefaultBiomes.WARM_FRESHWATER);
    public static Pair<String, SpawnBiomeData> rootball = Pair.of("unusualfishmod:rootball_spawns", DefaultBiomes.BEACH);
    public static Pair<String, SpawnBiomeData> sailor_barb = Pair.of("unusualfishmod:sailor_barb_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> sea_mosquito = Pair.of("unusualfishmod:sea_mosquito_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> sea_pancake = Pair.of("unusualfishmod:sea_pancake_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> sea_spider = Pair.of("unusualfishmod:sea_spider_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> shockcat = Pair.of("unusualfishmod:shockcat_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> smelter_snail = Pair.of("unusualfishmod:smelter_snail_spawns", DefaultBiomes.UNDERGROUND);
    public static Pair<String, SpawnBiomeData> spindlefish = Pair.of("unusualfishmod:spindlefish_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> spoon_shark = Pair.of("unusualfishmod:spoon_shark_spawns", DefaultBiomes.LUKEWARM_OCEAN);
    public static Pair<String, SpawnBiomeData> squoddle = Pair.of("unusualfishmod:squoddle_spawns", DefaultBiomes.DEEP_WARM);
    public static Pair<String, SpawnBiomeData> thorny_guitarfish = Pair.of("unusualfishmod:thorny_guitarfish_spawns", DefaultBiomes.SWAMP);
    public static Pair<String, SpawnBiomeData> thorny_snail = Pair.of("unusualfishmod:thorny_snail_spawns", DefaultBiomes.WARM_FRESHWATER);
    public static Pair<String, SpawnBiomeData> tiger_puffer = Pair.of("unusualfishmod:tiger_puffer_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> triple_twirl_pleco = Pair.of("unusualfishmod:triple_twirl_pleco_spawns", DefaultBiomes.WARM_FRESHWATER);
    public static Pair<String, SpawnBiomeData> trumpet_squid = Pair.of("unusualfishmod:trumpet_squid_spawns", DefaultBiomes.DEEP_WARM);
    public static Pair<String, SpawnBiomeData> whiskered_whaleshark = Pair.of("unusualfishmod:whiskered_whaleshark_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> yellow_whip_goby = Pair.of("unusualfishmod:yellow_whip_goby_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> zebra_cornetfish = Pair.of("unusualfishmod:zebra_cornetfish_spawns", DefaultBiomes.WARM_OCEAN);
    public static Pair<String, SpawnBiomeData> eyekito = Pair.of("unusualfishmod:eyekito_spawns", DefaultBiomes.COLD_OCEAN);
    public static Pair<String, SpawnBiomeData> jungle_shark = Pair.of("unusualfishmod:jungle_shark_spawns", DefaultBiomes.JUNGLE);
    public static Pair<String, SpawnBiomeData> snowflake_fish = Pair.of("unusualfishmod:snowflake_fish_spawns", DefaultBiomes.FROZEN_OCEAN);
    public static Pair<String, SpawnBiomeData> eyelash_fish = Pair.of("unusualfishmod:eyelash_fish_spawns", DefaultBiomes.MUSHROOM);
    public static Pair<String, SpawnBiomeData> crimsonshell = Pair.of("unusualfishmod:crimsonshell_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> greenglow = Pair.of("unusualfishmod:greenglow_spawns", DefaultBiomes.DEEP_WARM);
    public static Pair<String, SpawnBiomeData> volt = Pair.of("unusualfishmod:volt_spawns", DefaultBiomes.DEEP_COLD);
    public static Pair<String, SpawnBiomeData> tribble = Pair.of("unusualfishmod:tribble_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> trob = Pair.of("unusualfishmod:trob_spawns", DefaultBiomes.DEEP);
    public static Pair<String, SpawnBiomeData> trite = Pair.of("unusualfishmod:trite_spawns", DefaultBiomes.DEEP);



    private static boolean init = false;
    private static Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();

    public static void init() {
        try {
            for (Field f : BiomeConfig.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if(obj instanceof Pair){
                    String id = (String)((Pair) obj).getLeft();
                    SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
                    biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
                }
            }
        }catch (Exception e){
            UnusualFishMod.LOGGER.warn("Encountered error building unusualfishmod biome config .json files");
            e.printStackTrace();
        }
        init = true;
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Biome.BiomeCategory category, ResourceLocation name){
        if(!init){
            return false;
        }
        return biomeConfigValues.get(entry.getKey()).matches(category, name);
    }

    public static boolean test(Pair<String, SpawnBiomeData> spawns, Holder<Biome> biome) {
        return test(spawns, Biome.getBiomeCategory(biome), biome.value().getRegistryName());
    }

}
