package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.PinkfinIdol;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class PinkfinIdolModel<T extends PinkfinIdol> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart bb_main;

	public PinkfinIdolModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.Fin1 = root.getChild("Fin1");
		this.Fin2 = root.getChild("Fin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 10.0F));

		PartDefinition Fin1 = partdefinition.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 20.0F, 2.0F, -0.4363F, 0.7418F, 0.0F));

		PartDefinition Fin2 = partdefinition.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.6F, 20.0F, 2.0F, -0.4363F, -0.7418F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(39, 41).addBox(-2.5F, -18.0F, -3.0F, 5.0F, 18.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -6.0F, -13.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -23.0F, 3.0F, 0.0F, 28.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}