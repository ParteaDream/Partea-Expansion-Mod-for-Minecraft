package partea.partea_expansion.Enchantments;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.*;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantBloodTherapy;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.EnchantRainbowChiseledTeeth;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.*;
import partea.partea_expansion.Enchantments.WeaponEnch.*;

import static partea.partea_expansion.Enchantments.WeaponEnch.EnchantDoomedDeath.Doomed_Death;

public class EnchantRegister {
    public static void registerEnchantment(){
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "enchant_doomed_death"), Doomed_Death);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "ice_aspect"), EnchantIceAspect.ICE_ASPECT);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "auto_smelt"), EnchantAutoSmelt.Auto_Smelt);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "beheading"), EnchantBeheading.BEHEADING);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "experience"), EnchantExperience.EXPERIENCE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "glimmering"), EnchantmentGlimmering.GLIMMERING);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "consumer"), EnchantConsumer.CONSUMER);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "god_of_the_sea"), EnchantGodOfTheSea.GOD_OF_THE_SEA);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "nocturnal"), EnchantNocturnal.NOCTURNAL);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "deep_dark_fantasy"), EnchantPulse.PULSE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "rise"), EnchantRise.RISE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "pyramania"), EnchantPyromania.PYRAMANIA);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "soul_seeker"), EnchantSoulSeeker.SOUL_SEEKER);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "vigour"), EnchantVigour.VIGOUR);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "life_steal"), EnchantLifeSteal.LIFE_STEAL);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "raider"), EnchantRaider.RAIDER);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "dual_leap"), EnchantDualLeap.DUAL_LEAP);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "blaze_walker"), EnchantBlazeWalker.BLAZE_WALKER);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "blood_therapy"), EnchantBloodTherapy.BLOOD_THERAPY);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "rainbow_chiseled_teeth"), EnchantRainbowChiseledTeeth.Rainbow_Chiseled_Teeth);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "harmful_afterglow"), EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "precept_flickering"), EnchantPreceptFlickering.PRECEPT_FLICKERING);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "destructive_flare"), EnchantDestructiveFlare.DESTRUCTIVE_FLARE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "predictive_depth_of_field"), EnchantPredictiveDepthOfField.PREDICTIVE_DEPTH_OF_FIELD);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "antimatter_noninverse_equation"), EnchantAntimatterNoninverseEquation.Antimatter_Noninverse_Equation);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "afterglow_effect"), EnchantAfterglowEffect.Afterglow_Effect);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "construction_compensation"), EnchantCompensation.CONSTRUSTION_COMPENSATION);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "construction_staunch"), EnchantStaunch.CONSTRUSTION_STAUNCH);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "construction_bridging"), EnchantBridging.CONSTRUSTION_BRIDGING);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "interstellar_construction_subeutectic"), EnchantSubeutectic.Subeutectic);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "interstellar_construction_safety_payloads"), EnchantSafetyPayloads.SafetyPayloads);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "divine_construction_superstatic_fixation"), EnchantSuperstaticFixation.SuperstaticFixation);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "divine_construction_resonance_transmission"), EnchantResonanceTransmission.ResonanceTransmission);
    }
}
