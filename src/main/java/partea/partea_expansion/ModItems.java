package partea.partea_expansion;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import partea.partea_expansion.CustomItems.ArmorItems.*;
import partea.partea_expansion.CustomItems.GlintItem;
import partea.partea_expansion.CustomItems.Pearls.AncientPearl;
import partea.partea_expansion.CustomItems.CustomMaskItems.CustomFoolsMaskItem;
import partea.partea_expansion.CustomItems.CustomMaskItems.CustomThrillerMaskItem;
import partea.partea_expansion.CustomItems.DiamondProspectorItem;
import partea.partea_expansion.CustomItems.ModFoodComponents;
import partea.partea_expansion.CustomItems.Pearls.AvariciousPearl;
import partea.partea_expansion.CustomItems.Pearls.CrimsonPearl;
import partea.partea_expansion.CustomItems.SafeminingDetectorItem;
import partea.partea_expansion.CustomItems.ToolItems.*;
import partea.partea_expansion.sounds.ModSounds;

import static partea.partea_expansion.CustomItems.ArmorItems.ModArmorMaterial.GOLDEN_NETHERITE;

public class ModItems {
    public static Item KNEE_PADS = registerItem("knee_pads",
            new SneakerItem(ModArmorMaterial.KNEE_PADS, ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static Item Sneaker = registerItem("sneaker",
            new SneakerItem(ModArmorMaterial.SNEAKER, ArmorItem.Type.BOOTS,new FabricItemSettings()));
    public static Item SUSPICIOUS_SQUAMA= registerItem("suspicious_squama",
            new Item(new FabricItemSettings()));
    public static Item SUSPICIOUS_STONE = registerItem("suspicious_stone",
            new Item(new FabricItemSettings()));
    public static Item FLINT_KNIFE = registerItem("flint_knife"
            , new SwordItem(ModToolMaterials.FLINT, 0, -2, new FabricItemSettings().maxCount(1)));
    public static Item AZURITE_BOW = registerItem("azurite_bow"
            , new AzuriteBowItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1).maxDamage(8192)));
    public static Item BLACK_SWORD = registerItem("black_sword"
            , new BlackSwordItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static Item AZURITE_UPGRADE_SMITHING_TEMPLATE = registerItem("azurite_upgrade_smithing_template"
            , new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_INGOT = registerItem("azurite_ingot"
            , new GlintItem(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_HELMET = registerItem("azurite_helmet"
            , new ModAzuriteArmorItem(ModArmorMaterial.AZURITE, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_CHESTPLATE = registerItem("azurite_chestplate"
            , new ModAzuriteArmorItem(ModArmorMaterial.AZURITE, ArmorItem.Type.CHESTPLATE
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_LEGGINGS = registerItem("azurite_leggings"
            , new ModAzuriteArmorItem(ModArmorMaterial.AZURITE, ArmorItem.Type.LEGGINGS
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_BOOTS = registerItem("azurite_boots"
            , new ModAzuriteArmorItem(ModArmorMaterial.AZURITE, ArmorItem.Type.BOOTS
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_SWORD = registerItem("azurite_sword"
            , new AzuriteSwordItem(ModToolMaterials.AZURITE , 9, -2.0f
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_AXE = registerItem("azurite_axe"
            , new AzuriteAxeItem(ModToolMaterials.AZURITE, 11, -2.6f
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_PICKAXE = registerItem("azurite_pickaxe"
            , new AzuritePickaxeItem(ModToolMaterials.AZURITE, 4, -2f
                    ,new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_SHOVEL = registerItem("azurite_shovel"
            , new AzuriteShovelItem(ModToolMaterials.AZURITE, -1, -3.0f
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item AZURITE_HOE = registerItem("azurite_hoe"
            , new AzuriteHoeItem(ModToolMaterials.AZURITE, 0, 4.0f
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    
    public static Item AZURE_HELMET = registerItem("azure_helmet"
            , new ModAzureArmorItem(ModArmorMaterial.AZURE, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_CHESTPLATE = registerItem("azure_chestplate"
            , new ModAzureArmorItem(ModArmorMaterial.AZURE, ArmorItem.Type.CHESTPLATE
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_LEGGINGS = registerItem("azure_leggings"
            , new ModAzureArmorItem(ModArmorMaterial.AZURE, ArmorItem.Type.LEGGINGS
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_BOOTS = registerItem("azure_boots"
            , new ModAzureArmorItem(ModArmorMaterial.AZURE, ArmorItem.Type.BOOTS
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_SWORD = registerItem("azure_sword"
            , new SwordItem(ModToolMaterials.AZURE , 6, -2.0f
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_AXE = registerItem("azure_axe"
            , new AxeItem(ModToolMaterials.AZURE, 8, -2.8f
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_PICKAXE = registerItem("azure_pickaxe"
            , new PickaxeItem(ModToolMaterials.AZURE, 2, -2.4f
                    ,new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_SHOVEL = registerItem("azure_shovel"
            , new ShovelItem(ModToolMaterials.AZURE, -1.75f, -3.0f
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item AZURE_HOE = registerItem("azure_hoe"
            , new HoeItem(ModToolMaterials.AZURE, -2, 2.0f
                    , new FabricItemSettings().rarity(Rarity.RARE)));
    public static Item BASALT_BRICK = registerItem("basalt_brick"
            , new Item(new FabricItemSettings()));
    public static Item CRIMSON_PEARL = registerItem("crimson_pearl"
            , new CrimsonPearl(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(16)));
    public static Item AVARICIOUS_PEARL = registerItem("avaricious_pearl"
            , new AvariciousPearl(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(16)));
    public static Item HORSE_MEAT = registerItem("horse_meat"
            , new Item(new FabricItemSettings().food(ModFoodComponents.HORSE_MEAT)));
    public static Item COOKED_HORSE_MEAT = registerItem("cooked_horse_meat"
            , new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_HORSE_MEAT)));
    public static Item AFTERGLOW_CD = registerItem("afterglow_cd"
            , new Item(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static Item HEART_OF_THE_DEEP = registerItem("heart_of_the_deep"
            , new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static Item THRILLER_MASK = registerItem("thriller_mask"
            , new CustomThrillerMaskItem(ModArmorMaterial.THRILLER_MASK, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static Item ANCIENT_PEARL = registerItem("ancient_pearl"
            , new AncientPearl(new FabricItemSettings().rarity(Rarity.COMMON).maxCount(16)));
    public static Item FABRIC = registerItem("fabric"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item QUARTZ_DUST = registerItem("quartz_dust"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item CRYING_OBSIDIAN_DUST = registerItem("crying_obsidian_dust"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item CRYSTALLIZED_LAPIS_DUST = registerItem("crystallized_lapis_dust"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item CRYSTALLIZED_LAPIS = registerItem("crystallized_lapis"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item FOOLS_MASK = registerItem("fools_mask"
            , new CustomFoolsMaskItem(ModArmorMaterial.FOOLS_MASK, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static Item RAW_AZURE = registerItem("raw_azure"
            , new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item NIGHT_VISION_GLASSES = registerItem("night_vision_glasses"
            , new ModNightVisionGlassesItem(ModArmorMaterial.NIGHT_VISION_GLASSES, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item AMETHYST_SWORD = registerItem("amethyst_sword"
            , new AmethystSwordItem(ModToolMaterials.AMETHYST , 0, -2.6f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static Item AMETHYST_STILLETO = registerItem("amethyst_stilleto"
            , new SwordItem(ModToolMaterials.AMETHYST2 , 0, 4.0f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static Item AMETHYST = registerItem("amethyst"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item CRUDE_AMETHYST = registerItem("crude_amethyst"
            , new Item(new FabricItemSettings().rarity(Rarity.COMMON)));
    public static Item CREATIVE_MODE_SWORD = registerItem("creative_mode_sword"
            , new CreativeSwordItem(ModToolMaterials.CREATIVE_MATERIAL , 0, 6.0f
                    , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    public static Item SHED_A_LIGHT_MUSIC_DISC = registerItem("shed_a_light_music_disc"
            , new MusicDiscItem(7, ModSounds.SHED_A_LIGHT
                    ,new FabricItemSettings().maxCount(1),193));
    public static Item SILENT_TIME_MUSIC_DISC = registerItem("silent_time_music_disc"
            , new MusicDiscItem(7, ModSounds.SILENT_TIME
                    ,new FabricItemSettings().maxCount(1),160));
    public static Item GOLDEN_NETHERITE_INGOT = registerItem("golden_netherite_ingot"
            , new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_HELMET = registerItem("golden_netherite_helmet"
            , new ModGoldenNetheriteArmorItem(GOLDEN_NETHERITE, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_CHESTPLATE = registerItem("golden_netherite_chestplate"
            , new ModGoldenNetheriteArmorItem(GOLDEN_NETHERITE, ArmorItem.Type.CHESTPLATE
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_LEGGINGS = registerItem("golden_netherite_leggings"
            , new ModGoldenNetheriteArmorItem(GOLDEN_NETHERITE, ArmorItem.Type.LEGGINGS
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_BOOTS = registerItem("golden_netherite_boots"
            , new ModGoldenNetheriteArmorItem(GOLDEN_NETHERITE, ArmorItem.Type.BOOTS
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_SWORD = registerItem("golden_netherite_sword"
            , new SwordItem(ModToolMaterials.GOLDEN_NETHERITE , 4, -2.2f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_AXE = registerItem("golden_netherite_axe"
            , new AxeItem(ModToolMaterials.GOLDEN_NETHERITE, 6, -2.9f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_PICKAXE = registerItem("golden_netherite_pickaxe"
            , new PickaxeItem(ModToolMaterials.GOLDEN_NETHERITE, 2, -2.6f
                    ,new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_SHOVEL = registerItem("golden_netherite_shovel"
            , new ShovelItem(ModToolMaterials.GOLDEN_NETHERITE, -2.25f, -3.0f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_HOE = registerItem("golden_netherite_hoe"
            , new HoeItem(ModToolMaterials.GOLDEN_NETHERITE, -4, 0.0f
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("golden_netherite_upgrade_smithing_template"
            , new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    public static Item DIAMOND_NETHERITE_INGOT = registerItem("diamond_netherite_ingot"
            , new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_HELMET = registerItem("diamond_netherite_helmet"
            , new ModDiamondNetheriteArmorItem(ModArmorMaterial.DIAMOND_NETHERITE, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_CHESTPLATE = registerItem("diamond_netherite_chestplate"
            , new ModDiamondNetheriteArmorItem(ModArmorMaterial.DIAMOND_NETHERITE, ArmorItem.Type.CHESTPLATE
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_LEGGINGS = registerItem("diamond_netherite_leggings"
            , new ModDiamondNetheriteArmorItem(ModArmorMaterial.DIAMOND_NETHERITE, ArmorItem.Type.LEGGINGS
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_BOOTS = registerItem("diamond_netherite_boots"
            , new ModDiamondNetheriteArmorItem(ModArmorMaterial.DIAMOND_NETHERITE, ArmorItem.Type.BOOTS
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_SWORD = registerItem("diamond_netherite_sword"
            , new SwordItem(ModToolMaterials.DIAMOND_NETHERITE , 6, -2.0f
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_AXE = registerItem("diamond_netherite_axe"
            , new AxeItem(ModToolMaterials.DIAMOND_NETHERITE, 8, -2.8f
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_PICKAXE = registerItem("diamond_netherite_pickaxe"
            , new PickaxeItem(ModToolMaterials.DIAMOND_NETHERITE, 2, -2.4f
                    ,new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_SHOVEL = registerItem("diamond_netherite_shovel"
            , new ShovelItem(ModToolMaterials.DIAMOND_NETHERITE, -1.75f, -3.0f
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_HOE = registerItem("diamond_netherite_hoe"
            , new HoeItem(ModToolMaterials.DIAMOND_NETHERITE, -2, 2.0f
                    , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
    public static Item DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE = registerItem("diamond_netherite_upgrade_smithing_template"
            , new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()));

    public static Item AZURE_INGOT = registerItem("azure_ingot"
            , new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    public static Item DIAMOND_PROSPECTOR = registerItem("diamond_prospector"
            , new DiamondProspectorItem(new FabricItemSettings().maxDamage(96)));
    public static Item SAFEMINING_DETECTOR = registerItem("safemining_detector"
            , new SafeminingDetectorItem(new FabricItemSettings().maxDamage(128)));
    public static Item EMPTY_TERMINAL = registerItem("empty_terminal"
            , new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier("partea_expansion", name), item);
    }

    public static void registerItems(){

    }
}
