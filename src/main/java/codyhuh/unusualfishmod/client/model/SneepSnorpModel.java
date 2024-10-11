package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.SneepSnorp;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SneepSnorpModel<T extends SneepSnorp> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Root;

	public SneepSnorpModel(ModelPart base) {
		this.Root = base.getChild("Root");
		this.Tail = Root.getChild("Tail");
		this.Fin1 = Root.getChild("Fin1");
		this.Fin2 = Root.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(10, 10).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(0.0F, -5.0F, 1.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition Fin1 = Root.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.5F, 2.0F, 0.0F, 0.6545F, 0.0F));

		PartDefinition Fin2 = Root.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 1.5F, 2.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition RightBottomFin = Root.addOrReplaceChild("RightBottomFin", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition RightBottomFin_r1 = RightBottomFin.addOrReplaceChild("RightBottomFin_r1", CubeListBuilder.create().texOffs(10, 13).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftBottomFin = Root.addOrReplaceChild("LeftBottomFin", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition LeftBottomFin_r1 = LeftBottomFin.addOrReplaceChild("LeftBottomFin_r1", CubeListBuilder.create().texOffs(10, 13).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

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