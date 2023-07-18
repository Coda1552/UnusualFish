package com.peeko32213.unusualfishmod;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class UFModelLayers {
    public static final ModelLayerLocation PRAWN = create("prawn");
    public static final ModelLayerLocation ABYSSAL_BLAST = create("abyssal_blast");
    public static final ModelLayerLocation AERO_MONO = create("aero_mono");
    public static final ModelLayerLocation AMBER_GOBY = create("amber_goby");
    public static final ModelLayerLocation BABY_BASKING_TIAMAT = create("baby_basking_tiamat");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(UnusualFishMod.MOD_ID, name), "main");
    }


}
