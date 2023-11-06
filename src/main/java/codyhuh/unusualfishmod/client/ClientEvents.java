package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.model.*;
import codyhuh.unusualfishmod.client.model.item.PrismarineSpearModel;
import codyhuh.unusualfishmod.client.renderer.*;
import codyhuh.unusualfishmod.client.renderer.item.SeaSpikeRenderer;
import codyhuh.unusualfishmod.client.renderer.item.ThrownPrismarineSpearRenderer;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD)
public final class ClientEvents {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent e) {
		ItemProperties.register(UFItems.CLEMENT_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.FLUVIAL_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.THUNDEROUS_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.PRISMARINE_SPEAR.get(), new ResourceLocation("using"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.RIPSAW.get(), new ResourceLocation("sawing"), (stack, level, player, i) -> player != null && player.isUsingItem() && stack.hasTag() ? stack.getOrCreateTag().getFloat("SawingProgress") : 0.0F);
		ItemProperties.register(UFItems.CORAL_SKRIMP_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
		ItemProperties.register(UFItems.COPPERFLAME_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
		ItemProperties.register(UFItems.DEMON_HERRING_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
		e.registerEntityRenderer(UFEntities.DUALITY_DAMSELFISH.get(), DualityDamselfishRenderer::new);
		e.registerEntityRenderer(UFEntities.MOSSTHORN.get(), MossthornRenderer::new);
		e.registerEntityRenderer(UFEntities.RIPPER.get(), RipperRenderer::new);
		e.registerEntityRenderer(UFEntities.SPINDLEFISH.get(), SpindlefishRenderer::new);
		e.registerEntityRenderer(UFEntities.RHINO_TETRA.get(), RhinoTetraRenderer::new);
		e.registerEntityRenderer(UFEntities.DROOPING_GOURAMI.get(), DroopingGouramiRenderer::new);
		e.registerEntityRenderer(UFEntities.SAILOR_BARB.get(), SailorBarbRenderer::new);
		e.registerEntityRenderer(UFEntities.SEA_SPIDER.get(), SeaSpiderRenderer::new);
		e.registerEntityRenderer(UFEntities.TRIPLE_TWIRL_PLECO.get(), TripleTwirlPlecoRenderer::new);
		e.registerEntityRenderer(UFEntities.AERO_MONO.get(), AeroMonoRenderer::new);
		e.registerEntityRenderer(UFEntities.CLOWNTHORN_SHARK.get(), ClownthornSharkRenderer::new);
		e.registerEntityRenderer(UFEntities.ROUGHBACK.get(), RoughbackGuitarfishRenderer::new);
		e.registerEntityRenderer(UFEntities.PINKFIN.get(), PinkfinIdolRenderer::new);
		e.registerEntityRenderer(UFEntities.SEA_PANCAKE.get(), SeaPancakeRenderer::new);
		e.registerEntityRenderer(UFEntities.BRICK_SNAIL.get(), BrickSnailRenderer::new);
		e.registerEntityRenderer(UFEntities.ZEBRA_CORNETFISH.get(), ZebraCornetfishRenderer::new);
		e.registerEntityRenderer(UFEntities.TIGER_PUFFER.get(), TigerPufferRenderer::new);
		e.registerEntityRenderer(UFEntities.BLACKCAP_SNAIL.get(), BlackcapSnailRenderer::new);
		e.registerEntityRenderer(UFEntities.SNEEPSNORP.get(), SneepSnorpRenderer::new);
		e.registerEntityRenderer(UFEntities.DEEP_CRAWLER.get(), DeepCrawlerRenderer::new);
		e.registerEntityRenderer(UFEntities.WIZARD_JELLY.get(), ManaJellyfishRenderer::new);
		e.registerEntityRenderer(UFEntities.PORCUPINE_LOBSTA.get(), PorcupineLobsterRenderer::new);
		e.registerEntityRenderer(UFEntities.TRUMPET_SQUID.get(), TrumpetSquidRenderer::new);
		e.registerEntityRenderer(UFEntities.FRESHWATER_MANTIS.get(), FreshwaterMantisRenderer::new);
		e.registerEntityRenderer(UFEntities.BARK_ANGELFISH.get(), BarkAngelfishRenderer::new);
		e.registerEntityRenderer(UFEntities.SHOCKCAT.get(), ShockcatRenderer::new);
		e.registerEntityRenderer(UFEntities.MUDDYTOP_SNAIL.get(), MuddytopSnailRenderer::new);
		e.registerEntityRenderer(UFEntities.KALAPPA.get(), KalappaRenderer::new);
		e.registerEntityRenderer(UFEntities.LOBED_SKIPPER.get(), LobedSkipperRenderer::new);
		e.registerEntityRenderer(UFEntities.STOUT_BICHIR.get(), StoutBichirRenderer::new);
		e.registerEntityRenderer(UFEntities.BEAKED_HERRING.get(), BeakedHerringRenderer::new);
		e.registerEntityRenderer(UFEntities.PICKLEFISH.get(), PicklefishRenderer::new);
		e.registerEntityRenderer(UFEntities.BLIND_SAILFIN.get(), BlindSailfinRenderer::new);
		e.registerEntityRenderer(UFEntities.DEMON_HERRING.get(), DemonHerringRenderer::new);
		e.registerEntityRenderer(UFEntities.AMBER_GOBY.get(), AmberGobyRenderer::new);
		e.registerEntityRenderer(UFEntities.HATCHET_FISH.get(), HatchetfishRenderer::new);
		e.registerEntityRenderer(UFEntities.COPPERFLAME.get(), CopperflameAnthiasRenderer::new);
		e.registerEntityRenderer(UFEntities.ROOTBALL.get(), RootballRenderer::new);
		e.registerEntityRenderer(UFEntities.CELESTIAL_FISH.get(), CelestialFishRenderer::new);
		e.registerEntityRenderer(UFEntities.GNASHER.get(), GnasherRenderer::new);
		e.registerEntityRenderer(UFEntities.PRAWN.get(), PrawnRenderer::new);
		e.registerEntityRenderer(UFEntities.SQUODDLE.get(), SquoddleRenderer::new);
		e.registerEntityRenderer(UFEntities.SEA_MOSQUITO.get(), SeaMosquitoRenderer::new);
		e.registerEntityRenderer(UFEntities.FORKFISH.get(), ForkfishRenderer::new);
		e.registerEntityRenderer(UFEntities.SPOON_SHARK.get(), SpoonSharkRenderer::new);
		e.registerEntityRenderer(UFEntities.CORAL_SKRIMP.get(), CoralSkrimpRenderer::new);
		e.registerEntityRenderer(UFEntities.CIRCUSFISH.get(), CircusFishRenderer::new);
		e.registerEntityRenderer(UFEntities.BLIZZARDFIN.get(), BlizzardfinTunaRenderer::new);
		e.registerEntityRenderer(UFEntities.ABYSSAL_BLAST.get(), AbyssalBlastRenderer::new);
		e.registerEntityRenderer(UFEntities.EYELASH.get(), EyelashFishRenderer::new);
		e.registerEntityRenderer(UFEntities.SNOWFLAKE.get(), SnowflakeTailFishRenderer::new);
		e.registerEntityRenderer(UFEntities.TIGER_JUNGLE_SHARK.get(), TigerJungleSharkRenderer::new);
		e.registerEntityRenderer(UFEntities.CRIMSONSHELL_SQUID.get(), CrimsonshellSquidRenderer::new);
		e.registerEntityRenderer(UFEntities.VOLT_ANGLER.get(), VoltAnglerRenderer::new);
		e.registerEntityRenderer(UFEntities.TRIBBLE.get(), TribbleRenderer::new);
		e.registerEntityRenderer(UFEntities.PRISMARINE_SPEAR.get(), ThrownPrismarineSpearRenderer::new);
		e.registerEntityRenderer(UFEntities.SEA_SPIKE.get(), SeaSpikeRenderer::new);
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
		e.registerLayerDefinition(UFModelLayers.DUALITY_DAMSELFISH, DualityDamselfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.MOSSTHORN, MossthornModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.RIPPER, RipperModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SPINDLEFISH, SpindlefishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.RHINO_TETRA, RhinoTetraModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.DROOPING_GOURAMI, DroopingGouramiModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SAILOR_BARB, SailorBarbModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SEA_SPIDER, SeaSpiderModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.TRIPLE_TWIRL_PLECO, TripleTwirlPlecoModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.AERO_MONO, AeroMonoModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.CLOWNTHORN_SHARK, ClownthornSharkModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.ROUGHBACK_GUITARFISH, RoughbackGuitarfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.PINKFIN_IDOL, PinkfinIdolModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SEA_PANCAKE, SeaPancakeModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BRICK_SNAIL, BrickSnailModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.ZEBRA_CORNETFISH, ZebraCornetfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.TIGER_PUFFER, TigerPufferModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BLACKCAP_SNAIL, BlackcapSnailModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SNEEP_SNORP, SneepSnorpModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.DEEP_CRAWLER, DeepCrawlerModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.MANA_JELLYFISH, ManaJellyfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.PORCUPINE_LOBSTA, PorcupineLobsterModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.TRUMPET_SQUID, TrumpetSquidModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.FRESHWATER_MANTIS, FreshwaterMantisModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BARK_ANGELFISH, BarkAngelfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SHOCKCAT, ShockcatModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.MUDDYTOP_SNAIL, MuddytopSnailModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.KALAPPA, KalappaModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.LOBED_SKIPPER, LobedSkipperModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.STOUT_BICHIR, StoutBichirModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BEAKED_HERRING, BeakedHerringModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.PICKLEFISH, PicklefishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BLIND_SAILFIN, BlindSailfinModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.DEMON_HERRING, DemonHerringModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.AMBER_GOBY, AmberGobyModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.HATCHET_FISH, HatchetFishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.COPPERFLAME_ANTHIAS, CopperflameAnthiasModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.ROOTBALL, RootballModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.CELESTIAL_FISH, CelestialFishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.GNASHER, GnasherModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.PRAWN, PrawnModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SQUODDLE, SquoddleModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SEA_MOSQUITO, SeaMosquitoModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.FORKFISH, ForkfishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SPOON_SHARK, SpoonSharkModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.CORAL_SKRIMP, CoralSkrimpModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.CIRCUS_FISH, CircusFishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.BLIZZARDFIN_TUNA, BlizzardfinTunaModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.EYELASH_FISH, EyelashFishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.SNOWFLAKE_TAIL_FISH, SnowflakeTailFishModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.TIGER_JUNGLE_SHARK, TigerJungleSharkModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.CRIMSONSHELL_SQUID, CrimsonshellSquidModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.VOLT_ANGLER, VoltAnglerModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.TRIBBLE, TribbleModel::createBodyLayer);
		e.registerLayerDefinition(UFModelLayers.PRISMARINE_SPEAR, PrismarineSpearModel::createBodyLayer);
	}
}

