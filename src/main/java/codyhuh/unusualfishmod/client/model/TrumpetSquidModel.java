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
	private final ModelPart LeftArms;
	private final ModelPart RightArms;
	private final ModelPart head;

	public TrumpetSquidModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.head = Body.getChild("head");
		this.LeftArms = head.getChild("LeftArms");
		this.RightArms = head.getChild("RightArms");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 19.0F, -2.0F));

		PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 30).addBox(-2.5F, -3.0F, 0.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition LeftArm = head.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 1.0F, 3.0F));

		PartDefinition RightArm = head.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 1.0F, 3.0F));

		PartDefinition LeftArms = head.addOrReplaceChild("LeftArms", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 2.0F, 1.5F));

		PartDefinition RightArms = head.addOrReplaceChild("RightArms", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 2.0F, 1.5F));

		PartDefinition shell = Body.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 29).addBox(-4.0F, -5.0F, -2.0F, 9.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(24, 30).addBox(-1.0F, -3.0F, -22.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -3.0F, -14.0F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(24, 15).addBox(-0.5F, -4.0F, -17.0F, 2.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-0.5F, -10.0F, -22.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -10.0F, -20.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 6.0F));

		PartDefinition lid = shell.addOrReplaceChild("lid", CubeListBuilder.create(), PartPose.offset(0.5F, -5.0F, 1.0F));

		PartDefinition cube_r1 = lid.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 0).addBox(-3.5F, -1.0F, 1.0F, 7.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = lid.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftArms.yRot = -Mth.cos(limbSwing * 0.5F) * 1.0F * limbSwingAmount;
		this.RightArms.yRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.0F * limbSwingAmount;

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