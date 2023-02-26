package com.peeko32213.unusualfishmod.client.renderer;



import com.peeko32213.unusualfishmod.client.model.SeaPancakeModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.SeaPancake;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaPancakeRenderer extends MobRenderer<SeaPancake, SeaPancakeModel<SeaPancake>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/seapancake.png");

	public SeaPancakeRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaPancakeModel<>(renderManagerIn.bakeLayer(SeaPancakeModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaPancake entity) {
		return TEXTURE;
	}

}
