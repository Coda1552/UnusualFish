package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.MuddytopSnailModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.MuddytopSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MuddytopSnailRenderer extends MobRenderer<MuddytopSnail, MuddytopSnailModel<MuddytopSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/muddytopsnail.png");

	public MuddytopSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MuddytopSnailModel<>(renderManagerIn.bakeLayer(MuddytopSnailModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(MuddytopSnail entity) {
		return TEXTURE;
	}

}
