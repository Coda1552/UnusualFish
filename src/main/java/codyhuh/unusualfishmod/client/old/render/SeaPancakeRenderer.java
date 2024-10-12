package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.SeaPancakeModel;
import codyhuh.unusualfishmod.common.entity.SeaPancake;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaPancakeRenderer extends MobRenderer<SeaPancake, SeaPancakeModel<SeaPancake>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/seapancake.png");

	public SeaPancakeRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaPancakeModel<>(renderManagerIn.bakeLayer(UFModelLayers.SEA_PANCAKE)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaPancake entity) {
		return TEXTURE;
	}
}
