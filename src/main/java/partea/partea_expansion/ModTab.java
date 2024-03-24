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
                //blocks
                entries.add(GOLDEN_NETHERITE_BLOCK);
                entries.add(DIAMOND_NETHERITE_BLOCK);
                entries.add(AZURE_ORE);
                entries.add(AZURE_BLOCK);
                entries.add(SUSPICIOUS_ORE);
                entries.add(NETHER_SUSPICIOUS_ORE);
                entries.add(DEEPSLATE_SUSPICIOUS_ORE);
                entries.add(QUALITATIVE_ANALYZER);
                entries.add(TRASH_CAN);
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

                //combat & tool
                entries.add(CREATIVE_MODE_SWORD);
                entries.add(GOLDEN_NETHERITE_SWORD);
                entries.add(GOLDEN_NETHERITE_AXE);
                entries.add(GOLDEN_NETHERITE_PICKAXE);
                entries.add(GOLDEN_NETHERITE_SHOVEL);
                entries.add(GOLDEN_NETHERITE_HOE);
                entries.add(GOLDEN_NETHERITE_HELMET);
                entries.add(GOLDEN_NETHERITE_CHESTPLATE);
                entries.add(GOLDEN_NETHERITE_LEGGINGS);
                entries.add(GOLDEN_NETHERITE_BOOTS);
                entries.add(DIAMOND_NETHERITE_SWORD);
                entries.add(DIAMOND_NETHERITE_AXE);
                entries.add(DIAMOND_NETHERITE_PICKAXE);
                entries.add(DIAMOND_NETHERITE_SHOVEL);
                entries.add(DIAMOND_NETHERITE_HOE);
                entries.add(DIAMOND_NETHERITE_HELMET);
                entries.add(DIAMOND_NETHERITE_CHESTPLATE);
                entries.add(DIAMOND_NETHERITE_LEGGINGS);
                entries.add(DIAMOND_NETHERITE_BOOTS);
                entries.add(AZURE_SWORD);
                entries.add(AZURE_AXE);
                entries.add(AZURE_PICKAXE);
                entries.add(AZURE_SHOVEL);
                entries.add(AZURE_HOE);
                entries.add(AZURE_HELMET);
                entries.add(AZURE_CHESTPLATE);
                entries.add(AZURE_LEGGINGS);
                entries.add(AZURE_BOOTS);
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
                entries.add(AZURITE_CROSSBOW);
                entries.add(AZURITE_SNIPER_CROSSBOW);

                entries.add(SNIPER_CROSSBOW);
                entries.add(FLINT_KNIFE);
                entries.add(BLACK_SWORD);
                entries.add(NIGHT_VISION_GLASSES);
                entries.add(EMPTY_TERMINAL);
                entries.add(DIAMOND_PROSPECTOR);
                entries.add(SAFEMINING_DETECTOR);

                //杂项
                entries.add(COIN);
                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(RAW_AZURE);
                entries.add(AZURE_INGOT);
                entries.add(AZURITE_INGOT);
                entries.add(AZURITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(FABRIC);
                entries.add(BASALT_BRICK);
                entries.add(CRYSTALLIZED_LAPIS);
                entries.add(QUARTZ_DUST);
                entries.add(CRYSTALLIZED_LAPIS_DUST);
                entries.add(CRYING_OBSIDIAN_DUST);
                entries.add(Nether_Star_Shard);
                entries.add(Magic_Slime_Ball);
                entries.add(SUSPICIOUS_STONE);
                entries.add(NETHER_SUSPICIOUS_STONE);
                entries.add(SUSPICIOUS_SQUAMA);
                entries.add(CRUDE_AMETHYST);
                entries.add(AMETHYST);
                entries.add(AMETHYST_SWORD);
                entries.add(AMETHYST_STILLETO);

                entries.add(ANCIENT_PEARL);
                entries.add(CRIMSON_PEARL);
                entries.add(AVARICIOUS_PEARL);
                entries.add(HEART_OF_THE_DEEP);
                entries.add(HORSE_MEAT);
                entries.add(COOKED_HORSE_MEAT);
                entries.add(TEA);

                entries.add(SHED_A_LIGHT_MUSIC_DISC);
                entries.add(SILENT_TIME_MUSIC_DISC);

                entries.add(ITEM_FILTER);


                //奇物
                entries.add(Curio_Treasure_Bag);
                entries.add(Trash_Bag);
                entries.add(Golden_Trash_Bag);
                entries.add(FOOLS_MASK);
                entries.add(THRILLER_MASK);
                entries.add(KNEE_PADS);
                entries.add(Sneaker);
                entries.add(Galaxy_Lotto);
                entries.add(Interastra_Big_Lotto);
                entries.add(Totem_Of_Equilibrium);
                entries.add(ROBE_OF_THE_BEAUTY);
                entries.add(SILVER_COIN_OF_DISCORD);
                entries.add(Typical_Genius_Society_Gossip);
                entries.add(SOCIETY_TICKET);
                entries.add(Void_Wick_Trimmer);
                entries.add(Laurel_Crown_Of_Planar_Shifts);
                entries.add(TOTEM_OF_VOID);
                entries.add(Clock_Tricks);
                entries.add(Damaged_Galaxy_Lotto);
                entries.add(Damaged_Interastra_Big_Lotto);
                entries.add(Damaged_Totem_Of_Equilibrium);
                entries.add(Damaged_Laurel_Crown_Of_Planar_Shifts);
                entries.add(Damaged_Clock_Tricks);
                entries.add(Great_Runes_Of_Preservation);
                entries.add(Great_Runes_Of_Abundance);





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
                entries.add(TRASH_CAN);
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
                entries.add(AZURITE_CROSSBOW);
                entries.add(AZURITE_SNIPER_CROSSBOW);
                entries.add(SNIPER_CROSSBOW);

                entries.add(BLACK_SWORD);
                entries.add(FLINT_KNIFE);
                entries.add(AMETHYST_SWORD);
                entries.add(AMETHYST_STILLETO);
                entries.add(NIGHT_VISION_GLASSES);
            })
            .build();
    public static final ItemGroup INGREDIENTS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(GOLDEN_NETHERITE_INGOT))
            .displayName(Text.translatable("itemgroup.partea_expansion.5ingredients"))
            .entries((context, entries) ->{
                entries.add(COIN);
                entries.add(GOLDEN_NETHERITE_INGOT);
                entries.add(GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(DIAMOND_NETHERITE_INGOT);
                entries.add(DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(RAW_AZURE);
                entries.add(AZURE_INGOT);
                entries.add(AZURITE_UPGRADE_SMITHING_TEMPLATE);
                entries.add(SUSPICIOUS_STONE);
                entries.add(NETHER_SUSPICIOUS_STONE);
                entries.add(SUSPICIOUS_SQUAMA);
                entries.add(CRUDE_AMETHYST);
                entries.add(AMETHYST);
                entries.add(FABRIC);
                entries.add(BASALT_BRICK);
                entries.add(CRYSTALLIZED_LAPIS);
                entries.add(QUARTZ_DUST);
                entries.add(CRYSTALLIZED_LAPIS_DUST);
                entries.add(CRYING_OBSIDIAN_DUST);
                entries.add(Nether_Star_Shard);
                entries.add(Magic_Slime_Ball);
                entries.add(ANCIENT_PEARL);
                entries.add(CRIMSON_PEARL);
                entries.add(AVARICIOUS_PEARL);
                entries.add(HEART_OF_THE_DEEP);
                entries.add(HORSE_MEAT);
                entries.add(COOKED_HORSE_MEAT);
                entries.add(TEA);
                entries.add(SHED_A_LIGHT_MUSIC_DISC);
                entries.add(SILENT_TIME_MUSIC_DISC);
            })
            .build();
    public static final ItemGroup CURIOS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Totem_Of_Equilibrium))
            .displayName(Text.translatable("itemgroup.partea_expansion.6curios"))
            .entries((context, entries) ->{
                entries.add(Curio_Treasure_Bag);
                entries.add(Trash_Bag);
                entries.add(Golden_Trash_Bag);

                entries.add(FOOLS_MASK);
                entries.add(THRILLER_MASK);
                entries.add(KNEE_PADS);
                entries.add(Sneaker);
                entries.add(Galaxy_Lotto);
                entries.add(Interastra_Big_Lotto);
                entries.add(Totem_Of_Equilibrium);
                entries.add(ROBE_OF_THE_BEAUTY);
                entries.add(SILVER_COIN_OF_DISCORD);
                entries.add(Typical_Genius_Society_Gossip);
                entries.add(SOCIETY_TICKET);
                entries.add(Void_Wick_Trimmer);

                entries.add(Laurel_Crown_Of_Planar_Shifts);
                entries.add(TOTEM_OF_VOID);
                entries.add(Clock_Tricks);

                entries.add(Damaged_Galaxy_Lotto);
                entries.add(Damaged_Interastra_Big_Lotto);
                entries.add(Damaged_Totem_Of_Equilibrium);
                entries.add(Damaged_Laurel_Crown_Of_Planar_Shifts);
                entries.add(Damaged_Clock_Tricks);

                entries.add(Great_Runes_Of_Preservation);
                entries.add(Great_Runes_Of_Abundance);
            })
            .build();

    public static void registerTab(){
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "1partea_expansion"), PARTEA_EXPANSION);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "2blocks"), BLOCKS);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "3tools"), TOOLS);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "4combat"), COMBAT);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "5ingredients"), INGREDIENTS);
        Registry.register(Registries.ITEM_GROUP, new Identifier("partea_expansion", "6curios"), CURIOS);
    }

}
