package partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import partea.partea_expansion.potion.EffectDurance;

import java.util.Random;

public class EnchantFuli extends ClassRemembrance{
    public static Enchantment Fuli = new EnchantFuli();
    protected EnchantFuli() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public boolean isTreasure() {
        return false;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Random random = new Random();
        if(target instanceof LivingEntity T && random.nextFloat() < 0.1 + 0.05 * level && ((LivingEntity) target).hasStatusEffect(EffectDurance.EffectDurance)) {
           T.setHealth(Math.max(0, ((LivingEntity) target).getHealth() - ((LivingEntity) target).getMaxHealth() * 0.3f));
           T.removeStatusEffect(EffectDurance.EffectDurance);
        }
        super.onTargetDamaged(user, target, level);
    }
}
