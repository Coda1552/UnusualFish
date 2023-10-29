package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.DroopingGourami;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DroopingGouramiModel<T extends DroopingGourami> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Roots1;
	private final ModelPart Roots2;
	private final ModelPart bb_main;

	public DroopingGouramiModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.Roots1 = root.getChild("Roots1");
		this.Roots2 = root.getChild("Roots2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(16, 9).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.5F, 3.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(16, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 22.0F, -0.5F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(16, 6).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 22.0F, -0.5F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Roots1 = partdefinition.addOrReplaceChild("Roots1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 24.0F, -1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Roots2 = partdefinition.addOrReplaceChild("Roots2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 24.0F, -1.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(16, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(9, 0).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.25F * Mth.sin(0.5F * ageInTicks);
		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Roots1.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.7F * limbSwingAmount;
		this.Roots2.xRot = Mth.cos(limbSwing * 0.3F) * 0.7F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Roots1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Roots2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}