package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class CrimsonshellSquidModel<T extends CrimsonshellSquid> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart BigArm1;
	private final ModelPart BigArm2;
	private final ModelPart MidArm1;
	private final ModelPart MidArm2;
	private final ModelPart MidArm3;
	private final ModelPart MidArm4;
	private final ModelPart SmallArm1;
	private final ModelPart SmallArm3;
	private final ModelPart SmallArm2;
	private final ModelPart SmallArm4;
	private final ModelPart Horn1;
	private final ModelPart Horn2;

	public CrimsonshellSquidModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BigArm1 = this.Body.getChild("BigArm1");
		this.BigArm2 = this.Body.getChild("BigArm2");
		this.MidArm1 = this.Body.getChild("MidArm1");
		this.MidArm2 = this.Body.getChild("MidArm2");
		this.MidArm3 = this.Body.getChild("MidArm3");
		this.MidArm4 = this.Body.getChild("MidArm4");
		this.SmallArm1 = this.Body.getChild("SmallArm1");
		this.SmallArm3 = this.Body.getChild("SmallArm3");
		this.SmallArm2 = this.Body.getChild("SmallArm2");
		this.SmallArm4 = this.Body.getChild("SmallArm4");
		this.Horn1 = this.Body.getChild("Horn1");
		this.Horn2 = this.Body.getChild("Horn2");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, -8.0F, 5.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-3.0F, -9.0F, -8.0F, 6.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));

		PartDefinition BigArm1 = Body.addOrReplaceChild("BigArm1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.0F, 10.0F, -0.3491F, 0.48F, 0.0F));

		PartDefinition BigArm2 = Body.addOrReplaceChild("BigArm2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 2.0F, 10.0F, -0.3491F, -0.48F, 0.0F));

		PartDefinition MidArm1 = Body.addOrReplaceChild("MidArm1", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 4.0F, 10.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition MidArm3 = Body.addOrReplaceChild("MidArm3", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.75F, 4.0F, 10.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition MidArm2 = Body.addOrReplaceChild("MidArm2", CubeListBuilder.create().texOffs(0, 6).addBox(0.1403F, -0.0049F, 0.0078F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 3.0F, 10.0F, -0.4735F, -0.045F, 0.1504F));

		PartDefinition MidArm4 = Body.addOrReplaceChild("MidArm4", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(-0.1403F, -0.0049F, 0.0078F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.25F, 3.0F, 10.0F, -0.4735F, 0.045F, -0.1504F));

		PartDefinition SmallArm1 = Body.addOrReplaceChild("SmallArm1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 10.0F, 0.1712F, 0.3933F, -0.0082F));

		PartDefinition SmallArm3 = Body.addOrReplaceChild("SmallArm3", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.0F, 10.0F, 0.1712F, -0.3933F, 0.0082F));

		PartDefinition SmallArm2 = Body.addOrReplaceChild("SmallArm2", CubeListBuilder.create().texOffs(0, 10).addBox(0.1329F, -0.0304F, -0.3209F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 10.0F, -0.4557F, 0.5178F, 0.3205F));

		PartDefinition SmallArm4 = Body.addOrReplaceChild("SmallArm4", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-0.1329F, -0.0304F, -0.3209F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.0F, 10.0F, -0.4557F, -0.5178F, -0.3205F));

		PartDefinition Horn1 = Body.addOrReplaceChild("Horn1", CubeListBuilder.create().texOffs(10, 8).addBox(0.0F, -6.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Horn2 = Body.addOrReplaceChild("Horn2", CubeListBuilder.create().texOffs(10, 8).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 8.0F, 0.0F, 0.0F, -0.4363F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BigArm1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.BigArm2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SmallArm2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SmallArm4.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SmallArm1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SmallArm3.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidArm1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidArm2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidArm3.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.MidArm4.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}