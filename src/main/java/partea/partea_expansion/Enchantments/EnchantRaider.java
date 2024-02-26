package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

public class EnchantRaider extends Enchantment {
    public static Enchantment RAIDER = new EnchantRaider();

    public EnchantRaider() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 8;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getEntityWorld();
        if (target instanceof LivingEntity livingEntity) {
            if (livingEntity.getGroup() == EntityGroup.ILLAGER) {
                target.damage(world.getDamageSources().generic(), (float) level * 3F);
            }
        } else {
            super.onTargetDamaged(user, target, level);
        }
    }
    public boolean isTreasure(){
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
}
