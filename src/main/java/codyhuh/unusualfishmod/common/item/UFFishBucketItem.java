package codyhuh.unusualfishmod.common.item;

import java.util.function.Supplier;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class UFFishBucketItem extends MobBucketItem {

	public UFFishBucketItem(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Item item, boolean hasTooltip, Properties builder) {
		super(entityType, fluid, () -> SoundEvents.BUCKET_EMPTY_FISH, builder);

		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> UnusualFishMod.CALLBACKS.add(() -> ItemProperties.register(this, new ResourceLocation(UnusualFishMod.MOD_ID, "variant"), (stack, world, player, i) -> stack.hasTag() ? stack.getTag().getInt("Variant") : 0)));
	}
}