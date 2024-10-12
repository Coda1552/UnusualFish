package codyhuh.unusualfishmod.client.render;


import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.SeaMosquitoModel;
import codyhuh.unusualfishmod.common.entity.SeaMosquito;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SeaMosquitoRenderer extends MobRenderer<SeaMosquito, SeaMosquitoModel<SeaMosquito>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/seamosquito.png");

	public SeaMosquitoRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SeaMosquitoModel<>(renderManagerIn.bakeLayer(UFModelLayers.SEA_MOSQUITO)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(SeaMosquito entity) {
		return TEXTURE;
	}

}
