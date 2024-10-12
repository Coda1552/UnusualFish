package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.StoutBichir;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class StoutBichirModel<T extends StoutBichir> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Body;

	public StoutBichirModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = Body.getChild("Tail");
		this.Fin1 = Body.getChild("Fin1");
		this.Fin2 = Body.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, -11.0F, 2.0F, 0.0F, 8.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.5F, -5.0F, -2.0F, 9.0F, 9.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -10.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(21, 34).addBox(0.0F, 0.0F, -4.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 34).mirror().addBox(0.0F, 0.0F, -4.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition SideFin1 = Body.addOrReplaceChild("SideFin1", CubeListBuilder.create(), PartPose.offset(4.5F, 4.0F, 12.0F));

		PartDefinition cube_r3 = SideFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition SideFin2 = Body.addOrReplaceChild("SideFin2", CubeListBuilder.create(), PartPose.offset(-4.5F, 4.0F, 12.0F));

		PartDefinition cube_r4 = SideFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(20, 26).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(19, 0).addBox(-7.0F, 0.0F, 1.0F, 14.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 15.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 44).addBox(-3.5F, -5.0F, -19.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}