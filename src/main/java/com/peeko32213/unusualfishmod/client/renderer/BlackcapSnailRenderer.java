package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.BlackcapSnailModel;
import com.peeko32213.unusualfishmod.common.entity.ulitity.BlackCapSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlackcapSnailRenderer extends MobRenderer<BlackCapSnail, BlackcapSnailModel<BlackCapSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/blackcapsnail.png");

	public BlackcapSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BlackcapSnailModel<>(renderManagerIn.bakeLayer(BlackcapSnailModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackCapSnail entity) {
		return TEXTURE;
	}

}
