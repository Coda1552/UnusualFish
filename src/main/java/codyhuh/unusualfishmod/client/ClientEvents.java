package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.model.*;
import codyhuh.unusualfishmod.client.renderer.*;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD)
public final class ClientEvents {

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(UFModelLayers.DUALITY_DAMSELFISH, DualityDamselfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.MOSSTHORN, MossthornModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.RIPPER, RipperModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SPINDLEFISH, SpindlefishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.RHINO_TETRA, RhinoTetraModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.DROOPING_GOURAMI, DroopingGouramiModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SAILOR_BARB, SailorBarbModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SEA_SPIDER, SeaSpiderModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.TRIPLE_TWIRL_PLECO, TripleTwirlPlecoModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.AERO_MONO, AeroMonoModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.CLOWNTHORN_SHARK, ClownthornSharkModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.ROUGHBACK_GUITARFISH, RoughbackGuitarfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.PINKFIN_IDOL, PinkfinIdolModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SEA_PANCAKE, SeaPancakeModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BRICK_SNAIL, BrickSnailModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.ZEBRA_CORNETFISH, ZebraCornetfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.TIGER_PUFFER, TigerPufferModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BLACKCAP_SNAIL, BlackcapSnailModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SNEEP_SNORP, SneepSnorpModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.DEEP_CRAWLER, DeepCrawlerModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.MANA_JELLYFISH, ManaJellyfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.PORCUPINE_LOBSTA, PorcupineLobsterModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.TRUMPET_SQUID, TrumpetSquidModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.FRESHWATER_MANTIS, FreshwaterMantisModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BARK_ANGELFISH, BarkAngelfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SHOCKCAT, ShockcatModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.MUDDYTOP_SNAIL, MuddytopSnailModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.KALAPPA, KalappaModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.LOBED_SKIPPER, LobedSkipperModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.STOUT_BICHIR, StoutBichirModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BEAKED_HERRING, BeakedHerringModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.PICKLEFISH, PicklefishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BLIND_SAILFIN, BlindSailfinModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.DEMON_HERRING, DemonHerringModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.AMBER_GOBY, AmberGobyModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.HATCHET_FISH, HatchetFishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.COPPERFLAME_ANTHIAS, CopperflameAnthiasModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.ROOTBALL, RootballModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.CELESTIAL_FISH, CelestialFishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.GNASHER, GnasherModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.PRAWN, PrawnModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SQUODDLE, SquoddleModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SEA_MOSQUITO, SeaMosquitoModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.FORKFISH, ForkfishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SPOON_SHARK, SpoonSharkModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.CORAL_SKRIMP, CoralSkrimpModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.CIRCUS_FISH, CircusFishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.BLIZZARDFIN_TUNA, BlizzardfinTunaModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.EYELASH_FISH, EyelashFishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.SNOWFLAKE_TAIL_FISH, SnowflakeTailFishModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.TIGER_JUNGLE_SHARK, TigerJungleSharkModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.CRIMSONSHELL_SQUID, CrimsonshellSquidModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.VOLT_ANGLER, VoltAnglerModel::createBodyLayer);
		event.registerLayerDefinition(UFModelLayers.TRIBBLE, TribbleModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(UFEntities.DUALITY_DAMSELFISH.get(), DualityDamselfishRenderer::new);
		event.registerEntityRenderer(UFEntities.MOSSTHORN.get(), MossthornRenderer::new);
		event.registerEntityRenderer(UFEntities.RIPPER.get(), RipperRenderer::new);
		event.registerEntityRenderer(UFEntities.SPINDLEFISH.get(), SpindlefishRenderer::new);
		event.registerEntityRenderer(UFEntities.RHINO_TETRA.get(), RhinoTetraRenderer::new);
		event.registerEntityRenderer(UFEntities.DROOPING_GOURAMI.get(), DroopingGouramiRenderer::new);
		event.registerEntityRenderer(UFEntities.SAILOR_BARB.get(), SailorBarbRenderer::new);
		event.registerEntityRenderer(UFEntities.SEA_SPIDER.get(), SeaSpiderRenderer::new);
		event.registerEntityRenderer(UFEntities.TRIPLE_TWIRL_PLECO.get(), TripleTwirlPlecoRenderer::new);
		event.registerEntityRenderer(UFEntities.AERO_MONO.get(), AeroMonoRenderer::new);
		event.registerEntityRenderer(UFEntities.CLOWNTHORN_SHARK.get(), ClownthornSharkRenderer::new);
		event.registerEntityRenderer(UFEntities.ROUGHBACK.get(), RoughbackGuitarfishRenderer::new);
		event.registerEntityRenderer(UFEntities.PINKFIN.get(), PinkfinIdolRenderer::new);
		event.registerEntityRenderer(UFEntities.SEA_PANCAKE.get(), SeaPancakeRenderer::new);
		event.registerEntityRenderer(UFEntities.BRICK_SNAIL.get(), BrickSnailRenderer::new);
		event.registerEntityRenderer(UFEntities.ZEBRA_CORNETFISH.get(), ZebraCornetfishRenderer::new);
		event.registerEntityRenderer(UFEntities.TIGER_PUFFER.get(), TigerPufferRenderer::new);
		event.registerEntityRenderer(UFEntities.BLACKCAP_SNAIL.get(), BlackcapSnailRenderer::new);
		event.registerEntityRenderer(UFEntities.SNEEPSNORP.get(), SneepSnorpRenderer::new);
		event.registerEntityRenderer(UFEntities.DEEP_CRAWLER.get(), DeepCrawlerRenderer::new);
		event.registerEntityRenderer(UFEntities.WIZARD_JELLY.get(), ManaJellyfishRenderer::new);
		event.registerEntityRenderer(UFEntities.PORCUPINE_LOBSTA.get(), PorcupineLobsterRenderer::new);
		event.registerEntityRenderer(UFEntities.TRUMPET_SQUID.get(), TrumpetSquidRenderer::new);
		event.registerEntityRenderer(UFEntities.FRESHWATER_MANTIS.get(), FreshwaterMantisRenderer::new);
		event.registerEntityRenderer(UFEntities.BARK_ANGELFISH.get(), BarkAngelfishRenderer::new);
		event.registerEntityRenderer(UFEntities.SHOCKCAT.get(), ShockcatRenderer::new);
		event.registerEntityRenderer(UFEntities.MUDDYTOP_SNAIL.get(), MuddytopSnailRenderer::new);
		event.registerEntityRenderer(UFEntities.KALAPPA.get(), KalappaRenderer::new);
		event.registerEntityRenderer(UFEntities.LOBED_SKIPPER.get(), LobedSkipperRenderer::new);
		event.registerEntityRenderer(UFEntities.STOUT_BICHIR.get(), StoutBichirRenderer::new);
		event.registerEntityRenderer(UFEntities.BEAKED_HERRING.get(), BeakedHerringRenderer::new);
		event.registerEntityRenderer(UFEntities.PICKLEFISH.get(), PicklefishRenderer::new);
		event.registerEntityRenderer(UFEntities.BLIND_SAILFIN.get(), BlindSailfinRenderer::new);
		event.registerEntityRenderer(UFEntities.DEMON_HERRING.get(), DemonHerringRenderer::new);
		event.registerEntityRenderer(UFEntities.AMBER_GOBY.get(), AmberGobyRenderer::new);
		event.registerEntityRenderer(UFEntities.HATCHET_FISH.get(), HatchetfishRenderer::new);
		event.registerEntityRenderer(UFEntities.COPPERFLAME.get(), CopperflameAnthiasRenderer::new);
		event.registerEntityRenderer(UFEntities.ROOTBALL.get(), RootballRenderer::new);
		event.registerEntityRenderer(UFEntities.CELESTIAL_FISH.get(), CelestialFishRenderer::new);
		event.registerEntityRenderer(UFEntities.GNASHER.get(), GnasherRenderer::new);
		event.registerEntityRenderer(UFEntities.PRAWN.get(), PrawnRenderer::new);
		event.registerEntityRenderer(UFEntities.SQUODDLE.get(), SquoddleRenderer::new);
		event.registerEntityRenderer(UFEntities.SEA_MOSQUITO.get(), SeaMosquitoRenderer::new);
		event.registerEntityRenderer(UFEntities.FORKFISH.get(), ForkfishRenderer::new);
		event.registerEntityRenderer(UFEntities.SPOON_SHARK.get(), SpoonSharkRenderer::new);
		event.registerEntityRenderer(UFEntities.CORAL_SKRIMP.get(), CoralSkrimpRenderer::new);
		event.registerEntityRenderer(UFEntities.CIRCUSFISH.get(), CircusFishRenderer::new);
		event.registerEntityRenderer(UFEntities.BLIZZARDFIN.get(), BlizzardfinTunaRenderer::new);
		event.registerEntityRenderer(UFEntities.ABYSSAL_BLAST.get(), AbyssalBlastRenderer::new);
		event.registerEntityRenderer(UFEntities.EYELASH.get(), EyelashFishRenderer::new);
		event.registerEntityRenderer(UFEntities.SNOWFLAKE.get(), SnowflakeTailFishRenderer::new);
		event.registerEntityRenderer(UFEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleSharkRenderer::new);
		event.registerEntityRenderer(UFEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquidRenderer::new);
		event.registerEntityRenderer(UFEntities.VOLT_ANGLER.get(), VoltAnglerRenderer::new);
		event.registerEntityRenderer(UFEntities.TRIBBLE.get(), TribbleRenderer::new);

	}
}

