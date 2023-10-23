package com.peeko32213.unusualfishmod.client.renderer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.client.model.EyelashFishModel;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.EyelashFish;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class EyelashFishRenderer extends MobRenderer<EyelashFish, EyelashFishModel<EyelashFish>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_1.png"));
		hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_2.png"));
		hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_3.png"));
		hashMap.put(3, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_4.png"));
		hashMap.put(4, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_5.png"));
		hashMap.put(5, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_6.png"));
		hashMap.put(6, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_7.png"));
		hashMap.put(7, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_8.png"));
		hashMap.put(8, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_9.png"));
		hashMap.put(9, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_10.png"));
		hashMap.put(10, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/eyelashfish/eyelash_fish_11.png"));
	});

	public EyelashFishRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new EyelashFishModel<>(renderManagerIn.bakeLayer(EyelashFishModel.LAYER_LOCATION)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(EyelashFish entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}

	@Override
	protected void setupRotations(EyelashFish p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
		super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
		float f = 6.5F * Mth.sin(0.6F * p_116228_);
		p_116227_.mulPose(Vector3f.YP.rotationDegrees(f));

		if (!p_116226_.isInWater()) {
			p_116227_.translate(0.2D, 0.1D, 0.0D);
			p_116227_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
		}
	}
}
