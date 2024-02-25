package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantRise extends Enchantment {
    public static Enchantment RISE = new EnchantRise();
    public EnchantRise() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinPower(int level) { return 15; }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    public boolean isTreasure() {
        return true;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FLAME;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if((target instanceof LivingEntity)&&(user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.BOW)) {
            ((LivingEntity) target).addStatusEffect(
                    new StatusEffectInstance(StatusEffects.LEVITATION, 20 * level, level - 1, true, false));
        }
        super.onTargetDamaged(user, target, level);
    }
}
