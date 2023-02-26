package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.PorcupineLobsterModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.PorcupineLobster;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PorcupineLobsterRenderer extends MobRenderer<PorcupineLobster, PorcupineLobsterModel<PorcupineLobster>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/porcupinelobster.png");

	public PorcupineLobsterRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PorcupineLobsterModel<>(renderManagerIn.bakeLayer(PorcupineLobsterModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PorcupineLobster entity) {
		return TEXTURE;
	}

}
