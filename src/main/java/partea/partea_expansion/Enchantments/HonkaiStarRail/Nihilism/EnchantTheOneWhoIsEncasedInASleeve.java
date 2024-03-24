package partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class EnchantTheOneWhoIsEncasedInASleeve extends ClassNihilism{
    public static Enchantment The_One_Who_Is_Encased_In_A_Sleeve = new EnchantTheOneWhoIsEncasedInASleeve();

    protected EnchantTheOneWhoIsEncasedInASleeve() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 20 + level * 10;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity T && level > 0 && user instanceof PlayerEntity player){
            if (player.experienceLevel > 5){
                player.addExperience(-10);
                T.setHealth(T.getHealth() - T.getMaxHealth() * 0.02f * level);
            }
        }
    }
}
