package codyhuh.unusualfishmod.client.renderer;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.msc.AbyssalBlast;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class AbyssalBlastRenderer extends EntityRenderer<AbyssalBlast> {
    private static final ResourceLocation TEXTURE_0 = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/abyssalblast/abyssal_blast_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/abyssalblast/abyssal_blast_1.png");
    private static final ResourceLocation TEXTURE_2 = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/abyssalblast/abyssal_blast_2.png");
    private static final ResourceLocation TEXTURE_3 = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/abyssalblast/abyssal_blast_3.png");

    public AbyssalBlastRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(AbyssalBlast entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.25F, 0.0D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        int arcs = Mth.clamp(Mth.floor(entityIn.tickCount / 5F), 1, 4);
        matrixStackIn.translate(0.0D, 0.0F, 0.4D);

        for(int i = 0; i < arcs; i++){
            matrixStackIn.pushPose();
            matrixStackIn.translate(0, 0, -0.5F * i);
            renderArc(matrixStackIn, bufferIn, (i + 1) * 5, entityIn.isFasterAnimation());
            matrixStackIn.popPose();
        }

        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    private void renderArc(PoseStack matrixStackIn, MultiBufferSource bufferIn, int age, boolean fast) {
        matrixStackIn.pushPose();
        ResourceLocation res;
        if (fast) {
            res = getEntityTextureFaster(age);
        }
        else {
            res = getEntityTexture(age);
        }
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutoutNoCull(res));
        PoseStack.Pose lvt_19_1_ = matrixStackIn.last();
        Matrix4f lvt_20_1_ = lvt_19_1_.pose();
        Matrix3f lvt_21_1_ = lvt_19_1_.normal();
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex(lvt_20_1_, lvt_21_1_, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(AbyssalBlast entity) {
        return TEXTURE_0;
    }

    public void drawVertex(Matrix4f p_229039_1_, Matrix3f p_229039_2_, VertexConsumer p_229039_3_, int p_229039_4_, int p_229039_5_, int p_229039_6_, float p_229039_7_, float p_229039_8_, int p_229039_9_, int p_229039_10_, int p_229039_11_, int p_229039_12_) {
        p_229039_3_.vertex(p_229039_1_, (float) p_229039_4_, (float) p_229039_5_, (float) p_229039_6_).color(255, 255, 255, 255).uv(p_229039_7_, p_229039_8_).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_229039_12_).normal(p_229039_2_, (float) p_229039_9_, (float) p_229039_11_, (float) p_229039_10_).endVertex();
    }

    public ResourceLocation getEntityTexture(int age) {
        if (age < 1) {
            return TEXTURE_0;
        }
        else if (age < 15) {
            return TEXTURE_1;
        }
        else if (age < 40) {
            return TEXTURE_2;
        }
        else {
            return TEXTURE_3;
        }
    }

    public ResourceLocation getEntityTextureFaster(int age) {
        if (age < 6) {
            return TEXTURE_0;
        }
        else if (age < 9) {
            return TEXTURE_1;
        }
        else if (age < 12) {
            return TEXTURE_2;
        }
        else {
            return TEXTURE_3;
        }
    }

}
