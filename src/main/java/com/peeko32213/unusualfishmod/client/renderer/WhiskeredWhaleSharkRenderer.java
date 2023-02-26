package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.WhiskeredWhaleSharkModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.WhiskeredWhaleShark;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WhiskeredWhaleSharkRenderer extends MobRenderer<WhiskeredWhaleShark, WhiskeredWhaleSharkModel<WhiskeredWhaleShark>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/whiskeredwhaleshark.png");

	public WhiskeredWhaleSharkRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new WhiskeredWhaleSharkModel<>(renderManagerIn.bakeLayer(WhiskeredWhaleSharkModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(WhiskeredWhaleShark entity) {
		return TEXTURE;
	}

}
