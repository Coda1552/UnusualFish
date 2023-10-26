package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.CrimsonshellSquidModel;
import codyhuh.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;

public class CrimsonshellSquidRenderer extends MobRenderer<CrimsonshellSquid, CrimsonshellSquidModel<CrimsonshellSquid>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/crimsonshellsquid.png");

    public CrimsonshellSquidRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CrimsonshellSquidModel<>(renderManagerIn.bakeLayer(UFModelLayers.CRIMSONSHELL_SQUID)), 0.2F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrimsonshellSquid entity) {
        return TEXTURE;
    }
}
