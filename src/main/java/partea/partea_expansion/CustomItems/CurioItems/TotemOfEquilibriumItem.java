package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TotemOfEquilibriumItem extends ClassCurioItem {
    public TotemOfEquilibriumItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.totem_of_equilibrium.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
