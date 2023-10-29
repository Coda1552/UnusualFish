package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.CoralSkrimpModel;
import codyhuh.unusualfishmod.common.entity.CoralSkrimp;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class CoralSkrimpRenderer extends MobRenderer<CoralSkrimp, CoralSkrimpModel<CoralSkrimp>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/purple_skrimp.png"));
		hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/red_skrimp.png"));
		hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/yellow_skrimp.png"));
	});

	public CoralSkrimpRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoralSkrimpModel<>(renderManagerIn.bakeLayer(UFModelLayers.CORAL_SKRIMP)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(CoralSkrimp entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}
}
