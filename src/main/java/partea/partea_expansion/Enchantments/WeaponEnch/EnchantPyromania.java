package partea.partea_expansion.Enchantments.WeaponEnch;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantPyromania extends Enchantment {
    public static Enchantment PYRAMANIA = new EnchantPyromania();
    public EnchantPyromania() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.SHARPNESS && other != Enchantments.BANE_OF_ARTHROPODS
                && other != Enchantments.SMITE && other != EnchantRaider.RAIDER;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity && target.isOnFire() && ((LivingEntity) target).isUndead()) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,level - 1));
        }else if (target instanceof LivingEntity && target.isOnFire() && !((LivingEntity) target).isUndead()){
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,level - 1));
        }

        super.onTargetDamaged(user, target, level);
    }
}
