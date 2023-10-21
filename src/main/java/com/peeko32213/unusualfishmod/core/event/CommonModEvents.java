package com.peeko32213.unusualfishmod.core.event;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.HatchetFish;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.BlindSailfin;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.DroopingGourami;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.VoltAngler;
import com.peeko32213.unusualfishmod.common.entity.ambient.land.LobedSkipper;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.CoralSkrimp;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.DualityDamselfish;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.EyelashFish;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.SeaMosquito;
import com.peeko32213.unusualfishmod.common.entity.hostile.*;
import com.peeko32213.unusualfishmod.common.entity.ulitity.*;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void commonSetup(SpawnPlacementRegisterEvent e) {
        e.register(UnusualFishEntities.AERO_MONO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AeroMono::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.PINKFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, PinkfinIdol::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.CLOWNTHORN_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ClownthornShark::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.DUALITY_DAMSELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DualityDamselfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.DROOPING_GOURAMI.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DroopingGourami::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.MOSSTHORN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Mossthorn::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.RHINO_TETRA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, RhinoTetra::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.RIPPER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Ripper::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SAILOR_BARB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SailorBarb::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SPINDLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Spindlefish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.ZEBRA_CORNETFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ZebraCornetfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.TIGER_PUFFER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerPuffer::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SNEEPSNORP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SneepSnorp::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.WIZARD_JELLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ManaJellyfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.TRUMPET_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TrumpetSquid::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BARK_ANGELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BarkAngelfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.STOUT_BICHIR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, StoutBichir::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.KALAPPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Kalappa::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.LOBED_SKIPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LobedSkipper::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BEAKED_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BeakedHerring::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.PICKLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Picklefish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.DEMON_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DemonHerring::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.AMBER_GOBY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AmberGoby::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.COPPERFLAME.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CopperflameAnthias::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.ROOTBALL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Rootball::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.CELESTIAL_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CelestialFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.PRAWN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Prawn::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SEA_MOSQUITO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SeaMosquito::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.FORKFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Forkfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SPOON_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SpoonShark::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.CIRCUSFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CircusFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BLIZZARDFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BlizzardfinTuna::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.TIGER_JUNGLE_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerJungleShark::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SNOWFLAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SnowflakeTailFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.EYELASH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, EyelashFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.CRIMSONSHELL_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CrimsonshellSquid::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.VOLT_ANGLER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, VoltAngler::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.TRIBBLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Tribble::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SMELTER_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SmelterSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.CORAL_SKRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, CoralSkrimp::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SQUODDLE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Squoddle::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.GNASHER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Gnasher::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.HATCHET_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, HatchetFish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BLIND_SAILFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlindSailfin::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SHOCKCAT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Shockcat::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.MUDDYTOP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, MuddytopSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BRICK_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BrickSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.BLACKCAP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlackCapSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.DEEP_CRAWLER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, DeepCrawler::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.FRESHWATER_MANTIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, FreshwaterMantis::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.PORCUPINE_LOBSTA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, PorcupineLobster::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.TRIPLE_TWIRL_PLECO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, TripleTwirlPleco::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SEA_PANCAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaPancake::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.SEA_SPIDER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaSpider::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        e.register(UnusualFishEntities.ROUGHBACK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, RoughbackGuitarfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
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
        event.put(UnusualFishEntities.PINKFIN.get(), PinkfinIdol.createAttributes().build());
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
        event.put(UnusualFishEntities.COPPERFLAME.get(), CopperflameAnthias.createAttributes().build());
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
        event.put(UnusualFishEntities.SMELTER_SNAIL.get(), SmelterSnail.createAttributes().build());
        event.put(UnusualFishEntities.EYELASH.get(), EyelashFish.createAttributes().build());
        event.put(UnusualFishEntities.SNOWFLAKE.get(), SnowflakeTailFish.createAttributes().build());
        event.put(UnusualFishEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleShark.createAttributes().build());
        event.put(UnusualFishEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquid.createAttributes().build());
        event.put(UnusualFishEntities.VOLT_ANGLER.get(), VoltAngler.createAttributes().build());
        event.put(UnusualFishEntities.TRIBBLE.get(), Tribble.createAttributes().build());
    }

}
