package partea.partea_expansion.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import partea.partea_expansion.CustomTrades.HappyHappyHappy;
import partea.partea_expansion.CustomTrades.Jeweler;
import partea.partea_expansion.CustomTrades.TrashCanMaster;
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
        //Wanderer
        TradeOfferHelper.registerWanderingTraderOffers(2,factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 32),
                    new ItemStack(ModItems.FOOLS_MASK, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 32),
                    new ItemStack(ModItems.THRILLER_MASK, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 24),
                    new ItemStack(ModItems.Galaxy_Lotto, 1),
                    3,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 28),
                    new ItemStack(ModItems.Totem_Of_Equilibrium, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 24),
                    new ItemStack(ModItems.Sneaker, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 32),
                    new ItemStack(ModItems.KNEE_PADS, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 48),
                    new ItemStack(ModItems.Laurel_Crown_Of_Planar_Shifts, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 36),
                    new ItemStack(ModItems.Curio_Treasure_Bag, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 42),
                    new ItemStack(ModItems.ROBE_OF_THE_BEAUTY, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 32),
                    new ItemStack(ModItems.SILVER_COIN_OF_DISCORD, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 32),
                    new ItemStack(Items.TOTEM_OF_UNDYING, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 38),
                    new ItemStack(ModItems.TOTEM_OF_VOID, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 36),
                    new ItemStack(ModItems.Interastra_Big_Lotto, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 44),
                    new ItemStack(ModItems.Typical_Genius_Society_Gossip, 1),
                    1,5,0.05f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModItems.COIN, 28),
                    new ItemStack(ModItems.SOCIETY_TICKET, 1),
                    1,5,0.05f
            ));
        });

        //Happy
        TradeOfferHelper.registerVillagerOffers(HappyHappyHappy.Happy,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16)
                            , new ItemStack(ModItems.KNEE_PADS, 1)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(HappyHappyHappy.Happy,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 24)
                            , new ItemStack(ModItems.Sneaker, 1)
                            , 10, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(HappyHappyHappy.Happy,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32)
                            , new ItemStack(ModItems.FOOLS_MASK, 1)
                            , 10, 60, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(HappyHappyHappy.Happy,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32)
                            , new ItemStack(ModItems.THRILLER_MASK, 1)
                            , 10, 80, 0.05f
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


        //TrashCanMaster
        TradeOfferHelper.registerVillagerOffers(TrashCanMaster.Trash_Can_Master,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COIN, 25)
                            , new ItemStack(ModItems.Trash_Bag, 1)
                            , 1, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TrashCanMaster.Trash_Can_Master,1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COIN, 25)
                            , new ItemStack(ModItems.Trash_Bag, 1)
                            , 1, 5, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TrashCanMaster.Trash_Can_Master,2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COIN, 25)
                            , new ItemStack(ModItems.Trash_Bag, 1)
                            , 1, 60, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TrashCanMaster.Trash_Can_Master,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COIN, 25)
                            , new ItemStack(ModItems.Trash_Bag, 1)
                            , 1, 80, 0.05f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(TrashCanMaster.Trash_Can_Master,3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.COIN, 40)
                            , new ItemStack(ModItems.Golden_Trash_Bag, 1)
                            , 1, 80, 0.05f
                    )));
                });
    }
}
