package com.peeko32213.unusualfishmod.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.peeko32213.unusualfishmod.client.model.AeroMonoModel;
import com.peeko32213.unusualfishmod.client.model.CrimsonshellSquidModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.AeroMono;
import com.peeko32213.unusualfishmod.common.entity.ulitity.CelestialFish;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CrimsonshellSquidRenderer extends MobRenderer<CrimsonshellSquid, CrimsonshellSquidModel<CrimsonshellSquid>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("unusualfishmod:textures/entity/crimsonshellsquid2.png");

    public CrimsonshellSquidRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CrimsonshellSquidModel<>(renderManagerIn.bakeLayer(CrimsonshellSquidModel.LAYER_LOCATION)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonshellSquid entity) {
        return TEXTURE;
    }


}
