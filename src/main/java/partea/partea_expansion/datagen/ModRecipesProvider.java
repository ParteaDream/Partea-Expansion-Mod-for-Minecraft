package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.Modblocks;

import java.util.List;

public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> AZURE_LIST = List.of(Modblocks.AZURE_ORE);
    public ModRecipesProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.GOLDEN_NETHERITE_INGOT,
                RecipeCategory.BUILDING_BLOCKS, Modblocks.GOLDEN_NETHERITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DIAMOND_NETHERITE_INGOT,
                RecipeCategory.BUILDING_BLOCKS, Modblocks.DIAMOND_NETHERITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.AZURE_INGOT,
                RecipeCategory.BUILDING_BLOCKS, Modblocks.AZURE_BLOCK);

        offerSmelting(exporter,AZURE_LIST,RecipeCategory.MISC,ModItems.RAW_AZURE
                ,1.0f,400,"raw_azure");
        offerBlasting(exporter,AZURE_LIST,RecipeCategory.MISC,ModItems.RAW_AZURE
                ,1.0f,200,"raw_azure");

    }
}
