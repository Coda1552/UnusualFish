package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.RoughbackGuitarfishModel;
import codyhuh.unusualfishmod.common.entity.RoughbackGuitarfish;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoughbackGuitarfishRenderer extends MobRenderer<RoughbackGuitarfish, RoughbackGuitarfishModel<RoughbackGuitarfish>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/roughback.png");

	public RoughbackGuitarfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RoughbackGuitarfishModel<>(renderManagerIn.bakeLayer(UFModelLayers.ROUGHBACK_GUITARFISH)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(RoughbackGuitarfish entity) {
		return TEXTURE;
	}

}
