package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.Kalappa;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class KalappaModel<T extends Kalappa> extends EntityModel<T> {
	private final ModelPart Warts;
	private final ModelPart Claw1;
	private final ModelPart Claw2;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Hair1;
	private final ModelPart Hair2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart Leg7;
	private final ModelPart Leg8;
	private final ModelPart bb_main;

	public KalappaModel(ModelPart root) {
		this.Warts = root.getChild("Warts");
		this.Claw1 = root.getChild("Claw1");
		this.Claw2 = root.getChild("Claw2");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.Hair1 = root.getChild("Hair1");
		this.Hair2 = root.getChild("Hair2");
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

		PartDefinition Warts = partdefinition.addOrReplaceChild("Warts", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LargeWart = Warts.addOrReplaceChild("LargeWart", CubeListBuilder.create().texOffs(48, 57).addBox(-6.0F, -3.0F, 0.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -26.0F, 0.0F));

		PartDefinition SmallWart4 = Warts.addOrReplaceChild("SmallWart4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(5.0F, -25.0F, -4.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, 11.0F));

		PartDefinition SmallWart3 = Warts.addOrReplaceChild("SmallWart3", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -25.0F, -4.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 11.0F));

		PartDefinition SmallWart2 = Warts.addOrReplaceChild("SmallWart2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(5.0F, -25.0F, -4.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition SmallWart1 = Warts.addOrReplaceChild("SmallWart1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -25.0F, -4.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition Claw1 = partdefinition.addOrReplaceChild("Claw1", CubeListBuilder.create().texOffs(0, 7).addBox(11.0F, 4.0F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-4.0F, -4.0F, -6.0F, 18.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 47).addBox(-4.0F, 3.0F, -6.0F, 15.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(66, 57).addBox(-3.0F, -7.0F, -4.5F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(66, 57).addBox(-4.0F, -7.0F, -1.5F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 66).addBox(-2.0F, 7.0F, -4.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 13.0F, -8.0F, 0.1874F, 0.398F, -0.0608F));

		PartDefinition Claw2 = partdefinition.addOrReplaceChild("Claw2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-14.0F, 4.0F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 44).mirror().addBox(-14.0F, -4.0F, -6.0F, 18.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 47).mirror().addBox(-11.0F, 3.0F, -6.0F, 15.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(66, 57).mirror().addBox(-12.0F, -7.0F, -4.5F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(66, 57).mirror().addBox(-11.0F, -7.0F, -1.5F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 66).mirror().addBox(-13.0F, 7.0F, -4.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 13.0F, -8.0F, 0.1874F, -0.398F, 0.0608F));

		PartDefinition Eye1 = partdefinition.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 69).addBox(-1.0F, -7.0F, -3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 8.0F, -8.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Eye2 = partdefinition.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 69).mirror().addBox(-1.0F, -7.0F, -3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 8.0F, -8.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Hair1 = partdefinition.addOrReplaceChild("Hair1", CubeListBuilder.create().texOffs(42, 44).addBox(-13.0F, -3.0F, 0.0F, 26.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -6.5F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Hair2 = partdefinition.addOrReplaceChild("Hair2", CubeListBuilder.create().texOffs(42, 44).addBox(-13.0F, -3.0F, 0.0F, 26.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 12.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(24, 57).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(6.0F, 7.975F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 16.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(24, 57).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 16).mirror().addBox(6.0F, 7.975F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 16.0F, 3.5F, 0.0F, -0.1309F, 0.0F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 57).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 7).mirror().addBox(6.0F, 7.975F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.0F, 16.0F, 9.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(24, 57).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-11.0F, 7.975F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 16.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Leg5 = partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(24, 57).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-11.0F, 7.975F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 16.0F, 3.5F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Leg6 = partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(0, 57).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(7, 7).addBox(-11.0F, 7.975F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 16.0F, 9.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Leg7 = partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(0, 57).mirror().addBox(0.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 7).mirror().addBox(6.0F, 7.975F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 16.0F, 13.0F, 0.0F, -0.8727F, 0.0F));

		PartDefinition Leg8 = partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(0, 57).addBox(-8.0F, 0.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(7, 7).addBox(-11.0F, 7.975F, -1.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 16.0F, 13.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -26.0F, -8.0F, 28.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		//Legs
		this.Leg3.zRot = -Mth.cos(limbSwing * 1.3F) * 2.0F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 1.3F + (float) Math.PI) * 2.0F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 1.3F) * 2.0F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 1.3F + (float) Math.PI) * 2.0F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 1.3F) * 2.0F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 1.3F + (float) Math.PI) * 2.0F * limbSwingAmount;
		this.Leg7.zRot = Mth.cos(limbSwing * 1.3F) * 2.0F * limbSwingAmount;
		this.Leg8.zRot = Mth.cos(limbSwing * 1.3F + (float) Math.PI) * 2.0F * limbSwingAmount;

		this.Claw1.xRot = -f * 0.20F * Mth.sin(0.05F * ageInTicks);
		this.Claw2.xRot = f * 0.20F * Mth.sin(0.05F * ageInTicks);

		this.Eye1.yRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Eye2.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Warts.render(poseStack, buffer, packedLight, packedOverlay);
		Claw1.render(poseStack, buffer, packedLight, packedOverlay);
		Claw2.render(poseStack, buffer, packedLight, packedOverlay);
		Eye1.render(poseStack, buffer, packedLight, packedOverlay);
		Eye2.render(poseStack, buffer, packedLight, packedOverlay);
		Hair1.render(poseStack, buffer, packedLight, packedOverlay);
		Hair2.render(poseStack, buffer, packedLight, packedOverlay);
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