package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.TrumpetSquidModel;
import codyhuh.unusualfishmod.common.entity.TrumpetSquid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TrumpetSquidRenderer extends MobRenderer<TrumpetSquid, TrumpetSquidModel<TrumpetSquid>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/trumpetsquid.png");

	public TrumpetSquidRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TrumpetSquidModel<>(renderManagerIn.bakeLayer(UFModelLayers.TRUMPET_SQUID)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(TrumpetSquid entity) {
		return TEXTURE;
	}
}
