package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.RoughbackGuitarfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RoughbackGuitarfishModel<T extends RoughbackGuitarfish> extends EntityModel<T> {
	private final ModelPart BackBody;
	private final ModelPart root;
	private final ModelPart Tail;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;

	public RoughbackGuitarfishModel(ModelPart base) {
		this.root = base.getChild("Root");
		this.FrontFin1 = root.getChild("FrontFin1");
		this.FrontFin2 = root.getChild("FrontFin2");
		this.BackBody = root.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -2.0F, -5.0F, 11.0F, 4.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(1, 65).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(41, 27).addBox(-2.5F, -1.0F, -13.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -3.0F));

		PartDefinition BackBody = Root.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -5.0F, 0.0F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 18.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 10.0F));

		PartDefinition BackFin1 = BackBody.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 5.0F));

		PartDefinition cube_r1 = BackFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -5.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BackFin2 = BackBody.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 5.0F));

		PartDefinition cube_r2 = BackFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, -5.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition FrontFin1 = Root.addOrReplaceChild("FrontFin1", CubeListBuilder.create(), PartPose.offset(5.0F, 1.5F, 6.0F));

		PartDefinition cube_r3 = FrontFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -0.5F, -10.0F, 9.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition FrontFin2 = Root.addOrReplaceChild("FrontFin2", CubeListBuilder.create(), PartPose.offset(-5.0F, 1.5F, 6.0F));

		PartDefinition cube_r4 = FrontFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-9.0F, -0.5F, -10.0F, 9.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -0.1309F));

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
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}