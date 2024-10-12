package codyhuh.unusualfishmod.client.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.RootballModel;
import codyhuh.unusualfishmod.common.entity.Rootball;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RootballRenderer extends MobRenderer<Rootball, RootballModel<Rootball>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rootball.png");

	public RootballRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RootballModel<>(renderManagerIn.bakeLayer(UFModelLayers.ROOTBALL)), 0.2F);
	}

	protected void scale(Rootball p_114046_, PoseStack p_114047_, float p_114048_) {
		float f = p_114046_.getSwelling(p_114048_);
		float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
		f = Mth.clamp(f, 0.0F, 1.0F);
		f *= f;
		f *= f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		p_114047_.scale(f2, f3, f2);
	}

	protected float getWhiteOverlayProgress(Rootball p_114043_, float p_114044_) {
		float f = p_114043_.getSwelling(p_114044_);
		return (int)(f * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(Rootball entity) {
		return TEXTURE;
	}

}
