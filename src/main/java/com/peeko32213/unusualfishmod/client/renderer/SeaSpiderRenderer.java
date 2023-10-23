package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.SeaSpiderModel;

import com.peeko32213.unusualfishmod.common.entity.ambient.small.SeaSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaSpiderRenderer extends MobRenderer<SeaSpider, SeaSpiderModel<SeaSpider>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/crownedspider.png");

	public SeaSpiderRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaSpiderModel<>(renderManagerIn.bakeLayer(SeaSpiderModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaSpider entity) {
		return TEXTURE;
	}
}
