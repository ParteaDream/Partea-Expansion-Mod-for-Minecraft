package partea.partea_expansion.potion;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EffectPre extends StatusEffect {
    public static StatusEffect EffectPre = new EffectPre();

    protected EffectPre() {
        super(StatusEffectCategory.BENEFICIAL, 0xDB9452);
    }
}
