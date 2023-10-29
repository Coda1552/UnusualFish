package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.DeepCrawlerModel;
import codyhuh.unusualfishmod.common.entity.DeepCrawler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeepCrawlerRenderer extends MobRenderer<DeepCrawler, DeepCrawlerModel<DeepCrawler>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/deepcrawler.png");

	public DeepCrawlerRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new DeepCrawlerModel<>(renderManagerIn.bakeLayer(UFModelLayers.DEEP_CRAWLER)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(DeepCrawler entity) {
		return TEXTURE;
	}
}
