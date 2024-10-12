package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.VoltAngler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class VoltAnglerModel<T extends VoltAngler> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart Jaw;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;

	public VoltAnglerModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Jaw = this.Body.getChild("Jaw");
		this.Tail = this.Body.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -6.0F, -2.0F, 13.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(0.0F, -10.0F, 2.0F, 0.0F, 20.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(18, 16).addBox(0.0F, -13.0F, -11.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.5F, -6.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).mirror().addBox(-7.5F, -6.0F, 0.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 18.0F, -5.0F));

		PartDefinition Jaw = Body.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(18, 34).addBox(-4.5F, -8.0F, -2.0F, 9.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(35, 26).addBox(-4.5F, -7.0F, 0.0F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).addBox(3.5F, -11.0F, -1.0F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(40, 0).mirror().addBox(-3.5F, -11.0F, -1.0F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 12.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offsetAndRotation(6.5F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(38, 25).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 25).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition BottomFin1 = Body.addOrReplaceChild("BottomFin1", CubeListBuilder.create(), PartPose.offset(3.0F, 6.0F, 6.0F));

		PartDefinition fin_r1 = BottomFin1.addOrReplaceChild("fin_r1", CubeListBuilder.create().texOffs(18, 35).addBox(0.0F, 0.0F, -4.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition BottomFin2 = Body.addOrReplaceChild("BottomFin2", CubeListBuilder.create(), PartPose.offset(-3.0F, 6.0F, 6.0F));

		PartDefinition fin_r2 = BottomFin2.addOrReplaceChild("fin_r2", CubeListBuilder.create().texOffs(18, 35).mirror().addBox(0.0F, 0.0F, -4.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

		if (entity.isInWater()) {
			this.Body.xRot = headPitch * ((float)Math.PI / 180F);
			this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		}
		else {
			this.Body.xRot = 0.0F;
			this.Body.yRot = 0.0F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}