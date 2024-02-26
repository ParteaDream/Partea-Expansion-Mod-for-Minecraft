package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantDualLeap extends Enchantment {
    public static Enchantment DUAKLEAP = new EnchantDualLeap();
    public EnchantDualLeap() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return (20 * level);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    public boolean isTreasure(){
        return true;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
