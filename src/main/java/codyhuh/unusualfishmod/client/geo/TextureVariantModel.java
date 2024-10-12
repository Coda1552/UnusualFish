package codyhuh.unusualfishmod.client.geo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.List;
import java.util.function.Function;

public class TextureVariantModel<E extends LivingEntity & GeoEntity> extends GenericGeoModel<E> {
    List<ResourceLocation> textures;
    Function<E, Integer> whichTexture;

    public TextureVariantModel(String name) {
        super(name);
    }

    public TextureVariantModel<E> setTextures(Function<E, Integer> whichTexture, List<ResourceLocation> textures){
        this.whichTexture = whichTexture;
        this.textures = textures;
        return this;
    }

    @Override
    public ResourceLocation getTextureResource(E object) {
        if (this.textures == null || this.whichTexture == null) return null;
        return this.textures.get(this.whichTexture.apply(object));
    }
}