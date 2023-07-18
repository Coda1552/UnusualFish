package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ulitity.BlackCapSnail;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BlackcapSnailModel<T extends BlackCapSnail> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "blackcap_snail"), "main");
	private final ModelPart Shell;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Mouth;
	private final ModelPart bb_main;

	public BlackcapSnailModel(ModelPart root) {
		this.Shell = root.getChild("Shell");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.Mouth = root.getChild("Mouth");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Shell = partdefinition.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-1.5F, -9.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Eye1 = partdefinition.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 22.0F, -1.0F, 0.2182F, -0.1745F, 0.0F));

		PartDefinition Eye2 = partdefinition.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 22.0F, -1.0F, 0.2182F, 0.1745F, 0.0F));

		PartDefinition Mouth = partdefinition.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-0.5F, 1.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(12, 8).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 13).addBox(-1.5F, -1.0F, 1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Eye1.xRot = -f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Eye2.xRot = f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Mouth.yRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Shell.xRot = -f * 0.20F * Mth.sin(0.01F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Shell.render(poseStack, buffer, packedLight, packedOverlay);
		Eye1.render(poseStack, buffer, packedLight, packedOverlay);
		Eye2.render(poseStack, buffer, packedLight, packedOverlay);
		Mouth.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}