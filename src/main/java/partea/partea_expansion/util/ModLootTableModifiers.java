package partea.partea_expansion.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import partea.partea_expansion.Enchantments.EnchantBlazeWalker;
import partea.partea_expansion.Enchantments.EnchantGodOfTheSea;
import partea.partea_expansion.Enchantments.EnchantmentGlimmering;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantBloodTherapy;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantCelestialAnnihilation;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantCelestialSnipe;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantRainbowChiseledTeeth;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantCryOfTheWilderness;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantFuneralRitesForSensualWorshippers;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantTheOneWhoIsEncasedInASleeve;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantTheTwilightOfExistence;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance.EnchantIceAspect;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantDoomedDeath;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantExperience;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantPulse;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantPyromania;
import partea.partea_expansion.ModItems;

public class ModLootTableModifiers {
    private static final Identifier Village_Armorer = new Identifier("minecraft", "chests/village/village_armorer");
    private static final Identifier Village_Cartographer = new Identifier("minecraft", "chests/village/village_cartographer");
    private static final Identifier Village_Desert_House = new Identifier("minecraft", "chests/village/village_desert_house");
    private static final Identifier Village_Plains_House = new Identifier("minecraft", "chests/village/village_plains_house");
    private static final Identifier Village_Savanna_House = new Identifier("minecraft", "chests/village/village_savanna_house");
    private static final Identifier Village_Snowy_House = new Identifier("minecraft", "chests/village/village_snowy_house");
    private static final Identifier Village_Taiga_House = new Identifier("minecraft", "chests/village/village_taiga_house");
    private static final Identifier Village_Weaponsmith = new Identifier("minecraft", "chests/village/village_weaponsmith");


    private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");
    private static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    private static final Identifier SQUID_ID = new Identifier("minecraft", "entities/squid");
    private static final Identifier Elder_Guardian = new Identifier("minecraft", "entities/elder_guardian");
    private static final Identifier GLOW_SQUID_ID = new Identifier("minecraft", "entities/glow_squid");

    private static final Identifier ENDER_CITY_ID = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier BURIED_TREASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier SUS_SAND_ID = new Identifier("minecraft", "archaeology/desert_pyramid");
    private static final Identifier SH_LIB_ID = new Identifier("minecraft", "chests/stronghold_library");
    private static final Identifier SH_COR_ID = new Identifier("minecraft", "chests/stronghold_corridor");
    private static final Identifier WOODLAND_ID = new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier BASTION_BRIDGE = new Identifier("minecraft", "chests/bastion_bridge");
    private static final Identifier BASTION_HOGLiN_STABLE = new Identifier("minecraft", "chests/bastion_hoglin_stable");
    private static final Identifier BASTION_TREASURE = new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier RUINED_PORTAL = new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier NETHER_BRIDGE = new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier IGLOO_CHEST = new Identifier("minecraft", "chests/igloo_chest");
    private static final Identifier Shipwreck_Treasure = new Identifier("minecraft", "chests/shipwreck_treasure");
    private static final Identifier Underwater_Ruin_Big = new Identifier("minecraft", "chests/underwater_ruin_big");
    private static final Identifier Underwater_Ruin_Small = new Identifier("minecraft", "chests/underwater_ruin_small");
    private static final Identifier Pillager_Outpost = new Identifier("minecraft", "chests/pillager_outpost");

    public static void modifierLootTables() {



        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(IGLOO_CHEST.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantIceAspect.ICE_ASPECT,UniformLootNumberProvider.create(1f,2f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ANCIENT_CITY_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.07f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantDoomedDeath.Doomed_Death,UniformLootNumberProvider.create(1f,3f)));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.BLACK_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder2.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SH_COR_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FOOLS_MASK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SH_LIB_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.FOOLS_MASK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantExperience.EXPERIENCE,UniformLootNumberProvider.create(1f,2f)));
                tableBuilder.pool(poolBuilder2.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BURIED_TREASURE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(ModItems.SILENT_TIME_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
            if(SUS_SAND_ID.equals(id)){
                LootPool.Builder pool = LootPool.builder()
                        .with(ItemEntry.builder(Items.AMETHYST_SHARD))
                        .with(ItemEntry.builder(Items.ARCHER_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.MINER_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.PRIZE_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.SKULL_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .with(ItemEntry.builder(Items.TNT))
                        .with(ItemEntry.builder(Items.GUNPOWDER))
                        .with(ItemEntry.builder(Items.EMERALD));
                return LootTable.builder().pool(pool).build();
            }
            return null;
        }));



        //生物
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SQUID_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.SLIME_BALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GLOW_SQUID_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.SLIME_BALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(WARDEN_ID.equals(id)){
//                LootPool.Builder poolBuilder = LootPool.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1f))
//                        .with(ItemEntry.builder(ModItems.HEART_OF_THE_DEEP))
//                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
//                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantPulse.PULSE,UniformLootNumberProvider.create(1f,1f)));
                tableBuilder.pool(poolBuilder2.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(CREEPER_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.006f))
                        .with(ItemEntry.builder(ModItems.THRILLER_MASK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Elder_Guardian.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantGodOfTheSea.GOD_OF_THE_SEA,UniformLootNumberProvider.create(1f,1f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));


        //丰饶
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Underwater_Ruin_Big.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantCrystallyClear.CrystallyClear).add(EnchantFayu.Fayu).add(EnchantHannyaShip.HannyaShip)
                                .add(EnchantMerciful.Merciful).add(EnchantYuanyin.Yuanyin));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolAbu = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Abundance))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolAbu.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Underwater_Ruin_Small.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantCrystallyClear.CrystallyClear).add(EnchantFayu.Fayu).add(EnchantHannyaShip.HannyaShip)
                                .add(EnchantMerciful.Merciful).add(EnchantYuanyin.Yuanyin));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolAbu = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Abundance))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolAbu.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Shipwreck_Treasure.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantCrystallyClear.CrystallyClear).add(EnchantFayu.Fayu).add(EnchantHannyaShip.HannyaShip)
                                .add(EnchantMerciful.Merciful).add(EnchantYuanyin.Yuanyin));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantGodOfTheSea.GOD_OF_THE_SEA,UniformLootNumberProvider.create(1f,1f)));
                tableBuilder.pool(poolBuilder2.build());
                LootPool.Builder poolAbu = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Abundance))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolAbu.build());
            }
        }));


        //毁灭
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Pillager_Outpost.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantAfterglowEffect.Afterglow_Effect).add(EnchantAntimatterNoninverseEquation.Antimatter_Noninverse_Equation)
                                .add(EnchantDestructiveFlare.DESTRUCTIVE_FLARE).add(EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW).add(EnchantPreceptFlickering.PRECEPT_FLICKERING)
                                .add(EnchantPredictiveDepthOfField.PREDICTIVE_DEPTH_OF_FIELD));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(WOODLAND_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.FOOLS_MASK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.TEA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder2.build());
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantAfterglowEffect.Afterglow_Effect).add(EnchantAntimatterNoninverseEquation.Antimatter_Noninverse_Equation)
                                .add(EnchantDestructiveFlare.DESTRUCTIVE_FLARE).add(EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW).add(EnchantPreceptFlickering.PRECEPT_FLICKERING)
                                .add(EnchantPredictiveDepthOfField.PREDICTIVE_DEPTH_OF_FIELD));
                tableBuilder.pool(poolBuilder3.build());
            }
        }));



        //虚无
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ENDER_CITY_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.SHED_A_LIGHT_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantCryOfTheWilderness.Cry_Of_The_Wilderness).add(EnchantFuneralRitesForSensualWorshippers.Funeral_Rites_For_Sensual_Worshippers)
                                .add(EnchantTheOneWhoIsEncasedInASleeve.The_One_Who_Is_Encased_In_A_Sleeve).add(EnchantTheTwilightOfExistence.The_Twilight_Of_Existence));
                tableBuilder.pool(poolBuilder2.build());
            }
        }));




        //存护
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(NETHER_BRIDGE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBridging.CONSTRUSTION_BRIDGING).add(EnchantCompensation.CONSTRUSTION_COMPENSATION)
                                .add(EnchantFeedbackShelter.Feedback_Shelter).add(EnchantResonanceTransmission.ResonanceTransmission).add(EnchantSafetyPayloads.SafetyPayloads)
                                .add(EnchantStaunch.CONSTRUSTION_STAUNCH).add(EnchantSubeutectic.Subeutectic).add(EnchantSuperstaticFixation.SuperstaticFixation));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantPyromania.PYRAMANIA,UniformLootNumberProvider.create(1f,3f)));
                tableBuilder.pool(poolBuilder2.build());
                LootPool.Builder poolRunes = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Preservation))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolRunes.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(RUINED_PORTAL.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBridging.CONSTRUSTION_BRIDGING).add(EnchantCompensation.CONSTRUSTION_COMPENSATION)
                                .add(EnchantFeedbackShelter.Feedback_Shelter).add(EnchantResonanceTransmission.ResonanceTransmission).add(EnchantSafetyPayloads.SafetyPayloads)
                                .add(EnchantStaunch.CONSTRUSTION_STAUNCH).add(EnchantSubeutectic.Subeutectic).add(EnchantSuperstaticFixation.SuperstaticFixation));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantmentGlimmering.GLIMMERING,UniformLootNumberProvider.create(1f,1f)));
                tableBuilder.pool(poolBuilder2.build());
                LootPool.Builder poolRunes = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Preservation))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolRunes.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_TREASURE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBridging.CONSTRUSTION_BRIDGING).add(EnchantCompensation.CONSTRUSTION_COMPENSATION)
                                .add(EnchantFeedbackShelter.Feedback_Shelter).add(EnchantResonanceTransmission.ResonanceTransmission).add(EnchantSafetyPayloads.SafetyPayloads)
                                .add(EnchantStaunch.CONSTRUSTION_STAUNCH).add(EnchantSubeutectic.Subeutectic).add(EnchantSuperstaticFixation.SuperstaticFixation));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolRunes = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Preservation))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolRunes.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_HOGLiN_STABLE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBridging.CONSTRUSTION_BRIDGING).add(EnchantCompensation.CONSTRUSTION_COMPENSATION)
                                .add(EnchantFeedbackShelter.Feedback_Shelter).add(EnchantResonanceTransmission.ResonanceTransmission).add(EnchantSafetyPayloads.SafetyPayloads)
                                .add(EnchantStaunch.CONSTRUSTION_STAUNCH).add(EnchantSubeutectic.Subeutectic).add(EnchantSuperstaticFixation.SuperstaticFixation));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolRunes = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Preservation))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolRunes.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_BRIDGE.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Items.ANCIENT_DEBRIS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new SetEnchantmentsLootFunction.Builder().enchantment(EnchantBlazeWalker.BLAZE_WALKER,UniformLootNumberProvider.create(1f,2f)));
                tableBuilder.pool(poolBuilder2.build());
                LootPool.Builder poolBuilder3 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBridging.CONSTRUSTION_BRIDGING).add(EnchantCompensation.CONSTRUSTION_COMPENSATION)
                                .add(EnchantFeedbackShelter.Feedback_Shelter).add(EnchantResonanceTransmission.ResonanceTransmission).add(EnchantSafetyPayloads.SafetyPayloads)
                                .add(EnchantStaunch.CONSTRUSTION_STAUNCH).add(EnchantSubeutectic.Subeutectic).add(EnchantSuperstaticFixation.SuperstaticFixation));
                tableBuilder.pool(poolBuilder3.build());
                LootPool.Builder poolRunes = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.Great_Runes_Of_Preservation))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolRunes.build());
            }
        }));




        //巡猎
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Armorer.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Cartographer.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Desert_House.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Plains_House.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Savanna_House.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Snowy_House.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Taiga_House.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.6f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(Village_Weaponsmith.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(Items.BOOK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)))
                        .apply(new ModEnchantRandomlyLootFunction.Builder().add(EnchantBloodTherapy.BLOOD_THERAPY).add(EnchantCelestialAnnihilation.Celestial_Annihilation)
                                .add(EnchantCelestialSnipe.Celestial_Snipe).add(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
