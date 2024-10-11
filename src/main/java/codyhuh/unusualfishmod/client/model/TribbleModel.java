package codyhuh.unusualfishmod.client.model;

import codyhuh.unusualfishmod.common.entity.Tribble;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class TribbleModel<T extends Tribble> extends EntityModel<T> {
	private final ModelPart Head;
	private final ModelPart MouthPart1;
	private final ModelPart MouthPart2;
	private final ModelPart Feeler1;
	private final ModelPart Feeler2;
	private final ModelPart Root;

	public TribbleModel(ModelPart base) {
		this.Root = base.getChild("Root");
		this.Head = Root.getChild("Head");
		this.MouthPart1 = Head.getChild("MouthPart1");
		this.MouthPart2 = Head.getChild("MouthPart2");
		this.Feeler1 = Head.getChild("Feeler1");
		this.Feeler2 = Head.getChild("Feeler2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, -4.0F));

		PartDefinition Head = Root.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -2.5F, -7.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 4.0F));

		PartDefinition Feeler1 = Head.addOrReplaceChild("Feeler1", CubeListBuilder.create().texOffs(8, 8).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -6.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Feeler2 = Head.addOrReplaceChild("Feeler2", CubeListBuilder.create().texOffs(8, 8).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -2.0F, -6.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition MouthPart1 = Head.addOrReplaceChild("MouthPart1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.0F, -7.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition MouthPart2 = Head.addOrReplaceChild("MouthPart2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -1.0F, -7.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 1.0F));

		PartDefinition TailBits = Body.addOrReplaceChild("TailBits", CubeListBuilder.create().texOffs(17, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Legs1 = Body.addOrReplaceChild("Legs1", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, 0.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 3.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition Legs2 = Body.addOrReplaceChild("Legs2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 1.0472F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = 1.0F;

		this.Feeler1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.Feeler2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);

		this.MouthPart1.xRot = -f * 0.20F * Mth.sin(0.15F * ageInTicks);
		this.MouthPart2.xRot = f * 0.20F * Mth.sin(0.15F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}