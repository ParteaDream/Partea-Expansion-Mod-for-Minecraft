package partea.partea_expansion.Enchantments.HonkaiStarRail.Remenberance;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtTypes;
import partea.partea_expansion.potion.EffectDurance;
import partea.partea_expansion.util.FEUtil;

import java.util.Random;

public class EnchantIceAspect extends ClassRemembrance {
    public static Enchantment ICE_ASPECT = new EnchantIceAspect();
    protected EnchantIceAspect() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public boolean isTreasure() {
        return false;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        Random random = new Random();
        float extraChance = 0;
        if (FEUtil.hasEnchantment(user,EnchantTheTormentOfAlienation.TormentOfAlienation)){
            extraChance = FEUtil.getLevel(user, EnchantTheTormentOfAlienation.TormentOfAlienation);
        }
        if(target instanceof LivingEntity && random.nextFloat() < 0.04 + 0.03 * level + extraChance * 0.05) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(EffectDurance.EffectDurance, 20 * level + 20, 1, true, false));
        }
        super.onTargetDamaged(user, target, level);
    }
}
