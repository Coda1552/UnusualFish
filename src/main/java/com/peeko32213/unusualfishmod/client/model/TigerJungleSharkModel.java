package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.TigerJungleShark;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TigerJungleSharkModel<T extends TigerJungleShark> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "jungleshark"), "main");
	private final ModelPart Head;
	private final ModelPart LowerJaw;
	private final ModelPart Body;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackBody;
	private final ModelPart Tailfin;

	public TigerJungleSharkModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.LowerJaw = this.Head.getChild("LowerJaw");
		this.Body = root.getChild("Body");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tailfin = this.BackBody.getChild("Tailfin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, -4.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -4.0F, 3.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(3.0F, 5.0F, 2.0F));

		PartDefinition cube_r2 = Fin1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 8).addBox(0.0F, 0.0F, -1.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.2618F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-3.0F, 5.0F, 2.0F));

		PartDefinition cube_r3 = Fin2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(27, 29).addBox(-6.0F, 0.0F, -1.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.2618F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 19).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9F, 9.0F));

		PartDefinition Tailfin = BackBody.addOrReplaceChild("Tailfin", CubeListBuilder.create().texOffs(0, 33).addBox(-0.5F, -5.0F, 0.0F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(9, 33).addBox(-1.0F, 1.0F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(17, 19).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -4.0F));

		PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(32, 13).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(22, 0).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Body.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.Tailfin.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);


		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
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
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}