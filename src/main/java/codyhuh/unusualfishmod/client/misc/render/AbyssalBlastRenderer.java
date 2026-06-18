package codyhuh.unusualfishmod.client.misc.render;

import codyhuh.unusualfishmod.common.entity.item.AbyssalBlast;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;

import static codyhuh.unusualfishmod.UnusualFishMod.loc;

public class AbyssalBlastRenderer extends EntityRenderer<AbyssalBlast> {
    private static final ResourceLocation TEXTURE_0 = loc("textures/entity/abyssalblast/abyssal_blast_0.png");
    private static final ResourceLocation TEXTURE_1 = loc("textures/entity/abyssalblast/abyssal_blast_1.png");
    private static final ResourceLocation TEXTURE_2 = loc("textures/entity/abyssalblast/abyssal_blast_2.png");
    private static final ResourceLocation TEXTURE_3 = loc("textures/entity/abyssalblast/abyssal_blast_3.png");

    public AbyssalBlastRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(AbyssalBlast entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.translate(0.0D, 0.25F, 0.0D);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
        int arcs = Mth.clamp(Mth.floor(entityIn.tickCount / 5F), 1, 4);
        matrixStackIn.translate(0.0D, 0.0F, 0.4D);

        for (int i = 0; i < arcs; i++) {
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
        } else {
            res = getEntityTexture(age);
        }
        VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutoutNoCull(res));
        PoseStack.Pose pose = matrixStackIn.last();
        Matrix4f matrix4f = pose.pose();
        this.drawVertex(matrix4f, pose, ivertexbuilder, -1, 0, -1, 0, 0, 1, 0, 1, 240);
        this.drawVertex(matrix4f, pose, ivertexbuilder, -1, 0, 1, 0, 1, 1, 0, 1, 240);
        this.drawVertex(matrix4f, pose, ivertexbuilder, 1, 0, 1, 1, 1, 1, 0, 1, 240);
        this.drawVertex(matrix4f, pose, ivertexbuilder, 1, 0, -1, 1, 0, 1, 0, 1, 240);
        matrixStackIn.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(AbyssalBlast entity) {
        return TEXTURE_0;
    }

    public void drawVertex(Matrix4f matrixPos, PoseStack.Pose pose, VertexConsumer buffer, int x, int y, int z, float u, float v, int normalX, int normalY, int normalZ, int packedLight) {
        buffer.addVertex(matrixPos, (float) x, (float) y, (float) z).setColor(255, 255, 255, 255).setUv(u, v).setOverlay(OverlayTexture.NO_OVERLAY).setLight(packedLight).setNormal(pose, (float) normalX, (float) normalY, (float) normalZ);
    }

    public ResourceLocation getEntityTexture(int age) {
        if (age < 1) {
            return TEXTURE_0;
        } else if (age < 15) {
            return TEXTURE_1;
        } else if (age < 40) {
            return TEXTURE_2;
        } else {
            return TEXTURE_3;
        }
    }

    public ResourceLocation getEntityTextureFaster(int age) {
        if (age < 6) {
            return TEXTURE_0;
        } else if (age < 9) {
            return TEXTURE_1;
        } else if (age < 12) {
            return TEXTURE_2;
        } else {
            return TEXTURE_3;
        }
    }

}
