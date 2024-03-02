package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantRainbowChiseledTeeth extends ClassHunt {
    public static Enchantment Rainbow_Chiseled_Teeth = new EnchantRainbowChiseledTeeth();

    protected EnchantRainbowChiseledTeeth() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
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
