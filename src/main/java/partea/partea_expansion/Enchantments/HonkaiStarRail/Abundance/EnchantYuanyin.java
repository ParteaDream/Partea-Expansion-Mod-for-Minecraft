package partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantYuanyin extends ClassAbundance{
    public static Enchantment Yuanyin = new EnchantYuanyin();

    protected EnchantYuanyin() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS,EquipmentSlot.FEET,EquipmentSlot.CHEST,EquipmentSlot.HEAD});
    }
    public int getMaxLevel() {
        return 2;
    }
    public boolean isTreasure(){
        return false;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
