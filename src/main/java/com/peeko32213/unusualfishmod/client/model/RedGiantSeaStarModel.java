package com.peeko32213.unusualfishmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;

import com.peeko32213.unusualfishmod.common.entity.ambient.massive.RedGiantSeaStar;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class RedGiantSeaStarModel<Type extends RedGiantSeaStar> extends EntityModel<Type> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "redgiant_seastar"), "main");
	private final ModelPart MedArmFront1;
	private final ModelPart SmallArmFront1;
	private final ModelPart BigArmFront;
	private final ModelPart MedArmFront2;
	private final ModelPart SmallArmFront2;
	private final ModelPart SmallArmSide1;
	private final ModelPart MedArmSide1;
	private final ModelPart BigArmSide1;
	private final ModelPart MedArmSide2;
	private final ModelPart SmallArmSide2;
	private final ModelPart SmallArmBack1;
	private final ModelPart MedArmBack1;
	private final ModelPart BigArmBack;
	private final ModelPart MedArmBack2;
	private final ModelPart SmallArmBack2;
	private final ModelPart SmallArmSide3;
	private final ModelPart MedArmSide3;
	private final ModelPart BigArmSide2;
	private final ModelPart MedArmSide4;
	private final ModelPart SmallArmSide4;
	private final ModelPart bb_main;

	public RedGiantSeaStarModel(ModelPart root) {
		this.MedArmFront1 = root.getChild("MedArmFront1");
		this.SmallArmFront1 = root.getChild("SmallArmFront1");
		this.BigArmFront = root.getChild("BigArmFront");
		this.MedArmFront2 = root.getChild("MedArmFront2");
		this.SmallArmFront2 = root.getChild("SmallArmFront2");
		this.SmallArmSide1 = root.getChild("SmallArmSide1");
		this.MedArmSide1 = root.getChild("MedArmSide1");
		this.BigArmSide1 = root.getChild("BigArmSide1");
		this.MedArmSide2 = root.getChild("MedArmSide2");
		this.SmallArmSide2 = root.getChild("SmallArmSide2");
		this.SmallArmBack1 = root.getChild("SmallArmBack1");
		this.MedArmBack1 = root.getChild("MedArmBack1");
		this.BigArmBack = root.getChild("BigArmBack");
		this.MedArmBack2 = root.getChild("MedArmBack2");
		this.SmallArmBack2 = root.getChild("SmallArmBack2");
		this.SmallArmSide3 = root.getChild("SmallArmSide3");
		this.MedArmSide3 = root.getChild("MedArmSide3");
		this.BigArmSide2 = root.getChild("BigArmSide2");
		this.MedArmSide4 = root.getChild("MedArmSide4");
		this.SmallArmSide4 = root.getChild("SmallArmSide4");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MedArmFront1 = partdefinition.addOrReplaceChild("MedArmFront1",
				CubeListBuilder.create().texOffs(50, 35).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 22.0F, -9.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition SmallArmFront1 = partdefinition.addOrReplaceChild("SmallArmFront1",
				CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 2.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.5F, 22.0F, -9.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition BigArmFront = partdefinition.addOrReplaceChild("BigArmFront", CubeListBuilder.create()
				.texOffs(25, 30).addBox(-3.0F, 0.0F, -15.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 19.0F, -9.0F));

		PartDefinition MedArmFront2 = partdefinition.addOrReplaceChild("MedArmFront2",
				CubeListBuilder.create().texOffs(50, 35).mirror()
						.addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5F, 22.0F, -9.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition SmallArmFront2 = partdefinition.addOrReplaceChild("SmallArmFront2",
				CubeListBuilder.create().texOffs(0, 8).mirror()
						.addBox(-1.0F, 0.0F, -6.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-7.5F, 22.0F, -9.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition SmallArmSide1 = partdefinition.addOrReplaceChild("SmallArmSide1",
				CubeListBuilder.create().texOffs(51, 50).addBox(0.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 22.0F, -7.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition MedArmSide1 = partdefinition.addOrReplaceChild("MedArmSide1",
				CubeListBuilder.create().texOffs(0, 45).addBox(0.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 22.0F, -4.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition BigArmSide1 = partdefinition.addOrReplaceChild("BigArmSide1", CubeListBuilder.create()
				.texOffs(0, 50).addBox(0.0F, 0.0F, -2.5F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(9.5F, 19.0F, 0.5F));

		PartDefinition MedArmSide2 = partdefinition.addOrReplaceChild("MedArmSide2",
				CubeListBuilder.create().texOffs(25, 25).addBox(0.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 22.0F, 5.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition SmallArmSide2 = partdefinition.addOrReplaceChild("SmallArmSide2",
				CubeListBuilder.create().texOffs(35, 50).addBox(0.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.5F, 22.0F, 8.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition SmallArmBack1 = partdefinition.addOrReplaceChild("SmallArmBack1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.5F, 22.0F, 10.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition MedArmBack1 = partdefinition.addOrReplaceChild("MedArmBack1",
				CubeListBuilder.create().texOffs(50, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.5F, 22.0F, 10.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition BigArmBack = partdefinition.addOrReplaceChild("BigArmBack", CubeListBuilder.create()
				.texOffs(0, 25).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 19.0F, 10.0F));

		PartDefinition MedArmBack2 = partdefinition.addOrReplaceChild("MedArmBack2",
				CubeListBuilder.create().texOffs(50, 25).mirror()
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.5F, 22.0F, 10.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition SmallArmBack2 = partdefinition.addOrReplaceChild("SmallArmBack2",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-7.5F, 22.0F, 10.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition SmallArmSide3 = partdefinition.addOrReplaceChild("SmallArmSide3",
				CubeListBuilder.create().texOffs(51, 50).mirror()
						.addBox(-6.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-9.5F, 22.0F, -7.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition MedArmSide3 = partdefinition.addOrReplaceChild("MedArmSide3",
				CubeListBuilder.create().texOffs(0, 45).mirror()
						.addBox(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-9.5F, 22.0F, -4.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition BigArmSide2 = partdefinition.addOrReplaceChild("BigArmSide2",
				CubeListBuilder.create().texOffs(0, 50).mirror()
						.addBox(-15.0F, 0.0F, -2.5F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-9.5F, 19.0F, 0.5F));

		PartDefinition MedArmSide4 = partdefinition.addOrReplaceChild("MedArmSide4",
				CubeListBuilder.create().texOffs(25, 25).mirror()
						.addBox(-8.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-9.5F, 22.0F, 5.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition SmallArmSide4 = partdefinition.addOrReplaceChild("SmallArmSide4",
				CubeListBuilder.create().texOffs(35, 50).mirror()
						.addBox(-6.0F, 0.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-9.5F, 22.0F, 8.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-9.5F, -6.0F, -9.0F, 19.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}
		
		//Front
		//this.MedArmFront1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.SmallArmFront1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.BigArmFront.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmFront2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.SmallArmFront2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		
		//Left Side
		//this.SmallArmSide1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmSide1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.BigArmSide1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmSide2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.SmallArmSide2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		
		//Back
		//this.SmallArmBack1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmBack1.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.BigArmBack.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmBack2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.SmallArmBack2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		
		//Right Side
		//this.SmallArmSide3.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmSide3.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.BigArmSide2.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.MedArmSide4.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		//this.SmallArmSide4.zRot = -f * 0.2F * Mth.sin(0.1F * ageInTicks);
		
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		MedArmFront1.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmFront1.render(poseStack, buffer, packedLight, packedOverlay);
		BigArmFront.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmFront2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmFront2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmSide1.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmSide1.render(poseStack, buffer, packedLight, packedOverlay);
		BigArmSide1.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmSide2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmSide2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmBack1.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmBack1.render(poseStack, buffer, packedLight, packedOverlay);
		BigArmBack.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmBack2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmBack2.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmSide3.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmSide3.render(poseStack, buffer, packedLight, packedOverlay);
		BigArmSide2.render(poseStack, buffer, packedLight, packedOverlay);
		MedArmSide4.render(poseStack, buffer, packedLight, packedOverlay);
		SmallArmSide4.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}