package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.CopperflameAnthiasModel;
import codyhuh.unusualfishmod.common.entity.ambient.small.CopperflameAnthias;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

public class CopperflameAnthiasRenderer extends MobRenderer<CopperflameAnthias, CopperflameAnthiasModel<CopperflameAnthias>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/copperflame.png");

    public CopperflameAnthiasRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CopperflameAnthiasModel<>(renderManagerIn.bakeLayer(UFModelLayers.COPPERFLAME_ANTHIAS)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(CopperflameAnthias entity) {
        return TEXTURE;
    }

    protected void setupRotations(CopperflameAnthias p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
        float f = 4.3F * Mth.sin(0.6F * p_116228_);
        p_116227_.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2D, 0.1D, 0.0D);
            p_116227_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

    @Nullable
    protected RenderType getRenderType(CopperflameAnthias entity, boolean normal, boolean invis, boolean outline) {
        ResourceLocation resourcelocation = this.getTextureLocation(entity);
        return RenderType.entityTranslucent(resourcelocation);
    }

    protected int getBlockLightLevel(CopperflameAnthias entity, BlockPos partialTicks) {
        return 15;
    }
}
