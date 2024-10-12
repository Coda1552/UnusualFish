package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.Gnasher;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class GnasherModel<T extends Gnasher> extends ListModel<T> {
	private final ModelPart Body;
	private final ModelPart MainBody;
	private final ModelPart LowerJaw;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Wing1;
	private final ModelPart Wing2;
	private final ModelPart MidFin1;
	private final ModelPart MidFin2;
	private final ModelPart BackBody;
	private final ModelPart BackFin1;
	private final ModelPart BackFin2;
	private final ModelPart Tail;

	public GnasherModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.MainBody = Body.getChild("MainBody");
		this.LowerJaw = this.MainBody.getChild("LowerJaw");
		this.Fin1 = this.MainBody.getChild("Fin1");
		this.Fin2 = this.MainBody.getChild("Fin2");
		this.Wing1 = this.MainBody.getChild("Wing1");
		this.Wing2 = this.MainBody.getChild("Wing2");
		this.MidFin1 = this.MainBody.getChild("MidFin1");
		this.MidFin2 = this.MainBody.getChild("MidFin2");
		this.BackBody = this.MainBody.getChild("BackBody");
		this.BackFin1 = this.BackBody.getChild("BackFin1");
		this.BackFin2 = this.BackBody.getChild("BackFin2");
		this.Tail = this.BackBody.getChild("Tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -24.0F));

		PartDefinition MainBody = Body.addOrReplaceChild("MainBody", CubeListBuilder.create().texOffs(47, 26).addBox(-2.5F, -3.0F, -17.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.001F))
				.texOffs(0, 0).addBox(-2.5F, -6.0F, -24.0F, 5.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.5F, -7.0F, -13.0F, 7.0F, 7.0F, 33.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(2.0F, -5.5F, -16.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).mirror().addBox(-3.0F, -5.5F, -16.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 31).addBox(0.0F, -15.0F, -10.0F, 0.0F, 8.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(70, 31).addBox(-2.5F, -3.0F, -18.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(72, 25).addBox(2.5F, -3.0F, -17.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(72, 25).mirror().addBox(-2.5F, -3.0F, -17.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 24.0F));

		PartDefinition LowerJaw = MainBody.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(47, 15).addBox(-2.5F, 0.1F, -4.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(70, 27).addBox(-2.5F, -1.9F, -4.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.1F, -13.0F));

		PartDefinition Fin1 = MainBody.addOrReplaceChild("Fin1", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, 0.0F, -1.0F, 11.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.0F, -7.0F, 0.0F, -0.1745F, 0.7854F));

		PartDefinition Fin2 = MainBody.addOrReplaceChild("Fin2", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(-11.0F, 0.0F, -1.0F, 11.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -2.0F, -7.0F, 0.0F, 0.1745F, -0.7854F));

		PartDefinition Wing1 = MainBody.addOrReplaceChild("Wing1", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, 0.0F, -2.0F, 18.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -6.0F, -1.0F, -0.0294F, -0.0231F, 0.7516F));

		PartDefinition Wing2 = MainBody.addOrReplaceChild("Wing2", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-18.0F, 0.0F, -2.0F, 18.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -6.0F, -1.0F, -0.0294F, 0.0231F, -0.7516F));

		PartDefinition MidFin1 = MainBody.addOrReplaceChild("MidFin1", CubeListBuilder.create().texOffs(14, 14).addBox(0.0F, 0.0F, -1.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.0F, 13.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition MidFin2 = MainBody.addOrReplaceChild("MidFin2", CubeListBuilder.create().texOffs(14, 14).mirror().addBox(-5.0F, 0.0F, -1.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -2.0F, 13.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition BackBody = MainBody.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(0, 45).addBox(0.0F, -5.0F, 0.0F, 0.0F, 8.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 20.0F));

		PartDefinition BackFin1 = BackBody.addOrReplaceChild("BackFin1", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, 0.0F, -5.0F, 4.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition BackFin2 = BackBody.addOrReplaceChild("BackFin2", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-4.0F, 0.0F, -5.0F, 4.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 6.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 14.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 21.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);


		this.Fin1.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.Fin2.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);

		this.Wing1.xRot = -f * 0.50F * Mth.sin(0.1F * ageInTicks);
		this.Wing2.xRot = -f * 0.50F * Mth.sin(0.1F * ageInTicks);

		this.Body.xRot = headPitch * ((float)Math.PI / 220F);
		this.Body.yRot = netHeadYaw * ((float)Math.PI / 220F);

	}

	public void prepareMobModel (T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
		int l = p_102957_.getAttackAnimationTick();
		if (l > 0) {
			if (l > 5) {
				this.LowerJaw.xRot = Mth.sin(((float) (-4 + l) - p_102960_) / 4.0F) * (float) Math.PI * 0.4F;
			} else {
				this.LowerJaw.xRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_102960_) / 10.0F);
			}
		}
	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}