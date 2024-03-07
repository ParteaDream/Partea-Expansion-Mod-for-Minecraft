package partea.partea_expansion.CustomItems.ToolItems;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class AzuriteHoeItem extends HoeItem {
    public AzuriteHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
