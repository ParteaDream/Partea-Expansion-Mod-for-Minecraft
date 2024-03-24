package partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import partea.partea_expansion.potion.EffectDurance;

import java.util.Random;

public class EnchantClimbingThrill extends ClassRemembrance{
    public static Enchantment Climbing_Thrill = new EnchantClimbingThrill();
    protected EnchantClimbingThrill() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS,EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.FEET});
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
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (level > 0 && target instanceof LivingEntity T && user instanceof PlayerEntity player){
            Random random = new Random();
            if (T.hasStatusEffect(EffectDurance.EffectDurance) && random.nextFloat() < 0.04 + 0.02 * level){
                player.addExperience(3 + level);
            }
        }
    }
}
