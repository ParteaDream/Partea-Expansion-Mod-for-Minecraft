package partea.partea_expansion.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import partea.partea_expansion.CustomTrades.Jeweler;
import partea.partea_expansion.ModItems;

import static partea.partea_expansion.CustomTrades.NetherExplorer.NETHER_EXPLORER;

public class ModTraders {
    public static void registerTraders(){
        //mason expansion
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.MASON,1,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.COBBLESTONE, 32),
                    new ItemStack(Items.EMERALD, 1),
                    10,5,0.05f
            ));
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.DEEPSLATE, 32),
                    new ItemStack(Items.EMERALD,1),
                    10,5,0.05f
            )));
                });
        //Jeweler
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 8)
                            , new ItemStack(Items.COAL, 32)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2)
                            , new ItemStack(ModItems.SUSPICIOUS_STONE, 1)
                            , 5, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3)
                            , new ItemStack(Items.IRON_INGOT, 6)
                            , 10, 8, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4)
                            , new ItemStack(Items.GOLD_INGOT, 4)
                            , 10, 6, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8)
                            , new ItemStack(Items.LAPIS_LAZULI, 32)
                            , 10, 10, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8)
                            , new ItemStack(Items.REDSTONE, 32)
                            , 10, 10, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(Jeweler.Jeweler,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8)
                            , new ItemStack(Items.DIAMOND, 1)
                            , 10, 8, 0.05f
                    )));
                });


        //nether explorer
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.COBBLESTONE, 8), new ItemStack(Items.COAL, 4)
                            , new ItemStack(Items.GLOWSTONE_DUST, 32)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.REDSTONE, 4), new ItemStack(Blocks.SAND, 16)
                            , new ItemStack(Items.MAGMA_CREAM, 8)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.ARROW, 2), new ItemStack(Items.STRING, 4)
                            , new ItemStack(Items.GHAST_TEAR)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BUCKET), new ItemStack(Blocks.COBBLESTONE, 32)
                            , new ItemStack(Items.LAVA_BUCKET)
                            , 10, 12, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_INGOT,3), new ItemStack(Items.EMERALD, 5)
                            , new ItemStack(ModItems.CRIMSON_PEARL)
                            , 10, 10, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BLAZE_ROD, 1), new ItemStack(Blocks.COBBLESTONE, 16)
                            , new ItemStack(Items.MAGMA_CREAM,4)
                            , 10, 8, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GOLD_INGOT, 4), new ItemStack(Blocks.COBBLESTONE, 32)
                            , new ItemStack(ModItems.AVARICIOUS_PEARL)
                            , 10, 10, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.DIAMOND, 12), new ItemStack(Items.GOLD_INGOT, 32)
                            , new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                            , 10, 20, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(NETHER_EXPLORER,5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.DIAMOND, 6), new ItemStack(Items.GOLD_INGOT, 6)
                            , new ItemStack(Blocks.ANCIENT_DEBRIS)
                            , 10, 10, 0.05f
                    )));
                });
    }
}
