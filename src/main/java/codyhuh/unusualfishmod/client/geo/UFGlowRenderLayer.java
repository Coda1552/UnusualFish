package codyhuh.unusualfishmod.client.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class UFGlowRenderLayer<T extends GeoEntity> extends GeoRenderLayer<T> {
    private final ResourceLocation glowLayer;

    public UFGlowRenderLayer(GeoRenderer<T> layer, ResourceLocation glowOverlayResourceLocation) {
        super(layer);
        this.glowLayer = glowOverlayResourceLocation;
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.dragonExplosionAlpha(glowLayer));
        super.render(poseStack, animatable, bakedModel, renderType, bufferSource, vertexconsumer, partialTick, packedLight, packedOverlay);
    }
}