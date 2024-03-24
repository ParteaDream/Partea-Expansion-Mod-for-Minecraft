package partea.partea_expansion.CustomItems.ToolItems.AzuriteSeries;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class AzuritePickaxeItem extends PickaxeItem {
    public AzuritePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
