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
	private final ModelPart Tail;
	private final ModelPart TailFlap;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart BigFeeler1;
	private final ModelPart BigFeeler2;
	private final ModelPart SmallFeeler1;
	private final ModelPart SmallFeeler2;
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
		this.Tail = root.getChild("Tail");
		this.TailFlap = root.getChild("TailFlap");
		this.Jaw1 = root.getChild("Jaw1");
		this.Jaw2 = root.getChild("Jaw2");
		this.BigFeeler1 = root.getChild("BigFeeler1");
		this.BigFeeler2 = root.getChild("BigFeeler2");
		this.SmallFeeler1 = root.getChild("SmallFeeler1");
		this.SmallFeeler2 = root.getChild("SmallFeeler2");
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

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -7.0F, 0.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 10).addBox(-2.0F, -7.0F, -4.0F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 21.0F, 4.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition TailFlap = partdefinition.addOrReplaceChild("TailFlap", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -2.0F, 0.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 21.5F, 8.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Jaw1 = partdefinition.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.0F, -4.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Jaw2 = partdefinition.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 18.0F, -4.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BigFeeler1 = partdefinition.addOrReplaceChild("BigFeeler1", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 16.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition BigFeeler2 = partdefinition.addOrReplaceChild("BigFeeler2", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 16.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition SmallFeeler1 = partdefinition.addOrReplaceChild("SmallFeeler1", CubeListBuilder.create().texOffs(21, 11).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.025F, 16.0F, -2.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition SmallFeeler2 = partdefinition.addOrReplaceChild("SmallFeeler2", CubeListBuilder.create().texOffs(21, 11).mirror().addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.025F, 16.0F, -2.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition Arm1 = partdefinition.addOrReplaceChild("Arm1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -13.0F, -24.0F, 0.0F, 18.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 21.0F, -3.5F, 0.0F, -0.8727F, 0.0F));

		PartDefinition Arm2 = partdefinition.addOrReplaceChild("Arm2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -13.0F, -24.0F, 0.0F, 18.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 21.0F, -3.5F, 0.0F, 0.8727F, 0.0F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 20.0F, -1.0F, -0.3161F, 0.405F, -0.6771F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 20.0F, -1.0F, 0.0175F, -0.0531F, -0.5765F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(26, 0).addBox(-1.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 20.0F, -1.0F, 0.4601F, -0.6109F, -0.7384F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-10.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 20.0F, -1.0F, -0.3161F, -0.405F, 0.6771F));

		PartDefinition Leg5 = partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-10.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 20.0F, -1.0F, 0.0175F, 0.0531F, 0.5765F));

		PartDefinition Leg6 = partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-10.0F, -1.0F, 0.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 20.0F, -1.0F, 0.4601F, 0.6109F, 0.7384F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -8.0F, -4.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.01F))
		.texOffs(42, 17).addBox(-1.0F, -8.0F, -8.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -10.0F, -10.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		this.Leg3.zRot = -Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 0.3F) * 1.2F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 1.2F * limbSwingAmount;

		this.Arm1.xRot = -Mth.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
		this.Arm2.xRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.0F * limbSwingAmount;

		this.Jaw1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Jaw2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.BigFeeler1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.BigFeeler2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.SmallFeeler1.xRot = -f * 0.30F * Mth.sin(0.15F * ageInTicks);
		this.SmallFeeler2.xRot = f * 0.30F * Mth.sin(0.15F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailFlap.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Jaw1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Jaw2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BigFeeler1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BigFeeler2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SmallFeeler1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SmallFeeler2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
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