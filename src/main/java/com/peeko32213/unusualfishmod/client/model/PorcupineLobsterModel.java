package com.peeko32213.unusualfishmod.client.model;// Made with Blockbench 4.1.4
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.PorcupineLobster;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PorcupineLobsterModel<T extends PorcupineLobster> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MOD_ID, "porcupine_lobsta"), "main");
	private final ModelPart BackBody;
	private final ModelPart BackSpines1;
	private final ModelPart BackSpines2;
	private final ModelPart BackSpines3;
	private final ModelPart LowerSpike1;
	private final ModelPart LowerSpike2;
	private final ModelPart Antenae1;
	private final ModelPart Antenae2;
	private final ModelPart MidSpike1;
	private final ModelPart MidSpike2;
	private final ModelPart LowerMidSpike1;
	private final ModelPart LowerMidSpike2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart Leg7;
	private final ModelPart Leg8;
	private final ModelPart bb_main;

	public PorcupineLobsterModel(ModelPart root) {
		this.BackBody = root.getChild("BackBody");
		this.BackSpines1 = root.getChild("BackSpines1");
		this.BackSpines2 = root.getChild("BackSpines2");
		this.BackSpines3 = root.getChild("BackSpines3");
		this.LowerSpike1 = root.getChild("LowerSpike1");
		this.LowerSpike2 = root.getChild("LowerSpike2");
		this.Antenae1 = root.getChild("Antenae1");
		this.Antenae2 = root.getChild("Antenae2");
		this.MidSpike1 = root.getChild("MidSpike1");
		this.MidSpike2 = root.getChild("MidSpike2");
		this.LowerMidSpike1 = root.getChild("LowerMidSpike1");
		this.LowerMidSpike2 = root.getChild("LowerMidSpike2");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Leg5 = root.getChild("Leg5");
		this.Leg6 = root.getChild("Leg6");
		this.Leg7 = root.getChild("Leg7");
		this.Leg8 = root.getChild("Leg8");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BackBody = partdefinition.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 20).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Thingies1 = BackBody.addOrReplaceChild("Thingies1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.5F, 1.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.0F, 3.5F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Thingies2 = BackBody.addOrReplaceChild("Thingies2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -2.5F, 1.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 4.0F, 3.5F, 0.0F, 0.0F, -0.5236F));

		PartDefinition BackSpikes1 = BackBody.addOrReplaceChild("BackSpikes1", CubeListBuilder.create().texOffs(23, 0).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BackSpikes2 = BackBody.addOrReplaceChild("BackSpikes2", CubeListBuilder.create().texOffs(23, 0).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition BackSpikes3 = BackBody.addOrReplaceChild("BackSpikes3", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 0.0F, 3.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(18, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 5.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition BackSpines1 = partdefinition.addOrReplaceChild("BackSpines1", CubeListBuilder.create().texOffs(23, 0).addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 14.0F, -1.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackSpines2 = partdefinition.addOrReplaceChild("BackSpines2", CubeListBuilder.create().texOffs(23, 0).addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -2.0F));

		PartDefinition BackSpines3 = partdefinition.addOrReplaceChild("BackSpines3", CubeListBuilder.create().texOffs(23, 0).mirror().addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 14.0F, -1.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition LowerSpike1 = partdefinition.addOrReplaceChild("LowerSpike1", CubeListBuilder.create().texOffs(24, 24).addBox(0.0F, 0.0F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 17.5F, -6.0F, 0.4738F, -0.0148F, 0.0699F));

		PartDefinition LowerSpike2 = partdefinition.addOrReplaceChild("LowerSpike2", CubeListBuilder.create().texOffs(24, 24).mirror().addBox(0.0F, 0.0F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 17.5F, -6.0F, 0.4738F, 0.0148F, -0.0699F));

		PartDefinition Antenae1 = partdefinition.addOrReplaceChild("Antenae1", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -4.0F, -14.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 16.0F, -6.0F, -0.2618F, -0.6109F, 0.0F));

		PartDefinition Antenae2 = partdefinition.addOrReplaceChild("Antenae2", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0.0F, -4.0F, -14.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 16.0F, -6.0F, -0.2618F, 0.6109F, 0.0F));

		PartDefinition MidSpike1 = partdefinition.addOrReplaceChild("MidSpike1", CubeListBuilder.create().texOffs(17, 10).addBox(0.0F, -2.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 18.5F, -6.0F, -0.1806F, -0.2577F, 0.0465F));

		PartDefinition MidSpike2 = partdefinition.addOrReplaceChild("MidSpike2", CubeListBuilder.create().texOffs(17, 10).mirror().addBox(0.0F, -2.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 18.5F, -6.0F, -0.1806F, 0.2577F, -0.0465F));

		PartDefinition LowerMidSpike1 = partdefinition.addOrReplaceChild("LowerMidSpike1", CubeListBuilder.create().texOffs(17, 10).addBox(0.0F, -2.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.5F, -5.25F, 0.343F, -0.2577F, 0.0465F));

		PartDefinition LowerMidSpike2 = partdefinition.addOrReplaceChild("LowerMidSpike2", CubeListBuilder.create().texOffs(17, 10).mirror().addBox(0.0F, -2.0F, -10.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 18.5F, -5.25F, 0.343F, 0.2577F, -0.0465F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(24, 22).addBox(0.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.5F, -3.0F, -0.2567F, 0.609F, -0.4301F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(24, 22).addBox(0.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.5F, -3.0F, 0.0072F, 0.0142F, -0.3713F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(24, 22).addBox(0.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.5F, -3.0F, 0.1388F, -0.4221F, -0.3746F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-9.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 20.5F, -3.0F, -0.2567F, -0.609F, 0.4301F));

		PartDefinition Leg5 = partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-9.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 20.5F, -3.0F, 0.0072F, -0.0142F, 0.3713F));

		PartDefinition Leg6 = partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-9.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 20.5F, -3.0F, 0.1388F, 0.4221F, 0.3746F));

		PartDefinition Leg7 = partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(24, 22).addBox(0.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 20.5F, -3.0F, 0.3149F, -0.8099F, -0.4514F));

		PartDefinition Leg8 = partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(24, 22).mirror().addBox(-9.5F, -2.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 20.5F, -3.0F, 0.3149F, 0.8099F, 0.4514F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -10.0F, -6.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		//Legs
		this.Leg3.zRot = -Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg7.zRot = Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg8.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;

		//Spikes
		this.LowerSpike1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.LowerSpike2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.LowerMidSpike1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.LowerMidSpike2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidSpike1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidSpike2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Antenae1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Antenae2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		BackBody.render(poseStack, buffer, packedLight, packedOverlay);
		BackSpines1.render(poseStack, buffer, packedLight, packedOverlay);
		BackSpines2.render(poseStack, buffer, packedLight, packedOverlay);
		BackSpines3.render(poseStack, buffer, packedLight, packedOverlay);
		LowerSpike1.render(poseStack, buffer, packedLight, packedOverlay);
		LowerSpike2.render(poseStack, buffer, packedLight, packedOverlay);
		Antenae1.render(poseStack, buffer, packedLight, packedOverlay);
		Antenae2.render(poseStack, buffer, packedLight, packedOverlay);
		MidSpike1.render(poseStack, buffer, packedLight, packedOverlay);
		MidSpike2.render(poseStack, buffer, packedLight, packedOverlay);
		LowerMidSpike1.render(poseStack, buffer, packedLight, packedOverlay);
		LowerMidSpike2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg1.render(poseStack, buffer, packedLight, packedOverlay);
		Leg2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg3.render(poseStack, buffer, packedLight, packedOverlay);
		Leg4.render(poseStack, buffer, packedLight, packedOverlay);
		Leg5.render(poseStack, buffer, packedLight, packedOverlay);
		Leg6.render(poseStack, buffer, packedLight, packedOverlay);
		Leg7.render(poseStack, buffer, packedLight, packedOverlay);
		Leg8.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}