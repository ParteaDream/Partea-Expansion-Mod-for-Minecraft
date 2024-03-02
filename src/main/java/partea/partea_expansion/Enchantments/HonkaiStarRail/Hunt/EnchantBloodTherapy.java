package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantLifeSteal;

public class EnchantBloodTherapy extends ClassHunt {
    public static Enchantment BLOOD_THERAPY = new EnchantBloodTherapy();

    protected EnchantBloodTherapy() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantLifeSteal.LIFE_STEAL;
    }
}
