package codyhuh.unusualfishmod.client;

import net.minecraft.client.model.geom.ModelLayerLocation;

import static codyhuh.unusualfishmod.UnusualFishMod.loc;

public class UFModelLayers {
    public static final ModelLayerLocation ROOTBALL = create("rootball");
    public static final ModelLayerLocation PRISMARINE_SPEAR = create("prismarine_spear");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(loc(name), "main");
    }

}
