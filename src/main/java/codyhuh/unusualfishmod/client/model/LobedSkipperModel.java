package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.ambient.land.LobedSkipper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class LobedSkipperModel<T extends LobedSkipper> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart TopFin;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart BottomFin;
	private final ModelPart bb_main;

	public LobedSkipperModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.TopFin = root.getChild("TopFin");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.FrontFin1 = root.getChild("FrontFin1");
		this.FrontFin2 = root.getChild("FrontFin2");
		this.BackFin1 = root.getChild("BackFin1");
		this.BackFin2 = root.getChild("BackFin2");
		this.BottomFin = root.getChild("BottomFin");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -4.0F, 0.0F, 0.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 3.0F));

		PartDefinition TopFin = partdefinition.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Eye1 = partdefinition.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(12, 22).addBox(0.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 18.0F, -4.0F, 0.1309F, 0.0F, 0.1745F));

		PartDefinition Eye2 = partdefinition.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(12, 22).mirror().addBox(-2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 18.0F, -4.0F, 0.1309F, 0.0F, -0.1745F));

		PartDefinition FrontFin1 = partdefinition.addOrReplaceChild("FrontFin1", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 0.0F, -3.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 22.0F, -1.0F, -0.0843F, -0.6785F, 0.4562F));

		PartDefinition FrontFin2 = partdefinition.addOrReplaceChild("FrontFin2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 22.0F, -1.0F, -0.0843F, 0.6785F, -0.4562F));

		PartDefinition BackFin1 = partdefinition.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(19, 4).addBox(-1.0F, 0.0F, -1.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 23.0F, 3.0F, -0.215F, -0.0376F, 0.1786F));

		PartDefinition BackFin2 = partdefinition.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(19, 4).mirror().addBox(-3.0F, 0.0F, -1.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 23.0F, 3.0F, -0.215F, 0.0376F, -0.1786F));

		PartDefinition BottomFin = partdefinition.addOrReplaceChild("BottomFin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -3.5F));

		PartDefinition BottomFinLeft = BottomFin.addOrReplaceChild("BottomFinLeft", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, 0.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition BottomFinRight = BottomFin.addOrReplaceChild("BottomFinRight", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition BottomFinFront = BottomFin.addOrReplaceChild("BottomFinFront", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition BottomFinBack = BottomFin.addOrReplaceChild("BottomFinBack", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -7.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(0.0F, -8.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Tail.yRot = Mth.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tail.render(poseStack, buffer, packedLight, packedOverlay);
		TopFin.render(poseStack, buffer, packedLight, packedOverlay);
		Eye1.render(poseStack, buffer, packedLight, packedOverlay);
		Eye2.render(poseStack, buffer, packedLight, packedOverlay);
		FrontFin1.render(poseStack, buffer, packedLight, packedOverlay);
		FrontFin2.render(poseStack, buffer, packedLight, packedOverlay);
		BackFin1.render(poseStack, buffer, packedLight, packedOverlay);
		BackFin2.render(poseStack, buffer, packedLight, packedOverlay);
		BottomFin.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}