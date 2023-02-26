package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.BaskingTiamatModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.BaskingTiamat;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BaskingTiamatRenderer extends MobRenderer<BaskingTiamat, BaskingTiamatModel<BaskingTiamat>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/baskingtiamat.png");

    public BaskingTiamatRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new BaskingTiamatModel<>(renderManagerIn.bakeLayer(BaskingTiamatModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(BaskingTiamat entity) {
        return TEXTURE;
    }

}
