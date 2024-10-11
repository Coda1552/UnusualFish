package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.MuddytopSnail;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class MuddytopSnailModel<T extends MuddytopSnail> extends EntityModel<T> {
	private final ModelPart Shell;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Root;

	public MuddytopSnailModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Shell = Root.getChild("Shell");
		this.Eye1 = Root.getChild("Eye1");
		this.Eye2 = Root.getChild("Eye2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(14, 14).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Eye1 = Root.addOrReplaceChild("Eye1", CubeListBuilder.create(), PartPose.offset(2.0F, -3.0F, 0.0F));

		PartDefinition cube_r1 = Eye1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Eye2 = Root.addOrReplaceChild("Eye2", CubeListBuilder.create(), PartPose.offset(-2.0F, -3.0F, 0.0F));

		PartDefinition cube_r2 = Eye2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Shell = Root.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -7.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, 0.5F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Mouth = Shell.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(20, 17).addBox(-1.0F, -0.3372F, -1.4981F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0436F, 0.0F, 0.0F));

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
		this.Shell.xRot = -f * 0.20F * Mth.sin(0.01F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}