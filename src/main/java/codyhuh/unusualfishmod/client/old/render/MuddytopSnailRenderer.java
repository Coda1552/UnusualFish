package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.MuddytopSnailModel;
import codyhuh.unusualfishmod.common.entity.MuddytopSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
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
