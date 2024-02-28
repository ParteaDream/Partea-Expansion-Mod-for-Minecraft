package partea.partea_expansion.Enchantments.WeaponEnch;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import partea.partea_expansion.potion.CustomPotionDoomedDeath;

public class EnchantDoomedDeath extends Enchantment {
    public static Enchantment Doomed_Death = new EnchantDoomedDeath();
    public EnchantDoomedDeath() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    @Override
    public int getMinPower(int level) {
        return 15 + 10 * (level - 1);
    }

    public boolean isTreasure(){
        return true;
    }
    @Override
    public int getMaxLevel() {
        return 5;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if((target instanceof LivingEntity)) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(CustomPotionDoomedDeath.PotionDoomedDeath, 10 * level, level - 1));
        }
        super.onTargetDamaged(user, target, level);
    }
}