package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.FreshwaterMantisModel;
import codyhuh.unusualfishmod.common.entity.ulitity.FreshwaterMantis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;

public class FreshwaterMantisRenderer extends MobRenderer<FreshwaterMantis, FreshwaterMantisModel<FreshwaterMantis>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/freshwatermantis.png");

	public FreshwaterMantisRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FreshwaterMantisModel<>(renderManagerIn.bakeLayer(UFModelLayers.FRESHWATER_MANTIS)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(FreshwaterMantis entity) {
		return TEXTURE;
	}
}
