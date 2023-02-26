package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.RoughbackGuitarfishModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.RoughbackGuitarfish;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoughbackGuitarfishRenderer extends MobRenderer<RoughbackGuitarfish, RoughbackGuitarfishModel<RoughbackGuitarfish>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/roughback.png");

	public RoughbackGuitarfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RoughbackGuitarfishModel<>(renderManagerIn.bakeLayer(RoughbackGuitarfishModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(RoughbackGuitarfish entity) {
		return TEXTURE;
	}

}
