package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.SnowflakeTailFish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SnowflakeTailFishModel<T extends SnowflakeTailFish> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "snowflaketail"), "main");
	private final ModelPart BottomFin1;
	private final ModelPart BottomFin2;
	private final ModelPart Tail;
	private final ModelPart Fin2;
	private final ModelPart Fin1;
	private final ModelPart TopFin;
	private final ModelPart bb_main;

	public SnowflakeTailFishModel(ModelPart root) {
		this.BottomFin1 = root.getChild("BottomFin1");
		this.BottomFin2 = root.getChild("BottomFin2");
		this.Tail = root.getChild("Tail");
		this.Fin2 = root.getChild("Fin2");
		this.Fin1 = root.getChild("Fin1");
		this.TopFin = root.getChild("TopFin");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BottomFin1 = partdefinition.addOrReplaceChild("BottomFin1", CubeListBuilder.create(), PartPose.offset(1.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = BottomFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 4).addBox(1.0F, 0.0F, -1.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.3491F, 0.1309F, 0.0F));

		PartDefinition BottomFin2 = partdefinition.addOrReplaceChild("BottomFin2", CubeListBuilder.create(), PartPose.offset(-1.0F, 24.0F, 0.0F));

		PartDefinition cube_r2 = BottomFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.3491F, -0.1309F, 0.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(19, 19).addBox(0.0F, -4.0F, 0.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 3.0F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-1.0F, 23.0F, -1.0F));

		PartDefinition cube_r3 = Fin2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 7).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.9163F, -0.2618F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(1.0F, 23.0F, -1.0F));

		PartDefinition cube_r4 = Fin1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.9163F, 0.2618F));

		PartDefinition TopFin = partdefinition.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(0.0F, -1.0F, 1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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
		this.BottomFin1.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.7F * limbSwingAmount;
		this.BottomFin2.xRot = Mth.cos(limbSwing * 0.3F) * 0.7F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		BottomFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BottomFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TopFin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}