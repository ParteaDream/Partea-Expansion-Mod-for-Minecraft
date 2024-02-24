package partea.partea_expansion.CustomBlocks;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class GenOres {

    public static final RegistryKey<PlacedFeature> LARGE_AZURE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE
            , new Identifier("partea_expansion","ore_azure_large"));
    public static final RegistryKey<PlacedFeature> SMALL_AZURE_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE
            , new Identifier("partea_expansion","ore_azure_small"));


    public static void registerGenOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, LARGE_AZURE_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, SMALL_AZURE_ORE_PLACED_KEY);
    }
}
