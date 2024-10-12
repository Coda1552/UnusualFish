package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.BlindSailfin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BlindSailfinModel<T extends BlindSailfin> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart root;

	public BlindSailfinModel(ModelPart base) {
		this.root = base.getChild("Body");
		this.Tail = root.getChild("Tail");
		this.FrontFin1 = root.getChild("FrontFin1");
		this.FrontFin2 = root.getChild("FrontFin2");
		this.BackFin1 = root.getChild("BackFin1");
		this.BackFin2 = root.getChild("BackFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -13.0F, 7.0F, 0.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -7.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(18, 12).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 11.0F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("FrontFin1", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 4.0F));

		PartDefinition cube_r1 = FrontFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("FrontFin2", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 4.0F));

		PartDefinition cube_r2 = FrontFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 8.0F));

		PartDefinition cube_r3 = BackFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 7).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 8.0F));

		PartDefinition cube_r4 = BackFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 7).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.FrontFin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.FrontFin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}