package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.geo.GenericGeoModel;
import codyhuh.unusualfishmod.client.geo.GenericGeoRenderer;
import codyhuh.unusualfishmod.client.geo.TextureVariantModel;
import codyhuh.unusualfishmod.client.misc.render.AbyssalBlastRenderer;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.*;
import codyhuh.unusualfishmod.client.old.model.item.PrismarineSpearModel;
import codyhuh.unusualfishmod.client.old.render.*;
import codyhuh.unusualfishmod.client.misc.render.FallingTreeBlockRenderer;
import codyhuh.unusualfishmod.client.misc.render.SeaSpikeRenderer;
import codyhuh.unusualfishmod.client.misc.render.ThrownPrismarineSpearRenderer;
import codyhuh.unusualfishmod.client.old.render.layers.UFGlowRenderLayer;
import codyhuh.unusualfishmod.common.entity.*;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Bus.MOD)
public final class ClientEvents {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent e) {
		ItemProperties.register(UFItems.CLEMENT_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.FLUVIAL_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.THUNDEROUS_SHELL.get(), new ResourceLocation("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		ItemProperties.register(UFItems.PRISMARINE_SPEAR.get(), new ResourceLocation("using"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
		///ItemProperties.register(UFItems.RIPSAW.get(), new ResourceLocation("sawing"), (stack, level, player, i) -> player != null && player.isUsingItem() && stack.hasTag() ? stack.getOrCreateTag().getFloat("SawingProgress") : 0.0F);
		ItemProperties.register(UFItems.CORAL_SKRIMP_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
		ItemProperties.register(UFItems.COPPERFLAME_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
		ItemProperties.register(UFItems.DEMON_HERRING_BUCKET.get(), new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getOrCreateTag().getInt("Variant") : 0);
	}

	private static void make(EntityType type, String name){
		EntityRenderers.register(type, (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>(name), false));
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
		EntityType<?>[] simpleEntities = new EntityType[]{
				UFEntities.AERO_MONO.get(), UFEntities.AMBER_GOBY.get(), UFEntities.BARK_ANGELFISH.get(), UFEntities.BEAKED_HERRING.get(),
				UFEntities.BLACKCAP_SNAIL.get(), UFEntities.BLIND_SAILFIN.get(), UFEntities.BLIZZARDFIN_TUNA.get(), UFEntities.BRICK_SNAIL.get(),
				UFEntities.CIRCUS_FISH.get(), UFEntities.CLOWNTHORN_SHARK.get(), UFEntities.CRIMSONSHELL_SQUID.get(), UFEntities.DEEP_CRAWLER.get(),
				UFEntities.DROOPING_GOURAMI.get(), UFEntities.FORKFISH.get(), UFEntities.FRESHWATER_MANTIS.get(), UFEntities.KALAPPA.get(),
				UFEntities.LOBED_SKIPPER.get(), UFEntities.MOSSTHORN.get(), UFEntities.MUDDYTOP_SNAIL.get(), UFEntities.PINKFIN.get(),
				UFEntities.PORCUPINE_LOBSTA.get(), UFEntities.PRAWN.get(), UFEntities.RHINO_TETRA.get(), UFEntities.RIPPER.get(),
				UFEntities.ROOTBALL.get(), UFEntities.ROUGHBACK.get(), UFEntities.SAILOR_BARB.get(), UFEntities.SEA_MOSQUITO.get(),
				UFEntities.SEA_PANCAKE.get(), UFEntities.SEA_SPIDER.get(), UFEntities.SNEEPSNORP.get(), UFEntities.SNOWFLAKE.get(),
				UFEntities.SPINDLEFISH.get(), UFEntities.SPOON_SHARK.get(), UFEntities.SQUODDLE.get(), UFEntities.STOUT_BICHIR.get(),
				UFEntities.TIGER_JUNGLE_SHARK.get(), UFEntities.TIGER_PUFFER.get(), UFEntities.TRIBBLE.get(), UFEntities.TRUMPET_SQUID.get(),
				UFEntities.ZEBRA_CORNETFISH.get(), UFEntities.TRIPLE_TWIRL_PLECO.get(), // todo - triple twirl pleco variants
		};
		for (EntityType<?> type : simpleEntities) {
			make(type, type.getDescriptionId().substring("entity.unusualfishmod.".length()));
		}

		e.registerEntityRenderer(UFEntities.DUALITY_DAMSELFISH.get(), (ctx) -> {
			GenericGeoRenderer<DualityDamselfish> render = new GenericGeoRenderer<>(ctx, () -> {
				TextureVariantModel<DualityDamselfish> model = new TextureVariantModel<>("duality_damselfish");
				ArrayList<ResourceLocation> textures = new ArrayList<>();
				for (int i = 1; i <= 2; i++) {
					textures.add(new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/duality_damselfish/duality_damselfish_" + i + ".png"));
				}
				model.setTextures(DualityDamselfish::getVariant, textures);
				return model;
			}, false);
			return render;
		});

		e.registerEntityRenderer(UFEntities.CELESTIAL_FISH.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("celestial_fish"), true));

		e.registerEntityRenderer(UFEntities.COPPERFLAME.get(), (ctx) -> {
			GenericGeoRenderer<CopperflameAnthias> render = new GenericGeoRenderer<>(ctx, () -> {
				TextureVariantModel<CopperflameAnthias> model = new TextureVariantModel<>("copperflame_anthias");
				ArrayList<ResourceLocation> textures = new ArrayList<>();
				for (int i = 1; i <= 2; i++) {
					textures.add(new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/copperflame_anthias/copperflame_" + i + ".png"));
				}
				model.setTextures(CopperflameAnthias::getVariant, textures);
				return model;
			}, true);
			return render;
		});

		e.registerEntityRenderer(UFEntities.DEMON_HERRING.get(), (ctx) -> {
			GenericGeoRenderer<DemonHerring> render = new GenericGeoRenderer<>(ctx, () -> {
				TextureVariantModel<DemonHerring> model = new TextureVariantModel<>("demon_herring");
				ArrayList<ResourceLocation> textures = new ArrayList<>();
				for (int i = 1; i <= 3; i++) {
					textures.add(new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/demon_herring/demon_herring_" + i + ".png"));
				}
				model.setTextures(DemonHerring::getVariant, textures);
				return model;
			}, false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/demon_herring_" + render.getAnimatable().getVariant() + ".png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.GNASHER.get(), (ctx) -> {
			GenericGeoRenderer<Gnasher> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("gnasher"), false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/gnasher.png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.EYELASH.get(), (ctx) -> {
			GenericGeoRenderer<EyelashFish> render = new GenericGeoRenderer<>(ctx, () -> {
				TextureVariantModel<EyelashFish> model = new TextureVariantModel<>("eyelash_fish");
				ArrayList<ResourceLocation> textures = new ArrayList<>();
				for (int i = 1; i <= 15; i++) {
					textures.add(new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelash_fish/eyelash_fish_" + i + ".png"));
				}
				model.setTextures(EyelashFish::getVariant, textures);
				return model;
			}, false);
			return render;
		});

		e.registerEntityRenderer(UFEntities.HATCHET_FISH.get(), (ctx) -> {
			GenericGeoRenderer<HatchetFish> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("hatchet_fish"), false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/hatchet_fish.png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.WIZARD_JELLY.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("mana_jellyfish"), true));

		e.registerEntityRenderer(UFEntities.PICKLEFISH.get(), (ctx) -> {
			GenericGeoRenderer<Picklefish> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("picklefish"), false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/picklefish.png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.CORAL_SKRIMP.get(), (ctx) -> {
			GenericGeoRenderer<Skrimp> render = new GenericGeoRenderer<>(ctx, () -> {
				TextureVariantModel<Skrimp> model = new TextureVariantModel<>("skrimp");
				ArrayList<ResourceLocation> textures = new ArrayList<>();
				for (int i = 1; i <= 15; i++) {
					textures.add(new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/skrimp/skrimp_" + i + ".png"));
				}
				model.setTextures(Skrimp::getVariant, textures);
				return model;
			}, false);
			return render;
		});

		e.registerEntityRenderer(UFEntities.SHOCKCAT.get(), (ctx) -> {
			GenericGeoRenderer<Shockcat> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("shockcat"), false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/shockcat.png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.VOLT_ANGLER.get(), (ctx) -> {
			GenericGeoRenderer<VoltAngler> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("volt_angler"), false);
			render.addRenderLayer(new UFGlowRenderLayer<>(render, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/volt_angler.png")));
			return render;
		});

		e.registerEntityRenderer(UFEntities.ABYSSAL_BLAST.get(), AbyssalBlastRenderer::new);
		e.registerEntityRenderer(UFEntities.PRISMARINE_SPEAR.get(), ThrownPrismarineSpearRenderer::new);
		e.registerEntityRenderer(UFEntities.SEA_SPIKE.get(), SeaSpikeRenderer::new);
		e.registerEntityRenderer(UFEntities.FALLING_TREE.get(), FallingTreeBlockRenderer::new);
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

