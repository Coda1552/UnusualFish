package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.GrandCorydoraModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.GrandCorydora;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GrandCorydoraRenderer extends MobRenderer<GrandCorydora, GrandCorydoraModel<GrandCorydora>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/grandcorydora.png");

	public GrandCorydoraRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new GrandCorydoraModel<>(renderManagerIn.bakeLayer(GrandCorydoraModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(GrandCorydora entity) {
		return TEXTURE;
	}

}
