package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.BrickSnailModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.BrickSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BrickSnailRenderer extends MobRenderer<BrickSnail, BrickSnailModel<BrickSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/bricksnail.png");

	public BrickSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrickSnailModel<>(renderManagerIn.bakeLayer(BrickSnailModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(BrickSnail entity) {
		return TEXTURE;
	}

}
