package partea.partea_expansion;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import partea.partea_expansion.CustomBlocks.CustomDoomedDeathFlameBlock;
import partea.partea_expansion.CustomBlocks.QualitativeAnalyzer;

public class Modblocks {
    public static final Block DOOMED_DEATH_FLAME = new CustomDoomedDeathFlameBlock(FabricBlockSettings.create());
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

        Registry.register(Registries.BLOCK
                , new Identifier("partea_expansion", "doomed_death_flame"), DOOMED_DEATH_FLAME);
        Registry.register(Registries.ITEM, new Identifier("partea_expansion", "doomed_death_flame")
                , new BlockItem(DOOMED_DEATH_FLAME
                        , new FabricItemSettings().rarity(Rarity.UNCOMMON).fireproof()));

//        Registry.register((String)"fire", new FireBlock(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).replaceable().noCollision().breakInstantly().luminance((state) -> {
//            return 15;
//        }).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY)));
    }
}
