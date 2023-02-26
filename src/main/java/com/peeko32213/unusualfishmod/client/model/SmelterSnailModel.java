package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ulitity.SmelterSnail;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SmelterSnailModel<T extends SmelterSnail> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "smelter_snail"), "main");

	private final ModelPart Body;
	private final ModelPart Shell;
	private final ModelPart Mouth;
	private final ModelPart Feeler1;
	private final ModelPart Feeler2;

	public SmelterSnailModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Shell = root.getChild("shell");
		this.Mouth = this.Shell.getChild("mouth");
		this.Feeler1 = this.Mouth.getChild("feeler1");
		this.Feeler2 = this.Mouth.getChild("feeler2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(75, 56).addBox(-6.5F, -12.0F, 2.5F, 13.0F, 7.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(-12.5F, -5.0F, -0.5F, 25.0F, 5.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(51, 0).addBox(-16.0F, -0.1F, 0.0F, 32.0F, 0.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -11.0F));

		PartDefinition Shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5F, -23.0F, 0.0F, 23.0F, 23.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, -20.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Mouth = Shell.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Feeler1 = Mouth.addOrReplaceChild("feeler1", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -2.0F, -14.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.0F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition Feeler2 = Mouth.addOrReplaceChild("feeler2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -2.0F, -14.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.0F, 0.1745F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Feeler1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Feeler2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
		Shell.render(poseStack, buffer, packedLight, packedOverlay);
	}
}