package com.peeko32213.unusualfishmod.client.renderer;

import com.peeko32213.unusualfishmod.client.model.ManaJellyfishModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.ManaJellyfish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class ManaJellyfishRenderer extends MobRenderer<ManaJellyfish, ManaJellyfishModel<ManaJellyfish>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/wizardjellyfish.png");

	public ManaJellyfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ManaJellyfishModel<>(renderManagerIn.bakeLayer(ManaJellyfishModel.LAYER_LOCATION)), 0.2F);
	}

	protected float getFlipDegrees(ManaJellyfish jelly) {
		return 0.0F;
	}


	@Override
	public ResourceLocation getTextureLocation(ManaJellyfish entity) {
		return TEXTURE;
	}

	@Nullable
	protected RenderType getRenderType(ManaJellyfish entity, boolean normal, boolean invis, boolean outline) {
		ResourceLocation resourcelocation = this.getTextureLocation(entity);
		return RenderType.entityTranslucent(resourcelocation);
	}

	protected int getBlockLightLevel(ManaJellyfish entity, BlockPos partialTicks) {
		return 15;
	}


}
