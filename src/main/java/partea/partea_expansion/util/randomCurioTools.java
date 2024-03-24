package partea.partea_expansion.util;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import partea.partea_expansion.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class randomCurioTools {
    static WeightCategory_curios Damaged_Galaxy_Lotto = new WeightCategory_curios(ModItems.Damaged_Galaxy_Lotto,10);
    static WeightCategory_curios Damaged_Interastra_Big_Lotto = new WeightCategory_curios(ModItems.Damaged_Interastra_Big_Lotto,10);
    static WeightCategory_curios Damaged_Totem_Of_Equilibrium = new WeightCategory_curios(ModItems.Damaged_Totem_Of_Equilibrium,10);
    static WeightCategory_curios Damaged_Clock_Tricks = new WeightCategory_curios(ModItems.Damaged_Clock_Tricks,3);
    static WeightCategory_curios Damaged_Laurel_Crown_Of_Planar_Shifts = new WeightCategory_curios(ModItems.Damaged_Laurel_Crown_Of_Planar_Shifts,10);


    static WeightCategory_curios Clock_Tricks = new WeightCategory_curios(ModItems.Clock_Tricks,3);
    static WeightCategory_curios FOOLS_MASK = new WeightCategory_curios(ModItems.FOOLS_MASK,10);
    static WeightCategory_curios THRILLER_MASK = new WeightCategory_curios(ModItems.THRILLER_MASK,8);
    static WeightCategory_curios Galaxy_Lotto = new WeightCategory_curios(ModItems.Galaxy_Lotto,10);
    static WeightCategory_curios Interastra_Big_Lotto = new WeightCategory_curios(ModItems.Interastra_Big_Lotto,12);
    static WeightCategory_curios KNEE_PADS = new WeightCategory_curios(ModItems.KNEE_PADS,7);
    static WeightCategory_curios Laurel_Crown_Of_Planar_Shifts = new WeightCategory_curios(ModItems.Laurel_Crown_Of_Planar_Shifts,5);
    static WeightCategory_curios ROBE_OF_THE_BEAUTY = new WeightCategory_curios(ModItems.ROBE_OF_THE_BEAUTY,5);
    static WeightCategory_curios SILVER_COIN_OF_DISCORD = new WeightCategory_curios(ModItems.SILVER_COIN_OF_DISCORD,10);
    static WeightCategory_curios Sneaker = new WeightCategory_curios(ModItems.Sneaker,9);
    static WeightCategory_curios Society_Ticket = new WeightCategory_curios(ModItems.SOCIETY_TICKET,12);
    static WeightCategory_curios TOTEM_OF_EQUILIBRIUM = new WeightCategory_curios(ModItems.Totem_Of_Equilibrium,8);
    static WeightCategory_curios TOTEM_OF_VOID = new WeightCategory_curios(ModItems.TOTEM_OF_VOID,6);
    static WeightCategory_curios TOTEM_OF_UNDYING = new WeightCategory_curios(Items.TOTEM_OF_UNDYING,8);
    static WeightCategory_curios Typical_Genius_Society_Gossip = new WeightCategory_curios(ModItems.Typical_Genius_Society_Gossip,6);
    static WeightCategory_curios Void_Wick_Trimmer = new WeightCategory_curios(ModItems.Void_Wick_Trimmer,8);


    public static Item randomCurio(){
        return uniformMethod(FOOLS_MASK,THRILLER_MASK,Galaxy_Lotto,Interastra_Big_Lotto,KNEE_PADS,Laurel_Crown_Of_Planar_Shifts
                ,ROBE_OF_THE_BEAUTY,SILVER_COIN_OF_DISCORD,Sneaker,Society_Ticket,TOTEM_OF_EQUILIBRIUM,TOTEM_OF_VOID,TOTEM_OF_UNDYING
                ,Typical_Genius_Society_Gossip,Clock_Tricks,Void_Wick_Trimmer);
    }
    public static Item randomCurioButLotto(){
        return uniformMethod(FOOLS_MASK,THRILLER_MASK,KNEE_PADS,Laurel_Crown_Of_Planar_Shifts
                ,ROBE_OF_THE_BEAUTY,SILVER_COIN_OF_DISCORD,Sneaker,Society_Ticket,TOTEM_OF_EQUILIBRIUM,TOTEM_OF_VOID,TOTEM_OF_UNDYING
                ,Typical_Genius_Society_Gossip,Clock_Tricks,Void_Wick_Trimmer);
    }
    public static Item randomGoldenTrashbag(){
        return uniformMethod(Damaged_Galaxy_Lotto,Damaged_Interastra_Big_Lotto,Damaged_Totem_Of_Equilibrium
                ,Damaged_Clock_Tricks,TOTEM_OF_UNDYING,Damaged_Laurel_Crown_Of_Planar_Shifts);
    }
    public static Item randomTrashbag(){
        return uniformMethod(Damaged_Galaxy_Lotto,Damaged_Interastra_Big_Lotto,Damaged_Totem_Of_Equilibrium
                ,TOTEM_OF_UNDYING);
    }
    public static Item uniformMethod(WeightCategory_curios... vars){
        List<WeightCategory_curios> CurioList = new ArrayList<>(Arrays.asList(vars));
        return getWeight(CurioList);
    }



    public static Item getWeight(List<WeightCategory_curios> categorys) {
        int weightSum = 0;
        Item result=null;
        for (WeightCategory_curios wc : categorys) {
            weightSum += wc.getWeight();
        }
        Random random = new Random();
        int n = random.nextInt(weightSum); // n in [0, weightSum)
        int m = 0;
        for (WeightCategory_curios wc : categorys) {
            if (m <= n && n < m + wc.getWeight()) {
                result=wc.getCategory();
                break;
            }
            m += wc.getWeight();
        }
        return result;
    }
}
 class WeightCategory_curios {
    private Item category;//类别
    private int weight;//权重值

    public WeightCategory_curios(Item category, int weight) {
        this.category = category;
        this.weight = weight;
    }

    public Item getCategory() {
        return category;
    }

    public void setCategory(Item category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}