package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.4
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ulitity.FreshwaterMantis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FreshwaterMantisModel<T extends FreshwaterMantis> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "freshwater_mantis"), "main");
	private final ModelPart Head;
	private final ModelPart Thegmina1;
	private final ModelPart Thegmina2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Arm1;
	private final ModelPart Arm2;
	private final ModelPart bb_main;

	public FreshwaterMantisModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Thegmina1 = root.getChild("Thegmina1");
		this.Thegmina2 = root.getChild("Thegmina2");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Arm1 = root.getChild("Arm1");
		this.Arm2 = root.getChild("Arm2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -2.0F));

		PartDefinition Feeler1 = Head.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, -2.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -0.5F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Feeler2 = Head.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -4.0F, -2.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -2.0F, -0.5F, 0.0F, 0.0F, -0.6109F));

		PartDefinition MouthPart1 = Head.addOrReplaceChild("MouthPart1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition MouthPart2 = Head.addOrReplaceChild("MouthPart2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Thegmina1 = partdefinition.addOrReplaceChild("Thegmina1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.025F, 0.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.1745F, 0.1309F, 0.0F));

		PartDefinition Thegmina2 = partdefinition.addOrReplaceChild("Thegmina2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, -0.025F, 0.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 0.1745F, -0.1309F, 0.0F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 15.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 17.0F, 0.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 15.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 17.0F, 1.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-15.0F, -4.0F, 0.0F, 15.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 17.0F, 1.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-15.0F, -4.0F, 0.0F, 15.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 17.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition Arm1 = partdefinition.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -10.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 15.0F, -1.0F, -0.1745F, -0.5236F, 0.0F));

		PartDefinition Arm2 = partdefinition.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, -10.0F, 0.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 15.0F, -1.0F, -0.1745F, 0.5236F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(13, 14).addBox(-1.5F, -9.0F, 0.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(14, 24).addBox(-1.5F, -15.0F, -2.0F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Leg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.3F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.3F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.3F * limbSwingAmount;
		this.Leg3.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.3F * limbSwingAmount;

		this.Arm1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Arm2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);


	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		Thegmina1.render(poseStack, buffer, packedLight, packedOverlay);
		Thegmina2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg1.render(poseStack, buffer, packedLight, packedOverlay);
		Leg2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg3.render(poseStack, buffer, packedLight, packedOverlay);
		Leg4.render(poseStack, buffer, packedLight, packedOverlay);
		Arm1.render(poseStack, buffer, packedLight, packedOverlay);
		Arm2.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}