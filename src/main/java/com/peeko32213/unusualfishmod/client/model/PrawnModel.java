package com.peeko32213.unusualfishmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.hostile.Prawn;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PrawnModel<T extends Prawn> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(UnusualFishMod.MOD_ID, "prawn"), "main");
	private final ModelPart Feeler1;
	private final ModelPart Feeler2;
	private final ModelPart Tail;
	private final ModelPart Arm1;
	private final ModelPart Arm2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart bb_main;

	public PrawnModel(ModelPart root) {
		this.Feeler1 = root.getChild("Feeler1");
		this.Feeler2 = root.getChild("Feeler2");
		this.Tail = root.getChild("Tail");
		this.Arm1 = root.getChild("Arm1");
		this.Arm2 = root.getChild("Arm2");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Leg5 = root.getChild("Leg5");
		this.Leg6 = root.getChild("Leg6");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Feeler1 = partdefinition.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -14.0F, 14.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 9.0F, -5.0F, 0.2054F, -0.0741F, -1.2294F));

		PartDefinition Feeler2 = partdefinition.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-13.0F, 0.0F, -14.0F, 14.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 9.0F, -5.0F, 0.2054F, 0.0741F, 1.2294F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(57, 48).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition TailFins = Tail.addOrReplaceChild("TailFins", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 10.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition TailFin1 = TailFins.addOrReplaceChild("TailFin1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, 0.0F, -0.8027F, 0.1841F, -0.1872F));

		PartDefinition TailFin2 = TailFins.addOrReplaceChild("TailFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, 0.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.025F, 0.0F, -0.8027F, -0.1841F, 0.1872F));

		PartDefinition Arm1 = partdefinition.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -25.0F, -34.0F, 0.0F, 25.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 11.0F, -3.0F, -0.1309F, 0.0F, -0.9599F));

		PartDefinition Arm2 = partdefinition.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(3.0F, -25.0F, -34.0F, 0.0F, 25.0F, 34.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 11.0F, -3.0F, -0.1309F, 0.0F, 0.9599F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 19).addBox(-14.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 15.0F, -3.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 19).addBox(-14.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 15.0F, -1.5F, 0.0F, 0.1437F, 0.0F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 19).addBox(-14.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 15.0F, 0.0F, 0.0F, 0.6438F, 0.0F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 15.0F, -3.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Leg5 = partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 15.0F, -1.5F, 0.0F, -0.1437F, 0.0F));

		PartDefinition Leg6 = partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.0F, -3.0F, 0.0F, 16.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 15.0F, 0.0F, 0.0F, -0.6438F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(35, 7).addBox(-3.5F, -16.0F, -5.0F, 7.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-1.5F, -16.0F, -10.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(32, 22).addBox(0.0F, -19.0F, -14.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		limbSwingAmount = Mth.clamp(limbSwingAmount, -0.35F, 0.35F);
		this.Leg3.zRot = -Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;

		this.Arm1.xRot = -Mth.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
		this.Arm2.xRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.0F * limbSwingAmount;

		this.Feeler1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.Feeler2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Feeler1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Feeler2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}