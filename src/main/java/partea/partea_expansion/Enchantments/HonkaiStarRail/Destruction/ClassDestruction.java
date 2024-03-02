package partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt.ClassHunt;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation.ClassPreservation;

public class ClassDestruction extends Enchantment {
    protected ClassDestruction(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && !(other instanceof ClassPreservation)
                && !(other instanceof ClassHunt);
    }
}
