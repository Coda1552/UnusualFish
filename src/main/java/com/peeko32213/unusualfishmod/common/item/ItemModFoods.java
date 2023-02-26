package com.peeko32213.unusualfishmod.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ItemModFoods {

    //Raw
    public static final FoodProperties RAW_RIPPER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().effect(new MobEffectInstance(MobEffects.HUNGER, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_AERO_MONO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_AERO_MONO_STICK = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_BUMPFACE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_TETRA_RHINO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().fast().build();
    public static final FoodProperties RAW_SAILOR_BARB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().fast().build();
    public static final FoodProperties RAW_BARK_ANGEL = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().fast().build();
    public static final FoodProperties RAW_VEIL_TENTACLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_BLIZZARD_TUNA = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_SPINDLEFISH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().effect(new MobEffectInstance(MobEffects.POISON, 200, 1), 1.0F).effect(new MobEffectInstance(MobEffects.WEAKNESS, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_SHOCKCAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_MOSSTHORN = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).meat().effect(new MobEffectInstance(MobEffects.POISON, 200, 1), 1.0F).build();
    public static final FoodProperties RAW_LOBSTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_SNOWFLAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_EYEKITO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();
    public static final FoodProperties RAW_EYELASH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).meat().build();

    //Cooked
    public static final FoodProperties COOKED_AERO_MONO_STICK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).meat().fast().effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 1), 1.0F).build();
    public static final FoodProperties COOKED_BUMPFACE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).meat().build();
    public static final FoodProperties COOKED_TETRA_RHINO = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).meat().fast().build();
    public static final FoodProperties COOKED_SAILOR_BARB = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).meat().fast().build();
    public static final FoodProperties COOKED_VEIL_TENTACLE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_BLIZZARD_TUNA = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_BARK_ANGEL = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).meat().fast().build();
    public static final FoodProperties COOKED_MOSSTHORN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).meat().fast().build();
    public static final FoodProperties COOKED_SHOCKCAT = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).meat().build();
    public static final FoodProperties COOKED_LOBSTER = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).meat().build();
}
