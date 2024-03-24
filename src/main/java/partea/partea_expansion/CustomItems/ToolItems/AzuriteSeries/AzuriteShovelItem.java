package partea.partea_expansion.CustomItems.ToolItems.AzuriteSeries;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class AzuriteShovelItem extends ShovelItem {
    public AzuriteShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
