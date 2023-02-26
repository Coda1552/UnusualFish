package com.peeko32213.unusualfishmod.client.model;

import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;

import com.peeko32213.unusualfishmod.common.entity.ambient.small.Spindlefish;
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

public class SpindlefishModel<Type extends Spindlefish> extends ListModel<Type> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "spindlefish"), "main");
	private final ModelPart Fin1;
	private final ModelPart Tail;
	private final ModelPart Whiskers1;
	private final ModelPart Fin2;
	private final ModelPart Whiskers2;
	private final ModelPart Body;

	public SpindlefishModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Fin1 = this.Body.getChild("fin1");
		this.Tail = this.Body.getChild("tail");
		this.Whiskers1 = this.Body.getChild("whiskers1");
		this.Fin2 = this.Body.getChild("fin2");
		this.Whiskers2 = this.Body.getChild("whiskers2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.0F, -4.0F, 7.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, -6.0F, 0.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 19).addBox(0.05F, -5.0F, 0.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 2.0F, -2.0F, 0.0F, 1.1781F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-0.05F, -5.0F, 0.0F, 0.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 2.0F, -2.0F, 0.0F, -1.1781F, 0.0F));

		PartDefinition Whiskers1 = Body.addOrReplaceChild("whiskers1", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -7.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Whiskers2 = Body.addOrReplaceChild("whiskers2", CubeListBuilder.create().texOffs(30, 5).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, -7.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(22, 24).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.Body);
	}
}