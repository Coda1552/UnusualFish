package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.KalappaModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.Kalappa;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KalappaRenderer extends MobRenderer<Kalappa, KalappaModel<Kalappa>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/kalappa.png");

	public KalappaRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new KalappaModel<>(renderManagerIn.bakeLayer(KalappaModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Kalappa entity) {
		return TEXTURE;
	}

}
