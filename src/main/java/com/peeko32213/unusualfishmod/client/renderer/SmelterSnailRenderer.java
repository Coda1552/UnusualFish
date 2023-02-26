package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.SmelterSnailModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.SmelterSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.resources.ResourceLocation;

public class SmelterSnailRenderer extends MobRenderer<SmelterSnail, SmelterSnailModel<SmelterSnail>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/smeltersnail_iron.png");
    private static final ResourceLocation TEXTURE_SHEARED = new ResourceLocation("unusualfishmod:textures/entity/smeltersnail.png");

    public SmelterSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SmelterSnailModel<>(renderManagerIn.bakeLayer(SmelterSnailModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(SmelterSnail entity) {
        return entity.isSheared() ? TEXTURE_SHEARED : TEXTURE;
    }

}
