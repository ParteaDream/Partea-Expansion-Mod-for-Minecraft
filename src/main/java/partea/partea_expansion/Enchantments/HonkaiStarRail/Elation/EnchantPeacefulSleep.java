package partea.partea_expansion.Enchantments.HonkaiStarRail.Elation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantPeacefulSleep extends ClassElation{
    public static Enchantment Peaceful_Sleep = new EnchantPeacefulSleep();

    protected EnchantPeacefulSleep() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
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
}
