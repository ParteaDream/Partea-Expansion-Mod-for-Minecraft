package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class EnchantCelestialAnnihilation extends ClassHunt{
    public static Enchantment Celestial_Annihilation = new EnchantCelestialAnnihilation();

    protected EnchantCelestialAnnihilation() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Random random = new Random();
        if (target instanceof LivingEntity && random.nextFloat() < 0.02 + 0.02 * level && level > 0){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, level));
        }
    }
}
