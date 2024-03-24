package partea.partea_expansion.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectAftertaste extends StatusEffect {
    public static StatusEffect EffectAftertaste = new EffectAftertaste();

    protected EffectAftertaste() {
        super(StatusEffectCategory.HARMFUL, 0xFF3030);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }
}
