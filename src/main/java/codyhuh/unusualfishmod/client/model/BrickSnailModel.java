package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.BrickSnail;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BrickSnailModel<T extends BrickSnail> extends EntityModel<T> {
	private final ModelPart Shell;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart MouthBit1;
	private final ModelPart MouthBit2;
	private final ModelPart bb_main;

	public BrickSnailModel(ModelPart root) {
		this.Shell = root.getChild("Shell");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.MouthBit1 = root.getChild("MouthBit1");
		this.MouthBit2 = root.getChild("MouthBit2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Shell = partdefinition.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, 0.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -1.0F, -0.1309F, 0.0F, 0.0F));


		PartDefinition Eye1 = partdefinition.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 22.0F, -2.0F, 0.2618F, 0.0F, 0.2618F));

		PartDefinition Eye2 = partdefinition.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 22.0F, -2.0F, 0.2618F, 0.0F, -0.2618F));

		PartDefinition MouthBit1 = partdefinition.addOrReplaceChild("MouthBit1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 24.0F, -3.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition MouthBit2 = partdefinition.addOrReplaceChild("MouthBit2", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 24.0F, -3.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(11, 11).addBox(-1.5F, -1.0F, 2.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Eye1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Eye2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MouthBit1.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MouthBit2.yRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Shell.xRot = -f * 0.20F * Mth.sin(0.01F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Shell.render(poseStack, buffer, packedLight, packedOverlay);
		Eye1.render(poseStack, buffer, packedLight, packedOverlay);
		Eye2.render(poseStack, buffer, packedLight, packedOverlay);
		MouthBit1.render(poseStack, buffer, packedLight, packedOverlay);
		MouthBit2.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}