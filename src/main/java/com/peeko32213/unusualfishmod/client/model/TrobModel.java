package com.peeko32213.unusualfishmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.hostile.Trob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class TrobModel<T extends Trob> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "trob"), "main");

	private final ModelPart MouthPart1;
	private final ModelPart MouthPart2;
	private final ModelPart Feeler1;
	private final ModelPart Feeler2;
	private final ModelPart Legs1;
	private final ModelPart Legs2;
	private final ModelPart TailBits;
	private final ModelPart bb_main;

	public TrobModel(ModelPart root) {
		this.MouthPart1 = root.getChild("MouthPart1");
		this.MouthPart2 = root.getChild("MouthPart2");
		this.Feeler1 = root.getChild("Feeler1");
		this.Feeler2 = root.getChild("Feeler2");
		this.Legs1 = root.getChild("Legs1");
		this.Legs2 = root.getChild("Legs2");
		this.TailBits = root.getChild("TailBits");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MouthPart1 = partdefinition.addOrReplaceChild("MouthPart1", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 22.0F, -10.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition MouthPart2 = partdefinition.addOrReplaceChild("MouthPart2", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 22.0F, -10.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition Feeler1 = partdefinition.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 22.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Feeler2 = partdefinition.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 22.0F, -8.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Legs1 = partdefinition.addOrReplaceChild("Legs1", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, 0.0F, -7.0F, 0.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition Legs2 = partdefinition.addOrReplaceChild("Legs2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, 0.0F, -7.0F, 0.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 23.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition TailBits = partdefinition.addOrReplaceChild("TailBits", CubeListBuilder.create().texOffs(21, 22).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(25, 13).addBox(-6.0F, -4.0F, -10.0F, 12.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -2.5F, -4.0F, 12.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -3.0F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		this.Feeler1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.Feeler2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);

		this.MouthPart1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.MouthPart2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MouthPart1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		MouthPart2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Feeler1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Feeler2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Legs1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Legs2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		TailBits.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}