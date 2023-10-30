package codyhuh.unusualfishmod.client.model.item;

import codyhuh.unusualfishmod.common.entity.item.ThrownPrismarineSpear;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PrismarineSpearModel<T extends ThrownPrismarineSpear> extends EntityModel<T> {
	private final ModelPart spear;

	public PrismarineSpearModel(ModelPart root) {
		this.spear = root.getChild("spear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spear = partdefinition.addOrReplaceChild("spear", CubeListBuilder.create().texOffs(10, 0).addBox(-3.0F, -29.0F, 0.0F, 5.0F, 29.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.5F, -29.0F, -2.5F, 0.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		spear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}