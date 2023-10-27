package codyhuh.unusualfishmod.client.renderer.layers;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.ambient.small.DemonHerring;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DemonHerringGlowRenderLayer<T extends DemonHerring, M extends EntityModel<T>> extends RenderLayer<T, M> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/demon_herring_0.png"));
        hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/demon_herring_1.png"));
        hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/demon_herring_2.png"));
    });

    public DemonHerringGlowRenderLayer(RenderLayerParent<T, M> layer) {
        super(layer);
    }

    public RenderType renderType(T entity) {
        return RenderType.eyes(TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0)));
    }

    public void render(PoseStack p_116983_, @NotNull MultiBufferSource p_116984_, int p_116985_, T p_116986_, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
        VertexConsumer vertexconsumer = p_116984_.getBuffer(this.renderType(p_116986_));
        this.getParentModel().renderToBuffer(p_116983_, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}