package partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantCryOfTheWilderness extends ClassNihilism{
    public static Enchantment Cry_Of_The_Wilderness = new EnchantCryOfTheWilderness();

    protected EnchantCryOfTheWilderness() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
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
        if (level > 0 && target instanceof LivingEntity){
            T.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, level - 1));
            T.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE,300,2 * level - 2));
        }
    }
}
