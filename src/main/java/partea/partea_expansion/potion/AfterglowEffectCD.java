package partea.partea_expansion.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AfterglowEffectCD extends StatusEffect {
    public static StatusEffect AfterglowEffectCDEffect = new AfterglowEffectCD();

    protected AfterglowEffectCD() {
        super(StatusEffectCategory.NEUTRAL, 0xFFFAFA);
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
    }
}
