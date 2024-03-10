package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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
        BlockStateModelGenerator.BlockTexturePool palmPlanksPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Modblocks.PALM_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.DIAMOND_NETHERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.GOLDEN_NETHERITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.AZURE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.AZURE_ORE);
        blockStateModelGenerator.registerLog(Modblocks.PALM_LOG).log(Modblocks.PALM_LOG).wood(Modblocks.PALM_WOOD);
        blockStateModelGenerator.registerLog(Modblocks.STRIPPED_PALM_LOG).log(Modblocks.STRIPPED_PALM_LOG).wood(Modblocks.STRIPPED_PALM_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.PALM_LEAVES);
        blockStateModelGenerator.registerTintableCross(Modblocks.PALM_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.SUSPICIOUS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.DEEPSLATE_SUSPICIOUS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(Modblocks.NETHER_SUSPICIOUS_ORE);

        palmPlanksPool.stairs(Modblocks.PALM_STAIR);
        palmPlanksPool.slab(Modblocks.PALM_SLAB);
        palmPlanksPool.fence(Modblocks.PALM_FENCE);
        palmPlanksPool.fenceGate(Modblocks.PALM_FENCE_GATE);
        palmPlanksPool.button(Modblocks.PALM_BUTTON);
        palmPlanksPool.pressurePlate(Modblocks.PALM_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(Modblocks.PALM_DOOR);
        blockStateModelGenerator.registerTrapdoor(Modblocks.PALM_TRAPDOOR);

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
        itemModelGenerator.register(ModItems.RAW_AZURE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTALLIZED_LAPIS_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYSTALLIZED_LAPIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRYING_OBSIDIAN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARTZ_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.FABRIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.ANCIENT_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEART_OF_THE_DEEP, Models.GENERATED);
        itemModelGenerator.register(ModItems.AFTERGLOW_CD, Models.GENERATED);
        itemModelGenerator.register(ModItems.HORSE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_HORSE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AVARICIOUS_PEARL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BASALT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURE_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLACK_SWORD, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLINT_KNIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSPICIOUS_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHER_SUSPICIOUS_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSPICIOUS_SQUAMA, Models.GENERATED);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.KNEE_PADS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.Sneaker);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FOOLS_MASK);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.THRILLER_MASK);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DIAMOND_NETHERITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.AZURE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GOLDEN_NETHERITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.NIGHT_VISION_GLASSES);
    }
}
