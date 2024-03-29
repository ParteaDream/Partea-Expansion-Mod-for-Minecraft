package partea.partea_expansion.Enchantments.WeaponEnch;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance.EnchantHannyaShip;
import partea.partea_expansion.sounds.ModSounds;

public class EnchantLifeSteal extends Enchantment {
    public static Enchantment LIFE_STEAL = new EnchantLifeSteal();
    public EnchantLifeSteal() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 15 + (10 * level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantHannyaShip.HannyaShip;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getWorld();
        if (!world.isClient()) {
            if (user.getHealth() < user.getMaxHealth() && (Math.random() < 0.05 + 0.05 * level) && target instanceof LivingEntity) {
                float targetHealth = ((LivingEntity) target).getHealth();
                if (targetHealth > 0) {
                    world.playSound(null, user.getBlockPos(), ModSounds.BLURP, SoundCategory.PLAYERS, 1.0f, 1f);
                    user.heal(2);
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
