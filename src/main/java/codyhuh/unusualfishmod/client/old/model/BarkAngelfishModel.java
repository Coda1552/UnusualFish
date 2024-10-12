package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.BarkAngelfish;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BarkAngelfishModel<T extends BarkAngelfish> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Body;

	public BarkAngelfishModel(ModelPart root) {
		this.Body = root.getChild("Root");
		this.Tail = this.Body.getChild("Tail");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(6, 11).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -9.0F, 0.0F, 0.0F, 21.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -1.5F));

		PartDefinition Tail = Root.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(6, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition Fin1 = Root.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 2.0F));

		PartDefinition cube_r1 = Fin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Root.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 2.0F));

		PartDefinition cube_r2 = Fin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 0).mirror().addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.45F * Mth.sin(0.6F * ageInTicks);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}