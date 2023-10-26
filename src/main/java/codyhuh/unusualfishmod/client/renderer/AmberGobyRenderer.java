package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.AmberGobyModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import codyhuh.unusualfishmod.common.entity.ambient.small.AmberGoby;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AmberGobyRenderer extends MobRenderer<AmberGoby, AmberGobyModel<AmberGoby>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/ambergoby.png");

    public AmberGobyRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new AmberGobyModel<>(renderManagerIn.bakeLayer(UFModelLayers.AMBER_GOBY)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(AmberGoby entity) {
        return TEXTURE;
    }

    protected void setupRotations(AmberGoby p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);

        float f = 4.3F * Mth.sin(0.6F * p_116228_);

        p_116227_.mulPose(Vector3f.YP.rotationDegrees(f));

        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2D, 0.1D, 0.0D);
            p_116227_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

}
