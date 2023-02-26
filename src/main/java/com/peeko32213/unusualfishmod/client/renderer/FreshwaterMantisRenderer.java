package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.FreshwaterMantisModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.FreshwaterMantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FreshwaterMantisRenderer extends MobRenderer<FreshwaterMantis, FreshwaterMantisModel<FreshwaterMantis>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/freshwatermantis.png");

	public FreshwaterMantisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FreshwaterMantisModel<>(renderManagerIn.bakeLayer(FreshwaterMantisModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(FreshwaterMantis entity) {
		return TEXTURE;
	}

}
