package com.peeko32213.unusualfishmod.client.renderer;


import com.google.common.collect.Maps;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.client.model.CoralSkrimpModel;
import com.peeko32213.unusualfishmod.client.model.EyelashFishModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.CoralSkrimp;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.EyelashFish;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class EyelashFishRenderer extends MobRenderer<EyelashFish, EyelashFishModel<EyelashFish>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_1.png"));
		hashMap.put(1, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_2.png"));
		hashMap.put(2, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_3.png"));
		hashMap.put(3, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_4.png"));
		hashMap.put(4, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_5.png"));
		hashMap.put(5, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_6.png"));
		hashMap.put(6, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_7.png"));
		hashMap.put(7, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_8.png"));
		hashMap.put(8, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_9.png"));
		hashMap.put(9, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_10.png"));
		hashMap.put(10, new ResourceLocation(UnusualFishMod.MODID, "textures/entity/eyelashfish/eyelash_fish_11.png"));
	});

	public EyelashFishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new EyelashFishModel<>(renderManagerIn.bakeLayer(EyelashFishModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(EyelashFish entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}


}
