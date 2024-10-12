package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.TripleTwirlPleco;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class TripleTwirlPlecoModel<T extends TripleTwirlPleco> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart BigWhisker1;
	private final ModelPart BigWhisker2;
	private final ModelPart Whisker1;
	private final ModelPart Whisker2;
	private final ModelPart BigFin1;
	private final ModelPart BigFin2;
	private final ModelPart LittleFin1;
	private final ModelPart LittleFin2;
	private final ModelPart Body;

	public TripleTwirlPlecoModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.BigWhisker1 = this.Body.getChild("BigWhisker");
		this.BigWhisker2 = this.Body.getChild("BigWhisker2");
		this.Whisker1 = this.Body.getChild("Whisker1");
		this.Whisker2 = this.Body.getChild("Whisker2");
		this.BigFin1 = this.Body.getChild("FrontFin1");
		this.BigFin2 = this.Body.getChild("FrontFin2");
		this.LittleFin1 = this.Tail.getChild("BackFin1");
		this.LittleFin2 = this.Tail.getChild("BackFin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -8.0F, -4.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, -1.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 18).mirror().addBox(0.0F, -4.0F, -5.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.0F, 1.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 18).addBox(0.0F, -4.0F, -5.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Whisker1 = Body.addOrReplaceChild("Whisker1", CubeListBuilder.create().texOffs(10, 31).addBox(0.0F, 0.0F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -5.0F, 0.0F, -0.3491F, 0.1309F));

		PartDefinition Whisker2 = Body.addOrReplaceChild("Whisker2", CubeListBuilder.create().texOffs(11, 32).mirror().addBox(-7.75F, 0.0F, -5.0F, 8.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, -5.0F, 0.0F, 0.3491F, -0.1309F));

		PartDefinition BigWhisker = Body.addOrReplaceChild("BigWhisker", CubeListBuilder.create().texOffs(3, 48).addBox(-0.5F, 0.0F, -5.0F, 10.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -4.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition BigWhisker2 = Body.addOrReplaceChild("BigWhisker2", CubeListBuilder.create().texOffs(3, 48).mirror().addBox(-9.5F, 0.0F, -5.0F, 10.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.0F, -4.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition FrontFin1 = Body.addOrReplaceChild("FrontFin1", CubeListBuilder.create().texOffs(16, 5).addBox(0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition FrontFin2 = Body.addOrReplaceChild("FrontFin2", CubeListBuilder.create().texOffs(16, 5).mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 1.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -3.0F, 0.0F, 0.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition BackFin1 = Tail.addOrReplaceChild("BackFin1", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition cube_r3 = BackFin1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition BackFin2 = Tail.addOrReplaceChild("BackFin2", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.0F));

		PartDefinition cube_r4 = BackFin2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.Tail.yRot = -f * 0.20F * Mth.sin(0.4F * ageInTicks);
		this.BigWhisker1.yRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.BigWhisker2.yRot = -f * 0.30F * Mth.cos(0.1F * ageInTicks);
		this.Whisker1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Whisker2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}