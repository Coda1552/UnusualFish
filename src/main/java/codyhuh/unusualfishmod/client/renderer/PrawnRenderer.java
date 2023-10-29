package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.model.PrawnModel;
import codyhuh.unusualfishmod.common.entity.Prawn;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PrawnRenderer extends MobRenderer<Prawn, PrawnModel<Prawn>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/prawn.png");

	public PrawnRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new PrawnModel<>(renderManagerIn.bakeLayer(PrawnModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Prawn entity) {
		return TEXTURE;
	}

}
