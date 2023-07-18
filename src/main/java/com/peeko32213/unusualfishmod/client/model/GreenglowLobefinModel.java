package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.3.0
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.GreenglowLobefin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GreenglowLobefinModel<T extends GreenglowLobefin> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "greenglow"), "main");
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Tail;
	private final ModelPart LowerJaw;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;

	public GreenglowLobefinModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.LowerJaw = this.Body.getChild("LowerJaw");
		this.FrontFin1 = this.Body.getChild("FrontFin1");
		this.FrontFin2 = this.Body.getChild("FrontFin2");
		this.BackFin1 = this.Body.getChild("BackFin1");
		this.BackFin2 = this.Body.getChild("BackFin2");
		this.MidFin1 = this.Body.getChild("MidFin1");
		this.MidFin2 = this.Body.getChild("MidFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.0F, -12.0F, 7.0F, 7.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -9.0F, -9.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(36, 10).addBox(-2.0F, 1.0F, -20.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 10.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 15.0F));

		PartDefinition LowerJaw = Body.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -12.0F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("FrontFin1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.05F, -3.0F, 0.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, 2.0F, -6.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("FrontFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.05F, -3.0F, 0.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.6F, 2.0F, -6.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, 0.0F, -0.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 3.0F, 6.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-4.0F, 0.0F, -0.5F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 3.0F, 6.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition MidFin1 = Body.addOrReplaceChild("MidFin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -0.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 3.0F, -1.5F, 0.0F, 0.0F, 0.7418F));

		PartDefinition MidFin2 = Body.addOrReplaceChild("MidFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 0.0F, -0.5F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 3.0F, -1.5F, 0.0F, 0.0F, -0.7418F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.FrontFin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.FrontFin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

		this.BackFin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.BackFin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

		this.MidFin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.MidFin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
		}

	}

	public void prepareMobModel (T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
		super.prepareMobModel(p_102957_, p_102958_, p_102959_, p_102960_);
		int l = p_102957_.getAttackAnimationTick();
		if (l > 0) {
			float f4 = Mth.sin(((float) l - p_102960_) / 10.0F * (float) Math.PI * 0.25F);
			this.LowerJaw.xRot = ((float) Math.PI / 2F) * f4;
			if (l > 5) {
				this.LowerJaw.xRot = Mth.sin(((float) (-4 + l) - p_102960_) / 4.0F) * (float) Math.PI * 0.4F;
			} else {
				this.LowerJaw.xRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_102960_) / 10.0F);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}