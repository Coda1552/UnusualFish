package codyhuh.unusualfishmod.client;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class UFModelLayers {
    public static final ModelLayerLocation AERO_MONO = create("aero_mono");
    public static final ModelLayerLocation AMBER_GOBY = create("amber_goby");
    public static final ModelLayerLocation BARK_ANGELFISH = create("bark_angelfish");
    public static final ModelLayerLocation BEAKED_HERRING = create("beaked_herring");
    public static final ModelLayerLocation BLACKCAP_SNAIL = create("blackcap_snail");
    public static final ModelLayerLocation BLIND_SAILFIN = create("blind_sailfin");
    public static final ModelLayerLocation BLIZZARDFIN_TUNA = create("blizzardfin_tuna");
    public static final ModelLayerLocation BRICK_SNAIL = create("brick_snail");
    public static final ModelLayerLocation CIRCUS_FISH = create("circus_fish");
    public static final ModelLayerLocation CELESTIAL_FISH = create("celestial_fish");
    public static final ModelLayerLocation CLOWNTHORN_SHARK = create("clownthorn_shark");
    public static final ModelLayerLocation COPPERFLAME_ANTHIAS = create("copperflame_anthias");
    public static final ModelLayerLocation CORAL_SKRIMP = create("coral_skrimp");
    public static final ModelLayerLocation CRIMSONSHELL_SQUID = create("crimsonshell_squid");
    public static final ModelLayerLocation DEEP_CRAWLER = create("deep_crawler");
    public static final ModelLayerLocation DEMON_HERRING = create("demon_herring");
    public static final ModelLayerLocation DROOPING_GOURAMI = create("drooping_gourami");
    public static final ModelLayerLocation DUALITY_DAMSELFISH = create("duality_damselfish");
    public static final ModelLayerLocation EYELASH_FISH = create("eyelash_fish");
    public static final ModelLayerLocation FORKFISH = create("forkfish");
    public static final ModelLayerLocation FRESHWATER_MANTIS = create("freshwater_mantis");
    public static final ModelLayerLocation GNASHER = create("gnasher");
    public static final ModelLayerLocation HATCHET_FISH = create("hatchet_fish");
    public static final ModelLayerLocation KALAPPA = create("kalappa");
    public static final ModelLayerLocation LOBED_SKIPPER = create("lobed_skipper");
    public static final ModelLayerLocation MANA_JELLYFISH = create("mana_jellyfish");
    public static final ModelLayerLocation MOSSTHORN = create("mossthorn");
    public static final ModelLayerLocation MUDDYTOP_SNAIL = create("muddytop_snail");
    public static final ModelLayerLocation PICKLEFISH = create("picklefish");
    public static final ModelLayerLocation PINKFIN_IDOL = create("pinkfin_idol");
    public static final ModelLayerLocation PORCUPINE_LOBSTA = create("porcupine_lobsta");
    public static final ModelLayerLocation PRAWN = create("prawn");
    public static final ModelLayerLocation RHINO_TETRA = create("rhino_tetra");
    public static final ModelLayerLocation RIPPER = create("ripper");
    public static final ModelLayerLocation ROOTBALL = create("rootball");
    public static final ModelLayerLocation ROUGHBACK_GUITARFISH = create("roughback_guitarfish");
    public static final ModelLayerLocation SAILOR_BARB = create("sailor_barb");
    public static final ModelLayerLocation SEA_MOSQUITO = create("sea_mosquito");
    public static final ModelLayerLocation SEA_PANCAKE = create("sea_pancake");
    public static final ModelLayerLocation SEA_SPIDER = create("sea_spider");
    public static final ModelLayerLocation SHOCKCAT = create("shockcat");
    public static final ModelLayerLocation SNEEP_SNORP = create("sneep_snorp");
    public static final ModelLayerLocation SNOWFLAKE_TAIL_FISH = create("snowflake_tail_fish");
    public static final ModelLayerLocation SPINDLEFISH = create("spindlefish");
    public static final ModelLayerLocation SPOON_SHARK = create("spoon_shark");
    public static final ModelLayerLocation SQUODDLE = create("squoddle");
    public static final ModelLayerLocation STOUT_BICHIR = create("stout_bichir");
    public static final ModelLayerLocation TIGER_JUNGLE_SHARK = create("tiger_jungle_shark");
    public static final ModelLayerLocation TIGER_PUFFER = create("tiger_puffer");
    public static final ModelLayerLocation TRIBBLE = create("tribble");
    public static final ModelLayerLocation TRIPLE_TWIRL_PLECO = create("triple_twirl_pleco");
    public static final ModelLayerLocation TRUMPET_SQUID = create("trumpet_squid");
    public static final ModelLayerLocation VOLT_ANGLER = create("volt_angler");
    public static final ModelLayerLocation ZEBRA_CORNETFISH = create("zebra_cornetfish");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(UnusualFishMod.MOD_ID, name), "main");
    }

}
