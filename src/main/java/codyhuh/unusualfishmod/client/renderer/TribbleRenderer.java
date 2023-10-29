package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.TribbleModel;
import codyhuh.unusualfishmod.common.entity.Tribble;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TribbleRenderer extends MobRenderer<Tribble, TribbleModel<Tribble>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/tribble.png");

	public TribbleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TribbleModel<>(renderManagerIn.bakeLayer(UFModelLayers.TRIBBLE)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Tribble entity) {
		return TEXTURE;
	}

}
