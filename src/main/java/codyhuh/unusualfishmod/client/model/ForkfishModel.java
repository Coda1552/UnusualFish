package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.Forkfish;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ForkfishModel<T extends Forkfish> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fork2;
	private final ModelPart MidFork;
	private final ModelPart Fork1;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Body;

	public ForkfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.Fork1 = this.Body.getChild("Fork1");
		this.Fork2 = this.Body.getChild("Fork2");
		this.MidFork = this.Body.getChild("MidFork");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.0F, -5.0F, 7.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(0.0F, -8.0F, -2.0F, 0.0F, 15.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition Fork1 = Body.addOrReplaceChild("Fork1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.55F, -2.0F, -5.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Fork1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(25, 0).addBox(-0.5F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.0F, 0.25F, -0.0873F, -0.4363F, 0.0F));

		PartDefinition Fork2 = Body.addOrReplaceChild("Fork2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.55F, -2.0F, -5.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Fork2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-1.5F, -1.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.25F, -0.0873F, 0.4363F, 0.0F));

		PartDefinition MidFork = Body.addOrReplaceChild("MidFork", CubeListBuilder.create().texOffs(14, 18).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(3.5F, 2.0F, -2.0F));

		PartDefinition cube_r3 = Fin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-3.5F, 2.0F, -2.0F));

		PartDefinition cube_r4 = Fin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(14, 23).addBox(0.0F, -5.0F, 0.0F, 0.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.45F * Mth.sin(0.5F * ageInTicks);

		this.Fin1.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);

		if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
			this.Body.xRot += -0.05F - 0.05F * Mth.cos(ageInTicks * 0.3F);
		}
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}