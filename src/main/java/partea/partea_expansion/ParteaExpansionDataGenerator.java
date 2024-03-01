package partea.partea_expansion;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import partea.partea_expansion.datagen.*;
import partea.partea_expansion.world.ModConfiguredFeatures;
import partea.partea_expansion.world.ModPlacedFeatures;
import partea.partea_expansion.world.biome.ModBiomes;

public class ParteaExpansionDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModLootTablesProvider::new);
		pack.addProvider(ModRecipesProvider::new);
		pack.addProvider(ModPoiTagsProvider::new);
		pack.addProvider(ModWorldGenerators::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, ModBiomes::boostrap);
	}
}
