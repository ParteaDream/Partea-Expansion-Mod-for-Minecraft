package partea.partea_expansion.potion;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static partea.partea_expansion.potion.CustomPotionDoomedDeath.PotionDoomedDeath;

public class PotionRegister {
    public static void registerPotion(){
        Registry.register(Registries.STATUS_EFFECT, new Identifier("partea_expansion", "doomed_death"), PotionDoomedDeath);
    }
}
