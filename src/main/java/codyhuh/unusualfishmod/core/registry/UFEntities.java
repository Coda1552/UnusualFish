package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.entity.*;
import codyhuh.unusualfishmod.common.entity.item.AbyssalBlast;
import codyhuh.unusualfishmod.common.entity.item.FallingTreeBlockEntity;
import codyhuh.unusualfishmod.common.entity.item.SeaSpike;
import codyhuh.unusualfishmod.common.entity.item.ThrownPrismarineSpear;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UFEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UnusualFishMod.MOD_ID);

	// Living
	public static final DeferredHolder<EntityType<?>, EntityType<DualityDamselfish>> DUALITY_DAMSELFISH = ENTITIES.register("duality_damselfish", () -> EntityType.Builder.of(DualityDamselfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f).build("duality_damselfish"));
	public static final DeferredHolder<EntityType<?>, EntityType<Mossthorn>> MOSSTHORN = ENTITIES.register("mossthorn", () -> EntityType.Builder.of(Mossthorn::new, MobCategory.UNDERGROUND_WATER_CREATURE).sized(0.8f, 1.0f).build("mossthorn"));
	public static final DeferredHolder<EntityType<?>, EntityType<Ripper>> RIPPER = ENTITIES.register("ripper", () -> EntityType.Builder.of(Ripper::new, MobCategory.WATER_CREATURE).sized(0.9f, 0.6f).build("ripper"));
	public static final DeferredHolder<EntityType<?>, EntityType<Spindlefish>> SPINDLEFISH = ENTITIES.register("spindlefish", () -> EntityType.Builder.of(Spindlefish::new, MobCategory.WATER_AMBIENT).sized(0.6f, 0.7f).build("spindlefish"));
	public static final DeferredHolder<EntityType<?>, EntityType<RhinoTetra>> RHINO_TETRA = ENTITIES.register("rhino_tetra", () -> EntityType.Builder.of(RhinoTetra::new, MobCategory.WATER_AMBIENT).sized(1.0f, 0.8f).build("rhino_tetra"));
	public static final DeferredHolder<EntityType<?>, EntityType<DroopingGourami>> DROOPING_GOURAMI = ENTITIES.register("drooping_gourami", () -> EntityType.Builder.of(DroopingGourami::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build("drooping_gourami"));
	public static final DeferredHolder<EntityType<?>, EntityType<SailorBarb>> SAILOR_BARB = ENTITIES.register("sailor_barb", () -> EntityType.Builder.of(SailorBarb::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build("sailor_barb"));
	public static final DeferredHolder<EntityType<?>, EntityType<SeaSpider>> SEA_SPIDER = ENTITIES.register("sea_spider", () -> EntityType.Builder.of(SeaSpider::new, MobCategory.WATER_AMBIENT).sized(0.9f, 0.9f).build("sea_spider"));
	public static final DeferredHolder<EntityType<?>, EntityType<TripleTwirlPleco>> TRIPLE_TWIRL_PLECO = ENTITIES.register("triple_twirl_pleco", () -> EntityType.Builder.of(TripleTwirlPleco::new, MobCategory.WATER_AMBIENT).sized(0.75f, 0.45f).build("triple_twirl_pleco"));
	public static final DeferredHolder<EntityType<?>, EntityType<AeroMono>> AERO_MONO = ENTITIES.register("aero_mono", () -> EntityType.Builder.of(AeroMono::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f).build("aero_mono"));
	public static final DeferredHolder<EntityType<?>, EntityType<ClownthornShark>> CLOWNTHORN_SHARK = ENTITIES.register("clownthorn_shark", () -> EntityType.Builder.of(ClownthornShark::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f).build("clownthorn_shark"));
	public static final DeferredHolder<EntityType<?>, EntityType<RoughbackGuitarfish>> ROUGHBACK = ENTITIES.register("roughback_guitarfish", () -> EntityType.Builder.of(RoughbackGuitarfish::new, MobCategory.WATER_CREATURE).sized(1.0f, 0.3f).build("roughback_guitarfish"));
	public static final DeferredHolder<EntityType<?>, EntityType<SeaPancake>> SEA_PANCAKE = ENTITIES.register("sea_pancake", () -> EntityType.Builder.of(SeaPancake::new, MobCategory.WATER_CREATURE).sized(3.0f, 0.4f).build("sea_pancake"));
	public static final DeferredHolder<EntityType<?>, EntityType<PinkfinIdol>> PINKFIN = ENTITIES.register("pinkfin", () -> EntityType.Builder.of(PinkfinIdol::new, MobCategory.WATER_CREATURE).sized(1.0f, 1.8f).build("pinkfin"));
	public static final DeferredHolder<EntityType<?>, EntityType<BrickSnail>> BRICK_SNAIL = ENTITIES.register("brick_snail", () -> EntityType.Builder.of(BrickSnail::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build("brick_snail"));
	public static final DeferredHolder<EntityType<?>, EntityType<ZebraCornetfish>> ZEBRA_CORNETFISH = ENTITIES.register("zebra_cornetfish", () -> EntityType.Builder.of(ZebraCornetfish::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.3f).build("zebra_cornetfish"));
	public static final DeferredHolder<EntityType<?>, EntityType<TigerPuffer>> TIGER_PUFFER = ENTITIES.register("tiger_puffer", () -> EntityType.Builder.of(TigerPuffer::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.8f).build("tiger_puffer"));
	public static final DeferredHolder<EntityType<?>, EntityType<BlackCapSnail>> BLACKCAP_SNAIL = ENTITIES.register("blackcap_snail", () -> EntityType.Builder.of(BlackCapSnail::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.4f).build("blackcap_snail"));
	public static final DeferredHolder<EntityType<?>, EntityType<SneepSnorp>> SNEEPSNORP = ENTITIES.register("sneep_snorp", () -> EntityType.Builder.of(SneepSnorp::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f).build("sneep_snorp"));
	public static final DeferredHolder<EntityType<?>, EntityType<DeepCrawler>> DEEP_CRAWLER = ENTITIES.register("deep_crawler", () -> EntityType.Builder.of(DeepCrawler::new, MobCategory.WATER_CREATURE).sized(0.9f, 0.5f).build("deep_crawler"));
	public static final DeferredHolder<EntityType<?>, EntityType<ManaJellyfish>> WIZARD_JELLY = ENTITIES.register("wizard_jelly", () -> EntityType.Builder.of(ManaJellyfish::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.5f).build("wizard_jelly"));
	public static final DeferredHolder<EntityType<?>, EntityType<PorcupineLobster>> PORCUPINE_LOBSTA = ENTITIES.register("porcupine_lobsta", () -> EntityType.Builder.of(PorcupineLobster::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.6f).build("porcupine_lobsta"));
	public static final DeferredHolder<EntityType<?>, EntityType<TrumpetSquid>> TRUMPET_SQUID = ENTITIES.register("trumpet_squid", () -> EntityType.Builder.of(TrumpetSquid::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.6f).build("trumpet_squid"));
	public static final DeferredHolder<EntityType<?>, EntityType<FreshwaterMantis>> FRESHWATER_MANTIS = ENTITIES.register("freshwater_mantis", () -> EntityType.Builder.of(FreshwaterMantis::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.6f).build("freshwater_mantis"));
	public static final DeferredHolder<EntityType<?>, EntityType<BarkAngelfish>> BARK_ANGELFISH = ENTITIES.register("bark_angelfish", () -> EntityType.Builder.of(BarkAngelfish::new, MobCategory.WATER_AMBIENT).sized(0.2f, 0.2f).build("bark_angelfish"));
	public static final DeferredHolder<EntityType<?>, EntityType<Shockcat>> SHOCKCAT = ENTITIES.register("shockcat", () -> EntityType.Builder.of(Shockcat::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.7f).build("shockcat"));
	public static final DeferredHolder<EntityType<?>, EntityType<MuddytopSnail>> MUDDYTOP_SNAIL = ENTITIES.register("muddytop", () -> EntityType.Builder.of(MuddytopSnail::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f).build("muddytop"));
	public static final DeferredHolder<EntityType<?>, EntityType<Kalappa>> KALAPPA = ENTITIES.register("kalappa", () -> EntityType.Builder.of(Kalappa::new, MobCategory.CREATURE).sized(1.8f, 1.8f).build("kalappa"));
	public static final DeferredHolder<EntityType<?>, EntityType<LobedSkipper>> LOBED_SKIPPER = ENTITIES.register("skipper", () -> EntityType.Builder.of(LobedSkipper::new, MobCategory.CREATURE).sized(0.5f, 0.6f).eyeHeight(0.2F * 0.6f).build("skipper"));
	public static final DeferredHolder<EntityType<?>, EntityType<StoutBichir>> STOUT_BICHIR = ENTITIES.register("stout_bichir", () -> EntityType.Builder.of(StoutBichir::new, MobCategory.WATER_CREATURE).sized(1.0f, 0.7f).build("stout_bichir"));
	public static final DeferredHolder<EntityType<?>, EntityType<BeakedHerring>> BEAKED_HERRING = ENTITIES.register("beaked_herring", () -> EntityType.Builder.of(BeakedHerring::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.3f).build("beaked_herring"));
	public static final DeferredHolder<EntityType<?>, EntityType<Picklefish>> PICKLEFISH = ENTITIES.register("picklefish", () -> EntityType.Builder.of(Picklefish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("picklefish"));
	public static final DeferredHolder<EntityType<?>, EntityType<BlindSailfin>> BLIND_SAILFIN = ENTITIES.register("blindsailfin", () -> EntityType.Builder.of(BlindSailfin::new, MobCategory.WATER_AMBIENT).sized(0.6f, 0.5f).build("blindsailfin"));
	public static final DeferredHolder<EntityType<?>, EntityType<DemonHerring>> DEMON_HERRING = ENTITIES.register("demon_herring", () -> EntityType.Builder.of(DemonHerring::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("demon_herring"));
	public static final DeferredHolder<EntityType<?>, EntityType<AmberGoby>> AMBER_GOBY = ENTITIES.register("amber_goby", () -> EntityType.Builder.of(AmberGoby::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("amber_goby"));
	public static final DeferredHolder<EntityType<?>, EntityType<HatchetFish>> HATCHET_FISH = ENTITIES.register("hatchet_fish", () -> EntityType.Builder.of(HatchetFish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("hatchet_fish"));
	public static final DeferredHolder<EntityType<?>, EntityType<CopperflameAnthias>> COPPERFLAME = ENTITIES.register("copperflame", () -> EntityType.Builder.of(CopperflameAnthias::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("copperflame"));
	public static final DeferredHolder<EntityType<?>, EntityType<Rootball>> ROOTBALL = ENTITIES.register("rootball", () -> EntityType.Builder.of(Rootball::new, MobCategory.MONSTER).sized(0.5f, 0.4f).build("rootball"));
	public static final DeferredHolder<EntityType<?>, EntityType<CelestialFish>> CELESTIAL_FISH = ENTITIES.register("celestial", () -> EntityType.Builder.of(CelestialFish::new, MobCategory.WATER_CREATURE).sized(1.0f, 1.8f).build("celestial"));
	public static final DeferredHolder<EntityType<?>, EntityType<Gnasher>> GNASHER = ENTITIES.register("gnasher", () -> EntityType.Builder.of(Gnasher::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.8f).build("gnasher"));
	public static final DeferredHolder<EntityType<?>, EntityType<Prawn>> PRAWN = ENTITIES.register("prawn", () -> EntityType.Builder.of(Prawn::new, MobCategory.MONSTER).sized(1.5f, 1.2f).build("prawn"));
	public static final DeferredHolder<EntityType<?>, EntityType<Squoddle>> SQUODDLE = ENTITIES.register("squoddle", () -> EntityType.Builder.of(Squoddle::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("squoddle"));
	public static final DeferredHolder<EntityType<?>, EntityType<SeaMosquito>> SEA_MOSQUITO = ENTITIES.register("sea_mosquito", () -> EntityType.Builder.of(SeaMosquito::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("sea_mosquito"));
	public static final DeferredHolder<EntityType<?>, EntityType<Forkfish>> FORKFISH = ENTITIES.register("forkfish", () -> EntityType.Builder.of(Forkfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("forkfish"));
	public static final DeferredHolder<EntityType<?>, EntityType<SpoonShark>> SPOON_SHARK = ENTITIES.register("spoon_shark", () -> EntityType.Builder.of(SpoonShark::new, MobCategory.WATER_CREATURE).sized(1.1f, 0.4f).build("spoon_shark"));
	public static final DeferredHolder<EntityType<?>, EntityType<Skrimp>> CORAL_SKRIMP = ENTITIES.register("coral_skrimp", () -> EntityType.Builder.of(Skrimp::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f).build("coral_skrimp"));
	public static final DeferredHolder<EntityType<?>, EntityType<CircusFish>> CIRCUS_FISH = ENTITIES.register("circus", () -> EntityType.Builder.of(CircusFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.8f).build("circus"));
	public static final DeferredHolder<EntityType<?>, EntityType<BlizzardfinTuna>> BLIZZARDFIN_TUNA = ENTITIES.register("blizzardfin", () -> EntityType.Builder.of(BlizzardfinTuna::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.8f).build("blizzardfin"));
	public static final DeferredHolder<EntityType<?>, EntityType<SnowflakeTailFish>> SNOWFLAKE = ENTITIES.register("snowflaketail", () -> EntityType.Builder.of(SnowflakeTailFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f).build("snowflaketail"));
	public static final DeferredHolder<EntityType<?>, EntityType<EyelashFish>> EYELASH = ENTITIES.register("eyelash", () -> EntityType.Builder.of(EyelashFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f).build("eyelash"));
	public static final DeferredHolder<EntityType<?>, EntityType<TigerJungleShark>> TIGER_JUNGLE_SHARK = ENTITIES.register("jungleshark", () -> EntityType.Builder.of(TigerJungleShark::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.4f).build("jungleshark"));
	public static final DeferredHolder<EntityType<?>, EntityType<CrimsonshellSquid>> CRIMSONSHELL_SQUID = ENTITIES.register("crimsonshell", () -> EntityType.Builder.of(CrimsonshellSquid::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f).build("crimsonshell"));
	public static final DeferredHolder<EntityType<?>, EntityType<VoltAngler>> VOLT_ANGLER = ENTITIES.register("volt_angler", () -> EntityType.Builder.of(VoltAngler::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f).build("volt_angler"));
	public static final DeferredHolder<EntityType<?>, EntityType<Tribble>> TRIBBLE = ENTITIES.register("tribble", () -> EntityType.Builder.of(Tribble::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.2f).build("tribble"));

	// Other
	public static final DeferredHolder<EntityType<?>, EntityType<AbyssalBlast>> ABYSSAL_BLAST = ENTITIES.register("abyssal_blast", () -> EntityType.Builder.<AbyssalBlast>of(AbyssalBlast::new, MobCategory.MISC).sized(2.0F, 0.2F).fireImmune().build("abyssal_blast"));
	public static final DeferredHolder<EntityType<?>, EntityType<ThrownPrismarineSpear>> PRISMARINE_SPEAR = ENTITIES.register("prismarine_spear", () -> EntityType.Builder.<ThrownPrismarineSpear>of(ThrownPrismarineSpear::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("prismarine_spear"));
	public static final DeferredHolder<EntityType<?>, EntityType<SeaSpike>> SEA_SPIKE = ENTITIES.register("sea_spike", () -> EntityType.Builder.<SeaSpike>of(SeaSpike::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(20).build("sea_spike"));
	public static final DeferredHolder<EntityType<?>, EntityType<FallingTreeBlockEntity>> FALLING_TREE = ENTITIES.register("falling_tree", () -> EntityType.Builder.<FallingTreeBlockEntity>of(FallingTreeBlockEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).updateInterval(10).clientTrackingRange(20).build("falling_tree"));
}



