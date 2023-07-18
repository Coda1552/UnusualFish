package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ulitity.CelestialFish;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CelestialFishModel<T extends CelestialFish> extends ListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "celestial"), "main");
	private final ModelPart body;
	private final ModelPart fin1;
	private final ModelPart fin2;
	private final ModelPart topfin;
	private final ModelPart lowerfin;
	private final ModelPart tail;

	public CelestialFishModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tail = this.body.getChild("tail");
		this.fin1 = this.body.getChild("fin1");
		this.fin2 = this.body.getChild("fin2");
		this.topfin = this.body.getChild("topfin");
		this.lowerfin = this.body.getChild("lowerfin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(44, 0).addBox(-4.5F, -16.0F, -14.0F, 9.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -15.0F, -13.0F, 8.0F, 26.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(9, 11).addBox(-2.5F, -16.0F, -17.0F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

		PartDefinition fin1 = body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(12, 0).addBox(0.525F, -1.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, -2.0F, 0.48F, 0.48F, 0.0F));

		PartDefinition fin2 = body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(12, 0).mirror().addBox(-0.525F, -1.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -4.0F, -2.0F, 0.48F, -0.48F, 0.0F));

		PartDefinition topfin = body.addOrReplaceChild("topfin", CubeListBuilder.create().texOffs(24, 54).addBox(-1.0F, -21.0F, 0.0F, 2.0F, 21.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 10.0F));

		PartDefinition lowerfin = body.addOrReplaceChild("lowerfin", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 21.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 10.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.tail.yRot = -f * 0.1F * Mth.sin(0.1F * ageInTicks);
		this.fin1.xRot = -f * 0.40F * Mth.sin(0.1F * ageInTicks);
		this.fin2.xRot = -f * 0.40F * Mth.sin(0.1F * ageInTicks);

		this.topfin.xRot = -f * 0.1F * Mth.sin(0.06F * ageInTicks);
		this.lowerfin.xRot = f * 0.1F * Mth.sin(0.06F * ageInTicks);

		this.body.xRot = headPitch * ((float)Math.PI / 180F);
		this.body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
		}
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.body);
	}
}