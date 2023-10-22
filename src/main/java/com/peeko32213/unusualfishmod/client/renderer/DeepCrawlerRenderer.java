package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.DeepCrawlerModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.DeepCrawler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeepCrawlerRenderer extends MobRenderer<DeepCrawler, DeepCrawlerModel<DeepCrawler>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/deepcrawler.png");

	public DeepCrawlerRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DeepCrawlerModel<>(renderManagerIn.bakeLayer(DeepCrawlerModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(DeepCrawler entity) {
		return TEXTURE;
	}

}
