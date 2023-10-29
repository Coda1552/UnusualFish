package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.DualityDamselfish;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DualityDamselfishModel<T extends DualityDamselfish> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart LowerFin1;
	private final ModelPart LowerFin2;
	private final ModelPart Tail;

	public DualityDamselfishModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Tail = this.Body.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.LowerFin1 = this.Body.getChild("lowerfin1");
		this.LowerFin2 = this.Body.getChild("lowerfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -8.0F, 0.0F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(0.0F, -11.0F, 4.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, -1).addBox(0.0F, 0.0F, 6.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -4.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(14, 0).addBox(0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.0F, 3.0F, -0.3491F, 1.0472F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(14, 0).mirror().addBox(-0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -4.0F, 3.0F, -0.3491F, -1.0472F, 0.0F));

		PartDefinition LowerFin1 = Body.addOrReplaceChild("lowerfin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.1745F, 0.0F, -0.3054F));

		PartDefinition LowerFin2 = Body.addOrReplaceChild("lowerfin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 2.0F, 0.1745F, 0.0F, 0.3054F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, 12).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 8.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}


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