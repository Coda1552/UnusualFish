package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.SnowflakeTailFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SnowflakeTailFishModel<T extends SnowflakeTailFish> extends EntityModel<T> {
	private final ModelPart BottomFin1;
	private final ModelPart BottomFin2;
	private final ModelPart Tail;
	private final ModelPart Fin2;
	private final ModelPart Fin1;
	private final ModelPart fish;

	public SnowflakeTailFishModel(ModelPart root) {
		this.fish = root.getChild("fish");
		this.BottomFin1 = fish.getChild("bottom_fin_left");
		this.BottomFin2 = fish.getChild("bottom_fin_right");
		this.Tail = fish.getChild("tail");
		this.Fin2 = fish.getChild("r_fin");
		this.Fin1 = fish.getChild("l_fin");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fish = partdefinition.addOrReplaceChild("fish", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition bottom_fin_left = fish.addOrReplaceChild("bottom_fin_left", CubeListBuilder.create(), PartPose.offset(1.0F, 2.0F, 0.0F));

		PartDefinition cube_r1 = bottom_fin_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 4).addBox(1.0F, 0.0F, -1.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.3491F, 0.1309F, 0.0F));

		PartDefinition bottom_fin_right = fish.addOrReplaceChild("bottom_fin_right", CubeListBuilder.create(), PartPose.offset(-1.0F, 2.0F, 0.0F));

		PartDefinition cube_r2 = bottom_fin_right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 0.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.3491F, -0.1309F, 0.0F));

		PartDefinition tail = fish.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(19, 19).addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 3.0F));

		PartDefinition r_fin = fish.addOrReplaceChild("r_fin", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, -1.0F));

		PartDefinition cube_r3 = r_fin.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 7).addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.9163F, -0.2618F));

		PartDefinition l_fin = fish.addOrReplaceChild("l_fin", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, -1.0F));

		PartDefinition cube_r4 = l_fin.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.9163F, 0.2618F));

		PartDefinition body = fish.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(0.0F, 1.0F, 1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top_fin = fish.addOrReplaceChild("top_fin", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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
		this.BottomFin1.xRot = Mth.cos(limbSwing * 0.3F + (float)Math.PI) * 0.7F * limbSwingAmount;
		this.BottomFin2.xRot = Mth.cos(limbSwing * 0.3F) * 0.7F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}