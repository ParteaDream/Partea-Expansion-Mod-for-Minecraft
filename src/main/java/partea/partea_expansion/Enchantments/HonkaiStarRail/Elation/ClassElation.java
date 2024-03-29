package partea.partea_expansion.Enchantments.HonkaiStarRail.Elation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.ClassAbundance;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.ClassDestruction;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.ClassHunt;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.ClassNihilism;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.ClassPreservation;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance.ClassRemembrance;

public class ClassElation extends Enchantment {
    protected ClassElation(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }
    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof ClassPreservation)
                && !(other instanceof ClassHunt)
                && !(other instanceof ClassNihilism)
                && !(other instanceof ClassDestruction)
                && !(other instanceof ClassRemembrance)
                && !(other instanceof ClassAbundance);
    }
}
