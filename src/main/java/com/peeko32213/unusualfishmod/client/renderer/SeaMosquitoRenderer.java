package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.SeaMosquitoModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.SeaMosquito;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaMosquitoRenderer extends MobRenderer<SeaMosquito, SeaMosquitoModel<SeaMosquito>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/seamosquito.png");

	public SeaMosquitoRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaMosquitoModel<>(renderManagerIn.bakeLayer(SeaMosquitoModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaMosquito entity) {
		return TEXTURE;
	}

}
