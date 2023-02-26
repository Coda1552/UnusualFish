package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.ZebraCornetfish;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ZebraCornetfishModel<T extends ZebraCornetfish> extends ListModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "zebra_cornetfish"), "main");
	private final ModelPart Mouth;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Body;

	public ZebraCornetfishModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Mouth = this.Body.getChild("mouth");
		this.Tail = this.Body.getChild("tail");
		this.MidFin1 = this.Body.getChild("midfin1");
		this.MidFin2 = this.Body.getChild("midfin2");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.BackFin1 = this.Tail.getChild("backfin1");
		this.BackFin2 = this.Tail.getChild("backfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 33).addBox(-1.5F, -1.0F, -29.0F, 3.0F, 3.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, 12.0F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -1.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(10, 0).addBox(0.075F, 0.0F, 0.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -6.0F, -0.1309F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-0.075F, 0.0F, 0.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -1.0F, -6.0F, -0.1309F, -0.6109F, 0.0F));

		PartDefinition MidFin1 = Body.addOrReplaceChild("midfin1", CubeListBuilder.create().texOffs(10, 0).addBox(0.075F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 4.0F, -0.3054F, 0.3054F, 0.0F));

		PartDefinition MidFin2 = Body.addOrReplaceChild("midfin2", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-0.075F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.0F, 4.0F, -0.3054F, -0.3054F, 0.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, -28.25F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 17.0F));

		PartDefinition BackFin1 = Tail.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition BackFin2 = Tail.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(10, 6).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.5236F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.4F * ageInTicks);

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