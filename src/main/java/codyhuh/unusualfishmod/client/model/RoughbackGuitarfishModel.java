package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.ulitity.RoughbackGuitarfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RoughbackGuitarfishModel<T extends RoughbackGuitarfish> extends EntityModel<T> {
	private final ModelPart BackBody;
	private final ModelPart Backfin1;
	private final ModelPart Backfin2;
	private final ModelPart Tail;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart bb_main;

	public RoughbackGuitarfishModel(ModelPart root) {
		this.FrontFin1 = root.getChild("FrontFin1");
		this.FrontFin2 = root.getChild("FrontFin2");
		this.BackBody = root.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.Backfin1 = this.BackBody.getChild("BackFin1");
		this.Backfin2 = this.BackBody.getChild("BackFin2");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BackBody = partdefinition.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 15.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition BackFin1 = BackBody.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -5.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackFin2 = BackBody.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -5.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition FrontFin1 = partdefinition.addOrReplaceChild("FrontFin1", CubeListBuilder.create().texOffs(22, 0).addBox(0.0F, 0.0F, -11.0F, 9.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 23.0F, 3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition FrontFin2 = partdefinition.addOrReplaceChild("FrontFin2", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-9.0F, 0.0F, -11.0F, 9.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.5F, 23.0F, 3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -4.0F, -8.0F, 11.0F, 4.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(22, 27).addBox(-2.5F, -3.0F, -16.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(2.0F, -5.0F, -4.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(12, 10).addBox(0.0F, -7.0F, 11.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -4.0F, -14.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).mirror().addBox(-2.0F, -5.0F, -4.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 12).mirror().addBox(0.0F, -5.0F, -7.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.FrontFin1.zRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.FrontFin2.zRot = f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		BackBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontFin1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontFin2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}