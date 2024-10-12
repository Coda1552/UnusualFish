package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.SquoddleModel;
import codyhuh.unusualfishmod.common.entity.Squoddle;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SquoddleRenderer extends MobRenderer<Squoddle, SquoddleModel<Squoddle>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/squoddle.png");

	public SquoddleRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new SquoddleModel<>(renderManagerIn.bakeLayer(UFModelLayers.SQUODDLE)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Squoddle entity) {
		return TEXTURE;
	}
}
