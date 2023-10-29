package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.BrickSnailModel;
import codyhuh.unusualfishmod.common.entity.BrickSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BrickSnailRenderer extends MobRenderer<BrickSnail, BrickSnailModel<BrickSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/bricksnail.png");

	public BrickSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BrickSnailModel<>(renderManagerIn.bakeLayer(UFModelLayers.BRICK_SNAIL)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(BrickSnail entity) {
		return TEXTURE;
	}
}
