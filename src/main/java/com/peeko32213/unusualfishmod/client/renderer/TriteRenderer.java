package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.TriteModel;
import com.peeko32213.unusualfishmod.client.model.TrobModel;
import com.peeko32213.unusualfishmod.common.entity.hostile.Trite;
import com.peeko32213.unusualfishmod.common.entity.hostile.Trob;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TriteRenderer extends MobRenderer<Trite, TriteModel<Trite>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/trite.png");

	public TriteRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TriteModel<>(renderManagerIn.bakeLayer(TriteModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Trite entity) {
		return TEXTURE;
	}

}
