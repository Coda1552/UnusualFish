package codyhuh.unusualfishmod.client.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.BarkAngelfishModel;
import codyhuh.unusualfishmod.common.entity.BarkAngelfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BarkAngelfishRenderer extends MobRenderer<BarkAngelfish, BarkAngelfishModel<BarkAngelfish>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/barkangelfish.png");

    public BarkAngelfishRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new BarkAngelfishModel<>(renderManagerIn.bakeLayer(UFModelLayers.BARK_ANGELFISH)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(BarkAngelfish entity) {
        return TEXTURE;
    }

    protected void setupRotations(BarkAngelfish p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);

        float f = 6.5F * Mth.sin(0.6F * p_116228_);

        p_116227_.mulPose(Axis.YP.rotationDegrees(f));

        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2D, 0.1D, 0.0D);
            p_116227_.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

}
