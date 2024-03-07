package partea.partea_expansion.Enchantments.HonkaiStarRail.Hunt;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import partea.partea_expansion.ModItems;

public class EnchantCelestialSnipe extends Enchantment {
    public static Enchantment Celestial_Snipe = new EnchantCelestialSnipe();

    protected EnchantCelestialSnipe() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }
    public int getMaxLevel() {
        return 2;
    }

    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity && (user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == Items.BOW
                || user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.AZURITE_BOW) && level > 0){
            ((LivingEntity) target).setHealth(((LivingEntity) target).getHealth() - 3 * level);
        }
    }
}
