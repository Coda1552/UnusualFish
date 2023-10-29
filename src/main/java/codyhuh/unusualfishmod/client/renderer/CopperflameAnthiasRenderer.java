package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.CopperflameAnthiasModel;
import codyhuh.unusualfishmod.common.entity.CopperflameAnthias;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class CopperflameAnthiasRenderer extends MobRenderer<CopperflameAnthias, CopperflameAnthiasModel<CopperflameAnthias>> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/copperflame_0.png"));
        hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/copperflame_1.png"));
    });

    public CopperflameAnthiasRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CopperflameAnthiasModel<>(renderManagerIn.bakeLayer(UFModelLayers.COPPERFLAME_ANTHIAS)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(CopperflameAnthias entity) {
        return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
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

    protected int getBlockLightLevel(CopperflameAnthias entity, BlockPos partialTicks) {
        return 15;
    }
}
