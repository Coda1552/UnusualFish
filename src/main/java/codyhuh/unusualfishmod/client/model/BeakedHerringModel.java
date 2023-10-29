package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.BeakedHerring;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class BeakedHerringModel<T extends BeakedHerring> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Tail;


	public BeakedHerringModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.Tail = this.BackBody.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 0).addBox(-0.5F, -1.0F, -7.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(6, 9).addBox(0.025F, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.5F, -1.75F, -0.1745F, 0.5672F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(6, 9).mirror().addBox(-0.025F, 0.0F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -1.5F, -1.75F, -0.1745F, -0.5672F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.001F))
				.texOffs(0, 9).addBox(0.0F, -3.0F, 1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(8, 3).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.45F * Mth.sin(0.5F * ageInTicks);
		this.Tail.yRot = -f * 0.45F * Mth.sin(0.5F * ageInTicks);

		this.Fin1.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}