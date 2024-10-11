package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.BlackCapSnail;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BlackcapSnailModel<T extends BlackCapSnail> extends EntityModel<T> {
	private final ModelPart Shell;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Mouth;
	private final ModelPart root;
	private final ModelPart body;

	public BlackcapSnailModel(ModelPart base) {
		this.root = base.getChild("root");
		this.body = root.getChild("body");
		this.Shell = root.getChild("Shell");
		this.Eye1 = body.getChild("Eye1");
		this.Eye2 = body.getChild("Eye2");
		this.Mouth = body.getChild("Mouth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, -1.0F));

		PartDefinition Shell = root.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-1.5F, -9.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(12, 8).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye1 = body.addOrReplaceChild("Eye1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Eye1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Eye2 = body.addOrReplaceChild("Eye2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Eye2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Mouth = body.addOrReplaceChild("Mouth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition cube_r3 = Mouth.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 0).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Eye1.xRot = -f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Eye2.xRot = f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Shell.xRot = -0.15F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}