	package codyhuh.unusualfishmod.core.registry;

	import codyhuh.unusualfishmod.UnusualFishMod;
	import codyhuh.unusualfishmod.common.item.*;
	import net.minecraft.ChatFormatting;
	import net.minecraft.Util;
	import net.minecraft.core.Holder;
	import net.minecraft.core.component.DataComponents;
	import net.minecraft.core.registries.BuiltInRegistries;
	import net.minecraft.network.chat.Component;
	import net.minecraft.resources.ResourceLocation;
	import net.minecraft.world.item.*;
	import net.minecraft.world.level.material.Fluids;
	import net.neoforged.neoforge.registries.DeferredItem;
	import net.neoforged.neoforge.registries.DeferredRegister;

	import java.util.List;

	import static codyhuh.unusualfishmod.UnusualFishMod.loc;

	public final class UFItems {
		public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UnusualFishMod.MOD_ID);

		private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
		private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
		private static final Component ANCIENT_WEAPON_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", loc("ancient_weapon_upgrade"))).withStyle(TITLE_FORMAT);
		private static final Component ANCIENT_WEAPON_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", loc("smithing_template.ancient_weapon_parts.applies_to"))).withStyle(DESCRIPTION_FORMAT);
		private static final Component ANCIENT_WEAPON_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", loc("smithing_template.ancient_weapon_parts.ingredients"))).withStyle(DESCRIPTION_FORMAT);
		private static final Component ANCIENT_WEAPON_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", loc("smithing_template.ancient_weapon_parts.base_slot_description")));
		private static final Component ANCIENT_WEAPON_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", loc("smithing_template.ancient_weapon_parts.additions_slot_description")));
		private static final ResourceLocation EMPTY_SLOT_WEAPON_PARTS = loc("item/empty_slot_weapon_parts");
		private static final ResourceLocation EMPTY_SLOT_DEPTH_CLAW = loc("item/empty_slot_depth_claw");
		private static final ResourceLocation EMPTY_SLOT_RIPPER_TOOTH = loc("item/empty_slot_ripper_tooth");

		// Foods
		public static final DeferredItem<Item> RAW_EYELASH = ITEMS.register("raw_eyelash", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_EYELASH)));
		public static final DeferredItem<Item> RAW_SPINDLEFISH = ITEMS.register("raw_spindlefish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_SPINDLEFISH)));
		public static final DeferredItem<Item> RAW_SNOWFLAKE = ITEMS.register("raw_snowflake", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_SNOWFLAKE)));
		public static final DeferredItem<Item> RAW_AERO_MONO = ITEMS.register("raw_aero_mono", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_AERO_MONO)));
		public static final DeferredItem<Item> RAW_PICKLEFSIH = ITEMS.register("raw_picklefish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_PICKLEFISH)));
		public static final DeferredItem<Item> RAW_AMBER_GOBY = ITEMS.register("raw_amber_goby", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_AMBER_GOBY)));
		public static final DeferredItem<Item> RAW_BEAKED_HERRING = ITEMS.register("raw_beaked_herring", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_BEAKED_HERRING)));
		public static final DeferredItem<Item> RAW_BLIND_SAILFIN = ITEMS.register("raw_blind_sailfin", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_BLIND_SAILFIN)));
		public static final DeferredItem<Item> RAW_CIRCUS_FISH = ITEMS.register("raw_circus_fish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_CIRCUS_FISH)));
		public static final DeferredItem<Item> RAW_COPPERFLAME_ANTHIAS = ITEMS.register("raw_copperflame_anthias", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_COPPERFLAME_ANTHIAS)));
		public static final DeferredItem<Item> RAW_DEMON_HERRING = ITEMS.register("raw_demon_herring", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_DEMON_HERRING)));
		public static final DeferredItem<Item> RAW_DROOPING_GOURAMI = ITEMS.register("raw_drooping_gourami", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_DROOPING_GOURAMI)));
		public static final DeferredItem<Item> RAW_DUALITY_DAMSELFISH = ITEMS.register("raw_duality_damselfish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_DUALITY_DAMSELFISH)));
		public static final DeferredItem<Item> RAW_FORKFISH = ITEMS.register("raw_forkfish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_FORKFISH)));
		public static final DeferredItem<Item> RAW_HATCHETFISH = ITEMS.register("raw_hatchetfish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_HATCHETFISH)));
		public static final DeferredItem<Item> RAW_SNEEP_SNORP = ITEMS.register("raw_sneep_snorp", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_SNEEP_SNORP)));
		public static final DeferredItem<Item> RAW_TRIPLE_TWIRL_PLECO = ITEMS.register("raw_triple_twirl_pleco", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_TRIPLE_TWIRL_PLECO)));
		//public static final DeferredItem<Item> UNUSUAL_FILLET = ITEMS.register("unusual_fillet", () -> new Item(new Item.Properties().food(UFFoodProperties.UNUSUAL_FILLET)));

		public static final DeferredItem<Item> RAW_AERO_MONO_STICK = ITEMS.register("raw_aero_mono_stick", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_AERO_MONO_STICK)));
		public static final DeferredItem<Item> COOKED_AERO_MONO_STICK = ITEMS.register("cooked_aero_mono_stick", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_AERO_MONO_STICK)));
		//public static final DeferredItem<Item> RAW_BUMPFACE = ITEMS.register("raw_bumpface", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_BUMPFACE)));
		public static final DeferredItem<Item> RAW_SAILOR_BARB = ITEMS.register("raw_sailor_barb", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_SAILOR_BARB)));
		public static final DeferredItem<Item> RAW_BARK_ANGELFISH = ITEMS.register("raw_bark_angelfish", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_BARK_ANGELFISH)));
		public static final DeferredItem<Item> RAW_BLIZZARD_TUNA = ITEMS.register("raw_blizzard_tuna", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_BLIZZARD_TUNA)));
		public static final DeferredItem<Item> COOKED_BLIZZARD_TUNA = ITEMS.register("cooked_blizzard_tuna", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_BLIZZARD_TUNA)));
		public static final DeferredItem<Item> RAW_SHOCKCAT = ITEMS.register("raw_shockcat", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_SHOCKCAT)));
		public static final DeferredItem<Item> COOKED_SHOCKCAT = ITEMS.register("cooked_shockcat", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_SHOCKCAT)));
		public static final DeferredItem<Item> RAW_LOBSTER = ITEMS.register("raw_lobster", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_LOBSTER)));
		public static final DeferredItem<Item> COOKED_LOBSTER = ITEMS.register("cooked_lobster", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_LOBSTER)));
		public static final DeferredItem<Item> RAW_MOSSTHORN = ITEMS.register("raw_mossthorn", () -> new Item(new Item.Properties().food(UFFoodProperties.RAW_MOSSTHORN)));
		public static final DeferredItem<Item> COOKED_MOSSTHORN = ITEMS.register("cooked_mossthorn", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_MOSSTHORN)));
		public static final DeferredItem<Item> COOKED_UNUSUAL_FILLET = ITEMS.register("cooked_unusual_fillet", () -> new Item(new Item.Properties().food(UFFoodProperties.COOKED_UNUSUAL_FILLET)));
		public static final DeferredItem<Item> LOBSTER_ROLL = ITEMS.register("lobster_roll", () -> new Item(new Item.Properties().food(UFFoodProperties.LOBSTER_ROLL)));
		public static final DeferredItem<Item> ODD_FISHSTICKS = ITEMS.register("odd_fishsticks", () -> new Item(new Item.Properties().food(UFFoodProperties.ODD_FISHSTICKS)));
		public static final DeferredItem<Item> PICKLEDISH = ITEMS.register("pickledish", () -> new Item(new Item.Properties().food(UFFoodProperties.PICKLEDISH).stacksTo(1)));
		public static final DeferredItem<Item> STRANGE_BROTH = ITEMS.register("strange_broth", () -> new Item(new Item.Properties().food(UFFoodProperties.STRANGE_BROTH).stacksTo(1)));
		public static final DeferredItem<Item> UNUSUAL_SANDWICH = ITEMS.register("unusual_sandwich", () -> new Item(new Item.Properties().food(UFFoodProperties.UNUSUAL_SANDWICH)));
		public static final DeferredItem<Item> WEIRD_GOLDFISH = ITEMS.register("weird_goldfish", () -> new Item(new Item.Properties().food(UFFoodProperties.WEIRD_GOLDFISH)));

		// Drops
		public static final DeferredItem<Item> TENDRIL = ITEMS.register("tendril", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> RIPPER_TOOTH = ITEMS.register("ripper_tooth", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> LOBSTER_SPIKE = ITEMS.register("lobster_spike", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> RELUCENT_SHARD = ITEMS.register("relucent_shard", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> CRIMSON_SHARD = ITEMS.register("crimson_shard", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> DEPTH_CLAW = ITEMS.register("depth_claw", () -> new Item(new Item.Properties()));

		// Gear
		public static final DeferredItem<Item> DEPTH_SCYTHE = ITEMS.register("depth_scythe", () -> new DepthScytheItem(Tiers.DIAMOND, new Item.Properties().durability(600).attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.4F))));
		public static final DeferredItem<Item> RIPSAW = ITEMS.register("ripsaw", () -> new RipsawItem(new Item.Properties().stacksTo(1).attributes(AxeItem.createAttributes(UFTiers.RIPPER_SAW, 7.0F, -1.0F))));
		public static final DeferredItem<Item> FLUVIAL_SHELL = ITEMS.register("fluvial_shell", () -> new WeatherShellItem("rain", new Item.Properties().stacksTo(1).durability(1)));
		public static final DeferredItem<Item> CLEMENT_SHELL = ITEMS.register("clement_shell", () -> new WeatherShellItem("clear", new Item.Properties().stacksTo(1).durability(1)));
		public static final DeferredItem<Item> THUNDEROUS_SHELL = ITEMS.register("thunderous_shell", () -> new WeatherShellItem("thunder", new Item.Properties().stacksTo(1).durability(1)));
		public static final DeferredItem<Item> PRISMARINE_SPEAR = ITEMS.register("prismarine_spear", () -> new PrismarineSpearItem(new Item.Properties().stacksTo(1).durability(100)));
		public static final DeferredItem<Item> WEAPON_PARTS = ITEMS.register("weapon_parts", () -> new Item(new Item.Properties()));
		public static final DeferredItem<Item> ANCIENT_WEAPON_SMITHING_TEMPLATE = ITEMS.register("ancient_weapon_smithing_template", () -> new SmithingTemplateItem(ANCIENT_WEAPON_APPLIES_TO, ANCIENT_WEAPON_INGREDIENTS, ANCIENT_WEAPON_UPGRADE, ANCIENT_WEAPON_ADDITIONS_SLOT_DESCRIPTION, ANCIENT_WEAPON_BASE_SLOT_DESCRIPTION, List.of(EMPTY_SLOT_WEAPON_PARTS), List.of(EMPTY_SLOT_DEPTH_CLAW, EMPTY_SLOT_RIPPER_TOOTH)));
		public static final DeferredItem<Item> MUSIC_DISC_SEAFOAM = ITEMS.register("music_disc_seafoam", () -> new Item(new Item.Properties().component(DataComponents.JUKEBOX_PLAYABLE, new JukeboxPlayable(new EitherHolder<>(UFSounds.SEAFOAM_SONG), true)).stacksTo(1).rarity(Rarity.RARE)));
		//public static final DeferredItem<Item> STARGAZER = ITEMS.register("stargazer", () -> new StargazerItem(new Item.Properties().tab(UnusualFishMod.UNUSUAL_TAB).stacksTo(1)));


		// Buckets
		public static final DeferredItem<Item> AERO_MONO_BUCKET = ITEMS.register("aero_mono_bucket", () -> new UFFishBucketItem(UFEntities.AERO_MONO, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		//public static final DeferredItem<Item> RHINO_TETRA_BUCKET = ITEMS.register("rhino_tetra_bucket", () -> new UFFishBucketItem(UFEntities.RHINO_TETRA, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> DUALITY_DAMSELFISH_BUCKET = ITEMS.register("duality_damselfish_bucket", () -> new UFFishBucketItem(UFEntities.DUALITY_DAMSELFISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> DROOPING_GOURAMI_BUCKET = ITEMS.register("drooping_gourami_bucket", () -> new UFFishBucketItem(UFEntities.DROOPING_GOURAMI, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> MOSSTHORN_BUCKET = ITEMS.register("mossthorn_bucket", () -> new UFFishBucketItem(UFEntities.MOSSTHORN, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SAILOR_BARB_BUCKET = ITEMS.register("sailor_barb_bucket", () -> new UFFishBucketItem(UFEntities.SAILOR_BARB, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> TRIPLE_TWIRL_PLECO_BUCKET = ITEMS.register("triple_twirl_pleco_bucket", () -> new UFFishBucketItem(UFEntities.TRIPLE_TWIRL_PLECO, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SPINDLEFISH_BUCKET = ITEMS.register("spindlefish_bucket", () -> new UFFishBucketItem(UFEntities.SPINDLEFISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> RIPPER_BUCKET = ITEMS.register("ripper_bucket", () -> new UFFishBucketItem(UFEntities.RIPPER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SEA_SPIDER_BUCKET = ITEMS.register("sea_spider_bucket", () -> new UFFishBucketItem(UFEntities.SEA_SPIDER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> CLOWNTHORN_SHARK_BUCKET = ITEMS.register("clownthorn_shark_bucket", () -> new UFFishBucketItem(UFEntities.CLOWNTHORN_SHARK, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SNEEPSNORP_BUCKET = ITEMS.register("sneepsnorp_bucket", () -> new UFFishBucketItem(UFEntities.SNEEPSNORP, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BLACKCAP_SNAIL_BUCKET = ITEMS.register("blackcap_snail_bucket", () -> new UFFishBucketItem(UFEntities.BLACKCAP_SNAIL, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BRICK_SNAIL_BUCKET = ITEMS.register("brick_snail_bucket", () -> new UFFishBucketItem(UFEntities.BRICK_SNAIL, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> DEEP_CRAWLER_BUCKET = ITEMS.register("deep_crawler_bucket", () -> new UFFishBucketItem(UFEntities.DEEP_CRAWLER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> WIZARD_JELLY_BUCKET = ITEMS.register("wizard_jelly_bucket", () -> new UFFishBucketItem(UFEntities.WIZARD_JELLY, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> PORCUPINE_LOBSTA_BUCKET = ITEMS.register("porcupine_lobsta_bucket", () -> new UFFishBucketItem(UFEntities.PORCUPINE_LOBSTA, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> FRESHWATER_MANTIS_BUCKET = ITEMS.register("freshwater_mantis_bucket", () -> new UFFishBucketItem(UFEntities.FRESHWATER_MANTIS, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BARK_ANGELFISH_BUCKET = ITEMS.register("bark_angelfish_bucket", () -> new UFFishBucketItem(UFEntities.BARK_ANGELFISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SKIPPER_BUCKET = ITEMS.register("lobed_skipper_bucket", () -> new UFFishBucketItem(UFEntities.LOBED_SKIPPER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BEAKED_HERRING_BUCKET = ITEMS.register("beaked_herring_bucket", () -> new UFFishBucketItem(UFEntities.BEAKED_HERRING, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> PICKLEFISH_BUCKET = ITEMS.register("picklefish_bucket", () -> new UFFishBucketItem(UFEntities.PICKLEFISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BLIND_SAILFIN_BUCKET = ITEMS.register("blind_sailfin_bucket", () -> new UFFishBucketItem(UFEntities.BLIND_SAILFIN, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> DEMON_HERRING_BUCKET = ITEMS.register("demon_herring_bucket", () -> new UFFishBucketItem(UFEntities.DEMON_HERRING, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> AMBER_GOBY_BUCKET = ITEMS.register("amber_goby_bucket", () -> new UFFishBucketItem(UFEntities.AMBER_GOBY, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> HATCHET_FISH_BUCKET = ITEMS.register("hatchet_fish_bucket", () -> new UFFishBucketItem(UFEntities.HATCHET_FISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> COPPERFLAME_BUCKET = ITEMS.register("copperflame_bucket", () -> new UFFishBucketItem(UFEntities.COPPERFLAME, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SQUODDLE_BUCKET = ITEMS.register("squoddle_bucket", () -> new UFFishBucketItem(UFEntities.SQUODDLE, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SEA_MOSQUITO_BUCKET = ITEMS.register("sea_mosquito_bucket", () -> new UFFishBucketItem(UFEntities.SEA_MOSQUITO, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> FORKFISH_BUCKET = ITEMS.register("forkfish_bucket", () -> new UFFishBucketItem(UFEntities.FORKFISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SPOON_SHARK_BUCKET = ITEMS.register("spoon_shark_bucket", () -> new UFFishBucketItem(UFEntities.SPOON_SHARK, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> CORAL_SKRIMP_BUCKET = ITEMS.register("coral_skrimp_bucket", () -> new UFFishBucketItem(UFEntities.CORAL_SKRIMP, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> CIRCUS_FISH_BUCKET = ITEMS.register("circus_fish_bucket", () -> new UFFishBucketItem(UFEntities.CIRCUS_FISH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> EYELASH_FISH_BUCKET = ITEMS.register("eyelash_fish_bucket", () -> new UFFishBucketItem(UFEntities.EYELASH, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SNOWFLAKE_TAIL_FISH_BUCKET = ITEMS.register("snowflake_tail_fish_bucket", () -> new UFFishBucketItem(UFEntities.SNOWFLAKE, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> CRIMSONSHELL_SQUID_BUCKET = ITEMS.register("crimsonshell_squid_bucket", () -> new UFFishBucketItem(UFEntities.CRIMSONSHELL_SQUID, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> VOLT_ANGLER_BUCKET = ITEMS.register("volt_angler_bucket", () -> new UFFishBucketItem(UFEntities.VOLT_ANGLER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> BLIZZARDFIN_BUCKET = ITEMS.register("blizzardfin_bucket", () -> new UFFishBucketItem(UFEntities.BLIZZARDFIN_TUNA, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> MUDDYTOP_SNAIL_BUCKET = ITEMS.register("muddytop_snail_bucket", () -> new UFFishBucketItem(UFEntities.MUDDYTOP_SNAIL, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> SHOCKCAT_BUCKET = ITEMS.register("shockcat_bucket", () -> new UFFishBucketItem(UFEntities.SHOCKCAT, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> PINKFIN_IDOL_BUCKET = ITEMS.register("pinkfin_idol_bucket", () -> new UFFishBucketItem(UFEntities.PINKFIN, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> TIGER_PUFFER_BUCKET = ITEMS.register("tiger_puffer_bucket", () -> new UFFishBucketItem(UFEntities.TIGER_PUFFER, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> STOUT_BICHIR_BUCKET = ITEMS.register("stout_bichir_bucket", () -> new UFFishBucketItem(UFEntities.STOUT_BICHIR, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> TRIBBLE_BUCKET = ITEMS.register("tribble_bucket", () -> new UFFishBucketItem(UFEntities.TRIBBLE, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));
		public static final DeferredItem<Item> TRUMPET_SQUID_BUCKET = ITEMS.register("trumpet_squid_bucket", () -> new UFFishBucketItem(UFEntities.TRUMPET_SQUID, () -> Fluids.WATER, Items.BUCKET, false, new Item.Properties().stacksTo(1)));

		// Spawn Eggs
		public static final DeferredItem<SpawnEggItem> AERO_MONO_SPAWN_EGG = ITEMS.register("aero_mono_spawn_egg", () -> new SpawnEggItem(UFEntities.AERO_MONO.get(), 0x8ca8b5, 0x506884, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> PINKFIN_SPAWN_EGG = ITEMS.register("pinkfin_spawn_egg", () -> new SpawnEggItem(UFEntities.PINKFIN.get(), 0x0e011e, 0x421054, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BARBED_SPAWN_EGG = ITEMS.register("roughback_guitarfish_spawn_egg", () -> new SpawnEggItem(UFEntities.ROUGHBACK.get(), 0x5e5d4f, 0x92998e, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> CLOWNTHORN_SPAWN_EGG = ITEMS.register("clownthorn_shark_spawn_egg", () -> new SpawnEggItem(UFEntities.CLOWNTHORN_SHARK.get(), 0xbe5515, 0xa21e00, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> DUALITY_SPAWN_EGG = ITEMS.register("duality_damselfish_spawn_egg", () -> new SpawnEggItem(UFEntities.DUALITY_DAMSELFISH.get(), 0x8a94a1, 0x2c3338, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> DROOPING_GOURAMI_SPAWN_EGG = ITEMS.register("drooping_gourami_spawn_egg", () -> new SpawnEggItem(UFEntities.DROOPING_GOURAMI.get(), 0x54434d, 0x363243, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> MOSSTHORN_SPAWN_EGG = ITEMS.register("mossthorn_spawn_egg", () -> new SpawnEggItem(UFEntities.MOSSTHORN.get(), 0x26a529, 0x034223, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> RHINO_TETRA_SPAWN_EGG = ITEMS.register("rhino_tetra_spawn_egg", () -> new SpawnEggItem(UFEntities.RHINO_TETRA.get(), 0x919187, 0x7b2726, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> RIPPER_SPAWN_EGG = ITEMS.register("ripper_spawn_egg", () -> new SpawnEggItem(UFEntities.RIPPER.get(), 0x565950, 0x8f9386, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SAILOR_BARB_PAWN_EGG = ITEMS.register("sailor_barb_spawn_egg", () -> new SpawnEggItem(UFEntities.SAILOR_BARB.get(), 0x5e6a25, 0xa1a68c, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SEA_PANCAKE_SPAWN_EGG = ITEMS.register("sea_pancake_spawn_egg", () -> new SpawnEggItem(UFEntities.SEA_PANCAKE.get(), 0xbda877, 0xdfcbb7, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SEA_SPIDER_SPAWN_EGG = ITEMS.register("sea_spider_spawn_egg", () -> new SpawnEggItem(UFEntities.SEA_SPIDER.get(), 0x774128, 0xaf7834, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SPINDLEFISH_SPAWN_EGG = ITEMS.register("spindlefish_spawn_egg", () -> new SpawnEggItem(UFEntities.SPINDLEFISH.get(), 0x8e2573, 0xc14aeb, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> TRIPLE_TWIRL_PLECO_SPAWN_EGG = ITEMS.register("triple_twirl_pleco_spawn_egg", () -> new SpawnEggItem(UFEntities.TRIPLE_TWIRL_PLECO.get(), 0xc1923a, 0x903113, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BRICK_SNAIL_SPAWN_EGG = ITEMS.register("brick_snail_spawn_egg", () -> new SpawnEggItem(UFEntities.BRICK_SNAIL.get(), 0xb5553b, 0x674f17, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> ZEBRA_CORNETFISH_SPAWN_EGG = ITEMS.register("zebra_cornetfish_spawn_egg", () -> new SpawnEggItem(UFEntities.ZEBRA_CORNETFISH.get(), 0x153957, 0xc7ad0d, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> TIGER_PUFFER_SPAWN_EGG = ITEMS.register("tiger_puffer_spawn_egg", () -> new SpawnEggItem(UFEntities.TIGER_PUFFER.get(), 0x622814, 0x84736f, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BLACKCAP_SNAIL_SPAWN_EGG = ITEMS.register("blackcap_snail_spawn_egg", () -> new SpawnEggItem(UFEntities.BLACKCAP_SNAIL.get(), 0x262917, 0x4c3d27, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SNEEPSNORP_EGG = ITEMS.register("sneepsnorp_spawn_egg", () -> new SpawnEggItem(UFEntities.SNEEPSNORP.get(), 0x3347a7, 0xce8a24, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> DEEP_CRAWLER_SPAWN_EGG = ITEMS.register("deep_crawler_spawn_egg", () -> new SpawnEggItem(UFEntities.DEEP_CRAWLER.get(), 0x536761, 0x34363f, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> WIZARD_JELLY_SPAWN_EGG = ITEMS.register("wizard_jelly_spawn_egg", () -> new SpawnEggItem(UFEntities.WIZARD_JELLY.get(), 0x5550b4, 0x3aa8d7, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> PORCUPINE_LOBSTA_SPAWN_EGG = ITEMS.register("porcupine_lobsta_spawn_egg", () -> new SpawnEggItem(UFEntities.PORCUPINE_LOBSTA.get(), 0x624736, 0x9e521b, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> TRUMPET_SQUID_SPAWN_EGG = ITEMS.register("trumpet_squid_spawn_egg", () -> new SpawnEggItem(UFEntities.TRUMPET_SQUID.get(), 0xe8d26a, 0xc6a042, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> FRESHWATER_MANTIS_EGG = ITEMS.register("freshwater_mantis_spawn_egg", () -> new SpawnEggItem(UFEntities.FRESHWATER_MANTIS.get(), 0x454629, 0x94ab67, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BARK_ANGELFISH_SPAWN_EGG = ITEMS.register("bark_angelfish_spawn_egg", () -> new SpawnEggItem(UFEntities.BARK_ANGELFISH.get(), 0x553f1a, 0x35270a, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SHOCKCAT_SPAWN_EGG = ITEMS.register("shockcat_spawn_egg", () -> new SpawnEggItem(UFEntities.SHOCKCAT.get(), 0x34294f, 0x255f9b, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> MUDDYTOP_SNAIL_SPAWN_EGG = ITEMS.register("muddytop_snail_spawn_egg", () -> new SpawnEggItem(UFEntities.MUDDYTOP_SNAIL.get(), 0x23100e, 0x5f4d3b, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> KALAPPA_SPAWN_EGG = ITEMS.register("kalappa_spawn_egg", () -> new SpawnEggItem(UFEntities.KALAPPA.get(), 0x624051, 0x886d86, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> LOBED_SKIPPER_SPAWN_EGG = ITEMS.register("lobed_skipper_spawn_egg", () -> new SpawnEggItem(UFEntities.LOBED_SKIPPER.get(), 0x4b2618, 0x9e632f, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> STOUT_BICHIR_SPAWN_EGG = ITEMS.register("stout_bichir_spawn_egg", () -> new SpawnEggItem(UFEntities.STOUT_BICHIR.get(), 0x5a5e3d, 0xb08f33, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BEAKED_HERRING_SPAWN_EGG = ITEMS.register("beaked_herring_spawn_egg", () -> new SpawnEggItem(UFEntities.BEAKED_HERRING.get(), 0x8bacc4, 0xc5d0cf, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> PICKLEFISH_SPAWN_EGG = ITEMS.register("picklefish_spawn_egg", () -> new SpawnEggItem(UFEntities.PICKLEFISH.get(), 0x235806, 0xd0cd07, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BLIND_SAILFIN_SPAWN_EGG = ITEMS.register("blind_sailfin_spawn_egg", () -> new SpawnEggItem(UFEntities.BLIND_SAILFIN.get(), 0xdcccc3, 0xc19c8e, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> DEMON_HERRING_SPAWN_EGG = ITEMS.register("demon_herring_spawn_egg", () -> new SpawnEggItem(UFEntities.DEMON_HERRING.get(), 0x363243, 0xef7930, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> AMBER_GOBY_SPAWN_EGG = ITEMS.register("amber_goby_spawn_egg", () -> new SpawnEggItem(UFEntities.AMBER_GOBY.get(), 0xfb912e, 0xae5e2c, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> HATCHET_FISH_SPAWN_EGG = ITEMS.register("hatchet_fish_spawn_egg", () -> new SpawnEggItem(UFEntities.HATCHET_FISH.get(), 0x0b0b26, 0x7d3283, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> COPPERFLAME_SPAWN_EGG = ITEMS.register("copperflame_spawn_egg", () -> new SpawnEggItem(UFEntities.COPPERFLAME.get(), 0x4fab90, 0x7fcf90, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> ROOTBALL_SPAWN_EGG = ITEMS.register("root_spawn_egg", () -> new SpawnEggItem(UFEntities.ROOTBALL.get(), 0x647233, 0xad7d65, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> CELESTIAL_FISH_SPAWN_EGG = ITEMS.register("celestial_fish_spawn_egg", () -> new SpawnEggItem(UFEntities.CELESTIAL_FISH.get(), 0x6876a2, 0xe2e4c5, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> GNASHER_SPAWN_EGG = ITEMS.register("gnasher_spawn_egg", () -> new SpawnEggItem(UFEntities.GNASHER.get(), 0x323232, 0x465bb2, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> PRAWN_SPAWN_EGG = ITEMS.register("prawn_spawn_egg", () -> new SpawnEggItem(UFEntities.PRAWN.get(), 0x5a579e, 0x4694d1, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SQUODDLE_SPAWN_EGG = ITEMS.register("squoddle_spawn_egg", () -> new SpawnEggItem(UFEntities.SQUODDLE.get(), 0xb37817, 0xe58a2e, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SEA_MOSQUITO_SPAWN_EGG = ITEMS.register("sea_mosquito_spawn_egg", () -> new SpawnEggItem(UFEntities.SEA_MOSQUITO.get(), 0x326934, 0x6c122f, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> FORKFISH_SPAWN_EGG = ITEMS.register("forkfish_spawn_egg", () -> new SpawnEggItem(UFEntities.FORKFISH.get(), 0x8e882c, 0x3dbba0, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SPOON_SHARK_SPAWN_EGG = ITEMS.register("spoon_shark_spawn_egg", () -> new SpawnEggItem(UFEntities.SPOON_SHARK.get(), 0xddbd78, 0xb3925b, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> CORAL_SKRIMP_EGG = ITEMS.register("coral_skrimp_spawn_egg", () -> new SpawnEggItem(UFEntities.CORAL_SKRIMP.get(), 0x5a0e7a, 0xb34aa2, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> CIRCUS_FISH_SPAWN_EGG = ITEMS.register("circus_fish_spawn_egg", () -> new SpawnEggItem(UFEntities.CIRCUS_FISH.get(), 0xab4b36, 0xc88f62, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> BLIZZARDFIN_SPAWN_EGG = ITEMS.register("blizzardfin_spawn_egg", () -> new SpawnEggItem(UFEntities.BLIZZARDFIN_TUNA.get(), 0x9ed7dc, 0x6182a6, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> EYELASH_FISH_SPAWN_EGG = ITEMS.register("eyelash_fish_spawn_egg", () -> new SpawnEggItem(UFEntities.EYELASH.get(), 0xb7b7ba, 0xfcfcfa, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> SNOWFLAKE_TAIL_FISH_SPAWN_EGG = ITEMS.register("snowflake_tail_fish_spawn_egg", () -> new SpawnEggItem(UFEntities.SNOWFLAKE.get(), 0x649ccc, 0xcbe8e6, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> TIGER_JUNGLE_SHARK_SPAWN_EGG = ITEMS.register("tiger_jungle_shark_spawn_egg", () -> new SpawnEggItem(UFEntities.TIGER_JUNGLE_SHARK.get(), 0x272530, 0xa5a8c6, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> CRIMSONSHELL_SQUID_SPAWN_EGG = ITEMS.register("crimsonshell_squid_spawn_egg", () -> new SpawnEggItem(UFEntities.CRIMSONSHELL_SQUID.get(), 0xab101c, 0x432c39, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> VOLT_ANGLER_SPAWN_EGG = ITEMS.register("volt_angler_spawn_egg", () -> new SpawnEggItem(UFEntities.VOLT_ANGLER.get(), 0x2d4035, 0x509033, new Item.Properties()));
		public static final DeferredItem<SpawnEggItem> TRIBBLE_SPAWN_EGG = ITEMS.register("tribble_spawn_egg", () -> new SpawnEggItem(UFEntities.TRIBBLE.get(), 0x656f26, 0x46491a, new Item.Properties()));
	}
