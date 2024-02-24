package partea.partea_expansion.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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

        addDrop(Modblocks.AZURE_ORE,copperOreLikeDrops(Modblocks.AZURE_ORE, ModItems.RAW_AZURE));
    }

    public LootTable.Builder copperOreLikeDrops(Block drop, Item item){
        return dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop
                , ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0f,1.0f)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
