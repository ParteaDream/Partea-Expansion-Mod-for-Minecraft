package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import partea.partea_expansion.Modblocks;
import partea.partea_expansion.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registerFuture){
        super(output, registerFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.DIAMOND_PROSPECTOR_LIST)
                .forceAddTag(BlockTags.COAL_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .add(Blocks.RAW_COPPER_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Modblocks.DIAMOND_NETHERITE_BLOCK)
                .add(Modblocks.GOLDEN_NETHERITE_BLOCK)
                .add(Modblocks.AZURE_BLOCK)
                .add(Modblocks.AZURE_ORE);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(Modblocks.GOLDEN_NETHERITE_BLOCK)
                .add(Modblocks.DIAMOND_NETHERITE_BLOCK);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(Modblocks.AZURE_BLOCK)
                .add(Modblocks.AZURE_ORE);
    }
}
