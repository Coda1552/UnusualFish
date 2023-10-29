package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.SeaSpiderModel;
import codyhuh.unusualfishmod.common.entity.SeaSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaSpiderRenderer extends MobRenderer<SeaSpider, SeaSpiderModel<SeaSpider>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/crownedspider.png");

	public SeaSpiderRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaSpiderModel<>(renderManagerIn.bakeLayer(UFModelLayers.SEA_SPIDER)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaSpider entity) {
		return TEXTURE;
	}
}
