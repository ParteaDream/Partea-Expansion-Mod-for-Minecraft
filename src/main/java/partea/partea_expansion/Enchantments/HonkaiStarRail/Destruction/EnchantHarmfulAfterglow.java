package partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

import java.util.Map;

public class EnchantHarmfulAfterglow extends ClassDestruction {
    public static Enchantment HARMFUL_AFTERGLOW = new EnchantHarmfulAfterglow();
    protected EnchantHarmfulAfterglow() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }
    public int getMaxLevel() {
        return 2;
    }
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = user.getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW, user);
        if (shouldDamageAttacker1(level, random) && user.getStatusEffect(StatusEffects.ABSORPTION) == null && user.getHealth() >= 0.5f * user.getMaxHealth()) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0));
        }else if(shouldDamageAttacker2(level, random) && user.getStatusEffect(StatusEffects.ABSORPTION) == null && user.getHealth() < 0.5f * user.getMaxHealth()){
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 0));
        }
    }
    public static boolean shouldDamageAttacker1(int level, Random random) {
        if (level <= 0) {
            return false;
        } else {
            return random.nextFloat() < 0.2F + 0.05F * (float)level;
        }
    }
    public static boolean shouldDamageAttacker2(int level, Random random) {
        if (level <= 0) {
            return false;
        } else {
            return random.nextFloat() < 0.05F * (float)level;
        }
    }
}
