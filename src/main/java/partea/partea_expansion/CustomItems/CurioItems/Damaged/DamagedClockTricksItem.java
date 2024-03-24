package partea.partea_expansion.CustomItems.CurioItems.Damaged;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;

import java.util.List;

public class DamagedClockTricksItem extends ClassDamaged{
    Item product = ModItems.Clock_Tricks;
    public DamagedClockTricksItem(Settings settings) {
        super(settings);
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.clock_tricks.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    public Item getProduct(){
        return product;
    }
}

