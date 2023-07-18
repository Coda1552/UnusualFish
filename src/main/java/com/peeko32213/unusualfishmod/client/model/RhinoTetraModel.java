package com.peeko32213.unusualfishmod.client.model;

import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.RhinoTetra;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RhinoTetraModel<Type extends RhinoTetra> extends ListModel<Type> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "rhino_tetra"), "main");
	private final ModelPart Fin1;
	private final ModelPart Tail;
	private final ModelPart Fin2;
	private final ModelPart Body;

	public RhinoTetraModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.Tail = this.Body.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -3.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 7).addBox(0.0F, -4.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -1.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 5).addBox(0.025F, -1.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, -1.0F, -0.2182F, 0.5236F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-0.025F, -1.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.0F, -1.0F, -0.2182F, -0.5236F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.5F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.Body);
	}

}