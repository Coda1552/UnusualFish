package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.TigerJungleSharkModel;
import codyhuh.unusualfishmod.common.entity.TigerJungleShark;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TigerJungleSharkRenderer extends MobRenderer<TigerJungleShark, TigerJungleSharkModel<TigerJungleShark>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/tigerjungleshark.png");

    public TigerJungleSharkRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new TigerJungleSharkModel<>(renderManagerIn.bakeLayer(UFModelLayers.TIGER_JUNGLE_SHARK)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(TigerJungleShark entity) {
        return TEXTURE;
    }

    protected void setupRotations(TigerJungleShark p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
        super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
        float f = 4.3F * Mth.sin(0.6F * p_116228_);
        p_116227_.mulPose(Axis.YP.rotationDegrees(f));
        if (!p_116226_.isInWater()) {
            p_116227_.translate(0.2F, 0.1F, 0.0D);
            p_116227_.mulPose(Axis.ZP.rotationDegrees(90.0F));
        }
    }

}
