package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.BlackcapSnailModel;
import codyhuh.unusualfishmod.common.entity.BlackCapSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlackcapSnailRenderer extends MobRenderer<BlackCapSnail, BlackcapSnailModel<BlackCapSnail>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/blackcapsnail.png");

	public BlackcapSnailRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new BlackcapSnailModel<>(renderManagerIn.bakeLayer(UFModelLayers.BLACKCAP_SNAIL)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(BlackCapSnail entity) {
		return TEXTURE;
	}

}
