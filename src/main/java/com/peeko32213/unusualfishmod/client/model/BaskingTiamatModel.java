package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.BaskingTiamat;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BaskingTiamatModel<T extends BaskingTiamat> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "basking_tiamat"), "main");

	private final ModelPart Body;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackBody;
	private final ModelPart Tail;

	public BaskingTiamatModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Tail = this.BackBody.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -1.0F, -51.0F, 11.0F, 11.0F, 74.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.5F, -1.0F, -76.0F, 11.0F, 5.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(83, 85).addBox(-10.5F, 4.0F, -68.0F, 21.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 4.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(30, 30).mirror().addBox(-13.0F, 0.0F, 0.0F, 13.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 2.0F, -57.0F, 0.0F, 0.0873F, 0.3054F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(30, 30).addBox(0.0F, 0.0F, 0.0F, 13.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 2.0F, -57.0F, 0.0F, -0.0873F, -0.3054F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(20, 21).addBox(0.0F, -13.0F, 21.0F, 0.0F, 25.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 85).addBox(-4.5F, -5.0F, 0.0F, 9.0F, 9.0F, 65.0F, new CubeDeformation(0.0F))
				.texOffs(59, 0).addBox(-10.5F, 0.0F, 29.0F, 21.0F, 0.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 23.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 64.0F));

		PartDefinition TopFin = Tail.addOrReplaceChild("topfin", CubeListBuilder.create().texOffs(38, 38).addBox(-0.5F, -24.0F, 0.0F, 1.0F, 24.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition BottomTail = Tail.addOrReplaceChild("bottomtail", CubeListBuilder.create().texOffs(0, 30).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 26.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 220F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 220F);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}