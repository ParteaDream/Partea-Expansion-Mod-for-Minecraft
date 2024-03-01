package partea.partea_expansion;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import partea.partea_expansion.CustomItems.*;
import partea.partea_expansion.CustomItems.ArmorItems.ModArmorMaterial;
import partea.partea_expansion.CustomItems.ArmorItems.ModDiamondNetheriteArmorItem;
import partea.partea_expansion.CustomItems.ArmorItems.ModGoldenNetheriteArmorItem;
import partea.partea_expansion.CustomItems.ArmorItems.ModNightVisionGlassesItem;
import partea.partea_expansion.CustomItems.CustomMaskItems.CustomFoolsMaskItem;
import partea.partea_expansion.CustomItems.CustomMaskItems.CustomThrillerMaskItem;
import partea.partea_expansion.CustomItems.ToolItems.AmethystSwordItem;
import partea.partea_expansion.CustomItems.ToolItems.CreativeSwordItem;
import partea.partea_expansion.CustomItems.ToolItems.ModToolMaterials;
import partea.partea_expansion.sounds.ModSounds;

import static partea.partea_expansion.CustomItems.ArmorItems.ModArmorMaterial.GOLDEN_NETHERITE;

public class ModItems {
    public static Item AFTERGLOW_CD = registerItem("afterglow_cd"
            , new Item(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static Item HEART_OF_THE_DEEP = registerItem("heart_of_the_deep"
            , new Item(new FabricItemSettings().rarity(Rarity.RARE).maxCount(1)));
    public static Item THRILLER_MASK = registerItem("thriller_mask"
            , new CustomThrillerMaskItem(ModArmorMaterial.THRILLER_MASK, ArmorItem.Type.HELMET
                    , new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static Item ANCIENT_PEARL = registerItem("ancient_pearl"
            , new AncientPearl(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(16)));
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
            , new SafeminingDetectorItem(new FabricItemSettings().maxDamage(198)));
    public static Item EMPTY_TERMINAL = registerItem("empty_terminal"
            , new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier("partea_expansion", name), item);
    }

    public static void registerItems(){

    }
}
