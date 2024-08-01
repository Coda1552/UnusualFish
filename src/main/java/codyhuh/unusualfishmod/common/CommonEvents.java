package codyhuh.unusualfishmod.common;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.*;
import codyhuh.unusualfishmod.common.entity.item.ThrownPrismarineSpear;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent e) {
        DispenserBlock.registerBehavior(UFItems.PRISMARINE_SPEAR.get(), new AbstractProjectileDispenseBehavior() {
            protected Projectile getProjectile(Level level, Position pos, ItemStack stack) {
                ThrownPrismarineSpear arrow = new ThrownPrismarineSpear(UFEntities.PRISMARINE_SPEAR.get(), pos.x(), pos.y(), pos.z(), level);
                arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                return arrow;
            }
        });
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent e) {
        e.register(UFEntities.AERO_MONO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AeroMono::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.PINKFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, PinkfinIdol::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.CLOWNTHORN_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ClownthornShark::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.DUALITY_DAMSELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DualityDamselfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.DROOPING_GOURAMI.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DroopingGourami::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.MOSSTHORN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Mossthorn::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.RHINO_TETRA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, RhinoTetra::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.RIPPER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Ripper::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SAILOR_BARB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SailorBarb::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SPINDLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Spindlefish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.ZEBRA_CORNETFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ZebraCornetfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.TIGER_PUFFER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerPuffer::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SNEEPSNORP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SneepSnorp::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.WIZARD_JELLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, ManaJellyfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.TRUMPET_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TrumpetSquid::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BARK_ANGELFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BarkAngelfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.STOUT_BICHIR.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, StoutBichir::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.KALAPPA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Kalappa::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.LOBED_SKIPPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, LobedSkipper::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BEAKED_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BeakedHerring::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.PICKLEFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Picklefish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.DEMON_HERRING.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, DemonHerring::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.AMBER_GOBY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, AmberGoby::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.COPPERFLAME.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CopperflameAnthias::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.ROOTBALL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Rootball::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.CELESTIAL_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CelestialFish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.PRAWN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Prawn::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_MOSQUITO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SeaMosquito::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.FORKFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Forkfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SPOON_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SpoonShark::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.CIRCUSFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CircusFish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BLIZZARDFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, BlizzardfinTuna::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.TIGER_JUNGLE_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, TigerJungleShark::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SNOWFLAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, SnowflakeTailFish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.EYELASH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, EyelashFish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.CRIMSONSHELL_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, CrimsonshellSquid::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.VOLT_ANGLER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, VoltAngler::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.TRIBBLE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Tribble::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.CORAL_SKRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, CoralSkrimp::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SQUODDLE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Squoddle::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.GNASHER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Gnasher::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.HATCHET_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, HatchetFish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BLIND_SAILFIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlindSailfin::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SHOCKCAT.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, Shockcat::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.MUDDYTOP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, MuddytopSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BRICK_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BrickSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.BLACKCAP_SNAIL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, BlackCapSnail::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.DEEP_CRAWLER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, DeepCrawler::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.FRESHWATER_MANTIS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, FreshwaterMantis::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.PORCUPINE_LOBSTA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, PorcupineLobster::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.TRIPLE_TWIRL_PLECO.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, TripleTwirlPleco::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_PANCAKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaPancake::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.SEA_SPIDER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaSpider::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
        e.register(UFEntities.ROUGHBACK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, RoughbackGuitarfish::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
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
        event.put(UFEntities.CORAL_SKRIMP.get(), CoralSkrimp.createAttributes().build());
        event.put(UFEntities.CIRCUSFISH.get(), CircusFish.createAttributes().build());
        event.put(UFEntities.BLIZZARDFIN.get(), BlizzardfinTuna.createAttributes().build());
        event.put(UFEntities.EYELASH.get(), EyelashFish.createAttributes().build());
        event.put(UFEntities.SNOWFLAKE.get(), SnowflakeTailFish.createAttributes().build());
        event.put(UFEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleShark.createAttributes().build());
        event.put(UFEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquid.createAttributes().build());
        event.put(UFEntities.VOLT_ANGLER.get(), VoltAngler.createAttributes().build());
        event.put(UFEntities.TRIBBLE.get(), Tribble.createAttributes().build());
    }

}
