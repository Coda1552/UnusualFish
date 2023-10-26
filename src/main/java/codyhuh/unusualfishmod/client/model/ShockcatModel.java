package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.ulitity.Shockcat;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ShockcatModel<T extends Shockcat> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Tail;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart SideWhisker1;
	private final ModelPart SideWhisker2;
	private final ModelPart Whisker1;
	private final ModelPart Whisker2;

	public ShockcatModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.BackBody = this.Body.getChild("backbody");
		this.Tail = this.BackBody.getChild("tail");
		this.Fin1 = this.Body.getChild("fin1");
		this.Fin2 = this.Body.getChild("fin2");
		this.BackFin1 = this.Body.getChild("backfin1");
		this.BackFin2 = this.Body.getChild("backfin2");
		this.SideWhisker1 = this.Body.getChild("sidewhisker1");
		this.SideWhisker2 = this.Body.getChild("sidewhisker2");
		this.Whisker1 = this.Body.getChild("whisker1");
		this.Whisker2 = this.Body.getChild("whisker2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, 0.0F, 10.0F, 7.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(30, 31).addBox(-8.0F, -4.0F, -10.0F, 16.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(0.0F, -14.0F, 4.0F, 0.0F, 7.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -6.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("fin1", CubeListBuilder.create().texOffs(26, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Fin2 = Body.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(26, 0).mirror().addBox(-8.0F, 0.0F, 0.0F, 8.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(0, 41).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, 10.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition SideWhisker1 = Body.addOrReplaceChild("sidewhisker1", CubeListBuilder.create().texOffs(36, 10).addBox(-14.0F, -1.0F, 0.0F, 14.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -10.0F, -0.6902F, 1.0515F, -0.7603F));

		PartDefinition SideWhisker2 = Body.addOrReplaceChild("sidewhisker2", CubeListBuilder.create().texOffs(36, 10).mirror().addBox(0.0F, -1.0F, 0.0F, 14.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 0.0F, -10.0F, -0.6902F, -1.0515F, 0.7603F));

		PartDefinition Whisker1 = Body.addOrReplaceChild("whisker1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, -10.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Whisker2 = Body.addOrReplaceChild("whisker2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.5F, 0.0F, -10.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition BackBody = Body.addOrReplaceChild("backbody", CubeListBuilder.create().texOffs(12, 43).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -7.0F, 16.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -6.0F, 0.0F, 0.0F, 11.0F, 19.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 2.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);
		this.Tail.yRot = -f * 0.45F * Mth.sin(0.2F * ageInTicks);

		this.Fin1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Whisker1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Whisker2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SideWhisker1.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.SideWhisker2.xRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 180F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}