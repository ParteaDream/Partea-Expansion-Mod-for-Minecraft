package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.ClassAbundance;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction.ClassDestruction;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism.ClassNihilism;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.ClassPreservation;

public class ClassHunt extends Enchantment {
    protected ClassHunt(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other)
                && !(other instanceof ClassDestruction)
                && !(other instanceof ClassPreservation)
                && !(other instanceof ClassNihilism)
                && !(other instanceof ClassAbundance);
    }
}
