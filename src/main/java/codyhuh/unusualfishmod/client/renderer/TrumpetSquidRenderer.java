package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.TrumpetSquidModel;
import codyhuh.unusualfishmod.common.entity.ambient.predator.TrumpetSquid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import codyhuh.unusualfishmod.UnusualFishMod;
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
