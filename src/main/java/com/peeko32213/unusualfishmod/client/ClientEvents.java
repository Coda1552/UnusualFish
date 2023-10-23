package com.peeko32213.unusualfishmod.client;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.client.model.*;
import com.peeko32213.unusualfishmod.client.renderer.*;
import com.peeko32213.unusualfishmod.core.init.UnusualFishEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(DualityDamselfishModel.LAYER_LOCATION, DualityDamselfishModel::createBodyLayer);
		event.registerLayerDefinition(MossthornModel.LAYER_LOCATION, MossthornModel::createBodyLayer);
		event.registerLayerDefinition(RipperModel.LAYER_LOCATION, RipperModel::createBodyLayer);
		event.registerLayerDefinition(SpindlefishModel.LAYER_LOCATION, SpindlefishModel::createBodyLayer);
		event.registerLayerDefinition(RhinoTetraModel.LAYER_LOCATION, RhinoTetraModel::createBodyLayer);
		event.registerLayerDefinition(DroopingGouramiModel.LAYER_LOCATION, DroopingGouramiModel::createBodyLayer);
		event.registerLayerDefinition(SailorBarbModel.LAYER_LOCATION, SailorBarbModel::createBodyLayer);
		event.registerLayerDefinition(SeaSpiderModel.LAYER_LOCATION, SeaSpiderModel::createBodyLayer);
		event.registerLayerDefinition(TripleTwirlPlecoModel.LAYER_LOCATION, TripleTwirlPlecoModel::createBodyLayer);
		event.registerLayerDefinition(AeroMonoModel.LAYER_LOCATION, AeroMonoModel::createBodyLayer);
		event.registerLayerDefinition(ClownthornSharkModel.LAYER_LOCATION, ClownthornSharkModel::createBodyLayer);
		event.registerLayerDefinition(RoughbackGuitarfishModel.LAYER_LOCATION, RoughbackGuitarfishModel::createBodyLayer);
		event.registerLayerDefinition(PinkfinIdolModel.LAYER_LOCATION, PinkfinIdolModel::createBodyLayer);
		event.registerLayerDefinition(SeaPancakeModel.LAYER_LOCATION, SeaPancakeModel::createBodyLayer);
		event.registerLayerDefinition(BrickSnailModel.LAYER_LOCATION, BrickSnailModel::createBodyLayer);
		event.registerLayerDefinition(ZebraCornetfishModel.LAYER_LOCATION, ZebraCornetfishModel::createBodyLayer);
		event.registerLayerDefinition(TigerPufferModel.LAYER_LOCATION, TigerPufferModel::createBodyLayer);
		event.registerLayerDefinition(BlackcapSnailModel.LAYER_LOCATION, BlackcapSnailModel::createBodyLayer);
		event.registerLayerDefinition(SneepSnorpModel.LAYER_LOCATION, SneepSnorpModel::createBodyLayer);
		event.registerLayerDefinition(DeepCrawlerModel.LAYER_LOCATION, DeepCrawlerModel::createBodyLayer);
		event.registerLayerDefinition(ManaJellyfishModel.LAYER_LOCATION, ManaJellyfishModel::createBodyLayer);
		event.registerLayerDefinition(PorcupineLobsterModel.LAYER_LOCATION, PorcupineLobsterModel::createBodyLayer);
		event.registerLayerDefinition(TrumpetSquidModel.LAYER_LOCATION, TrumpetSquidModel::createBodyLayer);
		event.registerLayerDefinition(FreshwaterMantisModel.LAYER_LOCATION, FreshwaterMantisModel::createBodyLayer);
		event.registerLayerDefinition(BarkAngelfishModel.LAYER_LOCATION, BarkAngelfishModel::createBodyLayer);
		event.registerLayerDefinition(ShockcatModel.LAYER_LOCATION, ShockcatModel::createBodyLayer);
		event.registerLayerDefinition(MuddytopSnailModel.LAYER_LOCATION, MuddytopSnailModel::createBodyLayer);
		event.registerLayerDefinition(KalappaModel.LAYER_LOCATION, KalappaModel::createBodyLayer);
		event.registerLayerDefinition(LobedSkipperModel.LAYER_LOCATION, LobedSkipperModel::createBodyLayer);
		event.registerLayerDefinition(StoutBichirModel.LAYER_LOCATION, StoutBichirModel::createBodyLayer);
		event.registerLayerDefinition(BeakedHerringModel.LAYER_LOCATION, BeakedHerringModel::createBodyLayer);
		event.registerLayerDefinition(PicklefishModel.LAYER_LOCATION, PicklefishModel::createBodyLayer);
		event.registerLayerDefinition(BlindSailfinModel.LAYER_LOCATION, BlindSailfinModel::createBodyLayer);
		event.registerLayerDefinition(DemonHerringModel.LAYER_LOCATION, DemonHerringModel::createBodyLayer);
		event.registerLayerDefinition(AmberGobyModel.LAYER_LOCATION, AmberGobyModel::createBodyLayer);
		event.registerLayerDefinition(HatchetFishModel.LAYER_LOCATION, HatchetFishModel::createBodyLayer);
		event.registerLayerDefinition(CopperflameAnthiasModel.LAYER_LOCATION, CopperflameAnthiasModel::createBodyLayer);
		event.registerLayerDefinition(RootballModel.LAYER_LOCATION, RootballModel::createBodyLayer);
		event.registerLayerDefinition(CelestialFishModel.LAYER_LOCATION, CelestialFishModel::createBodyLayer);
		event.registerLayerDefinition(GnasherModel.LAYER_LOCATION, GnasherModel::createBodyLayer);
		event.registerLayerDefinition(PrawnModel.LAYER_LOCATION, PrawnModel::createBodyLayer);
		event.registerLayerDefinition(SquoddleModel.LAYER_LOCATION, SquoddleModel::createBodyLayer);
		event.registerLayerDefinition(SeaMosquitoModel.LAYER_LOCATION, SeaMosquitoModel::createBodyLayer);
		event.registerLayerDefinition(ForkfishModel.LAYER_LOCATION, ForkfishModel::createBodyLayer);
		event.registerLayerDefinition(SpoonSharkModel.LAYER_LOCATION, SpoonSharkModel::createBodyLayer);
		event.registerLayerDefinition(CoralSkrimpModel.LAYER_LOCATION, CoralSkrimpModel::createBodyLayer);
		event.registerLayerDefinition(CircusFishModel.LAYER_LOCATION, CircusFishModel::createBodyLayer);
		event.registerLayerDefinition(BlizzardfinTunaModel.LAYER_LOCATION, BlizzardfinTunaModel::createBodyLayer);
		event.registerLayerDefinition(EyelashFishModel.LAYER_LOCATION, EyelashFishModel::createBodyLayer);
		event.registerLayerDefinition(SnowflakeTailFishModel.LAYER_LOCATION, SnowflakeTailFishModel::createBodyLayer);
		event.registerLayerDefinition(TigerJungleSharkModel.LAYER_LOCATION, TigerJungleSharkModel::createBodyLayer);
		event.registerLayerDefinition(CrimsonshellSquidModel.LAYER_LOCATION, CrimsonshellSquidModel::createBodyLayer);
		event.registerLayerDefinition(VoltAnglerModel.LAYER_LOCATION, VoltAnglerModel::createBodyLayer);
		event.registerLayerDefinition(TribbleModel.LAYER_LOCATION, TribbleModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(UnusualFishEntities.DUALITY_DAMSELFISH.get(), DualityDamselfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.MOSSTHORN.get(), MossthornRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.RIPPER.get(), RipperRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SPINDLEFISH.get(), SpindlefishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.RHINO_TETRA.get(), RhinoTetraRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.DROOPING_GOURAMI.get(), DroopingGouramiRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SAILOR_BARB.get(), SailorBarbRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SEA_SPIDER.get(), SeaSpiderRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.TRIPLE_TWIRL_PLECO.get(), TripleTwirlPlecoRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.AERO_MONO.get(), AeroMonoRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.CLOWNTHORN_SHARK.get(), ClownthornSharkRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.ROUGHBACK.get(), RoughbackGuitarfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.PINKFIN.get(), PinkfinIdolRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SEA_PANCAKE.get(), SeaPancakeRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BRICK_SNAIL.get(), BrickSnailRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.ZEBRA_CORNETFISH.get(), ZebraCornetfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.TIGER_PUFFER.get(), TigerPufferRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BLACKCAP_SNAIL.get(), BlackcapSnailRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SNEEPSNORP.get(), SneepSnorpRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.DEEP_CRAWLER.get(), DeepCrawlerRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.WIZARD_JELLY.get(), ManaJellyfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.PORCUPINE_LOBSTA.get(), PorcupineLobsterRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.TRUMPET_SQUID.get(), TrumpetSquidRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.FRESHWATER_MANTIS.get(), FreshwaterMantisRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BARK_ANGELFISH.get(), BarkAngelfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SHOCKCAT.get(), ShockcatRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.MUDDYTOP_SNAIL.get(), MuddytopSnailRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.KALAPPA.get(), KalappaRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.LOBED_SKIPPER.get(), LobedSkipperRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.STOUT_BICHIR.get(), StoutBichirRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BEAKED_HERRING.get(), BeakedHerringRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.PICKLEFISH.get(), PicklefishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BLIND_SAILFIN.get(), BlindSailfinRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.DEMON_HERRING.get(), DemonHerringRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.AMBER_GOBY.get(), AmberGobyRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.HATCHET_FISH.get(), HatchetfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.COPPERFLAME.get(), CopperflameAnthiasRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.ROOTBALL.get(), RootballRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.CELESTIAL_FISH.get(), CelestialFishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.GNASHER.get(), GnasherRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.PRAWN.get(), PrawnRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SQUODDLE.get(), SquoddleRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SEA_MOSQUITO.get(), SeaMosquitoRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.FORKFISH.get(), ForkfishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SPOON_SHARK.get(), SpoonSharkRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.CORAL_SKRIMP.get(), CoralSkrimpRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.CIRCUSFISH.get(), CircusFishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.BLIZZARDFIN.get(), BlizzardfinTunaRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.ABYSSAL_BLAST.get(), AbyssalBlastRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.EYELASH.get(), EyelashFishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.SNOWFLAKE.get(), SnowflakeTailFishRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleSharkRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquidRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.VOLT_ANGLER.get(), VoltAnglerRenderer::new);
		event.registerEntityRenderer(UnusualFishEntities.TRIBBLE.get(), TribbleRenderer::new);

	}
}

