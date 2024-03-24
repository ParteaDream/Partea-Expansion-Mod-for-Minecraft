package partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantFuneralRitesForSensualWorshippers extends ClassNihilism{
    public static Enchantment Funeral_Rites_For_Sensual_Worshippers = new EnchantFuneralRitesForSensualWorshippers();

    protected EnchantFuneralRitesForSensualWorshippers() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
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
        if (level > 0 && target instanceof LivingEntity T){
            T.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 100 * level, level - 1));
        }
    }
}
