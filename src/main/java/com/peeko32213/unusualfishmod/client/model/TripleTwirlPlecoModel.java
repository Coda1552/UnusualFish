package com.peeko32213.unusualfishmod.client.model;

import com.google.common.collect.ImmutableList;
import com.peeko32213.unusualfishmod.UnusualFishMod;

import com.peeko32213.unusualfishmod.common.entity.ambient.small.TripleTwirlPleco;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TripleTwirlPlecoModel<Type extends TripleTwirlPleco> extends ListModel<Type> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(UnusualFishMod.MODID, "triple_twirl_pleco"), "main");
	private final ModelPart Tail;
	private final ModelPart BigWhisker;
	private final ModelPart Whisker1;
	private final ModelPart Whisker2;
	private final ModelPart BigFin1;
	private final ModelPart BigFin2;
	private final ModelPart LittleFin1;
	private final ModelPart LittleFin2;
	private final ModelPart Body;

	public TripleTwirlPlecoModel(ModelPart root) {
		this.Body = root.getChild("body");
		this.Tail = this.Body.getChild("tail");
		this.BigWhisker = this.Body.getChild("bigwhisker");
		this.Whisker1 = this.Body.getChild("whisker1");
		this.Whisker2 = this.Body.getChild("whisker2");
		this.BigFin1 = this.Body.getChild("frontfin1");
		this.BigFin2 = this.Body.getChild("frontfin2");
		this.LittleFin1 = this.Body.getChild("backfin1");
		this.LittleFin2 = this.Body.getChild("backfin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -9.0F, -3.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -1.0F));

		PartDefinition Whisker1 = Body.addOrReplaceChild("whisker1", CubeListBuilder.create().texOffs(18, 11).addBox(0.0F, 0.0F, -4.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -5.0F, 0.0F, -0.3491F, 0.1309F));

		PartDefinition Whisker2 = Body.addOrReplaceChild("whisker2", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(-5.0F, 0.0F, -4.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, -5.0F, 0.0F, 0.3491F, -0.1309F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("frontfin1", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("frontfin2", CubeListBuilder.create().texOffs(16, 5).mirror().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition BackFin1 = Body.addOrReplaceChild("backfin1", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, 3.0F, -0.0945F, -0.2909F, 0.3193F));

		PartDefinition BackFin2 = Body.addOrReplaceChild("backfin2", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.0F, 3.0F, -0.0945F, 0.2909F, -0.3193F));

		PartDefinition BigWhisker = Body.addOrReplaceChild("bigwhisker", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, 0.0F, -4.0F, 25.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -5.0F, 0.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.BigWhisker.yRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Whisker1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Whisker2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of( this.Body);
	}
}