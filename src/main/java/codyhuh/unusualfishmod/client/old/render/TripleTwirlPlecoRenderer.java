package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.TripleTwirlPlecoModel;
import codyhuh.unusualfishmod.common.entity.TripleTwirlPleco;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TripleTwirlPlecoRenderer extends MobRenderer<TripleTwirlPleco, TripleTwirlPlecoModel<TripleTwirlPleco>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/triple_twirl_pleco/twirl_pleco0.png");

	public TripleTwirlPlecoRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new TripleTwirlPlecoModel<>(renderManagerIn.bakeLayer(UFModelLayers.TRIPLE_TWIRL_PLECO)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(TripleTwirlPleco entity) {
		return TEXTURE;
	}
}
