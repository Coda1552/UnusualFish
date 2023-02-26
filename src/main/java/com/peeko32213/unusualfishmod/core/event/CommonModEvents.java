package com.peeko32213.unusualfishmod.core.event;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.BlindSailfin;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.DroopingGourami;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.Slatefish;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.GreenglowLobefin;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.VoltAngler;
import com.peeko32213.unusualfishmod.common.entity.ambient.land.LobedSkipper;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.BaskingTiamat;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.RedGiantSeaStar;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.WhiskeredWhaleShark;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.*;
import com.peeko32213.unusualfishmod.common.entity.hostile.*;
import com.peeko32213.unusualfishmod.common.entity.ulitity.*;
import com.peeko32213.unusualfishmod.common.entity.ai.HatchetFish;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MODID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(UnusualFishEntities.AERO_MONO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AeroMono::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.PINKFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, PinkfinIdol::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.ROUGHBACK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, RoughbackGuitarfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.CLOWNTHORN_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ClownthornShark::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.DUALITY_DAMSELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DualityDamselfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.DROOPING_GOURAMI.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DroopingGourami::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.MOSSTHORN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Mossthorn::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.GRAND_CORY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, GrandCorydora::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.REDGIANT_SEASTAR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, RedGiantSeaStar::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.RHINO_TETRA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, RhinoTetra::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.RIPPER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Ripper::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SAILOR_BARB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SailorBarb::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SEA_PANCAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaPancake::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SEA_SPIDER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaSpider::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SPINDLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Spindlefish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TRIPLE_TWIRL_PLECO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, TripleTwirlPleco::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.ZEBRA_CORNETFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ZebraCornetfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TIGER_PUFFER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerPuffer::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SNEEPSNORP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SneepSnorp::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BRICK_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BrickSnail::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BLACKCAP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlackCapSnail::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.DEEP_CRAWLER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, DeepCrawler::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.FRESHWATER_MANTIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, FreshwaterMantis::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.PORCUPINE_LOBSTA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, PorcupineLobster::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.WIZARD_JELLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ManaJellyfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TRUMPET_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TrumpetSquid::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BARK_ANGELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BarkAngelfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.STOUT_BICHIR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, StoutBichir::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.KALAPPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Kalappa::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.LOBED_SKIPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LobedSkipper::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SHOCKCAT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Shockcat::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.MUDDYTOP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, MuddytopSnail::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BEAKED_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BeakedHerring::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.PICKLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Picklefish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BLIND_SAILFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlindSailfin::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.DEMON_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DemonHerring::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.AMBER_GOBY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AmberGoby::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SLATEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Slatefish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.HATCHET_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, HatchetFish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.COPPERFLAME.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CopperflameAnthias::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.LONGJAW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, LongjawRockfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.COMET_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Cometfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.ROOTBALL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Rootball::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.CELESTIAL_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CelestialFish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.GNASHER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Gnasher::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.PRAWN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Prawn::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SQUODDLE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Squoddle::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SEA_MOSQUITO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SeaMosquito::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.FORKFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Forkfish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SPOON_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SpoonShark::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.CORAL_SKRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, CoralSkrimp::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.CIRCUSFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CircusFish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BLIZZARDFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BlizzardfinTuna::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BASKING_TIAMAT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BaskingTiamat::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.BABY_BASKING_TIAMAT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BaskingTiamatBaby::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SMELTER_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SmelterSnail::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.EYEKITO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Eyekito::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.JUNGLE_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerJungleShark::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.SNOWFLAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SnowflakeTailFish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.EYELASH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, EyelashFish::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.CRIMSONSHELL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CrimsonshellSquid::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.GREENGLOW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, GreenglowLobefin::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.VOLT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, VoltAngler::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TRIBLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Tribble::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TROB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Trob::canSpawn);
            SpawnPlacements.register(UnusualFishEntities.TRITE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Trite::canSpawn);
        });

    }

    @SubscribeEvent
    public static void registerAttributes (EntityAttributeCreationEvent event){
        event.put(UnusualFishEntities.DUALITY_DAMSELFISH.get(), DualityDamselfish.createAttributes().build());
        event.put(UnusualFishEntities.MOSSTHORN.get(), Mossthorn.createAttributes().build());
        event.put(UnusualFishEntities.RIPPER.get(), Ripper.createAttributes().build());
        event.put(UnusualFishEntities.SPINDLEFISH.get(), Spindlefish.createAttributes().build());
        event.put(UnusualFishEntities.RHINO_TETRA.get(), RhinoTetra.createAttributes().build());
        event.put(UnusualFishEntities.DROOPING_GOURAMI.get(), DroopingGourami.createAttributes().build());
        event.put(UnusualFishEntities.SAILOR_BARB.get(), SailorBarb.createAttributes().build());
        event.put(UnusualFishEntities.SEA_SPIDER.get(), SeaSpider.createAttributes().build());
        event.put(UnusualFishEntities.TRIPLE_TWIRL_PLECO.get(), TripleTwirlPleco.createAttributes().build());
        event.put(UnusualFishEntities.AERO_MONO.get(), AeroMono.createAttributes().build());
        event.put(UnusualFishEntities.CLOWNTHORN_SHARK.get(), ClownthornShark.createAttributes().build());
        event.put(UnusualFishEntities.ROUGHBACK.get(), RoughbackGuitarfish.createAttributes().build());
        event.put(UnusualFishEntities.REDGIANT_SEASTAR.get(), RedGiantSeaStar.createAttributes().build());
        event.put(UnusualFishEntities.PINKFIN.get(), PinkfinIdol.createAttributes().build());
        event.put(UnusualFishEntities.GRAND_CORY.get(), GrandCorydora.createAttributes().build());
        event.put(UnusualFishEntities.SEA_PANCAKE.get(), SeaPancake.createAttributes().build());
        event.put(UnusualFishEntities.BRICK_SNAIL.get(), BrickSnail.createAttributes().build());
        event.put(UnusualFishEntities.ZEBRA_CORNETFISH.get(), ZebraCornetfish.createAttributes().build());
        event.put(UnusualFishEntities.TIGER_PUFFER.get(), TigerPuffer.createAttributes().build());
        event.put(UnusualFishEntities.BLACKCAP_SNAIL.get(), BlackCapSnail.createAttributes().build());
        event.put(UnusualFishEntities.SNEEPSNORP.get(), SneepSnorp.createAttributes().build());
        event.put(UnusualFishEntities.DEEP_CRAWLER.get(), DeepCrawler.createAttributes().build());
        event.put(UnusualFishEntities.WIZARD_JELLY.get(), ManaJellyfish.createAttributes().build());
        event.put(UnusualFishEntities.PORCUPINE_LOBSTA.get(), PorcupineLobster.createAttributes().build());
        event.put(UnusualFishEntities.TRUMPET_SQUID.get(), TrumpetSquid.createAttributes().build());
        event.put(UnusualFishEntities.FRESHWATER_MANTIS.get(), FreshwaterMantis.createAttributes().build());
        event.put(UnusualFishEntities.BARK_ANGELFISH.get(), BarkAngelfish.createAttributes().build());
        event.put(UnusualFishEntities.SHOCKCAT.get(), Shockcat.createAttributes().build());
        event.put(UnusualFishEntities.MUDDYTOP_SNAIL.get(), MuddytopSnail.createAttributes().build());
        event.put(UnusualFishEntities.KALAPPA.get(), Kalappa.createAttributes().build());
        event.put(UnusualFishEntities.LOBED_SKIPPER.get(), LobedSkipper.createAttributes().build());
        event.put(UnusualFishEntities.STOUT_BICHIR.get(), StoutBichir.createAttributes().build());
        event.put(UnusualFishEntities.BEAKED_HERRING.get(), BeakedHerring.createAttributes().build());
        event.put(UnusualFishEntities.PICKLEFISH.get(), Picklefish.createAttributes().build());
        event.put(UnusualFishEntities.BLIND_SAILFIN.get(), BlindSailfin.createAttributes().build());
        event.put(UnusualFishEntities.DEMON_HERRING.get(), DemonHerring.createAttributes().build());
        event.put(UnusualFishEntities.AMBER_GOBY.get(), AmberGoby.createAttributes().build());
        event.put(UnusualFishEntities.HATCHET_FISH.get(), HatchetFish.createAttributes().build());
        event.put(UnusualFishEntities.SLATEFISH.get(), Slatefish.createAttributes().build());
        event.put(UnusualFishEntities.COPPERFLAME.get(), CopperflameAnthias.createAttributes().build());
        event.put(UnusualFishEntities.LONGJAW.get(), LongjawRockfish.createAttributes().build());
        event.put(UnusualFishEntities.COMET_FISH.get(), Cometfish.createAttributes().build());
        event.put(UnusualFishEntities.ROOTBALL.get(), Rootball.createAttributes().build());
        event.put(UnusualFishEntities.CELESTIAL_FISH.get(), CelestialFish.createAttributes().build());
        event.put(UnusualFishEntities.GNASHER.get(), Gnasher.createAttributes().build());
        event.put(UnusualFishEntities.PRAWN.get(), Prawn.createAttributes().build());
        event.put(UnusualFishEntities.SQUODDLE.get(), Squoddle.createAttributes().build());
        event.put(UnusualFishEntities.SEA_MOSQUITO.get(), SeaMosquito.createAttributes().build());
        event.put(UnusualFishEntities.FORKFISH.get(), Forkfish.createAttributes().build());
        event.put(UnusualFishEntities.SPOON_SHARK.get(), SpoonShark.createAttributes().build());
        event.put(UnusualFishEntities.CORAL_SKRIMP.get(), CoralSkrimp.createAttributes().build());
        event.put(UnusualFishEntities.CIRCUSFISH.get(), CircusFish.createAttributes().build());
        event.put(UnusualFishEntities.BLIZZARDFIN.get(), BlizzardfinTuna.createAttributes().build());
        event.put(UnusualFishEntities.WHISKERED.get(), WhiskeredWhaleShark.createAttributes().build());
        event.put(UnusualFishEntities.BASKING_TIAMAT.get(), BaskingTiamat.createAttributes().build());
        event.put(UnusualFishEntities.BABY_BASKING_TIAMAT.get(), BaskingTiamatBaby.createAttributes().build());
        event.put(UnusualFishEntities.SMELTER_SNAIL.get(), SmelterSnail.createAttributes().build());
        event.put(UnusualFishEntities.EYELASH.get(), EyelashFish.createAttributes().build());
        event.put(UnusualFishEntities.EYEKITO.get(), Eyekito.createAttributes().build());
        event.put(UnusualFishEntities.SNOWFLAKE.get(), SnowflakeTailFish.createAttributes().build());
        event.put(UnusualFishEntities.JUNGLE_SHARK.get(), TigerJungleShark.createAttributes().build());
        event.put(UnusualFishEntities.CRIMSONSHELL.get(), CrimsonshellSquid.createAttributes().build());
        event.put(UnusualFishEntities.GREENGLOW.get(), GreenglowLobefin.createAttributes().build());
        event.put(UnusualFishEntities.VOLT.get(), VoltAngler.createAttributes().build());
        event.put(UnusualFishEntities.TRIBLE.get(), Tribble.createAttributes().build());
        event.put(UnusualFishEntities.TROB.get(), Trob.createAttributes().build());
        event.put(UnusualFishEntities.TRITE.get(), Trite.createAttributes().build());

    }

}
