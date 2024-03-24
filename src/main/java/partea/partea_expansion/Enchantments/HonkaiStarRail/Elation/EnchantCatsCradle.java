package partea.partea_expansion.Enchantments.HonkaiStarRail.Elation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import partea.partea_expansion.potion.EffectAftertaste;

import java.util.Random;

public class EnchantCatsCradle extends ClassElation{
    public static Enchantment Cats_Cradle = new EnchantCatsCradle();

    protected EnchantCatsCradle() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
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
        if (level > 0 && target instanceof LivingEntity T && T.hasStatusEffect(EffectAftertaste.EffectAftertaste)){
            T.setHealth(T.getHealth() - random.nextFloat() * 18 * (0.75f + 0.25f * level));
        }
    }
}
