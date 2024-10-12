package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.Skrimp;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CoralSkrimpModel<T extends Skrimp> extends EntityModel<T> {
	private final ModelPart Head;
	private final ModelPart Claw1;
	private final ModelPart Claw2;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart bb_main;

	public CoralSkrimpModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Claw1 = root.getChild("Claw1");
		this.Claw2 = root.getChild("Claw2");
		this.Leg1 = root.getChild("Leg1");
		this.Leg2 = root.getChild("Leg2");
		this.Leg3 = root.getChild("Leg3");
		this.Leg4 = root.getChild("Leg4");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 18.0F, -5.0F));

		PartDefinition Feeler1 = Head.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.0F, -7.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.5F, -1.0F, -2.0F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition Feeler2 = Head.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(0.0F, -3.0F, -7.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, -2.0F, 0.0F, 0.4363F, -0.3927F));

		PartDefinition Claw1 = partdefinition.addOrReplaceChild("Claw1", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, 0.0F, -5.5F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 17.0F, -2.5F, 0.2182F, 0.0F, -0.5672F));

		PartDefinition Claw2 = partdefinition.addOrReplaceChild("Claw2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(0.0F, 0.0F, -5.5F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 17.0F, -2.5F, 0.2182F, 0.0F, 0.5672F));

		PartDefinition Leg1 = partdefinition.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(16, 17).addBox(-1.0F, -2.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 19.0F, 2.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition Leg2 = partdefinition.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(16, 17).addBox(-1.0F, -2.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 19.0F, 3.5F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Leg3 = partdefinition.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(16, 17).mirror().addBox(-8.0F, -2.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 19.0F, 2.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Leg4 = partdefinition.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(16, 17).mirror().addBox(-8.0F, -2.0F, 0.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 19.0F, 3.5F, 0.0F, 0.5236F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(20, 10).addBox(-1.0F, -8.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 5).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -11.0F, -3.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-1.0F, -9.0F, 2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -13.0F, -4.0F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Leg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.3F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.3F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.3F * limbSwingAmount;
		this.Leg3.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.3F * limbSwingAmount;

		this.Claw1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Claw2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, buffer, packedLight, packedOverlay);
		Claw1.render(poseStack, buffer, packedLight, packedOverlay);
		Claw2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg1.render(poseStack, buffer, packedLight, packedOverlay);
		Leg2.render(poseStack, buffer, packedLight, packedOverlay);
		Leg3.render(poseStack, buffer, packedLight, packedOverlay);
		Leg4.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}