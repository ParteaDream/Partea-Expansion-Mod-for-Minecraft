package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import partea.partea_expansion.ModItems;
import partea.partea_expansion.Modblocks;

public class ModLootTablesProvider extends FabricBlockLootTableProvider {

    public ModLootTablesProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Modblocks.GOLDEN_NETHERITE_BLOCK);
        addDrop(Modblocks.DIAMOND_NETHERITE_BLOCK);
        addDrop(Modblocks.AZURE_BLOCK);
        addDrop(Modblocks.QUALITATIVE_ANALYZER);
        addDrop(Modblocks.PALM_LOG);
        addDrop(Modblocks.PALM_PLANKS);
        addDrop(Modblocks.STRIPPED_PALM_LOG);
        addDrop(Modblocks.STRIPPED_PALM_WOOD);
        addDrop(Modblocks.PALM_WOOD);
        addDrop(Modblocks.PALM_STAIR);
        addDrop(Modblocks.PALM_SLAB,slabDrops(Modblocks.PALM_SLAB));
        addDrop(Modblocks.PALM_BUTTON);
        addDrop(Modblocks.PALM_FENCE);
        addDrop(Modblocks.PALM_FENCE_GATE);
        addDrop(Modblocks.PALM_PRESSURE_PLATE);
        addDrop(Modblocks.PALM_DOOR,doorDrops(Modblocks.PALM_DOOR));
        addDrop(Modblocks.PALM_TRAPDOOR);

        addDrop(Modblocks.AZURE_ORE,copperOreLikeDrops(Modblocks.AZURE_ORE, ModItems.RAW_AZURE));

        addDrop(Modblocks.SUSPICIOUS_ORE,oreDrops(Modblocks.SUSPICIOUS_ORE, ModItems.SUSPICIOUS_STONE));
        addDrop(Modblocks.DEEPSLATE_SUSPICIOUS_ORE,oreDrops(Modblocks.DEEPSLATE_SUSPICIOUS_ORE, ModItems.SUSPICIOUS_STONE));
        addDrop(Modblocks.NETHER_SUSPICIOUS_ORE,oreDrops(Modblocks.NETHER_SUSPICIOUS_ORE, ModItems.NETHER_SUSPICIOUS_STONE));

        addDrop(Modblocks.PALM_LEAVES,leavesDrops(Modblocks.PALM_LEAVES, Modblocks.PALM_SAPLING, 0.2f));
        addDrop(Modblocks.PALM_SAPLING);
    }

    public LootTable.Builder copperOreLikeDrops(Block drop, Item item){
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop
                , ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,1.0f)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
