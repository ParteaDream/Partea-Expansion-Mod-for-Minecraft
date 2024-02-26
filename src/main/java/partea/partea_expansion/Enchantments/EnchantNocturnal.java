package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantNocturnal extends Enchantment {
    public static Enchantment NOCTURNAL = new EnchantNocturnal();
    public EnchantNocturnal() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[] {EquipmentSlot.HEAD});
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getEntityWorld().isNight() && user.hasStatusEffect(StatusEffects.INVISIBILITY)) {
            user.removeStatusEffect(StatusEffects.INVISIBILITY);
        }
    }
}
