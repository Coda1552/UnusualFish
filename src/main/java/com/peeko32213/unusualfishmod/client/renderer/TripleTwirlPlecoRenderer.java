package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.TripleTwirlPlecoModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.TripleTwirlPleco;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TripleTwirlPlecoRenderer extends MobRenderer<TripleTwirlPleco, TripleTwirlPlecoModel<TripleTwirlPleco>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/tripletwirlpleco.png");

	public TripleTwirlPlecoRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TripleTwirlPlecoModel<>(renderManagerIn.bakeLayer(TripleTwirlPlecoModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(TripleTwirlPleco entity) {
		return TEXTURE;
	}

}
