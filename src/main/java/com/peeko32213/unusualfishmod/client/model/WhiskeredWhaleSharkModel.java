package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.WhiskeredWhaleShark;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WhiskeredWhaleSharkModel<T extends WhiskeredWhaleShark> extends ListModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "whiskered"), "main");
	private final ModelPart Whiskers;
	private final ModelPart Tail;
	private final ModelPart Tailfin;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;
	private final ModelPart Body;

	public WhiskeredWhaleSharkModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Whiskers = this.Body.getChild("whiskers");
		this.Tail = this.Body.getChild("tail");
		this.Tailfin = this.Tail.getChild("tailfin");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.MidFin1 = this.Body.getChild("midfin1");
		this.MidFin2 = this.Body.getChild("midfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -7.0F, -20.0F, 25.0F, 14.0F, 35.0F, new CubeDeformation(0.0F))
				.texOffs(61, 56).addBox(-11.0F, -3.0F, -31.0F, 22.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -17.0F, 9.0F, 1.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(58, 77).addBox(0.5F, 0.0F, -4.0F, 12.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 4.0F, -12.0F, 0.0F, -0.1309F, 0.48F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(58, 77).mirror().addBox(-12.5F, 0.0F, -4.0F, 12.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 4.0F, -12.0F, 0.0F, 0.1309F, -0.48F));

		PartDefinition MidFin1 = Body.addOrReplaceChild("midfin1", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, 0.0F, -2.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5F, 5.0F, 10.0F, 0.0F, -0.1309F, 0.48F));

		PartDefinition MidFin2 = Body.addOrReplaceChild("midfin2", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-6.0F, 0.0F, -2.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.5F, 5.0F, 10.0F, 0.0F, 0.1309F, -0.48F));

		PartDefinition Whiskers = Body.addOrReplaceChild("whiskers", CubeListBuilder.create().texOffs(72, 49).addBox(-10.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -31.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 67).addBox(-5.5F, -4.0F, 0.0F, 11.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(14, 14).addBox(0.0F, 5.0F, 5.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 13).addBox(0.0F, -8.0F, 5.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 15.0F));

		PartDefinition Tailfin = Tail.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -11.0F, 0.0F, 0.0F, 18.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 18.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);
		this.Tailfin.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);

		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

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