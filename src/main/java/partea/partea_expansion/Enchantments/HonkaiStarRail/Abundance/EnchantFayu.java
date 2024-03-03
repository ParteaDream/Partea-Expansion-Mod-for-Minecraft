package partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.EnchantVigour;

public class EnchantFayu extends ClassAbundance{
    public static Enchantment Fayu = new EnchantFayu();

    protected EnchantFayu() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.LEGS,EquipmentSlot.FEET,EquipmentSlot.CHEST,EquipmentSlot.HEAD});
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
        return super.canAccept(other) && other != EnchantVigour.VIGOUR;
    }
}
