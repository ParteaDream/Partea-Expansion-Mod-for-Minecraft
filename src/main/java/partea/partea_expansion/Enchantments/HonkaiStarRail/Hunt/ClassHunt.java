package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.ClassDestruction;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.ClassPreservation;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantLifeSteal;

public class ClassHunt extends Enchantment {
    protected ClassHunt(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantLifeSteal.LIFE_STEAL
                && !(other instanceof ClassDestruction)
                && !(other instanceof ClassPreservation);
    }
}
