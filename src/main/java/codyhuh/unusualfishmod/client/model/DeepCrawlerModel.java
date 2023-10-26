package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.ulitity.DeepCrawler;
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
	private final ModelPart Spike;

	public DeepCrawlerModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.BigLeg1 = this.Head.getChild("BigLeg1");
		this.BigLeg3 = this.Head.getChild("BigLeg3");
		this.BigLeg2 = this.Head.getChild("BigLeg2");
		this.BigLeg4 = this.Head.getChild("BigLeg4");
		this.LittleLeg1 = this.Head.getChild("LittleLeg1");
		this.LittleLeg3 = this.Head.getChild("LittleLeg3");
		this.LittleLeg2 = this.Head.getChild("LittleLeg2");
		this.LittleLeg4 = this.Head.getChild("LittleLeg4");
		this.Tail = root.getChild("Tail");
		this.Spike = this.Tail.getChild("Spike");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 11).addBox(3.5F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).mirror().addBox(-5.5F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(-5.5F, -4.0F, -7.0F, 11.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 1.0F));

		PartDefinition BigLeg1 = Head.addOrReplaceChild("BigLeg1", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -1.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, -3.5F, -0.9233F, 0.4484F, -1.0602F));

		PartDefinition BigLeg3 = Head.addOrReplaceChild("BigLeg3", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, -1.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 0.0F, -3.5F, -0.9233F, -0.4484F, 1.0602F));

		PartDefinition BigLeg2 = Head.addOrReplaceChild("BigLeg2", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -1.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 0.0F, -2.75F, 0.0848F, -0.1366F, -0.9083F));

		PartDefinition BigLeg4 = Head.addOrReplaceChild("BigLeg4", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-4.0F, -1.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 0.0F, -2.75F, 0.0848F, 0.1366F, 0.9083F));

		PartDefinition LittleLeg1 = Head.addOrReplaceChild("LittleLeg1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, -0.5F, 0.2618F, 0.0F, -1.309F));

		PartDefinition LittleLeg3 = Head.addOrReplaceChild("LittleLeg3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.2618F, 0.0F, 1.309F));

		PartDefinition LittleLeg2 = Head.addOrReplaceChild("LittleLeg2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.25F, 0.0F, 1.0F, 0.6545F, 0.0F, -1.309F));

		PartDefinition LittleLeg4 = Head.addOrReplaceChild("LittleLeg4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.25F, 0.0F, 1.0F, 0.6545F, 0.0F, 1.309F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, 1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Spike = Tail.addOrReplaceChild("Spike", CubeListBuilder.create().texOffs(21, 13).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 8.0F, 0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Tail.yRot = Mth.cos(limbSwing * 0.5F) * 1.7F * limbSwingAmount;
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
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}