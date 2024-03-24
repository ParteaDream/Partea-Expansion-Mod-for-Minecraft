package partea.partea_expansion.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class CustomPotionDoomedDeath extends StatusEffect {
    public static StatusEffect PotionDoomedDeath = new CustomPotionDoomedDeath();

    protected CustomPotionDoomedDeath() {
        super(StatusEffectCategory.HARMFUL, 0x8B1A1A);
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 21 - 6 * amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.damage(entity.getDamageSources().magic(), entity.getMaxHealth() * ( 0.005f + 0.005f*(1 << amplifier)));
    }
}
