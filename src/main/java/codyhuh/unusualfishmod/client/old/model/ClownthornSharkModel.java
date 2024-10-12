package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.ClownthornShark;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ClownthornSharkModel<T extends ClownthornShark> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Head;
	private final ModelPart Eye1;
	private final ModelPart Tail;

	public ClownthornSharkModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.Head = this.Body.getChild("Head");
		this.Eye1 = this.Head.getChild("Eye1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(17, 28).addBox(0.0F, -9.0F, 3.0F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, -11.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 35).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye1 = Head.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(37, 6).addBox(-6.0F, -2.0F, -2.0F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 31).addBox(-6.0F, -4.0F, -3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(36, 24).addBox(-6.0F, -1.0F, -5.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, -2.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 3.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 0).addBox(0.0F, 0.0F, -2.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-4.0F, 2.0F, 3.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 0).mirror().addBox(-5.0F, 0.0F, -2.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(16, 19).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(31, 29).addBox(0.0F, -7.0F, 1.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 11.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -7.0F, -1.0F, 0.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition BackFin1 = BackBody.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(2.0F, 2.0F, 4.0F));

		PartDefinition cube_r3 = BackFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 18).addBox(0.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BackFin2 = BackBody.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(-2.0F, 2.0F, 4.0F));

		PartDefinition cube_r4 = BackFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 18).mirror().addBox(-3.0F, 0.0F, -2.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.4F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.4F * ageInTicks);

		if (entity.isInWater()) {
			this.Body.xRot = headPitch * ((float)Math.PI / 180F);
			this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		}
		else {
			this.Body.xRot = 0.0F;
			this.Body.yRot = 0.0F;
		}
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}