package partea.partea_expansion.Enchantments.HonkaiStarRail.Nihilism;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import partea.partea_expansion.potion.CustomPotionDoomedDeath;
import partea.partea_expansion.util.FEUtil;

import java.util.Random;

public class EnchantTheTwilightOfExistence extends ClassNihilism{
    public static Enchantment The_Twilight_Of_Existence = new EnchantTheTwilightOfExistence();

    protected EnchantTheTwilightOfExistence() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        LivingEntity T =(LivingEntity) target;
        Random random = new Random();
        int level2 = FEUtil.getLevelArmor(user,EnchantTheOneWhoIsEncasedInASleeve.The_One_Who_Is_Encased_In_A_Sleeve);
        if (level > 0 && random.nextFloat() < level * 0.5 + 0.5 && !(level2 > 0)){
            T.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1));
        }else if (level > 0 && random.nextFloat() < level * 0.5 + 0.5 && (level2 > 0)){
            T.removeStatusEffect(StatusEffects.POISON);
            T.addStatusEffect(new StatusEffectInstance(CustomPotionDoomedDeath.PotionDoomedDeath, 100, 3));
        }
    }
}
