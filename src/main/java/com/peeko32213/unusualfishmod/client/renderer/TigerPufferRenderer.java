package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.TigerPufferModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.TigerPuffer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TigerPufferRenderer extends MobRenderer<TigerPuffer, TigerPufferModel<TigerPuffer>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/tigerpuffer.png");

	public TigerPufferRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TigerPufferModel<>(renderManagerIn.bakeLayer(TigerPufferModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(TigerPuffer entity) {
		return TEXTURE;
	}

}

