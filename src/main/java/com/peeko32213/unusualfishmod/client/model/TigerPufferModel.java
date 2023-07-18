package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.3
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ulitity.TigerPuffer;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TigerPufferModel<T extends TigerPuffer> extends ListModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "tiger_puffer"), "main");

	private final ModelPart Tail;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Body;
	private final ModelPart BackBody;

	public TigerPufferModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Tail = this.BackBody.getChild("tail");
		this.Eye1 = this.Body.getChild("eye1");
		this.Eye2 = this.Body.getChild("eye2");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(14, 29).addBox(-6.0F, -1.0F, -9.0F, 12.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(41, 0).addBox(-2.5F, 0.0F, -14.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 22).addBox(0.0F, -10.0F, 4.0F, 0.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.0F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.0F, -7.0F));

		PartDefinition Eye2 = Body.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -3.0F, -3.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -1.0F, -7.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.05F, -4.0F, -1.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 2.0F, -2.0F, -0.2618F, 1.0036F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.05F, -4.0F, -1.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 2.0F, -2.0F, -0.2618F, -1.0036F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(36, 31).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(14, 29).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin1.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);

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