package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.Shockcat;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ShockcatModel<T extends Shockcat> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart SideWhisker1;
	private final ModelPart SideWhisker2;
	private final ModelPart Whisker2;

	public ShockcatModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BackFin1 = this.Body.getChild("BackFin1");
		this.BackFin2 = this.Body.getChild("BackFin2");
		this.SideWhisker1 = this.Body.getChild("SideWhisker1");
		this.SideWhisker2 = this.Body.getChild("SideWhisker2");
		this.Whisker2 = this.Body.getChild("Whisker2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 7.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(28, 24).addBox(-8.0F, -2.0F, -10.0F, 16.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(0.0F, -12.0F, 6.0F, 0.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -6.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 2.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(21, 0).addBox(0.0F, 0.0F, -2.0F, 7.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 2.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-7.0F, 0.0F, -2.0F, 7.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 14.0F));

		PartDefinition cube_r3 = BackFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 38).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 14.0F));

		PartDefinition cube_r4 = BackFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 38).mirror().addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition SideWhisker2 = Body.addOrReplaceChild("SideWhisker2", CubeListBuilder.create(), PartPose.offset(8.0F, 1.0F, -10.0F));

		PartDefinition cube_r5 = SideWhisker2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, -1.0F, 0.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.8727F, 0.0F));

		PartDefinition SideWhisker1 = Body.addOrReplaceChild("SideWhisker1", CubeListBuilder.create(), PartPose.offset(-8.0F, 1.0F, -10.0F));

		PartDefinition cube_r6 = SideWhisker1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 0).mirror().addBox(-12.0F, -1.0F, 0.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.8727F, 0.0F));

		PartDefinition Whisker2 = Body.addOrReplaceChild("Whisker2", CubeListBuilder.create(), PartPose.offset(-0.5F, 2.0F, -7.0F));

		PartDefinition cube_r7 = Whisker2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 45).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(40, 40).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -3.0F, 16.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -6.0F, 0.0F, 0.0F, 11.0F, 19.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
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
		this.Whisker2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SideWhisker1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SideWhisker2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}