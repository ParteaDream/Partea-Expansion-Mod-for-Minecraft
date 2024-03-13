package partea.partea_expansion.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EffectDurance extends StatusEffect {
    public static StatusEffect EffectDurance = new EffectDurance();

    protected EffectDurance() {
        super(StatusEffectCategory.HARMFUL, 0x8B7500);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,  5, 5 * amplifier + 5, true, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 5, 5 * amplifier + 5, true, false));
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 2;
        return duration % i == 0;
    }
}
