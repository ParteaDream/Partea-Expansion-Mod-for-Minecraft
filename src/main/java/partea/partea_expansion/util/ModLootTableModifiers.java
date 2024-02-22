package partea.partea_expansion.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import partea.partea_expansion.ModItems;

public class ModLootTableModifiers {
    private static final Identifier ENDER_CITY_ID = new Identifier("minecraft", "chests/end_city_treasure");
    private static final Identifier BURIED_TREASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier SUS_SAND_ID = new Identifier("minecraft", "archaeology/desert_pyramid");
    private static final Identifier SQUID_ID = new Identifier("minecraft", "entities/squid");
    private static final Identifier GLOW_SQUID_ID = new Identifier("minecraft", "entities/glow_squid");

    public static void modifierLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ENDER_CITY_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(ModItems.SHED_A_LIGHT_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BURIED_TREASURE_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.7f))
                        .with(ItemEntry.builder(ModItems.SILENT_TIME_MUSIC_DISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));

        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
            if(SUS_SAND_ID.equals(id)){
                LootPool.Builder pool = LootPool.builder()
                        .with(ItemEntry.builder(Items.AMETHYST_SHARD))
                        .with(ItemEntry.builder(Items.ARCHER_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.MINER_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.PRIZE_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.SKULL_POTTERY_SHERD))
                        .with(ItemEntry.builder(Items.DIAMOND))
                        .with(ItemEntry.builder(Items.TNT))
                        .with(ItemEntry.builder(Items.GUNPOWDER))
                        .with(ItemEntry.builder(Items.EMERALD));
                return LootTable.builder().pool(pool).build();
            }
            return null;
        }));

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SQUID_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.SLIME_BALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(GLOW_SQUID_ID.equals(id)){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(Items.SLIME_BALL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)));
                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}
