package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import partea.partea_expansion.ModItems;

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
                ,ModItems.GOLDEN_NETHERITE_LEGGINGS,ModItems.GOLDEN_NETHERITE_BOOTS);

        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.SHED_A_LIGHT_MUSIC_DISC)
                .add(ModItems.SILENT_TIME_MUSIC_DISC);
    }
}
