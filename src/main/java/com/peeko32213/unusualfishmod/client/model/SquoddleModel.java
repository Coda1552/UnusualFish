package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.Squoddle;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SquoddleModel<T extends Squoddle> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "squoddle"), "main");
	private final ModelPart Feeler1;
	private final ModelPart Feeler2;
	private final ModelPart Spines1;
	private final ModelPart Spines2;
	private final ModelPart Feet1;
	private final ModelPart Feet2;
	private final ModelPart Feet3;
	private final ModelPart Feet4;
	private final ModelPart Feet5;
	private final ModelPart Feet6;
	private final ModelPart bb_main;

	public SquoddleModel(ModelPart root) {
		this.Feeler1 = root.getChild("Feeler1");
		this.Feeler2 = root.getChild("Feeler2");
		this.Spines1 = root.getChild("Spines1");
		this.Spines2 = root.getChild("Spines2");
		this.Feet1 = root.getChild("Feet1");
		this.Feet2 = root.getChild("Feet2");
		this.Feet3 = root.getChild("Feet3");
		this.Feet4 = root.getChild("Feet4");
		this.Feet5 = root.getChild("Feet5");
		this.Feet6 = root.getChild("Feet6");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Feeler1 = partdefinition.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(17, 6).addBox(0.0F, -3.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 19.0F, -6.0F, 0.0F, 0.0F, 2.2253F));

		PartDefinition Feeler2 = partdefinition.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(17, 6).mirror().addBox(0.0F, -3.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 19.0F, -6.0F, 0.0F, 0.0F, -2.2253F));

		PartDefinition Spines1 = partdefinition.addOrReplaceChild("Spines1", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -6.0F, -6.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 18.0F, 2.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Spines2 = partdefinition.addOrReplaceChild("Spines2", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(0.0F, -6.0F, -6.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 18.0F, 2.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Feet1 = partdefinition.addOrReplaceChild("Feet1", CubeListBuilder.create().texOffs(0, 5).addBox(0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Feet2 = partdefinition.addOrReplaceChild("Feet2", CubeListBuilder.create().texOffs(0, 5).addBox(0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Feet3 = partdefinition.addOrReplaceChild("Feet3", CubeListBuilder.create().texOffs(0, 5).addBox(0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 3.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Feet4 = partdefinition.addOrReplaceChild("Feet4", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, -3.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Feet5 = partdefinition.addOrReplaceChild("Feet5", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Feet6 = partdefinition.addOrReplaceChild("Feet6", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-0.5F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 20.0F, 3.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -6.0F, -8.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Feeler1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Feeler2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Feet1.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet2.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;

		this.Feet3.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet4.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;

		this.Feet5.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet6.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Feeler1.render(poseStack, buffer, packedLight, packedOverlay);
		Feeler2.render(poseStack, buffer, packedLight, packedOverlay);
		Spines1.render(poseStack, buffer, packedLight, packedOverlay);
		Spines2.render(poseStack, buffer, packedLight, packedOverlay);
		Feet1.render(poseStack, buffer, packedLight, packedOverlay);
		Feet2.render(poseStack, buffer, packedLight, packedOverlay);
		Feet3.render(poseStack, buffer, packedLight, packedOverlay);
		Feet4.render(poseStack, buffer, packedLight, packedOverlay);
		Feet5.render(poseStack, buffer, packedLight, packedOverlay);
		Feet6.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}