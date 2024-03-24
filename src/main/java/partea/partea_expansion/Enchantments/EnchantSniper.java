package partea.partea_expansion.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;

public class EnchantSniper extends Enchantment {
    public static Enchantment Sniper = new EnchantSniper();
    public EnchantSniper() {
        super(Rarity.UNCOMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 15 + level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof CrossbowItem || stack.getItem() instanceof BowItem;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity T){
            double x1 = user.getPos().getX();
            double y1 = user.getPos().getY();
            double z1 = user.getPos().getZ();
            double x2 = target.getPos().getX();
            double y2 = target.getPos().getY();
            double z2 = target.getPos().getZ();
            double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
            if (d >= 30){
                T.setHealth(T.getHealth() - 8 * ((float)Math.min(50, d) - 30)/20);
            }
        }
    }
}
