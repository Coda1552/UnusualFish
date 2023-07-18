package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.GrandCorydora;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GrandCorydoraModel<T extends GrandCorydora> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "grand_cory"), "main");

	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Whiskers1;
	private final ModelPart Whiskers2;
	private final ModelPart SideBarbels1;
	private final ModelPart SideBarbels2;
	private final ModelPart bb_main;

	public GrandCorydoraModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.BackFin1 = root.getChild("BackFin1");
		this.BackFin2 = root.getChild("BackFin2");
		this.Whiskers1 = root.getChild("Whiskers1");
		this.Whiskers2 = root.getChild("Whiskers2");
		this.SideBarbels1 = root.getChild("SideBarbels1");
		this.SideBarbels2 = root.getChild("SideBarbels2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -3.0F, 0.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 6.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(20, 6).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 23.0F, -2.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(20, 6).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 23.0F, -2.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition BackFin1 = partdefinition.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 23.0F, 3.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackFin2 = partdefinition.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 23.0F, 3.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Whiskers1 = partdefinition.addOrReplaceChild("Whiskers1", CubeListBuilder.create().texOffs(10, 18).addBox(0.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 23.0F, -7.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Whiskers2 = partdefinition.addOrReplaceChild("Whiskers2", CubeListBuilder.create().texOffs(10, 18).mirror().addBox(-4.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 23.0F, -7.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition SideBarbels1 = partdefinition.addOrReplaceChild("SideBarbels1", CubeListBuilder.create().texOffs(17, 0).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 23.5F, -5.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition SideBarbels2 = partdefinition.addOrReplaceChild("SideBarbels2", CubeListBuilder.create().texOffs(17, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 23.5F, -5.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(20, 20).addBox(-2.5F, -4.0F, -7.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -10.0F, 3.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Whiskers1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Whiskers2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SideBarbels1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		SideBarbels2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}