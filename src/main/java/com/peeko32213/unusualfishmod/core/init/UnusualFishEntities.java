package com.peeko32213.unusualfishmod.core.init;

import com.peeko32213.unusualfishmod.UnusualFishMod;

import com.peeko32213.unusualfishmod.common.entity.ambient.cave.BlindSailfin;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.DroopingGourami;
import com.peeko32213.unusualfishmod.common.entity.ambient.cave.Slatefish;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.CrimsonshellSquid;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.GreenglowLobefin;
import com.peeko32213.unusualfishmod.common.entity.ambient.deep.VoltAngler;
import com.peeko32213.unusualfishmod.common.entity.ambient.land.LobedSkipper;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.BaskingTiamat;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.RedGiantSeaStar;
import com.peeko32213.unusualfishmod.common.entity.ambient.massive.WhiskeredWhaleShark;
import com.peeko32213.unusualfishmod.common.entity.ambient.predator.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.small.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.special.*;
import com.peeko32213.unusualfishmod.common.entity.hostile.*;
import com.peeko32213.unusualfishmod.common.entity.msc.AbyssalBlast;
import com.peeko32213.unusualfishmod.common.entity.msc.AbyssalShot;
import com.peeko32213.unusualfishmod.common.entity.ulitity.*;
import com.peeko32213.unusualfishmod.common.entity.ambient.HatchetFish;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;
@Mod.EventBusSubscriber(modid = UnusualFishMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualFishEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			UnusualFishMod.MOD_ID);

	public static final RegistryObject<EntityType<DualityDamselfish>> DUALITY_DAMSELFISH = ENTITIES.register("duality_damselfish",
			() -> EntityType.Builder.of(DualityDamselfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "duality_damselfish").toString()));

	public static final RegistryObject<EntityType<Mossthorn>> MOSSTHORN = ENTITIES.register("mossthorn",
			() -> EntityType.Builder.of(Mossthorn::new, MobCategory.UNDERGROUND_WATER_CREATURE).sized(0.8f, 1.0f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "mossthorn").toString()));

	public static final RegistryObject<EntityType<Ripper>> RIPPER = ENTITIES.register("ripper",
			() -> EntityType.Builder.of(Ripper::new, MobCategory.WATER_CREATURE).sized(0.9f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "ripper").toString()));

	public static final RegistryObject<EntityType<Spindlefish>> SPINDLEFISH = ENTITIES.register("spindlefish",
			() -> EntityType.Builder.of(Spindlefish::new, MobCategory.WATER_AMBIENT).sized(0.6f, 0.7f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "spindlefish").toString()));

	public static final RegistryObject<EntityType<RhinoTetra>> RHINO_TETRA = ENTITIES.register("rhino_tetra",
			() -> EntityType.Builder.of(RhinoTetra::new, MobCategory.WATER_CREATURE).sized(0.2f, 0.2f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "rhino_tetra").toString()));

	public static final RegistryObject<EntityType<DroopingGourami>> DROOPING_GOURAMI = ENTITIES
			.register("drooping_gourami", () -> EntityType.Builder.of(DroopingGourami::new, MobCategory.WATER_AMBIENT)
					.sized(0.3f, 0.3f).build(new ResourceLocation(UnusualFishMod.MOD_ID, "drooping_gourami").toString()));

	public static final RegistryObject<EntityType<SailorBarb>> SAILOR_BARB = ENTITIES.register("sailor_barb",
			() -> EntityType.Builder.of(SailorBarb::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "sailor_barb").toString()));

	public static final RegistryObject<EntityType<SeaSpider>> SEA_SPIDER = ENTITIES.register("sea_spider",
			() -> EntityType.Builder.of(SeaSpider::new, MobCategory.WATER_AMBIENT).sized(0.9f, 0.9f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "sea_spider").toString()));

	public static final RegistryObject<EntityType<TripleTwirlPleco>> TRIPLE_TWIRL_PLECO = ENTITIES.register("triple_twirl_pleco",
			() -> EntityType.Builder.of(TripleTwirlPleco::new, MobCategory.WATER_AMBIENT).sized(0.9f, 0.9f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "triple_twirl_pleco").toString()));

	public static final RegistryObject<EntityType<AeroMono>> AERO_MONO = ENTITIES.register("aero_mono",
			() -> EntityType.Builder.of(AeroMono::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "aero_mono").toString()));

	public static final RegistryObject<EntityType<ClownthornShark>> CLOWNTHORN_SHARK = ENTITIES.register("clownthorn_shark",
			() -> EntityType.Builder.of(ClownthornShark::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "clownthorn_shark").toString()));

	public static final RegistryObject<EntityType<RoughbackGuitarfish>> ROUGHBACK = ENTITIES.register("roughback_guitarfish",
			() -> EntityType.Builder.of(RoughbackGuitarfish::new, MobCategory.WATER_CREATURE).sized(1.0f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "roughback_guitarfish").toString()));

	public static final RegistryObject<EntityType<RedGiantSeaStar>> REDGIANT_SEASTAR = ENTITIES.register("redgiant_seastar",
			() -> EntityType.Builder.of(RedGiantSeaStar::new, MobCategory.WATER_CREATURE).sized(2.0f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "redgiant_seastar").toString()));

	public static final RegistryObject<EntityType<SeaPancake>> SEA_PANCAKE = ENTITIES.register("sea_pancake",
			() -> EntityType.Builder.of(SeaPancake::new, MobCategory.WATER_CREATURE).sized(3.0f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "sea_pancake").toString()));

	public static final RegistryObject<EntityType<GrandCorydora>> GRAND_CORY = ENTITIES.register("grand_cory",
			() -> EntityType.Builder.of(GrandCorydora::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "grand_cory").toString()));

	public static final RegistryObject<EntityType<PinkfinIdol>> PINKFIN = ENTITIES.register("pinkfin",
			() -> EntityType.Builder.of(PinkfinIdol::new, MobCategory.WATER_CREATURE).sized(1.0f, 1.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "pinkfin").toString()));

	public static final RegistryObject<EntityType<BrickSnail>> BRICK_SNAIL = ENTITIES.register("brick_snail",
			() -> EntityType.Builder.of(BrickSnail::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "brick_snail").toString()));

	public static final RegistryObject<EntityType<ZebraCornetfish>> ZEBRA_CORNETFISH = ENTITIES.register("zebra_cornetfish",
			() -> EntityType.Builder.of(ZebraCornetfish::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "zebra_cornetfish").toString()));

	public static final RegistryObject<EntityType<TigerPuffer>> TIGER_PUFFER = ENTITIES.register("tiger_puffer",
			() -> EntityType.Builder.of(TigerPuffer::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "tiger_puffer").toString()));

	public static final RegistryObject<EntityType<BlackCapSnail>> BLACKCAP_SNAIL = ENTITIES.register("blackcap_snail",
			() -> EntityType.Builder.of(BlackCapSnail::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "blackcap_snail").toString()));

	public static final RegistryObject<EntityType<SneepSnorp>> SNEEPSNORP = ENTITIES.register("sneepsnorp",
			() -> EntityType.Builder.of(SneepSnorp::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "sneepsnorp").toString()));

	public static final RegistryObject<EntityType<DeepCrawler>> DEEP_CRAWLER = ENTITIES.register("deep_crawler",
			() -> EntityType.Builder.of(DeepCrawler::new, MobCategory.WATER_CREATURE).sized(0.9f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "deep_crawler").toString()));

	public static final RegistryObject<EntityType<ManaJellyfish>> WIZARD_JELLY = ENTITIES.register("wizard_jelly",
			() -> EntityType.Builder.of(ManaJellyfish::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "wizard_jelly").toString()));

	public static final RegistryObject<EntityType<PorcupineLobster>> PORCUPINE_LOBSTA = ENTITIES.register("porcupine_lobsta",
			() -> EntityType.Builder.of(PorcupineLobster::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "porcupine_lobsta").toString()));

	public static final RegistryObject<EntityType<TrumpetSquid>> TRUMPET_SQUID = ENTITIES.register("trumpet_squid",
			() -> EntityType.Builder.of(TrumpetSquid::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "trumpet_squid").toString()));

	public static final RegistryObject<EntityType<FreshwaterMantis>> FRESHWATER_MANTIS = ENTITIES.register("freshwater_mantis",
			() -> EntityType.Builder.of(FreshwaterMantis::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "freshwater_mantis").toString()));

	public static final RegistryObject<EntityType<BarkAngelfish>> BARK_ANGELFISH = ENTITIES.register("bark_angelfish",
			() -> EntityType.Builder.of(BarkAngelfish::new, MobCategory.WATER_AMBIENT).sized(0.2f, 0.2f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "bark_angelfish").toString()));

	public static final RegistryObject<EntityType<Shockcat>> SHOCKCAT = ENTITIES.register("shockcat",
			() -> EntityType.Builder.of(Shockcat::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.7f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "shockcat").toString()));

	public static final RegistryObject<EntityType<MuddytopSnail>> MUDDYTOP_SNAIL = ENTITIES.register("muddytop",
			() -> EntityType.Builder.of(MuddytopSnail::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "muddytop").toString()));

	public static final RegistryObject<EntityType<Kalappa>> KALAPPA = ENTITIES.register("kalappa",
			() -> EntityType.Builder.of(Kalappa::new, MobCategory.CREATURE).sized(1.8f, 1.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "kalappa").toString()));

	public static final RegistryObject<EntityType<LobedSkipper>> LOBED_SKIPPER = ENTITIES.register("skipper",
			() -> EntityType.Builder.of(LobedSkipper::new, MobCategory.CREATURE).sized(0.5f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "skipper").toString()));

	public static final RegistryObject<EntityType<StoutBichir>> STOUT_BICHIR = ENTITIES.register("stout_bichir",
			() -> EntityType.Builder.of(StoutBichir::new, MobCategory.WATER_CREATURE).sized(1.0f, 0.7f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "stout_bichir").toString()));

	public static final RegistryObject<EntityType<BeakedHerring>> BEAKED_HERRING = ENTITIES.register("beaked_herring",
			() -> EntityType.Builder.of(BeakedHerring::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "beaked_herring").toString()));

	public static final RegistryObject<EntityType<Picklefish>> PICKLEFISH = ENTITIES.register("picklefish",
			() -> EntityType.Builder.of(Picklefish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "picklefish").toString()));

	public static final RegistryObject<EntityType<BlindSailfin>> BLIND_SAILFIN = ENTITIES.register("blindsailfin",
			() -> EntityType.Builder.of(BlindSailfin::new, MobCategory.WATER_AMBIENT).sized(0.6f, 0.5f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "blindsailfin").toString()));

	public static final RegistryObject<EntityType<DemonHerring>> DEMON_HERRING = ENTITIES.register("demon_herring",
			() -> EntityType.Builder.of(DemonHerring::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "demon_herring").toString()));

	public static final RegistryObject<EntityType<AmberGoby>> AMBER_GOBY = ENTITIES.register("amber_goby",
			() -> EntityType.Builder.of(AmberGoby::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "amber_goby").toString()));

	public static final RegistryObject<EntityType<HatchetFish>> HATCHET_FISH = ENTITIES.register("hatchet_fish",
			() -> EntityType.Builder.of(HatchetFish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "hatchet_fish").toString()));

	public static final RegistryObject<EntityType<Slatefish>> SLATEFISH = ENTITIES.register("slatefish",
			() -> EntityType.Builder.of(Slatefish::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "slatefish").toString()));

	public static final RegistryObject<EntityType<CopperflameAnthias>> COPPERFLAME = ENTITIES.register("copperflame",
			() -> EntityType.Builder.of(CopperflameAnthias::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "copperflame").toString()));

	public static final RegistryObject<EntityType<LongjawRockfish>> LONGJAW = ENTITIES.register("longjaw",
			() -> EntityType.Builder.of(LongjawRockfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "longjaw").toString()));

	public static final RegistryObject<EntityType<Cometfish>> COMET_FISH = ENTITIES.register("comet_fish",
			() -> EntityType.Builder.of(Cometfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "comet_fish").toString()));

	public static final RegistryObject<EntityType<Rootball>> ROOTBALL = ENTITIES.register("rootball",
			() -> EntityType.Builder.of(Rootball::new, MobCategory.MONSTER).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "rootball").toString()));

	public static final RegistryObject<EntityType<CelestialFish>> CELESTIAL_FISH = ENTITIES.register("celestial",
			() -> EntityType.Builder.of(CelestialFish::new, MobCategory.WATER_CREATURE).sized(1.0f, 1.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "celestial").toString()));

	public static final RegistryObject<EntityType<Gnasher>> GNASHER = ENTITIES.register("gnasher",
			() -> EntityType.Builder.of(Gnasher::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "gnasher").toString()));

	public static final RegistryObject<EntityType<Prawn>> PRAWN = ENTITIES.register("prawn",
			() -> EntityType.Builder.of(Prawn::new, MobCategory.MONSTER).sized(1.7f, 1.0f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "prawn").toString()));

	public static final RegistryObject<EntityType<Squoddle>> SQUODDLE = ENTITIES.register("squoddle",
			() -> EntityType.Builder.of(Squoddle::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "squoddle").toString()));

	public static final RegistryObject<EntityType<SeaMosquito>> SEA_MOSQUITO = ENTITIES.register("sea_mosquito",
			() -> EntityType.Builder.of(SeaMosquito::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "sea_mosquito").toString()));

	public static final RegistryObject<EntityType<Forkfish>> FORKFISH = ENTITIES.register("forkfish",
			() -> EntityType.Builder.of(Forkfish::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "forkfish").toString()));

	public static final RegistryObject<EntityType<SpoonShark>> SPOON_SHARK = ENTITIES.register("spoon_shark",
			() -> EntityType.Builder.of(SpoonShark::new, MobCategory.WATER_AMBIENT).sized(1.1f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "spoon_shark").toString()));

	public static final RegistryObject<EntityType<CoralSkrimp>> CORAL_SKRIMP = ENTITIES.register("coral_skrimp",
			() -> EntityType.Builder.of(CoralSkrimp::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "coral_skrimp").toString()));

	public static final RegistryObject<EntityType<CircusFish>> CIRCUSFISH = ENTITIES.register("circus",
			() -> EntityType.Builder.of(CircusFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "circus").toString()));

	public static final RegistryObject<EntityType<BlizzardfinTuna>> BLIZZARDFIN = ENTITIES.register("blizzardfin",
			() -> EntityType.Builder.of(BlizzardfinTuna::new, MobCategory.WATER_AMBIENT).sized(0.8f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "blizzardfin").toString()));

	public static final RegistryObject<EntityType<WhiskeredWhaleShark>> WHISKERED_WHALE_SHARK = ENTITIES.register("whiskered",
			() -> EntityType.Builder.of(WhiskeredWhaleShark::new, MobCategory.WATER_CREATURE).sized(2.5f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "whiskered").toString()));

	public static final RegistryObject<EntityType<BaskingTiamat>> BASKING_TIAMAT = ENTITIES.register("basking_tiamat",
			() -> EntityType.Builder.of(BaskingTiamat::new, MobCategory.WATER_CREATURE).sized(5.5f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "basking_tiamat").toString()));

	public static final RegistryObject<EntityType<BaskingTiamatBaby>> BABY_BASKING_TIAMAT = ENTITIES.register("basking_tiamat_baby",
			() -> EntityType.Builder.of(BaskingTiamatBaby::new, MobCategory.WATER_CREATURE).sized(1.5f, 0.8f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "basking_tiamat_baby").toString()));

	public static final RegistryObject<EntityType<SmelterSnail>> SMELTER_SNAIL = ENTITIES.register("smelter_snail",
			() -> EntityType.Builder.of(SmelterSnail::new, MobCategory.WATER_CREATURE).sized(2.0f, 2.0f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "smelter_snail").toString()));

	public static final RegistryObject<EntityType<AbyssalBlast>> ABYSSAL_BLAST = ENTITIES.register("abyssal_blast",
			() -> registerEntity(EntityType.Builder.of(AbyssalBlast::new, MobCategory.MISC).sized(2.0F, 0.2F)
					.setCustomClientFactory(AbyssalBlast::new).fireImmune(), "abyssal_blast"));

	public static final RegistryObject<EntityType<AbyssalShot>> ABYSSAL_SHOT = ENTITIES.register("abyssal_shot",
			() -> registerEntity(EntityType.Builder.of(AbyssalShot::new, MobCategory.MISC).sized(1.0F, 1.0F)
					.setCustomClientFactory(AbyssalShot::new).fireImmune(), "abyssal_shot"));

	public static final RegistryObject<EntityType<SnowflakeTailFish>> SNOWFLAKE = ENTITIES.register("snowflaketail",
			() -> EntityType.Builder.of(SnowflakeTailFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "snowflaketail").toString()));

	public static final RegistryObject<EntityType<Eyekito>> EYEKITO = ENTITIES.register("eyekito",
			() -> EntityType.Builder.of(Eyekito::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "eyekito").toString()));

	public static final RegistryObject<EntityType<EyelashFish>> EYELASH = ENTITIES.register("eyelash",
			() -> EntityType.Builder.of(EyelashFish::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "eyelash").toString()));

	public static final RegistryObject<EntityType<TigerJungleShark>> TIGER_JUNGLE_SHARK = ENTITIES.register("jungleshark",
			() -> EntityType.Builder.of(TigerJungleShark::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "jungleshark").toString()));

	public static final RegistryObject<EntityType<CrimsonshellSquid>> CRIMSONSHELL_SQUID = ENTITIES.register("crimsonshell",
			() -> EntityType.Builder.of(CrimsonshellSquid::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "crimsonshell").toString()));

	public static final RegistryObject<EntityType<GreenglowLobefin>> GREENGLOW_LOBED_FIN = ENTITIES.register("greenglow",
			() -> EntityType.Builder.of(GreenglowLobefin::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "greenglow").toString()));

	public static final RegistryObject<EntityType<VoltAngler>> VOLT_ANGLER = ENTITIES.register("voltangler",
			() -> EntityType.Builder.of(VoltAngler::new, MobCategory.WATER_CREATURE).sized(0.6f, 0.6f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "voltangler").toString()));

	public static final RegistryObject<EntityType<Tribble>> TRIBBLE = ENTITIES.register("tribble",
			() -> EntityType.Builder.of(Tribble::new, MobCategory.WATER_CREATURE).sized(0.8f, 0.2f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "tribble").toString()));

	public static final RegistryObject<EntityType<Trob>> TROB = ENTITIES.register("trob",
			() -> EntityType.Builder.of(Trob::new, MobCategory.WATER_CREATURE).sized(1.2f, 0.3f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "trob").toString()));

	public static final RegistryObject<EntityType<Trite>> TRITE = ENTITIES.register("trite",
			() -> EntityType.Builder.of(Trite::new, MobCategory.WATER_CREATURE).sized(1.7f, 0.4f)
					.build(new ResourceLocation(UnusualFishMod.MOD_ID, "trite").toString()));


	private static final EntityType registerEntity(EntityType.Builder builder, String entityName) {
		return (EntityType) builder.build(entityName);
	}

	public static boolean rollSpawn (int rolls, Random random, MobSpawnType reason){
		if (reason == MobSpawnType.SPAWNER) {
			return true;
		} else {
			return rolls <= 0 || random.nextInt(rolls) == 0;
		}
	}

	}



