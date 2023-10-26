package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.UnusualFishMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import codyhuh.unusualfishmod.common.entity.ambient.cave.BlindSailfin;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BlindSailfinModel<T extends BlindSailfin> extends EntityModel<T> {
	private final ModelPart Tail;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart bb_main;

	public BlindSailfinModel(ModelPart root) {
		this.Tail = root.getChild("Tail");
		this.FrontFin1 = root.getChild("FrontFin1");
		this.FrontFin2 = root.getChild("FrontFin2");
		this.BackFin1 = root.getChild("BackFin1");
		this.BackFin2 = root.getChild("BackFin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, 4.0F));

		PartDefinition FrontFin1 = partdefinition.addOrReplaceChild("FrontFin1", CubeListBuilder.create().texOffs(10, 0).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, -3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition FrontFin2 = partdefinition.addOrReplaceChild("FrontFin2", CubeListBuilder.create().texOffs(10, 0).mirror().addBox(-4.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 23.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition BackFin1 = partdefinition.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(10, 2).addBox(0.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 23.0F, 1.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BackFin2 = partdefinition.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(10, 2).mirror().addBox(-2.0F, 0.0F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 23.0F, 1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(14, 15).addBox(-2.0F, -9.0F, -4.0F, 4.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -3.0F, -8.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -10.0F, 2.0F, 0.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

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
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}