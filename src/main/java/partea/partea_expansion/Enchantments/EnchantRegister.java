package partea.partea_expansion.Enchantments;

import net.minecraft.client.gui.screen.ingame.EnchantmentScreen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static partea.partea_expansion.Enchantments.EnchantDoomedDeath.Doomed_Death;

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
                , new Identifier("partea_expansion", "pulse"), EnchantPulse.PULSE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "rise"), EnchantRise.RISE);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "pyramania"), EnchantPyromania.PYRAMANIA);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "soul_seeker"), EnchantSoulSeeker.SOUL_SEEKER);
        Registry.register(Registries.ENCHANTMENT
                , new Identifier("partea_expansion", "vigour"), EnchantVigour.VIGOUR);
    }
}