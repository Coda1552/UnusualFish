package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.SeaSpider;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SeaSpiderModel<T extends SeaSpider> extends EntityModel<T> {
	private final ModelPart Claw1;
	private final ModelPart Claw2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart Leg7;
	private final ModelPart Leg8;
	private final ModelPart Body;

	public SeaSpiderModel(ModelPart root) {
		this.Claw1 = root.getChild("Claw1");
		this.Claw2 = root.getChild("Claw2");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.Leg5 = root.getChild("Leg5");
		this.Leg6 = root.getChild("Leg6");
		this.Leg7 = root.getChild("Leg7");
		this.Leg8 = root.getChild("Leg8");
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Claw1 = partdefinition.addOrReplaceChild("Claw1", CubeListBuilder.create().texOffs(12, 7).mirror().addBox(0.0F, 0.0F, -4.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 16.0F, -0.5F, 0.0F, 0.1745F, 0.0F));

		PartDefinition Claw2 = partdefinition.addOrReplaceChild("Claw2", CubeListBuilder.create().texOffs(12, 7).addBox(0.0F, 0.0F, -4.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 16.0F, -0.5F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 16.0F, -1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 16.0F, -0.75F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 20).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 16.0F, -1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Leg5 = partdefinition.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(0, 20).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 16.0F, -0.75F));

		PartDefinition Leg6 = partdefinition.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Leg7 = partdefinition.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, 0.0F, 0.0F, -1.0908F, 0.0F));

		PartDefinition Leg8 = partdefinition.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, 0.0F, 0.0F, 1.0908F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -6.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 7).addBox(-3.5F, -2.0F, 0.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(18, 5).addBox(-4.5F, -3.25F, 1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(18, 7).addBox(-3.0F, -4.5F, 1.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(18, 7).mirror().addBox(1.5F, -2.0F, 0.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 7).mirror().addBox(1.0F, -4.5F, 1.5F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(18, 5).mirror().addBox(1.5F, -3.25F, 1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 16.0F, -1.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Feeder = Body.addOrReplaceChild("Feeder", CubeListBuilder.create().texOffs(18, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Leg3.zRot = -Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.Leg7.zRot = Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.Leg8.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;

		this.Claw1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Claw2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Claw1.render(poseStack, buffer, packedLight, packedOverlay);
		Claw2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg1.render(poseStack, buffer, packedLight, packedOverlay);
		Leg2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg3.render(poseStack, buffer, packedLight, packedOverlay);
		Leg4.render(poseStack, buffer, packedLight, packedOverlay);
		Leg5.render(poseStack, buffer, packedLight, packedOverlay);
		Leg6.render(poseStack, buffer, packedLight, packedOverlay);
		Leg7.render(poseStack, buffer, packedLight, packedOverlay);
		Leg8.render(poseStack, buffer, packedLight, packedOverlay);
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}