package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.TribbleModel;
import com.peeko32213.unusualfishmod.client.model.TrobModel;
import com.peeko32213.unusualfishmod.common.entity.hostile.Tribble;
import com.peeko32213.unusualfishmod.common.entity.hostile.Trob;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TrobRenderer extends MobRenderer<Trob, TrobModel<Trob>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/trob.png");

	public TrobRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TrobModel<>(renderManagerIn.bakeLayer(TrobModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Trob entity) {
		return TEXTURE;
	}

}
