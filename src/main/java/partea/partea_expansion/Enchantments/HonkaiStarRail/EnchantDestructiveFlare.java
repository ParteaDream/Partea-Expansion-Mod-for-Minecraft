package partea.partea_expansion.Enchantments.HonkaiStarRail;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantDestructiveFlare extends Enchantment {
    public static Enchantment DESTRUCTIVE_FLARE = new EnchantDestructiveFlare();
    protected EnchantDestructiveFlare() {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }
    public int getMaxLevel() {
        return 2;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {
        if (user.getHealth() <= user.getMaxHealth() * 0.5){
            if (user.getHealth() <= user.getMaxHealth() * 0.3 && level > 1){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60, 1));
            }else{
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80, 0));
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
