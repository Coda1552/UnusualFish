package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.HatchetFishModel;
import codyhuh.unusualfishmod.client.renderer.layers.UFGlowRenderLayer;
import codyhuh.unusualfishmod.common.entity.HatchetFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class HatchetfishRenderer extends MobRenderer<HatchetFish, HatchetFishModel<HatchetFish>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/hatchetfish.png");

    public HatchetfishRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new HatchetFishModel<>(renderManagerIn.bakeLayer(UFModelLayers.HATCHET_FISH)), 0.2F);
        addLayer(new UFGlowRenderLayer<>(this, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/glow/hatchetfish.png")));
    }

    @Override
    public ResourceLocation getTextureLocation(HatchetFish entity) {
        return TEXTURE;
    }

    protected void setupRotations(HatchetFish p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
        float f = 4.3F * Mth.sin(0.6F * p_116228_);
        p_116227_.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2D, 0.1D, 0.0D);
            p_116227_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

}
