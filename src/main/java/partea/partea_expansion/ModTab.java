package partea.partea_expansion;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static partea.partea_expansion.ModItems.*;
import static partea.partea_expansion.Modblocks.*;
import static partea.partea_expansion.ParteaExpansion.ITEM_FILTER;

public class ModTab {
    public static final ItemGroup PARTEA_EXPANSION = FabricItemGroup.builder()
            .icon(() -> new ItemStack(FOOLS_MASK))
            .displayName(Text.translatable("itemgroup.partea_expansion.1partea_expansion"))
            .entries((context, entries) -> {
                entries.add(CREATIVE_MODE_SWORD);
                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(GOLDEN_NETHERITE_SWORD);
                entries.add(GOLDEN_NETHERITE_AXE);
                entries.add(GOLDEN_NETHERITE_PICKAXE);
                entries.add(GOLDEN_NETHERITE_SHOVEL);
                entries.add(GOLDEN_NETHERITE_HOE);
                entries.add(GOLDEN_NETHERITE_HELMET);
                entries.add(GOLDEN_NETHERITE_CHESTPLATE);
                entries.add(GOLDEN_NETHERITE_LEGGINGS);
                entries.add(GOLDEN_NETHERITE_BOOTS);
                entries.add(GOLDEN_NETHERITE_BLOCK);

                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(DIAMOND_NETHERITE_SWORD);
                entries.add(DIAMOND_NETHERITE_AXE);
                entries.add(DIAMOND_NETHERITE_PICKAXE);
                entries.add(DIAMOND_NETHERITE_SHOVEL);
                entries.add(DIAMOND_NETHERITE_HOE);
                entries.add(DIAMOND_NETHERITE_HELMET);
                entries.add(DIAMOND_NETHERITE_CHESTPLATE);
                entries.add(DIAMOND_NETHERITE_LEGGINGS);
                entries.add(DIAMOND_NETHERITE_BOOTS);
                entries.add(DIAMOND_NETHERITE_BLOCK);

                entries.add(AZURE_ORE);
                entries.add(RAW_AZURE);
                entries.add(AZURE_INGOT);
                entries.add(AZURE_SWORD);
                entries.add(AZURE_AXE);
                entries.add(AZURE_PICKAXE);
                entries.add(AZURE_SHOVEL);
                entries.add(AZURE_HOE);
                entries.add(AZURE_HELMET);
                entries.add(AZURE_CHESTPLATE);
                entries.add(AZURE_LEGGINGS);
                entries.add(AZURE_BOOTS);
                entries.add(AZURE_BLOCK);

                entries.add(AZURITE_INGOT);
                entries.add(AZURITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(AZURITE_SWORD);
                entries.add(AZURITE_AXE);
                entries.add(AZURITE_BOW);
                entries.add(AZURITE_PICKAXE);
                entries.add(AZURITE_SHOVEL);
                entries.add(AZURITE_HOE);
                entries.add(AZURITE_HELMET);
                entries.add(AZURITE_CHESTPLATE);
                entries.add(AZURITE_LEGGINGS);
                entries.add(AZURITE_BOOTS);

                entries.add(FABRIC);
                entries.add(BASALT_BRICK);
                entries.add(CRYSTALLIZED_LAPIS);
                entries.add(QUARTZ_DUST);
                entries.add(CRYSTALLIZED_LAPIS_DUST);
                entries.add(CRYING_OBSIDIAN_DUST);

                entries.add(FLINT_KNIFE);
                entries.add(SUSPICIOUS_ORE);
                entries.add(NETHER_SUSPICIOUS_ORE);
                entries.add(DEEPSLATE_SUSPICIOUS_ORE);
                entries.add(SUSPICIOUS_STONE);
                entries.add(NETHER_SUSPICIOUS_STONE);
                entries.add(CRUDE_AMETHYST);
                entries.add(AMETHYST);
                entries.add(AMETHYST_SWORD);
                entries.add(AMETHYST_STILLETO);

                entries.add(BLACK_SWORD);
                entries.add(NIGHT_VISION_GLASSES);
                entries.add(EMPTY_TERMINAL);
                entries.add(DIAMOND_PROSPECTOR);
                entries.add(SAFEMINING_DETECTOR);

                entries.add(SHED_A_LIGHT_MUSIC_DISC);
                entries.add(SILENT_TIME_MUSIC_DISC);

                entries.add(ITEM_FILTER);
                entries.add(QUALITATIVE_ANALYZER);
                entries.add(FOOLS_MASK);
                entries.add(THRILLER_MASK);
                entries.add(Sneaker);
                entries.add(KNEE_PADS);
                entries.add(ANCIENT_PEARL);
                entries.add(CRIMSON_PEARL);
                entries.add(AVARICIOUS_PEARL);
                entries.add(HEART_OF_THE_DEEP);
                entries.add(HORSE_MEAT);
                entries.add(COOKED_HORSE_MEAT);

                entries.add(PALM_SAPLING);
                entries.add(PALM_LOG);
                entries.add(PALM_WOOD);
                entries.add(STRIPPED_PALM_LOG);
                entries.add(STRIPPED_PALM_WOOD);
                entries.add(PALM_PLANKS);
                entries.add(PALM_LEAVES);
                entries.add(PALM_STAIR);
                entries.add(PALM_SLAB);
                entries.add(PALM_FENCE);
                entries.add(PALM_FENCE_GATE);
                entries.add(PALM_PRESSURE_PLATE);
                entries.add(PALM_BUTTON);
                entries.add(PALM_DOOR);
                entries.add(PALM_TRAPDOOR);

            })
            .build();

    public static final ItemGroup BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(AZURE_BLOCK))
            .displayName(Text.translatable("itemgroup.partea_expansion.2blocks"))
            .entries((context, entries) ->{
                entries.add(GOLDEN_NETHERITE_BLOCK);
                entries.add(DIAMOND_NETHERITE_BLOCK);
                entries.add(AZURE_ORE);
                entries.add(AZURE_BLOCK);
                entries.add(QUALITATIVE_ANALYZER);
                entries.add(SUSPICIOUS_ORE);
                entries.add(NETHER_SUSPICIOUS_ORE);
                entries.add(DEEPSLATE_SUSPICIOUS_ORE);
                entries.add(PALM_SAPLING);
                entries.add(PALM_LOG);
                entries.add(PALM_WOOD);
                entries.add(STRIPPED_PALM_LOG);
                entries.add(STRIPPED_PALM_WOOD);
                entries.add(PALM_PLANKS);
                entries.add(PALM_LEAVES);
                entries.add(PALM_STAIR);
                entries.add(PALM_SLAB);
                entries.add(PALM_FENCE);
                entries.add(PALM_FENCE_GATE);
                entries.add(PALM_PRESSURE_PLATE);
                entries.add(PALM_BUTTON);
                entries.add(PALM_DOOR);
                entries.add(PALM_TRAPDOOR);

            })
            .build();
    public static final ItemGroup TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DIAMOND_NETHERITE_PICKAXE))
            .displayName(Text.translatable("itemgroup.partea_expansion.3tools"))
            .entries((context, entries) ->{
                entries.add(GOLDEN_NETHERITE_AXE);
                entries.add(GOLDEN_NETHERITE_PICKAXE);
                entries.add(GOLDEN_NETHERITE_SHOVEL);
                entries.add(GOLDEN_NETHERITE_HOE);

                entries.add(DIAMOND_NETHERITE_AXE);
                entries.add(DIAMOND_NETHERITE_PICKAXE);
                entries.add(DIAMOND_NETHERITE_SHOVEL);
                entries.add(DIAMOND_NETHERITE_HOE);

                entries.add(AZURE_AXE);
                entries.add(AZURE_PICKAXE);
                entries.add(AZURE_SHOVEL);
                entries.add(AZURE_HOE);

                entries.add(AZURITE_AXE);
                entries.add(AZURITE_PICKAXE);
                entries.add(AZURITE_SHOVEL);
                entries.add(AZURITE_HOE);

                entries.add(EMPTY_TERMINAL);
                entries.add(DIAMOND_PROSPECTOR);
                entries.add(SAFEMINING_DETECTOR);

                entries.add(ITEM_FILTER);
            })
            .build();
    public static final ItemGroup COMBAT = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CREATIVE_MODE_SWORD))
            .displayName(Text.translatable("itemgroup.partea_expansion.4combat"))
            .entries((context, entries) ->{
                entries.add(CREATIVE_MODE_SWORD);

                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_HELMET);
                entries.add(GOLDEN_NETHERITE_CHESTPLATE);
                entries.add(GOLDEN_NETHERITE_LEGGINGS);
                entries.add(GOLDEN_NETHERITE_BOOTS);
                entries.add(GOLDEN_NETHERITE_SWORD);
                entries.add(GOLDEN_NETHERITE_AXE);

                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_HELMET);
                entries.add(DIAMOND_NETHERITE_CHESTPLATE);
                entries.add(DIAMOND_NETHERITE_LEGGINGS);
                entries.add(DIAMOND_NETHERITE_BOOTS);
                entries.add(DIAMOND_NETHERITE_SWORD);
                entries.add(DIAMOND_NETHERITE_AXE);

                entries.add(AZURE_INGOT);
                entries.add(AZURE_HELMET);
                entries.add(AZURE_CHESTPLATE);
                entries.add(AZURE_LEGGINGS);
                entries.add(AZURE_BOOTS);
                entries.add(AZURE_SWORD);
                entries.add(AZURE_AXE);

                entries.add(AZURITE_INGOT);
                entries.add(AZURITE_HELMET);
                entries.add(AZURITE_CHESTPLATE);
                entries.add(AZURITE_LEGGINGS);
                entries.add(AZURITE_BOOTS);
                entries.add(AZURITE_SWORD);
                entries.add(AZURITE_AXE);
                entries.add(AZURITE_BOW);

                entries.add(BLACK_SWORD);
                entries.add(FLINT_KNIFE);
                entries.add(AMETHYST_SWORD);
                entries.add(AMETHYST_STILLETO);

                entries.add(NIGHT_VISION_GLASSES);
                entries.add(FOOLS_MASK);
                entries.add(THRILLER_MASK);
                entries.add(Sneaker);
                entries.add(KNEE_PADS);
            })
            .build();
    public static final ItemGroup INGREDIENTS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GOLDEN_NETHERITE_INGOT))
            .displayName(Text.translatable("itemgroup.partea_expansion.5ingredients"))
            .entries((context, entries) ->{
                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(RAW_AZURE);
                entries.add(AZURE_INGOT);
                entries.add(AZURITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(SUSPICIOUS_STONE);
                entries.add(CRUDE_AMETHYST);
                entries.add(AMETHYST);
                entries.add(FABRIC);
                entries.add(BASALT_BRICK);
                entries.add(CRYSTALLIZED_LAPIS);
                entries.add(QUARTZ_DUST);
                entries.add(CRYSTALLIZED_LAPIS_DUST);
                entries.add(CRYING_OBSIDIAN_DUST);
                entries.add(ANCIENT_PEARL);
                entries.add(CRIMSON_PEARL);
                entries.add(AVARICIOUS_PEARL);
                entries.add(HEART_OF_THE_DEEP);
                entries.add(HORSE_MEAT);
                entries.add(COOKED_HORSE_MEAT);
                entries.add(SHED_A_LIGHT_MUSIC_DISC);
                entries.add(SILENT_TIME_MUSIC_DISC);
            })
            .build();

    public static void registerTab(){
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "1partea_expansion"), PARTEA_EXPANSION);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "2blocks"), BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "3tools"), TOOLS);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "4combat"), COMBAT);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "5ingredients"), INGREDIENTS);
    }

}
