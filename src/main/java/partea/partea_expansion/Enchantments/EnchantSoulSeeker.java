package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantSoulSeeker extends Enchantment {
    public static Enchantment SOUL_SEEKER = new EnchantSoulSeeker();
    public EnchantSoulSeeker() {
        super(Rarity.VERY_RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMinPower(int level) {
        return 12 + (level - 1) * 20;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public boolean isTreasure(){
        return true;
    }
    @Override
    public int getMaxLevel() { return 1; }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
}
