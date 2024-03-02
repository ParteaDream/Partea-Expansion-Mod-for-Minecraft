package partea.partea_expansion.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import partea.partea_expansion.world.ModPlacedFeatures;
import partea.partea_expansion.world.biome.ModBiomes;

public class ModTreeGeneration {
    public static void registerTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.PALM_BIOME),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PALM_TREE_KEY);
    }
}
