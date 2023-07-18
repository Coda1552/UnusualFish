package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.Picklefish;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PicklefishModel<T extends Picklefish> extends ListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "picklefish"), "main");
	private final ModelPart Tail;
	private final ModelPart Sensor;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Body;

	public PicklefishModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Tail = this.Body.getChild("tail");
		this.Sensor = this.Body.getChild("sensor");
		this.FrontFin1 = this.Body.getChild("frontfin1");
		this.FrontFin2 = this.Body.getChild("frontfin2");
		this.BackFin1 = this.Tail.getChild("backfin1");
		this.BackFin2 = this.Tail.getChild("backfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(4, 2).addBox(0.0F, -5.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.0F));

		PartDefinition BackFin1 = Tail.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(11, 4).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, 1.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition BackFin2 = Tail.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(11, 4).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.75F, 1.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition Sensor = Body.addOrReplaceChild("sensor", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("frontfin1", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.0F, -3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("frontfin2", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.0F, -3.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.FrontFin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.FrontFin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Sensor.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.Body);
	}
}