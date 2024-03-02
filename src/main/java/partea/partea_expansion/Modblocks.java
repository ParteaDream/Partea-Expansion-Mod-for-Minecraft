package partea.partea_expansion;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import partea.partea_expansion.CustomBlocks.CustomFakeObsidian;
import partea.partea_expansion.CustomBlocks.QualitativeAnalyzer;
import partea.partea_expansion.world.ModConfiguredFeatures;

import java.util.Optional;

public class Modblocks {
    public static final Block PALM_PLANKS = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Block PALM_STAIR = new StairsBlock(Modblocks.PALM_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_STAIRS));
    public static final Block PALM_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB));
    public static final Block PALM_BUTTON = new ButtonBlock(BlockSetType.OAK,5,FabricBlockSettings.copyOf(Blocks.OAK_BUTTON));
    public static final Block PALM_PRESSURE_PLATE = new PressurePlateBlock(BlockSetType.OAK,FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE));
    public static final Block PALM_FENCE_GATE = new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE));
    public static final Block PALM_FENCE = new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE));
    public static final Block PALM_DOOR = new DoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR));
    public static final Block PALM_TRAPDOOR = new TrapdoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR));
    public static final Block PALM_SAPLING = new SaplingBlock(new SaplingGenerator("palm"
            , Optional.empty()
            , Optional.of(ModConfiguredFeatures.PALM_TREE_KEY)
            , Optional.empty())
            ,FabricBlockSettings.copyOf(Blocks.OAK_SAPLING));
    public static final Block PALM_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG));
    public static final Block PALM_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
    public static final Block STRIPPED_PALM_LOG = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG));
    public static final Block STRIPPED_PALM_WOOD = new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD));

    public static final Block PALM_LEAVES = new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES));
    public static final Block FAKE_OBSIDIAN = new CustomFakeObsidian(FabricBlockSettings
            .create().strength(20f,5f).requiresTool().sounds(BlockSoundGroup.STONE));
//    public static final Block DOOMED_DEATH_FLAME = new CustomDoomedDeathFlameBlock(FabricBlockSettings.create());
    public static final Block GOLDEN_NETHERITE_BLOCK = new Block(FabricBlockSettings
            .create().strength(60.0f, 1500).luminance(8).requiresTool().sounds(BlockSoundGroup.NETHERITE));
    public static final Block DIAMOND_NETHERITE_BLOCK = new Block(FabricBlockSettings
            .create().strength(80.0f, 2500).luminance(15).requiresTool().sounds(BlockSoundGroup.NETHERITE));
    public static final Block AZURE_BLOCK = new Block(FabricBlockSettings
            .create().strength(100.0f, 4000).luminance(15).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block AZURE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), FabricBlockSettings
            .create().strength(50.0f, 4000).luminance(8).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block QUALITATIVE_ANALYZER = new QualitativeAnalyzer(FabricBlockSettings.create()
            .strength(3.5f, 3.5f).requiresTool().sounds(BlockSoundGroup.ANVIL).luminance(15));
    public static void registerBlocks(){
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_stair"), PALM_STAIR);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_stair"), new BlockItem(PALM_STAIR
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_slab"), PALM_SLAB);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_slab"), new BlockItem(PALM_SLAB
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_fence"), PALM_FENCE);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_fence"), new BlockItem(PALM_FENCE
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_pressure_plate"), PALM_PRESSURE_PLATE);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_pressure_plate"), new BlockItem(PALM_PRESSURE_PLATE
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_fence_gate"), PALM_FENCE_GATE);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_fence_gate"), new BlockItem(PALM_FENCE_GATE
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_button"), PALM_BUTTON);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_button"), new BlockItem(PALM_BUTTON
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_door"), PALM_DOOR);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_door"), new BlockItem(PALM_DOOR
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_trapdoor"), PALM_TRAPDOOR);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_trapdoor"), new BlockItem(PALM_TRAPDOOR
                        , new FabricItemSettings().rarity(Rarity.COMMON)));


        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_sapling"), PALM_SAPLING);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_sapling"), new BlockItem(PALM_SAPLING
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_log"), PALM_LOG);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_log"), new BlockItem(PALM_LOG
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_wood"), PALM_WOOD);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_wood"), new BlockItem(PALM_WOOD
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "stripped_palm_log"), STRIPPED_PALM_LOG);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "stripped_palm_log"), new BlockItem(STRIPPED_PALM_LOG
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "stripped_palm_wood"), STRIPPED_PALM_WOOD);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "stripped_palm_wood"), new BlockItem(STRIPPED_PALM_WOOD
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_planks"), PALM_PLANKS);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_planks"), new BlockItem(PALM_PLANKS
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "palm_leaves"), PALM_LEAVES);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "palm_leaves"), new BlockItem(PALM_LEAVES
                        , new FabricItemSettings().rarity(Rarity.COMMON)));

        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "fake_obsidian"), FAKE_OBSIDIAN);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "fake_obsidian"), new BlockItem(FAKE_OBSIDIAN
                        , new FabricItemSettings().rarity(Rarity.COMMON)));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "golden_netherite_block"), GOLDEN_NETHERITE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("partea_expansion", "golden_netherite_block")
                , new BlockItem(GOLDEN_NETHERITE_BLOCK
                        , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "diamond_netherite_block"), DIAMOND_NETHERITE_BLOCK);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "diamond_netherite_block"), new BlockItem(DIAMOND_NETHERITE_BLOCK
                        , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "azure_block"), AZURE_BLOCK);
        Registry.register(Registries.ITEM
            , new Identifier("partea_expansion", "azure_block"), new BlockItem(AZURE_BLOCK
                        , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "azure_ore"), AZURE_ORE);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "azure_ore"), new BlockItem(AZURE_ORE
                        , new FabricItemSettings().rarity(Rarity.RARE).fireproof()));
        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "qualitative_analyzer"), QUALITATIVE_ANALYZER);
        Registry.register(Registries.ITEM
                , new Identifier("partea_expansion", "qualitative_analyzer"), new BlockItem(QUALITATIVE_ANALYZER
                        , new FabricItemSettings().rarity(Rarity.COMMON).fireproof()));

//        Registry.register(Registries.BLOCK
//                , new Identifier("partea_expansion", "doomed_death_flame"), DOOMED_DEATH_FLAME);
//        Registry.register(Registries.ITEM, new Identifier("partea_expansion", "doomed_death_flame")
//                , new BlockItem(DOOMED_DEATH_FLAME
//                        , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));
    }
}
