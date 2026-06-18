package codyhuh.unusualfishmod.common;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.*;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = UnusualFishMod.MOD_ID)
public class CommonEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            DispenserBlock.registerProjectileBehavior(UFItems.PRISMARINE_SPEAR.get());
        });
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent e) {
        e.register(UFEntities.AERO_MONO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, AeroMono::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.PINKFIN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, PinkfinIdol::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.CLOWNTHORN_SHARK.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, ClownthornShark::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.DUALITY_DAMSELFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, DualityDamselfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.DROOPING_GOURAMI.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, DroopingGourami::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.MOSSTHORN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, Mossthorn::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.RHINO_TETRA.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, RhinoTetra::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.RIPPER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, Ripper::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SAILOR_BARB.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, SailorBarb::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SPINDLEFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, Spindlefish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.ZEBRA_CORNETFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, ZebraCornetfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.TIGER_PUFFER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerPuffer::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SNEEPSNORP.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, SneepSnorp::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.WIZARD_JELLY.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, ManaJellyfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.TRUMPET_SQUID.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, TrumpetSquid::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BARK_ANGELFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, BarkAngelfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.STOUT_BICHIR.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, StoutBichir::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.KALAPPA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Kalappa::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.LOBED_SKIPPER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LobedSkipper::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BEAKED_HERRING.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, BeakedHerring::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.PICKLEFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, Picklefish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.DEMON_HERRING.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, DemonHerring::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.AMBER_GOBY.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, AmberGoby::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.COPPERFLAME.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, CopperflameAnthias::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.ROOTBALL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Rootball::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.CELESTIAL_FISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, CelestialFish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.PRAWN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Prawn::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_MOSQUITO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, SeaMosquito::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.FORKFISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, Forkfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SPOON_SHARK.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, SpoonShark::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.CIRCUS_FISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, CircusFish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BLIZZARDFIN_TUNA.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, BlizzardfinTuna::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.TIGER_JUNGLE_SHARK.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerJungleShark::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.FROSTY_FIN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, FrostyFinFish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.EYELASH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, EyelashFish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.CRIMSONSHELL_SQUID.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, CrimsonshellSquid::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.VOLT_ANGLER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.WORLD_SURFACE, VoltAngler::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.TRIBBLE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Tribble::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.CORAL_SKRIMP.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Skrimp::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SQUODDLE.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Squoddle::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.GNASHER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Gnasher::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.HATCHET_FISH.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, HatchetFish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BLIND_SAILFIN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlindSailfin::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SHOCKCAT.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Shockcat::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.MUDDYTOP_SNAIL.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, MuddytopSnail::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BRICK_SNAIL.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BrickSnail::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.BLACKCAP_SNAIL.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlackCapSnail::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.DEEP_CRAWLER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, DeepCrawler::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.FRESHWATER_MANTIS.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, FreshwaterMantis::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.PORCUPINE_LOBSTA.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, PorcupineLobster::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.TRIPLE_TWIRL_PLECO.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, TripleTwirlPleco::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_PANCAKE.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaPancake::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_SPIDER.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaSpider::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(UFEntities.ROUGHBACK.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.OCEAN_FLOOR, RoughbackGuitarfish::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(UFEntities.DUALITY_DAMSELFISH.get(), DualityDamselfish.createAttributes().build());
        event.put(UFEntities.MOSSTHORN.get(), Mossthorn.createAttributes().build());
        event.put(UFEntities.RIPPER.get(), Ripper.createAttributes().build());
        event.put(UFEntities.SPINDLEFISH.get(), Spindlefish.createAttributes().build());
        event.put(UFEntities.RHINO_TETRA.get(), RhinoTetra.createAttributes().build());
        event.put(UFEntities.DROOPING_GOURAMI.get(), DroopingGourami.createAttributes().build());
        event.put(UFEntities.SAILOR_BARB.get(), SailorBarb.createAttributes().build());
        event.put(UFEntities.SEA_SPIDER.get(), SeaSpider.createAttributes().build());
        event.put(UFEntities.TRIPLE_TWIRL_PLECO.get(), TripleTwirlPleco.createAttributes().build());
        event.put(UFEntities.AERO_MONO.get(), AeroMono.createAttributes().build());
        event.put(UFEntities.CLOWNTHORN_SHARK.get(), ClownthornShark.createAttributes().build());
        event.put(UFEntities.ROUGHBACK.get(), RoughbackGuitarfish.createAttributes().build());
        event.put(UFEntities.PINKFIN.get(), PinkfinIdol.createAttributes().build());
        event.put(UFEntities.SEA_PANCAKE.get(), SeaPancake.createAttributes().build());
        event.put(UFEntities.BRICK_SNAIL.get(), BrickSnail.createAttributes().build());
        event.put(UFEntities.ZEBRA_CORNETFISH.get(), ZebraCornetfish.createAttributes().build());
        event.put(UFEntities.TIGER_PUFFER.get(), TigerPuffer.createAttributes().build());
        event.put(UFEntities.BLACKCAP_SNAIL.get(), BlackCapSnail.createAttributes().build());
        event.put(UFEntities.SNEEPSNORP.get(), SneepSnorp.createAttributes().build());
        event.put(UFEntities.DEEP_CRAWLER.get(), DeepCrawler.createAttributes().build());
        event.put(UFEntities.WIZARD_JELLY.get(), ManaJellyfish.createAttributes().build());
        event.put(UFEntities.PORCUPINE_LOBSTA.get(), PorcupineLobster.createAttributes().build());
        event.put(UFEntities.TRUMPET_SQUID.get(), TrumpetSquid.createAttributes().build());
        event.put(UFEntities.FRESHWATER_MANTIS.get(), FreshwaterMantis.createAttributes().build());
        event.put(UFEntities.BARK_ANGELFISH.get(), BarkAngelfish.createAttributes().build());
        event.put(UFEntities.SHOCKCAT.get(), Shockcat.createAttributes().build());
        event.put(UFEntities.MUDDYTOP_SNAIL.get(), MuddytopSnail.createAttributes().build());
        event.put(UFEntities.KALAPPA.get(), Kalappa.createAttributes().build());
        event.put(UFEntities.LOBED_SKIPPER.get(), LobedSkipper.createAttributes().build());
        event.put(UFEntities.STOUT_BICHIR.get(), StoutBichir.createAttributes().build());
        event.put(UFEntities.BEAKED_HERRING.get(), BeakedHerring.createAttributes().build());
        event.put(UFEntities.PICKLEFISH.get(), Picklefish.createAttributes().build());
        event.put(UFEntities.BLIND_SAILFIN.get(), BlindSailfin.createAttributes().build());
        event.put(UFEntities.DEMON_HERRING.get(), DemonHerring.createAttributes().build());
        event.put(UFEntities.AMBER_GOBY.get(), AmberGoby.createAttributes().build());
        event.put(UFEntities.HATCHET_FISH.get(), HatchetFish.createAttributes().build());
        event.put(UFEntities.COPPERFLAME.get(), CopperflameAnthias.createAttributes().build());
        event.put(UFEntities.ROOTBALL.get(), Rootball.createAttributes().build());
        event.put(UFEntities.CELESTIAL_FISH.get(), CelestialFish.createAttributes().build());
        event.put(UFEntities.GNASHER.get(), Gnasher.createAttributes().build());
        event.put(UFEntities.PRAWN.get(), Prawn.createAttributes().build());
        event.put(UFEntities.SQUODDLE.get(), Squoddle.createAttributes().build());
        event.put(UFEntities.SEA_MOSQUITO.get(), SeaMosquito.createAttributes().build());
        event.put(UFEntities.FORKFISH.get(), Forkfish.createAttributes().build());
        event.put(UFEntities.SPOON_SHARK.get(), SpoonShark.createAttributes().build());
        event.put(UFEntities.CORAL_SKRIMP.get(), Skrimp.createAttributes().build());
        event.put(UFEntities.CIRCUS_FISH.get(), CircusFish.createAttributes().build());
        event.put(UFEntities.BLIZZARDFIN_TUNA.get(), BlizzardfinTuna.createAttributes().build());
        event.put(UFEntities.EYELASH.get(), EyelashFish.createAttributes().build());
        event.put(UFEntities.FROSTY_FIN.get(), FrostyFinFish.createAttributes().build());
        event.put(UFEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleShark.createAttributes().build());
        event.put(UFEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquid.createAttributes().build());
        event.put(UFEntities.VOLT_ANGLER.get(), VoltAngler.createAttributes().build());
        event.put(UFEntities.TRIBBLE.get(), Tribble.createAttributes().build());
    }

}
