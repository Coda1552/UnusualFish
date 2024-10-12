package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.DemonHerringModel;
import codyhuh.unusualfishmod.client.old.render.layers.DemonHerringGlowRenderLayer;
import codyhuh.unusualfishmod.common.entity.DemonHerring;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class DemonHerringRenderer extends MobRenderer<DemonHerring, DemonHerringModel<DemonHerring>> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/demon_herring_0.png"));
        hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/demon_herring_1.png"));
        hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/demon_herring_2.png"));
    });

    public DemonHerringRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new DemonHerringModel<>(renderManagerIn.bakeLayer(UFModelLayers.DEMON_HERRING)), 0.2F);
        addLayer(new DemonHerringGlowRenderLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(DemonHerring entity) {
        return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
    }

    protected void setupRotations(DemonHerring p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
        float f = 4.3F * Mth.sin(0.6F * p_116228_);
        p_116227_.mulPose(Axis.YP.rotationDegrees(f));
        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2D, 0.1D, 0.0D);
            p_116227_.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

}
