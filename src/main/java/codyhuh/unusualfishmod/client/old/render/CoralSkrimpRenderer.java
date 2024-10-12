package codyhuh.unusualfishmod.client.old.render;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.old.UFModelLayers;
import codyhuh.unusualfishmod.client.old.model.CoralSkrimpModel;
import codyhuh.unusualfishmod.common.entity.Skrimp;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class CoralSkrimpRenderer extends MobRenderer<Skrimp, CoralSkrimpModel<Skrimp>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/purple_skrimp.png"));
		hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/red_skrimp.png"));
		hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/coralskrimp/yellow_skrimp.png"));
	});

	public CoralSkrimpRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CoralSkrimpModel<>(renderManagerIn.bakeLayer(UFModelLayers.CORAL_SKRIMP)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(Skrimp entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}
}
