package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.RhinoTetraModel;
import codyhuh.unusualfishmod.common.entity.RhinoTetra;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import java.util.Map;

public class RhinoTetraRenderer extends MobRenderer<RhinoTetra, RhinoTetraModel<RhinoTetra>> {
	public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
		hashMap.put(0, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_1.png"));
		hashMap.put(1, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_2.png"));
		hashMap.put(2, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_3.png"));
		hashMap.put(3, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_4.png"));
		hashMap.put(4, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_5.png"));
		hashMap.put(5, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_6.png"));
		hashMap.put(6, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_7.png"));
		hashMap.put(7, new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/rhino_tetra/rhinotetra_8.png"));
	});

	public RhinoTetraRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new RhinoTetraModel<>(renderManagerIn.bakeLayer(UFModelLayers.RHINO_TETRA)), 0.2F);
	}

	@Override
	public ResourceLocation getTextureLocation(RhinoTetra entity) {
		return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
	}

	protected void setupRotations(RhinoTetra p_116226_, PoseStack p_116227_, float p_116228_, float p_116229_, float p_116230_) {
		super.setupRotations(p_116226_, p_116227_, p_116228_, p_116229_, p_116230_);
		float f = 4.3F * Mth.sin(0.6F * p_116228_);
		p_116227_.mulPose(Axis.YP.rotationDegrees(f));
		if (!p_116226_.isInWater()) {
			p_116227_.translate(0.2D, 0.1D, 0.0D);
			p_116227_.mulPose(Axis.ZP.rotationDegrees(90.0F));
		}
	}

}
