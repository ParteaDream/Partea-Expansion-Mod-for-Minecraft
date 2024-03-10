package partea.partea_expansion.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EvilLizardEffect extends StatusEffect {
    protected EvilLizardEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF8247);
    }
    public static StatusEffect EvilLizardEffect = new EvilLizardEffect();
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,20,4));
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 10;
        return duration % i == 0;
    }
}
