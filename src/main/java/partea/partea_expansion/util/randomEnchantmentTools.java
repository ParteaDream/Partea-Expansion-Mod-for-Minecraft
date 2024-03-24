package partea.partea_expansion.util;

import net.minecraft.enchantment.Enchantment;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Elation.EnchantCatsCradle;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Elation.EnchantPeacefulSleep;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Elation.EnchantPortraitOfTheBurningMan;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantBloodTherapy;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantCelestialAnnihilation;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantCelestialSnipe;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantRainbowChiseledTeeth;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantCryOfTheWilderness;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantFuneralRitesForSensualWorshippers;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantTheOneWhoIsEncasedInASleeve;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.EnchantTheTwilightOfExistence;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class randomEnchantmentTools {
    static WeightCategory_ench Abu_CC = new WeightCategory_ench(EnchantCrystallyClear.CrystallyClear,10);
    static WeightCategory_ench Abu_FY = new WeightCategory_ench(EnchantFayu.Fayu,15);
    static WeightCategory_ench Abu_HS = new WeightCategory_ench(EnchantHannyaShip.HannyaShip,10);
    static WeightCategory_ench Abu_Me = new WeightCategory_ench(EnchantMerciful.Merciful,5);
    static WeightCategory_ench Abu_YY = new WeightCategory_ench(EnchantYuanyin.Yuanyin,15);

    static WeightCategory_ench Des_AE = new WeightCategory_ench(EnchantAfterglowEffect.Afterglow_Effect,5);
    static WeightCategory_ench Des_ANE = new WeightCategory_ench(EnchantAntimatterNoninverseEquation.Antimatter_Noninverse_Equation,5);
    static WeightCategory_ench Des_DF = new WeightCategory_ench(EnchantDestructiveFlare.DESTRUCTIVE_FLARE,10);
    static WeightCategory_ench Des_HA = new WeightCategory_ench(EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW,10);
    static WeightCategory_ench Des_PF = new WeightCategory_ench(EnchantPreceptFlickering.PRECEPT_FLICKERING,10);
    static WeightCategory_ench Des_PDF = new WeightCategory_ench(EnchantPredictiveDepthOfField.PREDICTIVE_DEPTH_OF_FIELD,10);


    static WeightCategory_ench Ela_CC = new WeightCategory_ench(EnchantCatsCradle.Cats_Cradle,5);
    static WeightCategory_ench Ela_PS = new WeightCategory_ench(EnchantPeacefulSleep.Peaceful_Sleep,5);
    static WeightCategory_ench Ela_PTBM = new WeightCategory_ench(EnchantPortraitOfTheBurningMan.PortraitOfTheBurningMan,10);

    static WeightCategory_ench Hun_BT = new WeightCategory_ench(EnchantBloodTherapy.BLOOD_THERAPY,10);
    static WeightCategory_ench Hun_CA = new WeightCategory_ench(EnchantCelestialAnnihilation.Celestial_Annihilation,10);
    static WeightCategory_ench Hun_CS = new WeightCategory_ench(EnchantCelestialSnipe.Celestial_Snipe,5);
    static WeightCategory_ench Hun_RCT = new WeightCategory_ench(EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth,10);

    static WeightCategory_ench Nih_CTW = new WeightCategory_ench(EnchantCryOfTheWilderness.Cry_Of_The_Wilderness,10);
    static WeightCategory_ench Nih_FRFSW = new WeightCategory_ench(EnchantFuneralRitesForSensualWorshippers.Funeral_Rites_For_Sensual_Worshippers,5);
    static WeightCategory_ench Nih_TOWIEIAS = new WeightCategory_ench(EnchantTheOneWhoIsEncasedInASleeve.The_One_Who_Is_Encased_In_A_Sleeve,5);
    static WeightCategory_ench Nih_TTE = new WeightCategory_ench(EnchantTheTwilightOfExistence.The_Twilight_Of_Existence,10);

    static WeightCategory_ench Pre_B = new WeightCategory_ench(EnchantBridging.CONSTRUSTION_BRIDGING,15);
    static WeightCategory_ench Pre_C = new WeightCategory_ench(EnchantCompensation.CONSTRUSTION_COMPENSATION,15);
    static WeightCategory_ench Pre_FS = new WeightCategory_ench(EnchantFeedbackShelter.Feedback_Shelter,10);
    static WeightCategory_ench Pre_RT = new WeightCategory_ench(EnchantResonanceTransmission.ResonanceTransmission,5);
    static WeightCategory_ench Pre_SP = new WeightCategory_ench(EnchantSafetyPayloads.SafetyPayloads,10);
    static WeightCategory_ench Pre_Sta = new WeightCategory_ench(EnchantStaunch.CONSTRUSTION_STAUNCH,15);
    static WeightCategory_ench Pre_Sub = new WeightCategory_ench(EnchantSubeutectic.Subeutectic,10);
    static WeightCategory_ench Pre_Sup = new WeightCategory_ench(EnchantSuperstaticFixation.SuperstaticFixation,5);

    static WeightCategory_ench Rem_Sup = new WeightCategory_ench(EnchantClimbingThrill.Climbing_Thrill,10);
    static WeightCategory_ench Rem_FL = new WeightCategory_ench(EnchantFuli.Fuli,5);
    static WeightCategory_ench Rem_IA = new WeightCategory_ench(EnchantIceAspect.ICE_ASPECT,15);
    static WeightCategory_ench Rem_TTA = new WeightCategory_ench(EnchantTheTormentOfAlienation.TormentOfAlienation,10);
    static WeightCategory_ench Rem_ST = new WeightCategory_ench(EnchantSensitivity.Sensitivity,10);

    public static Enchantment randomHonkaiEnchant_All(){
        Random random = new Random();
        switch (random.nextInt(0,7)){
            case 0 -> {
                return randomHonkaiEnchant_Rem();
            }
            case 1 -> {
                return randomHonkaiEnchant_Hun();
            }
            case 2 -> {
                return randomHonkaiEnchant_Nih();
            }
            case 3 -> {
                return randomHonkaiEnchant_Ela();
            }
            case 4 -> {
                return randomHonkaiEnchant_Abu();
            }
            case 5 -> {
                return randomHonkaiEnchant_Des();
            }
            default -> {
                return randomHonkaiEnchant_Pre();
            }
        }
    }
    public static Enchantment randomHonkaiEnchant_Rem(){
        return uniformMethod(Rem_Sup,Rem_FL,Rem_IA,Rem_TTA,Rem_ST);
    }
    public static Enchantment randomHonkaiEnchant_Pre(){
        return uniformMethod(Pre_B,Pre_C,Pre_FS,Pre_RT,Pre_SP,Pre_Sta,Pre_Sub,Pre_Sup);
    }
    public static Enchantment randomHonkaiEnchant_Nih(){
        return uniformMethod(Nih_CTW,Nih_FRFSW,Nih_TOWIEIAS,Nih_TTE);
    }
    public static Enchantment randomHonkaiEnchant_Hun(){
        return uniformMethod(Hun_BT,Hun_CA,Hun_CS,Hun_RCT);
    }
    public static Enchantment randomHonkaiEnchant_Abu(){
        return uniformMethod(Abu_CC,Abu_FY,Abu_HS,Abu_Me,Abu_YY);
    }
    public static Enchantment randomHonkaiEnchant_Des(){
        return uniformMethod(Des_AE,Des_ANE,Des_DF,Des_HA,Des_PF,Des_PDF);
    }
    public static Enchantment randomHonkaiEnchant_Ela(){
        return uniformMethod(Ela_CC,Ela_PS,Ela_PTBM);
    }

    public static Enchantment uniformMethod(WeightCategory_ench... vars){
        List<WeightCategory_ench> EnchantmentList = new ArrayList<>(Arrays.asList(vars));
        return getWeight(EnchantmentList);
    }



    public static Enchantment getWeight(List<WeightCategory_ench> categorys) {
        int weightSum = 0;
        Enchantment result=null;
        for (WeightCategory_ench wc : categorys) {
            weightSum += wc.getWeight();
        }
        Random random = new Random();
        int n = random.nextInt(weightSum); // n in [0, weightSum)
        int m = 0;
        for (WeightCategory_ench wc : categorys) {
            if (m <= n && n < m + wc.getWeight()) {
                result=wc.getCategory();
                break;
            }
            m += wc.getWeight();
        }
        return result;
    }
}
class WeightCategory_ench {
    private Enchantment category;//类别
    private int weight;//权重值

    public WeightCategory_ench(Enchantment category, int weight) {
        this.category = category;
        this.weight = weight;
    }

    public Enchantment getCategory() {
        return category;
    }

    public void setCategory(Enchantment category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}