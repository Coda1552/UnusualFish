package codyhuh.unusualfishmod.client.geo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;

import static codyhuh.unusualfishmod.UnusualFishMod.loc;

public class GenericGeoModel<E extends LivingEntity & GeoEntity> extends GeoModel<E> {
    private final String model;
    private final String texture;
    private final String anim;

    public GenericGeoModel(String name) {
        this(name, name, name);
    }

    public GenericGeoModel(String model, String texture, String anim) {
        this.model = model;
        this.texture = texture;
        this.anim = anim;
    }


    @Override
    public ResourceLocation getModelResource(E object) {
        return loc("geo/entity/" + model + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(E object) {
        return loc("textures/entity/" + texture + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(E object) {
        return loc("animations/entity/" + anim + ".animation.json");
    }
}