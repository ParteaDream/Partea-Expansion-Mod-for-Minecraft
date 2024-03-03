package partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.ClassAbundance;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.ClassDestruction;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.ClassHunt;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.ClassPreservation;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.EnchantFeedbackShelter;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantLifeSteal;

public class ClassNihilism extends Enchantment {
    protected ClassNihilism(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other)
                && !(other instanceof ClassDestruction)
                && !(other instanceof ClassPreservation)
                && !(other instanceof ClassHunt)
                && !(other instanceof ClassAbundance);
    }
}
