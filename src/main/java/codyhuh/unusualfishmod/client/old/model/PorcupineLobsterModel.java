package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.PorcupineLobster;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class PorcupineLobsterModel<T extends PorcupineLobster> extends EntityModel<T> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Antenae1;
	private final ModelPart Antenae2;
	private final ModelPart LowerMidSpike1;
	private final ModelPart LowerMidSpike2;
	private final ModelPart Left_legs;
	private final ModelPart Right_legs;
	private final ModelPart Leg1;
	private final ModelPart Leg2;
	private final ModelPart Leg3;
	private final ModelPart Leg4;
	private final ModelPart Leg5;
	private final ModelPart Leg6;
	private final ModelPart Leg7;
	private final ModelPart Leg8;

	public PorcupineLobsterModel(ModelPart base) {
		this.root = base.getChild("Root");
		this.Body = root.getChild("Body");
		this.BackBody = root.getChild("BackBody");
		this.Antenae1 = Body.getChild("Antenae1");
		this.Antenae2 = Body.getChild("Antenae2");
		this.LowerMidSpike1 = Body.getChild("LowerMidSpike1");
		this.LowerMidSpike2 = Body.getChild("LowerMidSpike2");
		this.Right_legs = root.getChild("Right_legs");
		this.Left_legs = root.getChild("Left_legs");
		this.Leg1 = Left_legs.getChild("Leg1");
		this.Leg2 = Left_legs.getChild("Leg2");
		this.Leg3 = Left_legs.getChild("Leg3");
		this.Leg4 = Right_legs.getChild("Leg4");
		this.Leg5 = Right_legs.getChild("Leg5");
		this.Leg6 = Right_legs.getChild("Leg6");
		this.Leg7 = Left_legs.getChild("Leg7");
		this.Leg8 = Right_legs.getChild("Leg8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -10.0F, -6.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(2.0F, -13.0F, -8.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).mirror().addBox(-2.0F, -13.0F, -8.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition BackSpines1 = Body.addOrReplaceChild("BackSpines1", CubeListBuilder.create().texOffs(27, 10).addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -1.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackSpines2 = Body.addOrReplaceChild("BackSpines2", CubeListBuilder.create().texOffs(28, 9).addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -2.0F));

		PartDefinition BackSpines3 = Body.addOrReplaceChild("BackSpines3", CubeListBuilder.create().texOffs(27, 10).mirror().addBox(0.0F, -2.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -10.0F, -1.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Antenae1 = Body.addOrReplaceChild("Antenae1", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -5.0F, -14.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, -6.0F, -0.2618F, -0.6109F, 0.0F));

		PartDefinition Antenae2 = Body.addOrReplaceChild("Antenae2", CubeListBuilder.create().texOffs(0, 2).mirror().addBox(0.0F, -5.0F, -14.0F, 0.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -8.0F, -6.0F, -0.2618F, 0.6109F, 0.0F));

		PartDefinition LowerMidSpike1 = Body.addOrReplaceChild("LowerMidSpike1", CubeListBuilder.create().texOffs(17, 11).addBox(0.0F, -4.0F, -10.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.5F, -5.25F, 0.343F, -0.2577F, 0.0465F));

		PartDefinition LowerMidSpike2 = Body.addOrReplaceChild("LowerMidSpike2", CubeListBuilder.create().texOffs(17, 11).mirror().addBox(0.0F, -4.0F, -10.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -5.5F, -5.25F, 0.343F, 0.2577F, -0.0465F));

		PartDefinition Left_legs = Root.addOrReplaceChild("Left_legs", CubeListBuilder.create(), PartPose.offset(3.0F, 3.0F, -3.0F));

		PartDefinition Leg7 = Left_legs.addOrReplaceChild("Leg7", CubeListBuilder.create().texOffs(0, 33).addBox(0.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, 0.3149F, -0.8099F, -0.4514F));

		PartDefinition Leg3 = Left_legs.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 33).addBox(0.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, 0.1388F, -0.4221F, -0.3746F));

		PartDefinition Leg2 = Left_legs.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(0, 33).addBox(0.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, 0.0072F, 0.0142F, -0.3713F));

		PartDefinition Leg1 = Left_legs.addOrReplaceChild("Leg1", CubeListBuilder.create().texOffs(0, 33).addBox(0.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, 0.0F, -0.2567F, 0.609F, -0.4301F));

		PartDefinition Right_legs = Root.addOrReplaceChild("Right_legs", CubeListBuilder.create(), PartPose.offset(-3.0F, 3.0F, -3.0F));

		PartDefinition Leg4 = Right_legs.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-10.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, -0.2567F, -0.609F, 0.4301F));

		PartDefinition Leg5 = Right_legs.addOrReplaceChild("Leg5", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-10.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, 0.0072F, -0.0142F, 0.3713F));

		PartDefinition Leg6 = Right_legs.addOrReplaceChild("Leg6", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-10.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, 0.1388F, 0.4221F, 0.3746F));

		PartDefinition Leg8 = Right_legs.addOrReplaceChild("Leg8", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-10.5F, -2.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, 0.3149F, 0.8099F, 0.4514F));

		PartDefinition BackBody = Root.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -2.7716F, -1.1481F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Thingies1 = BackBody.addOrReplaceChild("Thingies1", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, 0.0F, -3.5F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.2284F, 2.3519F, 0.0F, 0.0F, 0.5236F));

		PartDefinition BackSpikes1 = BackBody.addOrReplaceChild("BackSpikes1", CubeListBuilder.create().texOffs(31, 8).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.7716F, 1.8519F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BackSpikes3 = BackBody.addOrReplaceChild("BackSpikes3", CubeListBuilder.create().texOffs(31, 8).mirror().addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -2.7716F, 1.8519F, 0.0F, 0.0F, -0.2618F));

		PartDefinition BackSpikes2 = BackBody.addOrReplaceChild("BackSpikes2", CubeListBuilder.create().texOffs(27, 13).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.7716F, 1.8519F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(16, 0).addBox(-4.5F, -0.0207F, -1.1359F, 9.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0216F, 5.8519F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Thingies2 = BackBody.addOrReplaceChild("Thingies2", CubeListBuilder.create().texOffs(1, 0).mirror().addBox(-1.0F, 0.0F, -3.5F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 1.2284F, 2.3519F, 0.0F, 0.0F, -0.5236F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		//Legs
		this.Leg3.zRot = -Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg4.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg2.zRot = Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg5.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg1.zRot = -Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg6.zRot = -Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;
		this.Leg7.zRot = Mth.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount;
		this.Leg8.zRot = Mth.cos(limbSwing * 0.5F + (float) Math.PI) * 1.5F * limbSwingAmount;

		//Spikes
		this.LowerMidSpike1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.LowerMidSpike2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Antenae1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Antenae2.xRot = f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}