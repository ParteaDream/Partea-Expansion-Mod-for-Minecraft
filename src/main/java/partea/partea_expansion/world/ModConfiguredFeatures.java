package partea.partea_expansion.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import partea.partea_expansion.Modblocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> AZURE_ORE_KEY = registryKey("azure_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> PALM_TREE_KEY = registryKey("palm_tree");
    public static RegistryKey<ConfiguredFeature<?,?>> registryKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier("partea_expansion", name));
    }
    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stonePlace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatePlace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherPlace = new TagMatchRuleTest(BlockTags.NETHER_CARVER_REPLACEABLES);
        RuleTest endPlace = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> end =
                List.of(OreFeatureConfig.createTarget(endPlace, Modblocks.AZURE_ORE.getDefaultState()));

        register(context,AZURE_ORE_KEY,Feature.ORE, new OreFeatureConfig(end, 3, 0.5f));
        register(context,PALM_TREE_KEY,Feature.TREE,new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Modblocks.PALM_LOG),
                new DarkOakTrunkPlacer(4,10,3),
                BlockStateProvider.of(Modblocks.PALM_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(6),ConstantIntProvider.create(3),ConstantIntProvider.create(6),
                        0.0f,0.0f,0.2f,0.2f),
                new TwoLayersFeatureSize(3,1,4)
        ).build());
    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key,F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
