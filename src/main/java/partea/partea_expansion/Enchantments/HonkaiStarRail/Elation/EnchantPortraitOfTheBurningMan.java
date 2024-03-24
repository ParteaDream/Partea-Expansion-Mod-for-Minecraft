package partea.partea_expansion.Enchantments.HonkaiStarRail.Elation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import partea.partea_expansion.potion.EffectAftertaste;
import partea.partea_expansion.util.FEUtil;
import partea.partea_expansion.util.RandomStatusEffects;

import java.util.Random;

public class EnchantPortraitOfTheBurningMan extends ClassElation{
    public static Enchantment PortraitOfTheBurningMan = new EnchantPortraitOfTheBurningMan();

    protected EnchantPortraitOfTheBurningMan() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Random random = new Random();
        if (random.nextFloat() < 0.4 && level > 0 && target instanceof LivingEntity T){
            if (FEUtil.hasEnchantment(user, EnchantPeacefulSleep.Peaceful_Sleep)){
                int ps = FEUtil.getLevelArmor(user, EnchantPeacefulSleep.Peaceful_Sleep);
                if (random.nextFloat() < 0.3 - 0.05 * level){
                    T.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomBeneficialEffect(), 100, 0));
                    user.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomHarmfulEffect(), 100,0));
                    T.addStatusEffect(new StatusEffectInstance(EffectAftertaste.EffectAftertaste,100,0));
                }else {
                    T.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomHarmfulEffectWithNoDot(), 160, level));
                    user.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomBeneficialEffect(), 160,level* 2 - 2 + ps));
                    T.addStatusEffect(new StatusEffectInstance(EffectAftertaste.EffectAftertaste,160,0));
                }
                return;
            }
            float f = random.nextFloat();
            if (f < 0.3 - 0.05 * level){
                T.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomBeneficialEffect(), 100, 1));
                user.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomHarmfulEffect(), 100,1));
                T.addStatusEffect(new StatusEffectInstance(EffectAftertaste.EffectAftertaste,100,0));
            }else if (f > 0.5 - 0.05 * level){
                T.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomHarmfulEffectWithNoDot(), 160, level - 1));
                user.addStatusEffect(new StatusEffectInstance(RandomStatusEffects.randomBeneficialEffect(), 160,level - 1));
                T.addStatusEffect(new StatusEffectInstance(EffectAftertaste.EffectAftertaste,160,0));
            }
        }
    }
}
