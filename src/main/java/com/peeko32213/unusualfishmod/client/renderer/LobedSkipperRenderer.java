package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.LobedSkipperModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.land.LobedSkipper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LobedSkipperRenderer extends MobRenderer<LobedSkipper, LobedSkipperModel<LobedSkipper>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/lobedskipper.png");

	public LobedSkipperRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LobedSkipperModel<>(renderManagerIn.bakeLayer(LobedSkipperModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(LobedSkipper entity) {
		return TEXTURE;
	}

}
