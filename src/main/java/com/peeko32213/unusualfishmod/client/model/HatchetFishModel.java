package com.peeko32213.unusualfishmod.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.HatchetFish;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.AeroMono;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class HatchetFishModel<T extends HatchetFish> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "hatchet_fish"), "main");

	private final ModelPart Jaw;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart bb_main;

	public HatchetFishModel(ModelPart root) {
		this.Jaw = root.getChild("Jaw");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.Tail = root.getChild("Tail");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Jaw = partdefinition.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 23.0F, -4.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Eye1 = partdefinition.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 19.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Eye2 = partdefinition.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(16, 5).mirror().addBox(-2.0F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 19.0F, -3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(12, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 4.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 21.0F, -1.5F, 0.7854F, 0.5236F, 0.0F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, -2.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 21.0F, -1.5F, 0.7854F, -0.5236F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(8, 9).addBox(-1.5F, -5.0F, -4.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 10).addBox(0.0F, -7.0F, 0.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
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
		Jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Eye1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Eye2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}