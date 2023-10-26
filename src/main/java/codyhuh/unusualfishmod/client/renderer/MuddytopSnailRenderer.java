package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.MuddytopSnailModel;
import codyhuh.unusualfishmod.common.entity.ambient.small.MuddytopSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;

public class MuddytopSnailRenderer extends MobRenderer<MuddytopSnail, MuddytopSnailModel<MuddytopSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/muddytopsnail.png");

	public MuddytopSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new MuddytopSnailModel<>(renderManagerIn.bakeLayer(UFModelLayers.MUDDYTOP_SNAIL)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(MuddytopSnail entity) {
		return TEXTURE;
	}
}
