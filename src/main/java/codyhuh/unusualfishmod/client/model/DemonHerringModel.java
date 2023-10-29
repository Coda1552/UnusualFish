package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.DemonHerring;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DemonHerringModel<T extends DemonHerring> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart Jaw;
	private final ModelPart Tail;
	private final ModelPart Light;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart LowerFin1;
	private final ModelPart LowerFin2;

	public DemonHerringModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Jaw = this.Body.getChild("jaw");
		this.Light = this.Body.getChild("light");
		this.Tail = this.Body.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.LowerFin1 = this.Body.getChild("lowerfin1");
		this.LowerFin2 = this.Body.getChild("lowerfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Jaw = Body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(12, 14).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 0).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 0.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition Light = Body.addOrReplaceChild("light", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, -3.75F, -0.1224F, 0.7013F, 0.0684F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.025F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, -3.75F, -0.1224F, -0.7013F, -0.0684F));

		PartDefinition LowerFin1 = Body.addOrReplaceChild("lowerfin1", CubeListBuilder.create().texOffs(6, 11).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -2.0F, 0.3491F, 0.0F, -0.3927F));

		PartDefinition LowerFin2 = Body.addOrReplaceChild("lowerfin2", CubeListBuilder.create().texOffs(6, 11).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -2.0F, 0.3491F, 0.0F, 0.3927F));

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