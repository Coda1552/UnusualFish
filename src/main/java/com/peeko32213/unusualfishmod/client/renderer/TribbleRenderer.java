package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.PrawnModel;
import com.peeko32213.unusualfishmod.client.model.TribbleModel;
import com.peeko32213.unusualfishmod.common.entity.hostile.Prawn;
import com.peeko32213.unusualfishmod.common.entity.hostile.Tribble;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TribbleRenderer extends MobRenderer<Tribble, TribbleModel<Tribble>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/tribble.png");

	public TribbleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TribbleModel<>(renderManagerIn.bakeLayer(TribbleModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Tribble entity) {
		return TEXTURE;
	}

}
