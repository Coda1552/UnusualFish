package codyhuh.unusualfishmod.client.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class UFGlowRenderLayer<T extends LivingEntity & GeoEntity> extends GeoRenderLayer<T> {
    private final ResourceLocation glowLayer;

    public UFGlowRenderLayer(GeoRenderer<T> layer, ResourceLocation glowOverlayResourceLocation) {
        super(layer);
        this.glowLayer = glowOverlayResourceLocation;
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.dragonExplosionAlpha(glowLayer));

        if (!animatable.isInvisible()) {
            this.getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType, vertexconsumer, partialTick, packedLight, LivingEntityRenderer.getOverlayCoords(animatable, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}