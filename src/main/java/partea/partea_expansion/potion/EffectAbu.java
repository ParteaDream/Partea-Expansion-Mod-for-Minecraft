package partea.partea_expansion.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectAbu extends StatusEffect {
    public static StatusEffect EffectAbu = new EffectAbu();

    protected EffectAbu() {
        super(StatusEffectCategory.BENEFICIAL, 0xBFC553);
    }
}
