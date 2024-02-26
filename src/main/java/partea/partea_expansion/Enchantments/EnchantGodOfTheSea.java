package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantGodOfTheSea extends Enchantment {
    public static Enchantment GOD_OF_THE_SEA = new EnchantGodOfTheSea();
    public EnchantGodOfTheSea() {
        super(Rarity.VERY_RARE, EnchantmentTarget.TRIDENT, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinPower(int level) { return 10; }

    @Override
    public boolean isTreasure() { return true; }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
