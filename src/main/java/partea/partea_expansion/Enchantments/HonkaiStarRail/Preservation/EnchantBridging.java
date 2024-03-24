package partea.partea_expansion.Enchantments.HonkaiStarRail.Preservation;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import partea.partea_expansion.potion.EffectPre;

import java.util.Map;
import java.util.Random;

public class EnchantBridging extends ClassPreservation {
    public static Enchantment CONSTRUSTION_BRIDGING = new EnchantBridging();

    protected EnchantBridging() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET});
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

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        Random random = new Random();
        Map.Entry<EquipmentSlot, ItemStack> entry = EnchantmentHelper.chooseEquipmentWith(EnchantBridging.CONSTRUSTION_BRIDGING, user);
        if(random.nextFloat() < 0.5){
            if (entry != null) {
                if (user.hasStatusEffect(EffectPre.EffectPre)){
                    level ++;
                }
                entry.getValue().setDamage(entry.getValue().getDamage() - level * 2);
            }
        }
    }
}
