package partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.random.Random;

public class EnchantPredictiveDepthOfField extends ClassDestruction {
    public static Enchantment PREDICTIVE_DEPTH_OF_FIELD = new EnchantPredictiveDepthOfField();

    protected EnchantPredictiveDepthOfField() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = user.getRandom();
        if(level == 1){
            if (user.getHealth() <= 0.5*user.getMaxHealth()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 100, 0));
            }
        }else if (level == 2){
            if (user.getHealth() <= 0.5*user.getMaxHealth()){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,100,0));
                if (user.getHealth() <= 0.3*user.getMaxHealth()){
                    if(user.hasStatusEffect(StatusEffects.RESISTANCE)){
                        user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,60,1));
                    }
                }
            }
        }
    }
}
