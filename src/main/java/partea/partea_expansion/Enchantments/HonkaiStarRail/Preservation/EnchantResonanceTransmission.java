package partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class EnchantResonanceTransmission extends ClassPreservation {
    public static Enchantment ResonanceTransmission = new EnchantResonanceTransmission();

    protected EnchantResonanceTransmission() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 18 + level * 10;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        LivingEntity T = (LivingEntity) target;
        if(user.hasStatusEffect(StatusEffects.ABSORPTION)){
            T.setHealth(T.getHealth() - user.getAbsorptionAmount() * (0.25f + 0.25f * level));
        }
    }
}
