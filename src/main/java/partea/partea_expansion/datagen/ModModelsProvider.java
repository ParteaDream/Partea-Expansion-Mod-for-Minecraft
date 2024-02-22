package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.Modblocks;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output){
        super(output);
    }
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.DIAMOND_NETHERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.GOLDEN_NETHERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.AZURE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.AZURE_ORE);
        blockStateModelGenerator.registerSimpleState(Modblocks.QUALITATIVE_ANALYZER);
    }
    public void generateItemModels(ItemModelGenerator itemModelGenerator){
        itemModelGenerator.register(ModItems.CREATIVE_MODE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMPTY_TERMINAL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SAFEMINING_DETECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLDEN_NETHERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_NETHERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_PROSPECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AZURE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHED_A_LIGHT_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILENT_TIME_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUDE_AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.AMETHYST_STILLETO, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAE_AZURE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NIGHT_VISION_GLASSES);
    }
}
