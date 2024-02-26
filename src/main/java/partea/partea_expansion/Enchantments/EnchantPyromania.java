package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

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
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity && target.isOnFire()) {
            target.damage(user.getDamageSources().mobAttack(user), level*4 + 2);
        }

        super.onTargetDamaged(user, target, level);
    }
}
