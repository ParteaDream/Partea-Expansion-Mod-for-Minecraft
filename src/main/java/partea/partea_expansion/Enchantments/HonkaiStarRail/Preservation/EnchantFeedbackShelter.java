package partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class EnchantFeedbackShelter extends ClassPreservation{
    public static Enchantment Feedback_Shelter = new EnchantFeedbackShelter();

    protected EnchantFeedbackShelter() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
