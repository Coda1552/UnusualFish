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
	private final ModelPart root;
	private final ModelPart body;

	public BrickSnailModel(ModelPart base) {
		this.root = base.getChild("Root");
		this.body = root.getChild("body");
		this.Shell = root.getChild("Shell");
		this.Eye1 = root.getChild("Eye1");
		this.Eye2 = root.getChild("Eye2");
		this.MouthBit1 = body.getChild("MouthBit1");
		this.MouthBit2 = body.getChild("MouthBit2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, -2.0F));

		PartDefinition Shell = Root.addOrReplaceChild("Shell", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 2.0F));

		PartDefinition cube_r1 = Shell.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -1.0F, 5.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Eye1 = Root.addOrReplaceChild("Eye1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -1.0F, -0.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Eye1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Eye2 = Root.addOrReplaceChild("Eye2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -1.0F, -0.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Eye2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition body = Root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 13).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.5F));

		PartDefinition MouthBit1 = body.addOrReplaceChild("MouthBit1", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.5F, -2.5F));

		PartDefinition MouthBit2 = body.addOrReplaceChild("MouthBit2", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 0.5F, -2.5F));

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
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}