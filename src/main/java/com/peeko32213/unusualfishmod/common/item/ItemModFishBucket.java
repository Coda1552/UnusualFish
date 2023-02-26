package com.peeko32213.unusualfishmod.common.item;

import java.util.function.Supplier;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class ItemModFishBucket extends MobBucketItem {

	public ItemModFishBucket(Supplier<? extends EntityType<?>> entityType, Supplier<? extends Fluid> fluid, Item item,
							 boolean hasTooltip, Properties builder) {
		super(entityType, fluid, () -> SoundEvents.BUCKET_EMPTY_FISH, builder);
		DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> UnusualFishMod.CALLBACKS.add(() ->
				ItemProperties.register(this, new ResourceLocation(UnusualFishMod.MODID, "variant"),
						(stack, world, player, i) -> stack.hasTag() ? stack.getTag().getInt("Variant") : 0)));
	}

}