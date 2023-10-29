package codyhuh.unusualfishmod.client.renderer.item;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.item.ThrownPrismarineSpear;
import codyhuh.unusualfishmod.core.registry.UFItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class ThrownPrismarineSpearRenderer extends EntityRenderer<ThrownPrismarineSpear> {
    public static final ResourceLocation LOC = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/prismarine_spear.png");

    public ThrownPrismarineSpearRenderer(EntityRendererProvider.Context p_174420_) {
        super(p_174420_);
    }

    public void render(ThrownPrismarineSpear spear, float p_116112_, float p_116113_, PoseStack stack, MultiBufferSource buffer, int p_116116_) {
        stack.pushPose();

        stack.translate(0.0D, -0.15D, 0.0D);

        stack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(p_116113_, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(p_116113_, spear.xRotO, spear.getXRot()) - 45.0F));
        stack.scale(3.0F, 3.0F, 1.75F);

        Minecraft mc = Minecraft.getInstance();

        BakedModel model = mc.getItemRenderer().getModel(new ItemStack(UFItems.PRISMARINE_SPEAR.get()), mc.level, null, 0);
        mc.getItemRenderer().render(new ItemStack(UFItems.PRISMARINE_SPEAR.get()), ItemTransforms.TransformType.GROUND, true, stack, buffer, getPackedLightCoords(spear, 1.0F), OverlayTexture.NO_OVERLAY, model);

        stack.popPose();
        super.render(spear, p_116112_, p_116113_, stack, buffer, p_116116_);
    }

    public ResourceLocation getTextureLocation(ThrownPrismarineSpear p_116109_) {
        return LOC;
    }
}