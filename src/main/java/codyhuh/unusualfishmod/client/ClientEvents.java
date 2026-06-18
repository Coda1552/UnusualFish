package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.geo.*;
import codyhuh.unusualfishmod.client.misc.render.*;
import codyhuh.unusualfishmod.client.misc.render.model.PrismarineSpearModel;
import codyhuh.unusualfishmod.client.misc.render.model.RootballModel;
import codyhuh.unusualfishmod.common.entity.*;
import codyhuh.unusualfishmod.core.registry.UFEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.ArrayList;

import static codyhuh.unusualfishmod.UnusualFishMod.loc;

@EventBusSubscriber(modid = UnusualFishMod.MOD_ID, value = Dist.CLIENT)
public final class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        ItemProperties.register(UFItems.CLEMENT_SHELL.get(), loc("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
        ItemProperties.register(UFItems.FLUVIAL_SHELL.get(), loc("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
        ItemProperties.register(UFItems.THUNDEROUS_SHELL.get(), loc("blowing"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
        ItemProperties.register(UFItems.PRISMARINE_SPEAR.get(), loc("using"), (p_234978_, p_234979_, p_234980_, p_234981_) -> p_234980_ != null && p_234980_.isUsingItem() && p_234980_.getUseItem() == p_234978_ ? 1.0F : 0.0F);
        ///ItemProperties.register(UFItems.RIPSAW.get(), new ResourceLocation("sawing"), (stack, level, player, i) -> player != null && player.isUsingItem() && stack.hasTag() ? stack.getOrCreateTag().getFloat("SawingProgress") : 0.0F);
        ItemProperties.register(UFItems.CORAL_SKRIMP_BUCKET.get(), loc("variant"), (stack, level, entity, seed) -> getBucketVariant(stack));
        ItemProperties.register(UFItems.COPPERFLAME_BUCKET.get(), loc("variant"), (stack, level, entity, seed) -> getBucketVariant(stack));
        ItemProperties.register(UFItems.DEMON_HERRING_BUCKET.get(), loc("variant"), (stack, level, entity, seed) -> getBucketVariant(stack));
    }

    private static int getBucketVariant(ItemStack stack) {
        CustomData customData = stack.get(DataComponents.BUCKET_ENTITY_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            if (customData.contains("Variant")) {
                return tag.getInt("Variant");
            }
        }
        return 0;
    }

    private static void make(EntityType type, String name) {
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
                UFEntities.ROUGHBACK.get(), UFEntities.SAILOR_BARB.get(), UFEntities.SEA_MOSQUITO.get(),
                UFEntities.SEA_PANCAKE.get(), UFEntities.SEA_SPIDER.get(), UFEntities.SNEEPSNORP.get(), UFEntities.FROSTY_FIN.get(),
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
                    textures.add(loc("textures/entity/duality_damselfish/duality_damselfish_" + i + ".png"));
                }
                model.setTextures(DualityDamselfish::getVariant, textures);
                return model;
            }, false);
            return render;
        });

        e.registerEntityRenderer(UFEntities.CELESTIAL_FISH.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("celestial_fish"), true));

        e.registerEntityRenderer(UFEntities.COPPERFLAME.get(), (ctx) -> {
            GenericGeoRenderer<CopperflameAnthias> render = new GenericGeoRenderer<>(ctx, () -> {
                TextureVariantModel<CopperflameAnthias> model = new TextureVariantModel<>("copperflame");
                ArrayList<ResourceLocation> textures = new ArrayList<>();
                for (int i = 1; i <= 2; i++) {
                    textures.add(loc("textures/entity/copperflame_anthias/copperflame_" + i + ".png"));
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
                    textures.add(loc("textures/entity/demon_herring/demon_herring_" + i + ".png"));
                }
                model.setTextures(DemonHerring::getVariant, textures);
                return model;
            }, false);
            render.addRenderLayer(new DemonHerringGlowRenderLayer<>(render));
            return render;
        });

        e.registerEntityRenderer(UFEntities.GNASHER.get(), (ctx) -> {
            GenericGeoRenderer<Gnasher> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("gnasher"), false);
            render.addRenderLayer(new UFGlowRenderLayer<>(render, loc("textures/entity/glow/gnasher.png")));
            return render;
        });

        e.registerEntityRenderer(UFEntities.EYELASH.get(), (ctx) -> {
            GenericGeoRenderer<EyelashFish> render = new GenericGeoRenderer<>(ctx, () -> {
                TextureVariantModel<EyelashFish> model = new TextureVariantModel<>("eyelash_fish");
                ArrayList<ResourceLocation> textures = new ArrayList<>();
                for (int i = 1; i <= 15; i++) {
                    textures.add(loc("textures/entity/eyelash_fish/eyelash_fish_" + i + ".png"));
                }
                model.setTextures(EyelashFish::getVariant, textures);
                return model;
            }, false);
            return render;
        });

        e.registerEntityRenderer(UFEntities.HATCHET_FISH.get(), (ctx) -> {
            GenericGeoRenderer<HatchetFish> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("hatchet_fish"), false);
            render.addRenderLayer(new UFGlowRenderLayer<>(render, loc("textures/entity/glow/hatchet_fish.png")));
            return render;
        });

        e.registerEntityRenderer(UFEntities.WIZARD_JELLY.get(), (ctx) -> new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("mana_jellyfish"), true));

        e.registerEntityRenderer(UFEntities.PICKLEFISH.get(), (ctx) -> {
            GenericGeoRenderer<Picklefish> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("picklefish"), false);
            render.addRenderLayer(new UFGlowRenderLayer<>(render, loc("textures/entity/glow/picklefish.png")));
            return render;
        });

        e.registerEntityRenderer(UFEntities.CORAL_SKRIMP.get(), (ctx) -> {
            GenericGeoRenderer<Skrimp> render = new GenericGeoRenderer<>(ctx, () -> {
                TextureVariantModel<Skrimp> model = new TextureVariantModel<>("skrimp");
                ArrayList<ResourceLocation> textures = new ArrayList<>();
                for (int i = 1; i <= 15; i++) {
                    textures.add(loc("textures/entity/skrimp/skrimp_" + i + ".png"));
                }
                model.setTextures(Skrimp::getVariant, textures);
                return model;
            }, false);
            return render;
        });

        e.registerEntityRenderer(UFEntities.SHOCKCAT.get(), (ctx) -> {
            GenericGeoRenderer<Shockcat> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("shockcat"), false);
            render.addRenderLayer(new UFGlowRenderLayer<>(render, loc("textures/entity/glow/shockcat.png")));
            return render;
        });

        e.registerEntityRenderer(UFEntities.VOLT_ANGLER.get(), (ctx) -> {
            GenericGeoRenderer<VoltAngler> render = new GenericGeoRenderer<>(ctx, () -> new GenericGeoModel<>("volt_angler"), false);
            render.addRenderLayer(new UFGlowRenderLayer<>(render, loc("textures/entity/glow/volt_angler.png")));
            return render;
        });

        e.registerEntityRenderer(UFEntities.ABYSSAL_BLAST.get(), AbyssalBlastRenderer::new);
        e.registerEntityRenderer(UFEntities.PRISMARINE_SPEAR.get(), ThrownPrismarineSpearRenderer::new);
        e.registerEntityRenderer(UFEntities.SEA_SPIKE.get(), SeaSpikeRenderer::new);
        e.registerEntityRenderer(UFEntities.FALLING_TREE.get(), FallingTreeBlockRenderer::new);
        e.registerEntityRenderer(UFEntities.ROOTBALL.get(), RootballRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(UFModelLayers.PRISMARINE_SPEAR, PrismarineSpearModel::createBodyLayer);
        e.registerLayerDefinition(UFModelLayers.ROOTBALL, RootballModel::createBodyLayer);
    }

}

