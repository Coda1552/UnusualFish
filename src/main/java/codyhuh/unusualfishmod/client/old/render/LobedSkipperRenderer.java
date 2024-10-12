package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.LobedSkipperModel;
import codyhuh.unusualfishmod.common.entity.LobedSkipper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LobedSkipperRenderer extends MobRenderer<LobedSkipper, LobedSkipperModel<LobedSkipper>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/lobedskipper.png");

	public LobedSkipperRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new LobedSkipperModel<>(renderManagerIn.bakeLayer(UFModelLayers.LOBED_SKIPPER)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(LobedSkipper entity) {
		return TEXTURE;
	}
}
