package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.PorcupineLobsterModel;
import codyhuh.unusualfishmod.common.entity.PorcupineLobster;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PorcupineLobsterRenderer extends MobRenderer<PorcupineLobster, PorcupineLobsterModel<PorcupineLobster>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/porcupinelobster.png");

	public PorcupineLobsterRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PorcupineLobsterModel<>(renderManagerIn.bakeLayer(UFModelLayers.PORCUPINE_LOBSTA)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(PorcupineLobster entity) {
		return TEXTURE;
	}

}
