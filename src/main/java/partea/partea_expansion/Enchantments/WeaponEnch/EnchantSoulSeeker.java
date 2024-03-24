package partea.partea_expansion.Enchantments.WeaponEnch;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

public class EnchantSoulSeeker extends Enchantment {
    public static Enchantment SOUL_SEEKER = new EnchantSoulSeeker();
    public EnchantSoulSeeker() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMinPower(int level) {
        return 12 + (level - 1) * 20;
    }

    public int getMaxPower(int level) {
        return 50;
    }

    public boolean isTreasure(){
        return true;
    }
    @Override
    public int getMaxLevel() { return 1; }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof BowItem || stack.getItem() instanceof CrossbowItem;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.QUICK_CHARGE;
    }
}
