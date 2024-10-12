package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.DemonHerring;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DemonHerringModel<T extends DemonHerring> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Light;
	private final ModelPart Fin1;
	private final ModelPart Fin2;

	public DemonHerringModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Light = this.Body.getChild("Light");
		this.Tail = this.Body.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(10, 10).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(0.0F, -4.0F, 2.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, -4.0F));

		PartDefinition Jaw = Body.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -2.0F));

		PartDefinition cube_r1 = Jaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F))
				.texOffs(7, 4).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.5F, 0.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

		PartDefinition Light = Body.addOrReplaceChild("Light", CubeListBuilder.create().texOffs(10, 14).addBox(0.0F, -4.0F, -0.5F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.5F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, 0.0F));

		PartDefinition cube_r2 = Fin1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(0.025F, -1.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, 0.0F));

		PartDefinition cube_r3 = Fin2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 0).addBox(-0.025F, -1.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Light.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}