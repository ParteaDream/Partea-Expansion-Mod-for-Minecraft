package partea.partea_expansion.Enchantments.HonkaiStarRail.Abundance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import partea.partea_expansion.Enchantments.WeaponEnch.EnchantLifeSteal;
import partea.partea_expansion.potion.EffectAbu;
import partea.partea_expansion.sounds.ModSounds;

public class EnchantHannyaShip extends ClassAbundance{
    public static Enchantment HannyaShip = new EnchantHannyaShip();

    protected EnchantHannyaShip() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }
    public boolean isTreasure(){
        return false;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != EnchantLifeSteal.LIFE_STEAL;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getWorld();
        if (user.hasStatusEffect(EffectAbu.EffectAbu)){
            level ++;
        }
        if (!world.isClient()) {
            if (user.getHealth() < user.getMaxHealth() && (Math.random() < 0.15) && target instanceof LivingEntity) {
                world.playSound(null, user.getBlockPos(), ModSounds.BLURP, SoundCategory.PLAYERS, 1.0f, 1f);
                user.heal(user.getMaxHealth() * (0.04f + level * 0.02f));
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
