package com.peeko32213.unusualfishmod.client.model;

import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;

import com.peeko32213.unusualfishmod.common.entity.ambient.predator.ClownthornShark;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ClownthornSharkModel<Type extends ClownthornShark> extends ListModel<Type> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "clownthorn_shark"), "main");
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Tail;

	public ClownthornSharkModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Tail = this.BackBody.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.Eye1 = this.Body.getChild("eye1");
		this.Eye2 = this.Body.getChild("eye2");
		this.BackFin1 = this.BackBody.getChild("backfin1");
		this.BackFin2 = this.BackBody.getChild("backfin2");
		;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(21, 14).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(22, 25).addBox(0.0F, -13.0F, -1.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 27).addBox(-3.0F, -6.0F, -9.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -7.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(20, 8).addBox(0.5F, -8.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(27, 5).addBox(0.5F, -7.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye2 = Body.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(20, 8).mirror().addBox(-2.5F, -8.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(27, 5).mirror().addBox(-2.5F, -7.0F, -8.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 1).addBox(0.0F, -4.0F, 3.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 7.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 11.0F));

		PartDefinition BackFin1 = BackBody.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 4.0F, -0.0844F, 0.1002F, -0.0042F));

		PartDefinition BackFin2 = BackBody.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 4.0F, -0.0844F, -0.1002F, 0.0042F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(12, 0).addBox(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.0F, -0.0579F, 0.2555F, 0.1671F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(-5.0F, 0.0F, -3.0F, 5.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -1.0F, 0.0F, -0.0579F, -0.2555F, -0.1671F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.4F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.4F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
		}

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.Body);
	}
}