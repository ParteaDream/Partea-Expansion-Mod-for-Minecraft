package partea.partea_expansion.CustomItems.CurioItems.Damaged;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;

import java.util.List;

public class DamagedTotemOfEquilibriumItem extends ClassDamaged{
    Item product = ModItems.Totem_Of_Equilibrium;
    public DamagedTotemOfEquilibriumItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.totem_of_equilibrium.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    public Item getProduct(){
        return product;
    }
}
