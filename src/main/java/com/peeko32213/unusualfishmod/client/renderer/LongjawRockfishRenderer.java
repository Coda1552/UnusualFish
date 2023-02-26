package com.peeko32213.unusualfishmod.client.renderer;


import com.peeko32213.unusualfishmod.client.model.LongRockFishModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.LongjawRockfish;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LongjawRockfishRenderer extends MobRenderer<LongjawRockfish, LongRockFishModel<LongjawRockfish>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/longrockfish.png");

	public LongjawRockfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LongRockFishModel<>(renderManagerIn.bakeLayer(LongRockFishModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(LongjawRockfish entity) {
		return TEXTURE;
	}

}
