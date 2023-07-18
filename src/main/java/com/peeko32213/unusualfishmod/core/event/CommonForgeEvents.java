package com.peeko32213.unusualfishmod.core.event;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.core.config.BiomeConfig;
import com.peeko32213.unusualfishmod.core.config.UnusualFishConfig;
import com.peeko32213.unusualfishmod.core.config.util.SpawnBiomeData;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class CommonForgeEvents {
    public static boolean initBiomes = false;
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onBiomesLoad(BiomeLoadingEvent event) {

        initBiomes = true;
        if (testBiome(BiomeConfig.aero_mono, event.getCategory(), event.getName()) && UnusualFishConfig.aeroMonoSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.AERO_MONO.get(), UnusualFishConfig.aeroMonoSpawnWeight, 3, 5));
        }

        if (testBiome(BiomeConfig.ahmar_idol, event.getCategory(), event.getName()) && UnusualFishConfig.ahmarIdolSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.PINKFIN.get(), UnusualFishConfig.ahmarIdolSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.bark_angel, event.getCategory(), event.getName()) && UnusualFishConfig.barkAngelSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BARK_ANGELFISH.get(), UnusualFishConfig.barkAngelSpawnWeight, 3, 5));
        }

        if (testBiome(BiomeConfig.basking_tiamat_baby, event.getCategory(), event.getName()) && UnusualFishConfig.baskingTiamaitBabySpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BABY_BASKING_TIAMAT.get(), UnusualFishConfig.baskingTiamaitBabySpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.basking_tiamat, event.getCategory(), event.getName()) && UnusualFishConfig.baskingTiamaitSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BASKING_TIAMAT.get(), UnusualFishConfig.baskingTiamaitSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.beaked_herring, event.getCategory(), event.getName()) && UnusualFishConfig.beakedHerringSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BEAKED_HERRING.get(), UnusualFishConfig.beakedHerringSpawnWeight, 1, 8));
        }

        if (testBiome(BiomeConfig.blackcap_snail, event.getCategory(), event.getName()) && UnusualFishConfig.blackcapSnailSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BLACKCAP_SNAIL.get(), UnusualFishConfig.blackcapSnailSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.blizzardfin_tuna, event.getCategory(), event.getName()) && UnusualFishConfig.blizzardfinTunaSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BLIZZARDFIN.get(), UnusualFishConfig.blizzardfinTunaSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.brick_snail, event.getCategory(), event.getName()) && UnusualFishConfig.brickSnailSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BRICK_SNAIL.get(), UnusualFishConfig.brickSnailSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.bumpface, event.getCategory(), event.getName()) && UnusualFishConfig.bumpfaceSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SNEEPSNORP.get(), UnusualFishConfig.bumpfaceSpawnWeight, 3, 5));
        }

        if (testBiome(BiomeConfig.cave_loach, event.getCategory(), event.getName()) && UnusualFishConfig.caveloachSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.BLIND_SAILFIN.get(), UnusualFishConfig.caveloachSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.celestial_fish, event.getCategory(), event.getName()) && UnusualFishConfig.celestialFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.CELESTIAL_FISH.get(), UnusualFishConfig.celestialFishSpawnWeight, 1, 1));
        }

        if (testBiome(BiomeConfig.circus_fish, event.getCategory(), event.getName()) && UnusualFishConfig.circusFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.CIRCUSFISH.get(), UnusualFishConfig.circusFishSpawnWeight, 1, 1));
        }

        if (testBiome(BiomeConfig.clownthorn_shark, event.getCategory(), event.getName()) && UnusualFishConfig.clownthornSharkSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.CLOWNTHORN_SHARK.get(), UnusualFishConfig.clownthornSharkSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.copperflame_anthias, event.getCategory(), event.getName()) && UnusualFishConfig.copperflameAnthiasSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.COPPERFLAME.get(), UnusualFishConfig.copperflameAnthiasSpawnWeight, 3, 4));
        }

        if (testBiome(BiomeConfig.coral_skrimp, event.getCategory(), event.getName()) && UnusualFishConfig.coralSkrimpSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.CORAL_SKRIMP.get(), UnusualFishConfig.coralSkrimpSpawnRolls, 1, 3));
        }

        if (testBiome(BiomeConfig.deep_crawler, event.getCategory(), event.getName()) && UnusualFishConfig.deepCrawlerSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.DEEP_CRAWLER.get(), UnusualFishConfig.deepCrawlerSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.demon_herring, event.getCategory(), event.getName()) && UnusualFishConfig.demonHerringSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.DEMON_HERRING.get(), UnusualFishConfig.demonHerringSpawnWeight, 1, 8));
        }

        if (testBiome(BiomeConfig.prawn, event.getCategory(), event.getName()) && UnusualFishConfig.prawnSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.PRAWN.get(), UnusualFishConfig.prawnSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.dragon_bichir, event.getCategory(), event.getName()) && UnusualFishConfig.dragonBichirSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.STOUT_BICHIR.get(), UnusualFishConfig.dragonBichirSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.duality_damselfish, event.getCategory(), event.getName()) && UnusualFishConfig.dualityDamselfishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.DUALITY_DAMSELFISH.get(), UnusualFishConfig.dualityDamselfishSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.false_swordfish, event.getCategory(), event.getName()) && UnusualFishConfig.falseSwordfishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SLATEFISH.get(), UnusualFishConfig.falseSwordfishSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.fork_fish, event.getCategory(), event.getName()) && UnusualFishConfig.forkFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.FORKFISH.get(), UnusualFishConfig.forkFishSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.freshwater_mantis, event.getCategory(), event.getName()) && UnusualFishConfig.freshwaterMantisSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.FRESHWATER_MANTIS.get(), UnusualFishConfig.freshwaterMantisSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.gnasher, event.getCategory(), event.getName()) && UnusualFishConfig.gnasherSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.GNASHER.get(), UnusualFishConfig.gnasherSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.gravel_flounder, event.getCategory(), event.getName()) && UnusualFishConfig.gravelFlounderSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.COMET_FISH.get(), UnusualFishConfig.gravelFlounderSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.handy_gourami, event.getCategory(), event.getName()) && UnusualFishConfig.handyGouramiSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.DROOPING_GOURAMI.get(), UnusualFishConfig.handyGouramiSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.hatchet_fish, event.getCategory(), event.getName()) && UnusualFishConfig.hatchetFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.HATCHET_FISH.get(), UnusualFishConfig.hatchetFishSpawnWeight, 1, 4));
        }

        if (testBiome(BiomeConfig.humpback_poggling, event.getCategory(), event.getName()) && UnusualFishConfig.humpbackPogglingSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.LONGJAW.get(), UnusualFishConfig.humpbackPogglingSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.kalappa, event.getCategory(), event.getName()) && UnusualFishConfig.kalappaSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.KALAPPA.get(), UnusualFishConfig.kalappaSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.lobed_skipper, event.getCategory(), event.getName()) && UnusualFishConfig.lobedSkipperSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.LOBED_SKIPPER.get(), UnusualFishConfig.lobedSkipperSpawnRolls, 1, 2));
        }

        if (testBiome(BiomeConfig.mana_jelly, event.getCategory(), event.getName()) && UnusualFishConfig.manaJellyfishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.WIZARD_JELLY.get(), UnusualFishConfig.manaJellyfishSpawnWeight, 3, 4));
        }

        if (testBiome(BiomeConfig.mossthorn, event.getCategory(), event.getName()) && UnusualFishConfig.mossthornSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.MOSSTHORN.get(), UnusualFishConfig.mossthornSpawnWeight, 3, 4));
        }

        if (testBiome(BiomeConfig.mudpig, event.getCategory(), event.getName()) && UnusualFishConfig.mudPigSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.GRAND_CORY.get(), UnusualFishConfig.mudPigSpawnWeight, 2, 3));
        }

        if (testBiome(BiomeConfig.picklefish, event.getCategory(), event.getName()) && UnusualFishConfig.pickleFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.PICKLEFISH.get(), UnusualFishConfig.pickleFishSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.porcupine_lobster, event.getCategory(), event.getName()) && UnusualFishConfig.porcupineLobsterSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.PORCUPINE_LOBSTA.get(), UnusualFishConfig.porcupineLobsterSpawnWeight, 1, 4));
        }

        if (testBiome(BiomeConfig.red_giant_seastar, event.getCategory(), event.getName()) && UnusualFishConfig.redGiantSeaStarSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.REDGIANT_SEASTAR.get(), UnusualFishConfig.redGiantSeaStarSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.rhino_tetra, event.getCategory(), event.getName()) && UnusualFishConfig.rhinoTetraSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.RHINO_TETRA.get(), UnusualFishConfig.rhinoTetraSpawnWeight, 3, 5));
        }

        if (testBiome(BiomeConfig.ripper, event.getCategory(), event.getName()) && UnusualFishConfig.ripperSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.RIPPER.get(), UnusualFishConfig.ripperSpawnWeight, 1, 5));
        }

        if (testBiome(BiomeConfig.rootball, event.getCategory(), event.getName()) && UnusualFishConfig.rootballSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.MONSTER).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.ROOTBALL.get(), UnusualFishConfig.rootballSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.sailor_barb, event.getCategory(), event.getName()) && UnusualFishConfig.sailorBarbSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SAILOR_BARB.get(), UnusualFishConfig.sailorBarbSpawnWeight, 3, 5));
        }

        if (testBiome(BiomeConfig.sea_mosquito, event.getCategory(), event.getName()) && UnusualFishConfig.seaMosquitoSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SEA_MOSQUITO.get(), UnusualFishConfig.seaMosquitoSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.sea_pancake, event.getCategory(), event.getName()) && UnusualFishConfig.seaPancakeSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SEA_PANCAKE.get(), UnusualFishConfig.seaPancakeSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.sea_spider, event.getCategory(), event.getName()) && UnusualFishConfig.seaSpiderSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SEA_SPIDER.get(), UnusualFishConfig.seaSpiderSpawnWeight, 1, 4));
        }

        if (testBiome(BiomeConfig.shockcat, event.getCategory(), event.getName()) && UnusualFishConfig.shockcatSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SHOCKCAT.get(), UnusualFishConfig.shockcatSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.smelter_snail, event.getCategory(), event.getName()) && UnusualFishConfig.smelterSnailSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SMELTER_SNAIL.get(), UnusualFishConfig.smelterSnailSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.spindlefish, event.getCategory(), event.getName()) && UnusualFishConfig.spindleFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SPINDLEFISH.get(), UnusualFishConfig.spindleFishSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.spoon_shark, event.getCategory(), event.getName()) && UnusualFishConfig.spoonSharkSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SPOON_SHARK.get(), UnusualFishConfig.spoonSharkSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.squoddle, event.getCategory(), event.getName()) && UnusualFishConfig.squoddleSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SQUODDLE.get(), UnusualFishConfig.squoddleSpawnWeight, 1, 3));
        }

        if (testBiome(BiomeConfig.thorny_guitarfish, event.getCategory(), event.getName()) && UnusualFishConfig.thornyGuitarfishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.ROUGHBACK.get(), UnusualFishConfig.thornyGuitarfishSpawnWeight, 1, 3));
        }

        if (testBiome(BiomeConfig.thorny_snail, event.getCategory(), event.getName()) && UnusualFishConfig.thornySnailSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.MUDDYTOP_SNAIL.get(), UnusualFishConfig.thornySnailSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.tiger_puffer, event.getCategory(), event.getName()) && UnusualFishConfig.tigerPufferSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TIGER_PUFFER.get(), UnusualFishConfig.tigerPufferSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.triple_twirl_pleco, event.getCategory(), event.getName()) && UnusualFishConfig.tripleTwirlPlecoSpawnRolls > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TRIPLE_TWIRL_PLECO.get(), UnusualFishConfig.tripleTwirlPlecoSpawnRolls, 2, 4));
        }

        if (testBiome(BiomeConfig.trumpet_squid, event.getCategory(), event.getName()) && UnusualFishConfig.trumpetSquidSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TRUMPET_SQUID.get(), UnusualFishConfig.trumpetSquidSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.whiskered_whaleshark, event.getCategory(), event.getName()) && UnusualFishConfig.whiskeredWhaleSharkSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.WHISKERED_WHALE_SHARK.get(), UnusualFishConfig.whiskeredWhaleSharkSpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.yellow_whip_goby, event.getCategory(), event.getName()) && UnusualFishConfig.yellowWhipGobySpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.AMBER_GOBY.get(), UnusualFishConfig.yellowWhipGobySpawnWeight, 1, 2));
        }

        if (testBiome(BiomeConfig.zebra_cornetfish, event.getCategory(), event.getName()) && UnusualFishConfig.zebraCornetfishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.ZEBRA_CORNETFISH.get(), UnusualFishConfig.zebraCornetfishSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.eyekito, event.getCategory(), event.getName()) && UnusualFishConfig.eyekitoSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.EYEKITO.get(), UnusualFishConfig.eyekitoSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.jungle_shark, event.getCategory(), event.getName()) && UnusualFishConfig.jungleSharkSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TIGER_JUNGLE_SHARK.get(), UnusualFishConfig.jungleSharkSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.snowflake_fish, event.getCategory(), event.getName()) && UnusualFishConfig.snowflakeFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.SNOWFLAKE.get(), UnusualFishConfig.snowflakeFishSpawnWeight, 3, 5));
        }
        if (testBiome(BiomeConfig.eyelash_fish, event.getCategory(), event.getName()) && UnusualFishConfig.eyelashFishSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.EYELASH.get(), UnusualFishConfig.eyelashFishSpawnWeight, 4, 6));
        }
        if (testBiome(BiomeConfig.crimsonshell, event.getCategory(), event.getName()) && UnusualFishConfig.crimsonshellSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.CRIMSONSHELL_SQUID.get(), UnusualFishConfig.crimsonshellSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.greenglow, event.getCategory(), event.getName()) && UnusualFishConfig.greenglowSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.GREENGLOW_LOBED_FIN.get(), UnusualFishConfig.greenglowSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.volt, event.getCategory(), event.getName()) && UnusualFishConfig.voltSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.VOLT_ANGLER.get(), UnusualFishConfig.voltSpawnWeight, 1, 2));
        }
        if (testBiome(BiomeConfig.tribble, event.getCategory(), event.getName()) && UnusualFishConfig.tribbleSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TRIBBLE.get(), UnusualFishConfig.tribbleSpawnWeight, 3, 6));
        }
        if (testBiome(BiomeConfig.trob, event.getCategory(), event.getName()) && UnusualFishConfig.trobSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TROB.get(), UnusualFishConfig.trobSpawnWeight, 2, 4));
        }
        if (testBiome(BiomeConfig.trite, event.getCategory(), event.getName()) && UnusualFishConfig.triteSpawnWeight > 0) {
            event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(UnusualFishEntities.TRITE.get(), UnusualFishConfig.triteSpawnWeight, 1, 2));
        }
    }

    public static boolean testBiome(Pair<String, SpawnBiomeData> entry, Biome.BiomeCategory category, ResourceLocation registryName) {
        boolean result = false;
        try {
            result = BiomeConfig.test(entry, category, registryName);
        } catch (Exception e) {
            UnusualFishMod.LOGGER.warn("could not test biome config for " + entry.getLeft() + ", defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }

}


