package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.Ripper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RipperModel<T extends Ripper> extends ListModel<T> {
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Tail;
	private final ModelPart Jaw;
	private final ModelPart Body;

	public RipperModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.FrontFin1 = this.Body.getChild("FrontFin1");
		this.FrontFin2 = this.Body.getChild("FrontFin2");
		this.BackFin1 = this.Body.getChild("BackFin1");
		this.BackFin2 = this.Body.getChild("BackFin2");
		this.Tail = this.Body.getChild("Tail");
		this.Jaw = this.Body.getChild("Jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(21, 0).addBox(-1.5F, -5.0F, -12.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(-3, 0).addBox(-2.5F, -4.0F, -10.0F, 5.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 14).addBox(-2.5F, -5.0F, -4.0F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(21, 5).addBox(0.0F, -10.0F, 5.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -5.0F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("FrontFin1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = FrontFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, 0.0F, -1.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("FrontFin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = FrontFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-7.0F, 0.0F, -1.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = BackFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 28).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = BackFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.25F, 0.0F, 0.0F, 11.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, 0.75F, 0.0F, 4.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.75F, 10.0F));

		PartDefinition Jaw = Body.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(9, 28).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -2.0F, -7.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.FrontFin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.FrontFin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	public void prepareMobModel(T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
		int i = p_102957_.getAttackAnimationTick();
		if (i > 0) {
			this.Jaw.xRot = -130F + 0.3F * Mth.triangleWave((float)i - p_102960_, -10.0F);
		}
		else {
			this.Jaw.xRot = (-0.2F + 0.1F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
		}
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}

}