package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.EyelashFish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class EyelashFishModel<T extends EyelashFish> extends EntityModel<T> {
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Eyelash1;
	private final ModelPart Eyelash2;
	private final ModelPart Tail;
	private final ModelPart Fish;

	public EyelashFishModel(ModelPart root) {
		this.Fish = root.getChild("fish");
		this.Fin1 = Fish.getChild("l_fin");
		this.Fin2 = Fish.getChild("r_fin");
		this.Eyelash1 = Fish.getChild("l_eyelash");
		this.Eyelash2 = Fish.getChild("r_eyelash");
		this.Tail = Fish.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fish = partdefinition.addOrReplaceChild("fish", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition l_fin = fish.addOrReplaceChild("l_fin", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, 0.0F));

		PartDefinition cube_r1 = l_fin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.8727F, 0.0F));

		PartDefinition r_fin = fish.addOrReplaceChild("r_fin", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, 0.0F));

		PartDefinition cube_r2 = r_fin.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition l_eyelash = fish.addOrReplaceChild("l_eyelash", CubeListBuilder.create(), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition cube_r3 = l_eyelash.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -1.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition r_eyelash = fish.addOrReplaceChild("r_eyelash", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, 0.0F));

		PartDefinition cube_r4 = r_eyelash.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition body = fish.addOrReplaceChild("body", CubeListBuilder.create().texOffs(11, 10).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, 0.4363F, 0.0F, 0.4363F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, 0.4363F, 0.0F, -0.4363F));

		PartDefinition tail = fish.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.25F * Mth.sin(0.5F * ageInTicks);
		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Eyelash1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Eyelash2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Fish.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}