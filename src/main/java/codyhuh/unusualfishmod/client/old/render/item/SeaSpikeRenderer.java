package codyhuh.unusualfishmod.client.old.render.item;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.item.SeaSpike;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SeaSpikeRenderer extends ArrowRenderer<SeaSpike> {
   public static final ResourceLocation LOCATION = new ResourceLocation(UnusualFishMod.MOD_ID, "textures/entity/item/sea_spike.png");

   public SeaSpikeRenderer(EntityRendererProvider.Context p_174399_) {
      super(p_174399_);
   }

   public ResourceLocation getTextureLocation(SeaSpike p_116001_) {
      return LOCATION;
   }
}