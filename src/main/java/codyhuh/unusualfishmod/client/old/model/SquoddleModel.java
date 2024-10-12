package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.Squoddle;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SquoddleModel<T extends Squoddle> extends EntityModel<T> {
	private final ModelPart Spines1;
	private final ModelPart Spines2;
	private final ModelPart Feet1;
	private final ModelPart Feet2;
	private final ModelPart Feet3;
	private final ModelPart Feet4;
	private final ModelPart Feet5;
	private final ModelPart Feet6;
	private final ModelPart LeftFeet;
	private final ModelPart RightFeet;
	private final ModelPart root;

	public SquoddleModel(ModelPart base) {
		this.root = base.getChild("Root");
		this.Spines1 = root.getChild("Spines1");
		this.Spines2 = root.getChild("Spines2");
		this.LeftFeet = root.getChild("LeftFeet");
		this.RightFeet = root.getChild("RightFeet");
		this.Feet1 = LeftFeet.getChild("Feet1");
		this.Feet2 = LeftFeet.getChild("Feet2");
		this.Feet3 = LeftFeet.getChild("Feet3");
		this.Feet4 = RightFeet.getChild("Feet4");
		this.Feet5 = RightFeet.getChild("Feet5");
		this.Feet6 = RightFeet.getChild("Feet6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -5.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = Root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(11, 10).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -5.0F));

		PartDefinition Feeler1 = Head.addOrReplaceChild("Feeler1", CubeListBuilder.create(), PartPose.offset(1.5F, 1.0F, -1.0F));

		PartDefinition cube_r1 = Feeler1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -1.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Feeler2 = Head.addOrReplaceChild("Feeler2", CubeListBuilder.create(), PartPose.offset(-1.5F, 1.0F, -1.0F));

		PartDefinition cube_r2 = Feeler2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, -1.0F, -4.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Spines1 = Root.addOrReplaceChild("Spines1", CubeListBuilder.create(), PartPose.offset(1.0F, -8.0F, 0.0F));

		PartDefinition cube_r3 = Spines1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Spines2 = Root.addOrReplaceChild("Spines2", CubeListBuilder.create(), PartPose.offset(-1.0F, -8.0F, 0.0F));

		PartDefinition cube_r4 = Spines2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition LeftFeet = Root.addOrReplaceChild("LeftFeet", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -0.5F));

		PartDefinition Feet1 = LeftFeet.addOrReplaceChild("Feet1", CubeListBuilder.create(), PartPose.offset(0.05F, 0.0F, -2.5F));

		PartDefinition cube_r5 = Feet1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Feet2 = LeftFeet.addOrReplaceChild("Feet2", CubeListBuilder.create(), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Feet2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(10, 16).addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Feet3 = LeftFeet.addOrReplaceChild("Feet3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.5F));

		PartDefinition cube_r7 = Feet3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(16, 17).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition RightFeet = Root.addOrReplaceChild("RightFeet", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -0.5F));

		PartDefinition Feet4 = RightFeet.addOrReplaceChild("Feet4", CubeListBuilder.create(), PartPose.offset(-0.05F, 0.0F, -2.5F));

		PartDefinition cube_r8 = Feet4.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Feet5 = RightFeet.addOrReplaceChild("Feet5", CubeListBuilder.create(), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Feet5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(10, 16).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Feet6 = RightFeet.addOrReplaceChild("Feet6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.5F));

		PartDefinition cube_r10 = Feet6.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(16, 17).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition tail = Root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r11 = tail.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition cube_r12 = tail.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, -4.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 3.0F, 0.0F, 0.0F, 0.6109F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Feet1.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet2.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
		this.Feet3.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet4.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
		this.Feet5.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.2F * limbSwingAmount;
		this.Feet6.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}