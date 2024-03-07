package partea.partea_expansion.CustomItems.ToolItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class AzuriteSwordItem extends SwordItem {
    public AzuriteSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
