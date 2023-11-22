package codyhuh.unusualfishmod.client.renderer.item;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.client.UFModelLayers;
import codyhuh.unusualfishmod.client.model.item.PrismarineSpearModel;
import codyhuh.unusualfishmod.common.entity.item.ThrownPrismarineSpear;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ThrownPrismarineSpearRenderer extends EntityRenderer<ThrownPrismarineSpear> {
    public static final ResourceLocation LOC = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/item/prismarine_spear.png");
    private final PrismarineSpearModel<ThrownPrismarineSpear> model;

    public ThrownPrismarineSpearRenderer(EntityRendererProvider.Context p_174420_) {
        super(p_174420_);
        this.model = new PrismarineSpearModel<>(p_174420_.bakeLayer(UFModelLayers.PRISMARINE_SPEAR));
    }

    public void render(ThrownPrismarineSpear spear, float p_116112_, float p_116113_, PoseStack stack, MultiBufferSource buffer, int p_116116_) {
        stack.pushPose();

        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(p_116113_, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(p_116113_, spear.xRotO, spear.getXRot()) + 90.0F));

        this.model.renderToBuffer(stack, buffer.getBuffer(this.model.renderType(this.getTextureLocation(spear))), p_116116_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        stack.popPose();
        super.render(spear, p_116112_, p_116113_, stack, buffer, p_116116_);
    }

    public ResourceLocation getTextureLocation(ThrownPrismarineSpear p_116109_) {
        return LOC;
    }
}