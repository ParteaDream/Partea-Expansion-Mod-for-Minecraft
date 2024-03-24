package partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import partea.partea_expansion.potion.EffectPre;

public class EnchantSuperstaticFixation extends ClassPreservation {
    public static Enchantment SuperstaticFixation = new EnchantSuperstaticFixation();

    protected EnchantSuperstaticFixation() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 18 + level * 10;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.hasStatusEffect(EffectPre.EffectPre)) {
            level++;
        }
        if(user.hasStatusEffect(StatusEffects.ABSORPTION)){
            attacker.damage(user.getDamageSources().magic(),user.getAbsorptionAmount() * (level * 0.3f + 0.5f));
        }
    }
}
