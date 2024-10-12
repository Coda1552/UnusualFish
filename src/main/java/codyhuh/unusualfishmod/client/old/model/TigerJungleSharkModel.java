package codyhuh.unusualfishmod.client.old.model;

import codyhuh.unusualfishmod.common.entity.TigerJungleShark;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class TigerJungleSharkModel<T extends TigerJungleShark> extends EntityModel<T> {
	private final ModelPart root;
	private final ModelPart tail;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart l_fin;
	private final ModelPart r_fin;
	private final ModelPart jaw;

	public TigerJungleSharkModel(ModelPart base) {
		this.root = base.getChild("Root");
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = body.getChild("tail");
		this.l_fin = body.getChild("l_fin");
		this.r_fin = body.getChild("r_fin");
		this.jaw = head.getChild("jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition head = Root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 27).addBox(-3.0F, -4.0F, -8.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(16, 27).addBox(-1.0F, 0.0F, -6.0F, 2.5F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -4.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(19, 39).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(31, 6).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = Root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 12.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 8.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition l_fin = body.addOrReplaceChild("l_fin", CubeListBuilder.create(), PartPose.offset(4.0F, 6.5F, 4.0F));

		PartDefinition cube_r2 = l_fin.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(31, 0).addBox(0.0F, -0.5F, -1.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, -0.6109F, 0.2618F));

		PartDefinition r_fin = body.addOrReplaceChild("r_fin", CubeListBuilder.create(), PartPose.offset(-4.0F, 6.5F, 4.0F));

		PartDefinition cube_r3 = r_fin.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(31, 0).mirror().addBox(-8.0F, -0.5F, -1.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 0.6109F, -0.2618F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 15.0F));

		PartDefinition fin = tail.addOrReplaceChild("fin", CubeListBuilder.create().texOffs(41, 39).addBox(-0.5F, -9.0F, -1.0F, 1.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;
		if (!entity.isInWater()) {
			f = 1.5F;
		}

		this.body.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);
		this.tail.yRot = -f * 0.3F * Mth.sin(0.1F * ageInTicks);

		this.r_fin.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
		this.l_fin.xRot = -f * 0.30F * Mth.sin(0.1F * ageInTicks);
	}

	public void prepareMobModel (T p_102957_, float p_102958_, float p_102959_, float p_102960_) {
		super.prepareMobModel(p_102957_, p_102958_, p_102959_, p_102960_);
		int l = p_102957_.getAttackAnimationTick();
		if (l > 0) {
			if (l > 5) {
				this.jaw.xRot = Mth.sin(((float) (-4 + l) - p_102960_) / 4.0F) * (float) Math.PI * 0.4F;
			} else {
				this.jaw.xRot = 0.15707964F * Mth.sin((float) Math.PI * ((float) l - p_102960_) / 10.0F);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}