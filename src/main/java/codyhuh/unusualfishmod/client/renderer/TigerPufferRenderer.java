package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.TigerPufferModel;
import codyhuh.unusualfishmod.common.entity.TigerPuffer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TigerPufferRenderer extends MobRenderer<TigerPuffer, TigerPufferModel<TigerPuffer>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/tigerpuffer.png");

	public TigerPufferRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TigerPufferModel<>(renderManagerIn.bakeLayer(UFModelLayers.TIGER_PUFFER)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(TigerPuffer entity) {
		return TEXTURE;
	}
}

