package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.StoutBichir;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class StoutBichirModel<T extends StoutBichir> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "stout_bichir"), "main");

	private final ModelPart Tail;
	private final ModelPart TailBit;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart SideFin1;
	private final ModelPart SideFin2;
	private final ModelPart bb_main;

	public StoutBichirModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.TailBit = this.Tail.getChild("TailBit");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.SideFin1 = root.getChild("SideFin1");
		this.SideFin2 = root.getChild("SideFin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -6.0F, 0.0F, 0.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 5.0F));

		PartDefinition TailBit = Tail.addOrReplaceChild("TailBit", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -6.0F, 0.0F, 0.0F, 11.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 14.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -1.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 21.0F, -9.0F, 0.5236F, 0.3927F, 0.0F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, -1.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 21.0F, -9.0F, 0.5236F, -0.3927F, 0.0F));

		PartDefinition SideFin1 = partdefinition.addOrReplaceChild("SideFin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 24.0F, -2.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition SideFin2 = partdefinition.addOrReplaceChild("SideFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 24.0F, -2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -9.0F, -12.0F, 9.0F, 9.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(28, 30).addBox(-2.5F, -5.0F, -17.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 14).addBox(0.0F, -13.0F, -6.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(0.0F, -1.0F, 2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.TailBit.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);


		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SideFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SideFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}