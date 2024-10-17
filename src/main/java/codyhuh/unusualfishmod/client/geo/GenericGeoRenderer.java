package codyhuh.unusualfishmod.client.geo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.function.Supplier;

public class GenericGeoRenderer<T extends LivingEntity & GeoEntity> extends GeoEntityRenderer<T> {
	private float scale = 1F;
	private boolean glow;

	public GenericGeoRenderer(EntityRendererProvider.Context renderManager, Supplier<GeoModel<T>> model, boolean glow) {
		super(renderManager, model.get());
		this.shadowRadius = 0.3F;
	}

	public GenericGeoRenderer(EntityRendererProvider.Context renderManager, Supplier<GeoModel<T>> model, float scale) {
		this(renderManager, model.get(), scale);
		this.scale = scale;
	}
	
	public GenericGeoRenderer(EntityRendererProvider.Context mgr, GeoModel<T> modelProvider, boolean glow) {
		super(mgr, modelProvider);
	}

	public GenericGeoRenderer(EntityRendererProvider.Context mgr, GeoModel<T> modelProvider, float scale) {
		this(mgr, modelProvider, false);
		this.scale = scale;
	}
	
	@Override
	public void render(T entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferIn, int packedLightIn) {
		if (scale != 1F) {
			stack.scale(scale, scale, scale);
		}

		if (entity instanceof AgeableMob mob && mob.isBaby()) {
			stack.scale(0.5F, 0.5F, 0.5F);
		}

		super.render(entity, entityYaw, partialTicks, stack, bufferIn, packedLightIn);
	}

	@Override
	public void preRender(PoseStack poseStack, T animatable, BakedGeoModel bakedGeoModel, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		super.preRender(poseStack, animatable, bakedGeoModel, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected int getBlockLightLevel(T p_114496_, BlockPos p_114497_) {
		return glow ? 15 : super.getBlockLightLevel(p_114496_, p_114497_);
	}

	@Override
	public RenderType getRenderType(T animatable, ResourceLocation texture, @org.jetbrains.annotations.Nullable MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(texture);
	}
}