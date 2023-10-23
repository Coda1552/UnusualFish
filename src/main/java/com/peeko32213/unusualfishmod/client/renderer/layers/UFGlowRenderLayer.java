package com.peeko32213.unusualfishmod.client.renderer.layers;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class UFGlowRenderLayer<T extends LivingEntity, M extends EntityModel<T>> extends EyesLayer<T, M> {
    private final ResourceLocation glowLayer;

    public UFGlowRenderLayer(RenderLayerParent<T, M> layer, ResourceLocation glowOverlayResourceLocation) {
        super(layer);
        this.glowLayer = glowOverlayResourceLocation;
    }

    public RenderType renderType() {
        return RenderType.eyes(glowLayer);
    }
}