package codyhuh.unusualfishmod.core.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class UFFoodProperties {

    // Raw
    public static final FoodProperties RAW_RIPPER = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_AERO_MONO = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 0), 1.0F).build();
    public static final FoodProperties RAW_AERO_MONO_STICK = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 0), 1.0F).build();
    public static final FoodProperties RAW_BUMPFACE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_RHINO_TETRA = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties RAW_SAILOR_BARB = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties RAW_BARK_ANGELFISH = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).fast().build();
    public static final FoodProperties RAW_BLIZZARD_TUNA = new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build();
    public static final FoodProperties RAW_SPINDLEFISH = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_SHOCKCAT = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_MOSSTHORN = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 1), 1.0F).build();
    public static final FoodProperties RAW_LOBSTER = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_SNOWFLAKE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 150, 1), 1.0F).build();
    public static final FoodProperties RAW_EYELASH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties UNUSUAL_FILLET = new FoodProperties.Builder().nutrition(3).saturationMod(0.15F).build();
    public static final FoodProperties RAW_PICKLEFISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_AMBER_GOBY = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_BEAKED_HERRING = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_BLIND_SAILFIN = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_CIRCUS_FISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_COPPERFLAME_ANTHIAS = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_DEMON_HERRING = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_DROOPING_GOURAMI = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_DUALITY_DAMSELFISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_FORKFISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_HATCHETFISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_SNEEP_SNORP = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties RAW_TRIPLE_TWIRL_PLECO = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();

    // Cooked
    public static final FoodProperties COOKED_AERO_MONO_STICK = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 150, 1), 1.0F).build();
    public static final FoodProperties COOKED_BUMPFACE = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties COOKED_RHINO_TETRA = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast().build();
    public static final FoodProperties COOKED_SAILOR_BARB = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).fast().build();
    public static final FoodProperties COOKED_BLIZZARD_TUNA = new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build();
    public static final FoodProperties COOKED_BARK_ANGELFISH = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast().build();
    public static final FoodProperties COOKED_MOSSTHORN = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).fast().build();
    public static final FoodProperties COOKED_SHOCKCAT = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).build();
    public static final FoodProperties COOKED_LOBSTER = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).build();
    public static final FoodProperties COOKED_UNUSUAL_FILLET = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).build();

    // Meals
    public static final FoodProperties LOBSTER_ROLL = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties ODD_FISHSTICKS = new FoodProperties.Builder().nutrition(8).saturationMod(0.5F).build();
    public static final FoodProperties PICKLEDISH = new FoodProperties.Builder().nutrition(8).saturationMod(0.4F).build();
    public static final FoodProperties STRANGE_BROTH = new FoodProperties.Builder().nutrition(12).saturationMod(0.85F).build();
    public static final FoodProperties UNUSUAL_SANDWICH = new FoodProperties.Builder().nutrition(14).saturationMod(0.7F).build();
    public static final FoodProperties WEIRD_GOLDFISH = new FoodProperties.Builder().nutrition(4).saturationMod(0.35F).fast().build();
}
