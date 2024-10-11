package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.HatchetFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class HatchetFishModel<T extends HatchetFish> extends EntityModel<T> {
	private final ModelPart Root;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;

	public HatchetFishModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.Tail = Root.getChild("Tail");
		this.Fin1 = Root.getChild("Fin1");
		this.Fin2 = Root.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -3.0F, 2.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 9).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -2.0F));

		PartDefinition Fin1 = Root.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, 2.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Root.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 2.0F, -1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.6109F, 0.0F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(6, 14).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition Eye1 = Root.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(8, 0).addBox(-3.0F, -1.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -1.0F));

		PartDefinition Jaw = Root.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -2.0F));

		PartDefinition cube_r3 = Jaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 4).addBox(-1.5F, -4.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}