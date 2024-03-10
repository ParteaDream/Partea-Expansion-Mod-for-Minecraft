package partea.partea_expansion.Enchantments.HonkaiStarRail.Destruction;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class EnchantAntimatterNoninverseEquation extends ClassDestruction {
    public static Enchantment Antimatter_Noninverse_Equation = new EnchantAntimatterNoninverseEquation();

    protected EnchantAntimatterNoninverseEquation() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }
    public boolean isTreasure(){
        return true;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity && ((LivingEntity) target).isUndead()) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,level*2 - 1,false,false,false));
            user.damage(user.getDamageSources().magic(),user.getMaxHealth() * (0.3f + 0.1f * level));
        }else if (target instanceof LivingEntity && !((LivingEntity) target).isUndead()){
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,1,level*2 - 1,false,false,false));
            user.damage(user.getDamageSources().magic(),user.getMaxHealth() * (0.3f + 0.1f * level));
        }
        super.onTargetDamaged(user, target, level);
    }
}
