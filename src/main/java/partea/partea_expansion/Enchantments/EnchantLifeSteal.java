package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import partea.partea_expansion.sounds.ModSounds;

public class EnchantLifeSteal extends Enchantment {
    public static Enchantment LIFE_STEAL = new EnchantLifeSteal();
    public EnchantLifeSteal() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (7 * level);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getWorld();
        if (!world.isClient()) {
            if (user.getHealth() < user.getMaxHealth() && (Math.random() < 0.10 + (level * 0.05)) && target instanceof LivingEntity) {
                float targetHealth = ((LivingEntity) target).getHealth();
                if (targetHealth > 0) {
                    world.playSound(null, user.getBlockPos(), ModSounds.BLURP, SoundCategory.PLAYERS, 1.0f, 1f);
                    user.heal(user.getMaxHealth() * 0.2f);
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
