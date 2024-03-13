package partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.ClassAbundance;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.ClassDestruction;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.ClassHunt;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.ClassNihilism;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance.ClassRemembrance;

public class ClassPreservation extends Enchantment {
    protected ClassPreservation(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other)
                && !(other instanceof ClassDestruction)
                && !(other instanceof ClassHunt)
                && !(other instanceof ClassNihilism)
                && !(other instanceof ClassAbundance)
                && !(other instanceof ClassRemembrance);
    }
}
