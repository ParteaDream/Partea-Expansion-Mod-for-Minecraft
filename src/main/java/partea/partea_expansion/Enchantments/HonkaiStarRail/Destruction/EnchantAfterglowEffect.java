package partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantAfterglowEffect extends ClassDestruction {
    public static Enchantment Afterglow_Effect = new EnchantAfterglowEffect();

    protected EnchantAfterglowEffect() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }
    public int getMaxLevel() {
        return 2;
    }
    public boolean isTreasure(){
        return true;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
