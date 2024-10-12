package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.SeaPancake;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SeaPancakeModel<T extends SeaPancake> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Body;

	public SeaPancakeModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Tail = this.Body.getChild("tail");
		this.Eye1 = this.Body.getChild("eye1");
		this.Eye2 = this.Body.getChild("eye2");
		this.BackFin1 = this.Body.getChild("backfin1");
		this.BackFin2 = this.Body.getChild("backfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-22.5F, -2.0F, -23.0F, 45.0F, 4.0F, 45.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(-0.5F, -6.0F, 22.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 49).addBox(-8.0F, -1.0F, 22.0F, 16.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -6.0F, 0.0F, 0.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.0F, 29.0F));

		PartDefinition Eye1 = Body.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -2.0F, -8.0F));

		PartDefinition Eye2 = Body.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.5F, -2.0F, -8.0F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.5F, 23.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 0.5F, 23.0F, 0.0F, 0.0F, -0.2182F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 220F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 220F);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}

}