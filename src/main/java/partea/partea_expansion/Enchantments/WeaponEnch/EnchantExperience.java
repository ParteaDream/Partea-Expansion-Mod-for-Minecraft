package partea.partea_expansion.Enchantments.WeaponEnch;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantExperience extends Enchantment {
    public static Enchantment EXPERIENCE = new EnchantExperience();
    public EnchantExperience() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 15 + 5 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
