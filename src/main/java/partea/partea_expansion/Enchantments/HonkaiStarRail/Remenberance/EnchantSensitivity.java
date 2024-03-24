package partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantSensitivity extends ClassRemembrance{
    public static Enchantment Sensitivity = new EnchantTheTormentOfAlienation();
    protected EnchantSensitivity() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public boolean isTreasure() {
        return false;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

}
