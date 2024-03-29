package partea.partea_expansion.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import partea.partea_expansion.Modblocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> AZURE_ORE_PLACED_KEY = registryKey("azure_ore_placed_key");
    public static final RegistryKey<PlacedFeature> SUSPICIOUS_ORE_PLACED_KEY = registryKey("suspicious_ore_placed_key");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_SUSPICIOUS_ORE_PLACED_KEY = registryKey("deepslate_suspicious_ore_placed_key");
    public static final RegistryKey<PlacedFeature> NETHER_SUSPICIOUS_ORE_PLACED_KEY = registryKey("nether_suspicious_ore_placed_key");

    public static final RegistryKey<PlacedFeature> PALM_TREE_KEY = registryKey("palm_tree_key");

    public static void boostrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, AZURE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AZURE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(30),YOffset.fixed(70))));
        register(context,PALM_TREE_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PALM_TREE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(8,0.2f,6),
                        Modblocks.PALM_SAPLING));
        register(context, SUSPICIOUS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SUSPICIOUS_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(0),YOffset.fixed(60))));
        register(context, DEEPSLATE_SUSPICIOUS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SUSPICIOUS_ORE_KEY),
                ModOrePlacement.modifiersWithCount(7,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-60),YOffset.fixed(0))));
        register(context, NETHER_SUSPICIOUS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_SUSPICIOUS_ORE_KEY),
                ModOrePlacement.modifiersWithCount(20,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(5),YOffset.fixed(120))));
    }
    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("partea_expansion", name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
