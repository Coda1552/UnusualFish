package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.DeepCrawler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DeepCrawlerModel<T extends DeepCrawler> extends EntityModel<T> {
	private final ModelPart Head;
	private final ModelPart BigLeg1;
	private final ModelPart BigLeg3;
	private final ModelPart BigLeg2;
	private final ModelPart BigLeg4;
	private final ModelPart LittleLeg1;
	private final ModelPart LittleLeg3;
	private final ModelPart LittleLeg2;
	private final ModelPart LittleLeg4;
	private final ModelPart Tail;
	private final ModelPart Body;
	private final ModelPart r_legs;
	private final ModelPart l_legs;

	public DeepCrawlerModel(ModelPart base) {
		this.Body = base.getChild("Body");
		this.Head = Body.getChild("Head");
		this.r_legs = Head.getChild("r_legs");
		this.l_legs = Head.getChild("l_legs");
		this.BigLeg1 = this.l_legs.getChild("BigLeg1");
		this.BigLeg3 = this.r_legs.getChild("BigLeg3");
		this.BigLeg2 = this.l_legs.getChild("BigLeg2");
		this.BigLeg4 = this.r_legs.getChild("BigLeg4");
		this.LittleLeg1 = this.l_legs.getChild("LittleLeg1");
		this.LittleLeg3 = this.r_legs.getChild("LittleLeg3");
		this.LittleLeg2 = this.l_legs.getChild("LittleLeg2");
		this.LittleLeg4 = this.r_legs.getChild("LittleLeg4");
		this.Tail = Body.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -3.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 26).addBox(-5.5F, -2.5F, -8.0F, 11.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition r_legs = Head.addOrReplaceChild("r_legs", CubeListBuilder.create(), PartPose.offset(-4.0F, 1.5F, -3.0F));

		PartDefinition LittleLeg4 = r_legs.addOrReplaceChild("LittleLeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = LittleLeg4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 11).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, -0.2618F, 0.0F));

		PartDefinition LittleLeg3 = r_legs.addOrReplaceChild("LittleLeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = LittleLeg3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.1745F));

		PartDefinition BigLeg4 = r_legs.addOrReplaceChild("BigLeg4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = BigLeg4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(10, 22).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition BigLeg3 = r_legs.addOrReplaceChild("BigLeg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition cube_r4 = BigLeg3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(20, 22).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, -0.1745F));

		PartDefinition l_legs = Head.addOrReplaceChild("l_legs", CubeListBuilder.create(), PartPose.offset(4.0F, 1.5F, -3.0F));

		PartDefinition LittleLeg2 = l_legs.addOrReplaceChild("LittleLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = LittleLeg2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(17, 11).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.2618F, 0.0F));

		PartDefinition LittleLeg1 = l_legs.addOrReplaceChild("LittleLeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = LittleLeg1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.1745F));

		PartDefinition BigLeg2 = l_legs.addOrReplaceChild("BigLeg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = BigLeg2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(10, 22).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BigLeg1 = l_legs.addOrReplaceChild("BigLeg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition cube_r8 = BigLeg1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 22).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.1745F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -1.9924F, -0.1743F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Spike = Tail.addOrReplaceChild("Spike", CubeListBuilder.create().texOffs(20, 11).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(21, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0076F, 7.8257F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Tail.yRot = Mth.cos(limbSwing * 0.5F) * 0.7F * limbSwingAmount;
		this.LittleLeg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.BigLeg3.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.BigLeg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.BigLeg4.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.BigLeg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.LittleLeg3.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
		this.LittleLeg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
		this.LittleLeg4.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.7F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}