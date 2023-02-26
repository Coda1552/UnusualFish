package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.SeaMosquito;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class SeaMosquitoModel<T extends SeaMosquito> extends ListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "sea_mosquito"), "main");
	private final ModelPart Mouth;
	private final ModelPart Tail;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart LargeFin1;
	private final ModelPart LargeFin2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Body;

	public SeaMosquitoModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Mouth = this.Body.getChild("mouth");
		this.Tail = this.Body.getChild("tail");
		this.Eye1 = this.Body.getChild("eye1");
		this.Eye2 = this.Body.getChild("eye2");
		this.LargeFin1 = this.Body.getChild("largefin1");
		this.LargeFin2 = this.Body.getChild("largefin2");
		this.MidFin1 = this.Body.getChild("midfin1");
		this.MidFin2 = this.Body.getChild("midfin2");
		this.BackFin1 = this.Body.getChild("backfin1");
		this.BackFin2 = this.Body.getChild("backfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 2.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 4).addBox(-0.5F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.5F, -4.0F, 0.1325F, -0.285F, 0.1325F));

		PartDefinition Eye2 = Body.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(-1.5F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, -0.5F, -4.0F, 0.1325F, 0.285F, -0.1325F));

		PartDefinition LargeFin1 = Body.addOrReplaceChild("largefin1", CubeListBuilder.create().texOffs(12, 11).addBox(0.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.5F, -1.5F));

		PartDefinition LargeFin2 = Body.addOrReplaceChild("largefin2", CubeListBuilder.create().texOffs(12, 11).mirror().addBox(-6.0F, 0.0F, -1.5F, 6.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -0.5F, -1.5F));

		PartDefinition MidFin1 = Body.addOrReplaceChild("midfin1", CubeListBuilder.create().texOffs(6, 14).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.5F, 1.0F));

		PartDefinition MidFin2 = Body.addOrReplaceChild("midfin2", CubeListBuilder.create().texOffs(6, 14).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -0.5F, 1.0F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(6, 16).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.5F, 3.0F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(6, 16).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -0.5F, 3.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.LargeFin1.zRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.LargeFin2.zRot = f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.MidFin1.zRot = f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.MidFin2.zRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.BackFin1.zRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.BackFin2.zRot = f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.Tail.xRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);

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