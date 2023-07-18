package com.peeko32213.unusualfishmod.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.BaskingTiamatBaby;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BaskingTiamatBabyModel<T extends BaskingTiamatBaby> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackBody;
	private final ModelPart Tail;

	public BaskingTiamatBabyModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Tail = this.BackBody.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 22).addBox(-1.5F, -3.0F, -16.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(25, 7).addBox(-4.5F, -1.0F, -13.0F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -3.0F, -8.0F, 3.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -2.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(18, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -2.0F, -11.0F, -0.2042F, -0.3378F, 0.2967F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.25F, -2.0F, -11.0F, -0.2042F, 0.3378F, -0.2967F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -4.5F, 0.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, 0.0F, 5.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).mirror().addBox(-4.0F, 0.0F, 5.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.5F, 11.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -5.5F, 0.0F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);
		this.Tail.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);

		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}