package partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class EnchantMerciful extends ClassAbundance {
    public static Enchantment Merciful = new EnchantMerciful();

    protected EnchantMerciful() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.LEGS, EquipmentSlot.FEET, EquipmentSlot.CHEST, EquipmentSlot.HEAD});
    }

    public int getMaxLevel() {
        return 2;
    }

    public boolean isTreasure() {
        return false;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        LivingEntity T = (LivingEntity) target;
        if(level > 0){
            T.setHealth(T.getHealth() - user.getHealth() * (0.1f + 0.2f * level));
        }
    }
}