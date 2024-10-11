package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.CrimsonshellSquid;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import java.util.Collections;

public class CrimsonshellSquidModel<T extends CrimsonshellSquid> extends AgeableListModel<T> {
	private final ModelPart Body;
	private final ModelPart BigArm1;
	private final ModelPart BigArm2;
	private final ModelPart MidArm1;
	private final ModelPart MidArm2;
	private final ModelPart SmallArm1;
	private final ModelPart SmallArm3;
	private final ModelPart SmallArm2;
	private final ModelPart SmallArm4;
	private final ModelPart l_arms;
	private final ModelPart r_arms;

	public CrimsonshellSquidModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.l_arms = Body.getChild("l_arms");
		this.r_arms = Body.getChild("r_arms");
		this.BigArm1 = this.l_arms.getChild("BigArm1");
		this.BigArm2 = this.r_arms.getChild("BigArm2");
		this.MidArm1 = this.l_arms.getChild("MidArm1");
		this.MidArm2 = this.r_arms.getChild("MidArm2");
		this.SmallArm1 = this.r_arms.getChild("SmallArm1");
		this.SmallArm3 = this.l_arms.getChild("SmallArm3");
		this.SmallArm2 = this.l_arms.getChild("SmallArm2");
		this.SmallArm4 = this.r_arms.getChild("SmallArm4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(0, 23).addBox(-2.5F, -12.0F, -1.0F, 5.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -3.0F));

		PartDefinition Horn1 = Body.addOrReplaceChild("Horn1", CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, -5.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Horn2 = Body.addOrReplaceChild("Horn2", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.0F, -5.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition l_arms = Body.addOrReplaceChild("l_arms", CubeListBuilder.create(), PartPose.offset(2.5F, 0.0F, -5.0F));

		PartDefinition SmallArm2 = l_arms.addOrReplaceChild("SmallArm2", CubeListBuilder.create().texOffs(10, 7).addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.0F, 0.0F, 0.2062F, -0.4F, 0.2727F));

		PartDefinition SmallArm3 = l_arms.addOrReplaceChild("SmallArm3", CubeListBuilder.create().texOffs(10, 10).addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, -0.6229F, -0.4F, 0.2727F));

		PartDefinition MidArm1 = l_arms.addOrReplaceChild("MidArm1", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, -5.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 0.0F, -0.3503F, -0.082F, 0.0299F));

		PartDefinition BigArm1 = l_arms.addOrReplaceChild("BigArm1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2182F, -0.7418F, 0.0F));

		PartDefinition r_arms = Body.addOrReplaceChild("r_arms", CubeListBuilder.create(), PartPose.offset(-2.5F, 0.0F, -5.0F));

		PartDefinition BigArm2 = r_arms.addOrReplaceChild("BigArm2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.2182F, 0.7418F, 0.0F));

		PartDefinition MidArm2 = r_arms.addOrReplaceChild("MidArm2", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(0.0F, -1.0F, -5.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, 0.0F, 0.0F, -0.3503F, 0.082F, -0.0299F));

		PartDefinition SmallArm1 = r_arms.addOrReplaceChild("SmallArm1", CubeListBuilder.create().texOffs(10, 10).mirror().addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, 0.0F, -0.6229F, 0.4F, -0.2727F));

		PartDefinition SmallArm4 = r_arms.addOrReplaceChild("SmallArm4", CubeListBuilder.create().texOffs(10, 7).mirror().addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 1.0F, 0.0F, 0.2062F, 0.4F, -0.2727F));

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