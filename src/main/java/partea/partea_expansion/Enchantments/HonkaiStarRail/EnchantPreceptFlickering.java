package partea.partea_expansion.Enchantments.HonkaiStarRail;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

import java.util.Map;

public class EnchantPreceptFlickering extends Enchantment {
    public static Enchantment PRECEPT_FLICKERING = new EnchantPreceptFlickering();
    protected EnchantPreceptFlickering() {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }
    public int getMaxLevel() {
        return 2;
    }
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = user.getRandom();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(EnchantHarmfulAfterglow.HARMFUL_AFTERGLOW, user);
        if (shouldDamageAttacker(level, random)&&(user.getHealth() <= user.getMaxHealth() * 0.3)) {
            if (level == 2){
                if(random.nextFloat() < 0.03f){
                    user.heal(user.getMaxHealth() * 0.3f);
                }else if(random.nextFloat() > 0.5f){
                    user.heal(user.getMaxHealth() * 0.15f);
                }else{
                    user.heal(user.getMaxHealth() * 0.1f);
                }
            }else if(level == 1){
                if(random.nextFloat() < 0.5f) {
                    user.heal(user.getMaxHealth() * 0.15f);
                }
            }


        }
    }
    public static boolean shouldDamageAttacker(int level, Random random) {
        if (level <= 0) {
            return false;
        } else {
            return random.nextFloat() < 0.25f;
        }
    }
}
