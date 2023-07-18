package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.ManaJellyfish;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ManaJellyfishModel<T extends ManaJellyfish> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "wizard_jelly"), "main");
	private final ModelPart Body;

	public ManaJellyfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-4.5F, 5.0F, 4.5F, 9.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-4.5F, 5.0F, -4.5F, 9.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 4).addBox(-4.5F, 5.0F, -4.5F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 4).mirror().addBox(4.5F, 5.0F, -4.5F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition InsideThing2 = Body.addOrReplaceChild("InsideThing2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(0.0F, -3.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition InsideThing1 = Body.addOrReplaceChild("InsideThing1", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -3.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}



}