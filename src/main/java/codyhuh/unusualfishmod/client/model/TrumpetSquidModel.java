package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.TrumpetSquid;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import java.util.Collections;

public class TrumpetSquidModel<T extends TrumpetSquid> extends AgeableListModel<T> {
	private final ModelPart Body;
	private final ModelPart TopArms;
	private final ModelPart BottomArms;
	private final ModelPart LeftArms;
	private final ModelPart RightArms;
	private final ModelPart FeederArm1;
	private final ModelPart FeederArm2;

	public TrumpetSquidModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.TopArms = this.Body.getChild("toparms");
		this.BottomArms = this.Body.getChild("bottomarms");
		this.LeftArms = this.Body.getChild("leftarms");
		this.RightArms = this.Body.getChild("rightarms");
		this.FeederArm1 = this.Body.getChild("feederarm1");
		this.FeederArm2 = this.Body.getChild("feederarm2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 34).addBox(-2.5F, 0.0F, 14.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-2.5F, -3.0F, 10.0F, 5.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(18, 34).addBox(-1.5F, -2.0F, -25.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -6.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(-1.0F, -4.0F, 8.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.5F, -3.0F, -19.0F, 5.0F, 5.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, -2.0F));

		PartDefinition TopArms = Body.addOrReplaceChild("toparms", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 18.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition BottomArms = Body.addOrReplaceChild("bottomarms", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 18.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition LeftArms = Body.addOrReplaceChild("leftarms", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.0F, 18.0F, -0.4371F, -0.0849F, -0.3816F));

		PartDefinition RightArms = Body.addOrReplaceChild("rightarms", CubeListBuilder.create().texOffs(10, 28).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.0F, 18.0F, -0.4371F, 0.0849F, 0.3816F));

		PartDefinition FeederArm1 = Body.addOrReplaceChild("feederarm1", CubeListBuilder.create().texOffs(0, 34).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, 18.0F, -0.3494F, 0.041F, -0.0149F));

		PartDefinition FeederArm2 = Body.addOrReplaceChild("feederarm2", CubeListBuilder.create().texOffs(10, 20).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.0F, 18.0F, -0.3494F, -0.041F, 0.0149F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.FeederArm1.yRot = -Mth.cos(limbSwing * 0.3F) * 0.6F * limbSwingAmount;
		this.FeederArm2.yRot = -Mth.cos(limbSwing * 0.3F + (float) Math.PI) * 0.6F * limbSwingAmount;
		this.LeftArms.yRot = -Mth.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
		this.RightArms.yRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.0F * limbSwingAmount;
		this.TopArms.xRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 0.5F * limbSwingAmount;

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	protected Iterable<ModelPart> headParts() {
		return Collections.emptyList();
	}

	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(Body);
	}
}