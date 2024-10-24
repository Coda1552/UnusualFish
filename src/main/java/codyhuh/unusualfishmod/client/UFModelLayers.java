package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class UFModelLayers {
    public static final ModelLayerLocation ROOTBALL = create("rootball");
    public static final ModelLayerLocation PRISMARINE_SPEAR = create("prismarine_spear");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(UnusualFishMod.MOD_ID, name), "main");
    }

}
