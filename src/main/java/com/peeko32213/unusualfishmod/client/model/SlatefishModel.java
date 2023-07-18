package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.Slatefish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SlatefishModel<T extends Slatefish> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "slatefish"), "main");

	private final ModelPart Tail;
	private final ModelPart Spike1;
	private final ModelPart Spike2;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart bb_main;

	public SlatefishModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.Spike1 = root.getChild("Spike1");
		this.Spike2 = root.getChild("Spike2");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(19, 9).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 2.0F));

		PartDefinition Tailfin = Tail.addOrReplaceChild("Tailfin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 3.0F));

		PartDefinition Spike1 = partdefinition.addOrReplaceChild("Spike1", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 22.0F, -2.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition Spike2 = partdefinition.addOrReplaceChild("Spike2", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 22.0F, -2.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 23.0F, -3.0F, 0.0F, 0.2182F, 0.3054F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.25F, 23.0F, -3.0F, 0.0F, -0.2182F, -0.3054F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -6.0F, -1.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Spike1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Spike2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}