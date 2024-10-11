package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.Picklefish;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class PicklefishModel<T extends Picklefish> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart FrontFin1;
	private final ModelPart FrontFin2;
	private final ModelPart Body;

	public PicklefishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.FrontFin1 = this.Body.getChild("FrontFin1");
		this.FrontFin2 = this.Body.getChild("FrontFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(12, 10).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(8, 6).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -5.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -2.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -4.5F, 0.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 5.0F));

		PartDefinition BackFin1 = Tail.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.75F, 1.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("FrontFin1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = FrontFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("FrontFin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = FrontFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

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
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}