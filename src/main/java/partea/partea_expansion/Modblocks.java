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

public class Modblocks {
    public static final Block GOLDEN_NETHERITE_BLOCK = new Block(FabricBlockSettings
            .create().strength(60.0f, 1500).luminance(8).requiresTool().sounds(BlockSoundGroup.NETHERITE));
    public static final Block DIAMOND_NETHERITE_BLOCK = new Block(FabricBlockSettings
            .create().strength(80.0f, 2500).luminance(15).requiresTool().sounds(BlockSoundGroup.NETHERITE));
    public static final Block AZURE_BLOCK = new Block(FabricBlockSettings
            .create().strength(100.0f, 4000).luminance(15).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block AZURE_ORE = new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), FabricBlockSettings
            .create().strength(50.0f, 4000).luminance(8).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));
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
                        , new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    }
}
