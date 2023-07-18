package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.UFModelLayers;
import com.peeko32213.unusualfishmod.client.model.PrawnModel;
import com.peeko32213.unusualfishmod.common.entity.hostile.Prawn;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PrawnRenderer extends MobRenderer<Prawn, PrawnModel<Prawn>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/prawn.png");

	public PrawnRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PrawnModel<>(renderManagerIn.bakeLayer(UFModelLayers.PRAWN)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Prawn entity) {
		return TEXTURE;
	}

}
