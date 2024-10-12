package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.TigerPuffer;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class TigerPufferModel<T extends TigerPuffer> extends ListModel<T> {
	private final ModelPart Tail;
	private final ModelPart Eye1;
	private final ModelPart Eye2;
	private final ModelPart Fin1;
	private final ModelPart Fin2;
	private final ModelPart Body;
	private final ModelPart BackBody;
	private final ModelPart Head;

	public TigerPufferModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.BackBody = this.Body.getChild("BackBody");
		this.Tail = this.BackBody.getChild("Tail");
		this.Head = this.Body.getChild("Head");
		this.Eye1 = this.Head.getChild("Eye1");
		this.Eye2 = this.Head.getChild("Eye2");
		this.Fin1 = this.Body.getChild("Fin1");
		this.Fin2 = this.Body.getChild("Fin2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(0, 19).addBox(0.0F, -10.0F, -1.0F, 0.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(12, 46).addBox(0.0F, -9.0F, 10.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 43).addBox(0.0F, 3.0F, 10.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition BottomFin_r1 = Body.addOrReplaceChild("BottomFin_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 6.0F, 6.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition BottomFin_r2 = Body.addOrReplaceChild("BottomFin_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 29).addBox(-6.0F, -5.0F, -5.0F, 12.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(40, 42).addBox(-3.0F, -3.0F, -9.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -6.0F));

		PartDefinition Eye1 = Head.addOrReplaceChild("Eye1", CubeListBuilder.create().texOffs(24, 52).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -4.0F, -1.0F));

		PartDefinition Eye2 = Head.addOrReplaceChild("Eye2", CubeListBuilder.create().texOffs(24, 52).mirror().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -4.0F, -1.0F));

		PartDefinition Fin1 = Body.addOrReplaceChild("Fin1", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 6.0F, -6.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition fin_r1 = Fin1.addOrReplaceChild("fin_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Fin2 = Body.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 6.0F, -6.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition fin_r2 = Fin2.addOrReplaceChild("fin_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-5.0F, 0.0F, -3.0F, 5.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition BackBody = Body.addOrReplaceChild("BackBody", CubeListBuilder.create().texOffs(41, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition Tail = BackBody.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(20, 32).addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.BackBody.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Tail.yRot = -f * 0.20F * Mth.sin(0.1F * ageInTicks);
		this.Fin1.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);
		this.Fin2.xRot = -f * 0.40F * Mth.sin(0.4F * ageInTicks);

		if (entity.isInWater()) {
			this.Body.xRot = headPitch * ((float)Math.PI / 180F);
			this.Body.yRot = netHeadYaw * ((float)Math.PI / 180F);
		}
		else {
			this.Body.xRot = 0.0F;
			this.Body.yRot = 0.0F;
		}

	}

	@Override
	public Iterable<ModelPart> parts() {
		return ImmutableList.of(this.Body);
	}
}