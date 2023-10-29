package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.ManaJellyfishModel;
import codyhuh.unusualfishmod.common.entity.ManaJellyfish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class ManaJellyfishRenderer extends MobRenderer<ManaJellyfish, ManaJellyfishModel<ManaJellyfish>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/wizardjellyfish.png");

	public ManaJellyfishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new ManaJellyfishModel<>(renderManagerIn.bakeLayer(UFModelLayers.MANA_JELLYFISH)), 0.2F);
	}

	protected float getFlipDegrees(ManaJellyfish jelly) {
		return 0.0F;
	}

	@Override
	public ResourceLocation getTextureLocation(ManaJellyfish entity) {
		return TEXTURE;
	}

	@Nullable
	protected RenderType getRenderType(ManaJellyfish entity, boolean normal, boolean invis, boolean outline) {
		ResourceLocation resourcelocation = this.getTextureLocation(entity);
		return RenderType.entityTranslucent(resourcelocation);
	}

	protected int getBlockLightLevel(ManaJellyfish entity, BlockPos partialTicks) {
		return 15;
	}
}
