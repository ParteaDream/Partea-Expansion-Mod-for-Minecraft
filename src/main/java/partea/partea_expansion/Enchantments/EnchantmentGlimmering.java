package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

public class EnchantmentGlimmering extends Enchantment{
    public static Enchantment GLIMMERING = new EnchantmentGlimmering();
    public EnchantmentGlimmering() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.FEET,EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS});
    }

    @Override
    public int getMinPower(int level) { return 5; }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canAccept (Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FROST_WALKER;
    }
    public boolean isTreasure() {
        return true;
    }
}
