package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.ZebraCornetfish;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class ZebraCornetfishModel<T extends ZebraCornetfish> extends ListModel<T> {
	private final ModelPart Mouth;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Body;

	public ZebraCornetfishModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Mouth = this.Body.getChild("Mouth");
		this.Tail = this.Body.getChild("Tail");
		this.MidFin1 = this.Body.getChild("MidFin1");
		this.MidFin2 = this.Body.getChild("MidFin2");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
		this.BackFin1 = this.Tail.getChild("BackFin1");
		this.BackFin2 = this.Tail.getChild("BackFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, -1.0F, -21.0F, 3.0F, 3.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(14, 54).addBox(-2.0F, -3.0F, -1.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -8.0F, 14.0F, 0.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -9.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 17).addBox(0.075F, -1.4872F, -0.1958F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, 2.0F, -0.1309F, 0.6109F, 0.0F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(-0.075F, -1.4872F, -0.1958F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.5F, 2.0F, -0.1309F, -0.6109F, 0.0F));

		PartDefinition MidFin1 = Body.addOrReplaceChild("MidFin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.075F, -1.4769F, -0.1504F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.5F, 12.0F, -0.3054F, 0.3054F, 0.0F));

		PartDefinition MidFin2 = Body.addOrReplaceChild("MidFin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.075F, -1.4769F, -0.1504F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.5F, 12.0F, -0.3054F, -0.3054F, 0.0F));

		PartDefinition Mouth = Body.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 2.0F, -20.25F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(25, 21).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.0F));

		PartDefinition BackFin1 = Tail.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition cube_r1 = BackFin1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition BackFin2 = Tail.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition cube_r2 = BackFin2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 24).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition tail_end = Tail.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(25, 25).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 14.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.10F * Mth.sin(0.1F * ageInTicks);
		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.4F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}