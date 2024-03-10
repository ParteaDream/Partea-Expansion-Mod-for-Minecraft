package partea.partea_expansion.potion;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static partea.partea_expansion.potion.AfterglowEffectCD.AfterglowEffectCDEffect;
import static partea.partea_expansion.potion.CustomPotionDoomedDeath.PotionDoomedDeath;

public class EffectRegister {

    public static void registerEffect() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("partea_expansion", "doomed_death"), PotionDoomedDeath);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("partea_expansion", "afterglow_cd"), AfterglowEffectCDEffect);
        Registry.register(Registries.STATUS_EFFECT, new Identifier("partea_expansion", "evil_lizard"), EvilLizardEffect.EvilLizardEffect);
    }
}
