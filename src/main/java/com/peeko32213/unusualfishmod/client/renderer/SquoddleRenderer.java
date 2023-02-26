package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.SquoddleModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.Squoddle;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SquoddleRenderer extends MobRenderer<Squoddle, SquoddleModel<Squoddle>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/squoddle.png");

	public SquoddleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SquoddleModel<>(renderManagerIn.bakeLayer(SquoddleModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Squoddle entity) {
		return TEXTURE;
	}

}
