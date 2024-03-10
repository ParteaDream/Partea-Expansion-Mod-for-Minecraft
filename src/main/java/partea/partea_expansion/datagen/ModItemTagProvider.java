package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.Modblocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture){
        super(output, completableFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.DIAMOND_NETHERITE_HELMET,ModItems.DIAMOND_NETHERITE_CHESTPLATE,ModItems.DIAMOND_NETHERITE_LEGGINGS
                ,ModItems.DIAMOND_NETHERITE_BOOTS,ModItems.GOLDEN_NETHERITE_HELMET,ModItems.GOLDEN_NETHERITE_CHESTPLATE
                ,ModItems.GOLDEN_NETHERITE_LEGGINGS,ModItems.GOLDEN_NETHERITE_BOOTS,ModItems.AZURE_HELMET,ModItems.AZURE_CHESTPLATE,
                        ModItems.AZURE_LEGGINGS,ModItems.AZURE_BOOTS,ModItems.AZURITE_HELMET,ModItems.AZURITE_CHESTPLATE,
                        ModItems.AZURITE_LEGGINGS,ModItems.AZURITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.SHED_A_LIGHT_MUSIC_DISC)
                .add(ModItems.SILENT_TIME_MUSIC_DISC);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(Modblocks.PALM_LOG.asItem())
                .add(Modblocks.PALM_WOOD.asItem())
                .add(Modblocks.STRIPPED_PALM_WOOD.asItem())
                .add(Modblocks.STRIPPED_PALM_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(Modblocks.PALM_PLANKS.asItem());
    }
}
