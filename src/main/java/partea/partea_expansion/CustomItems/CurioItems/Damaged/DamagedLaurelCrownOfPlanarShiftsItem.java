package partea.partea_expansion.CustomItems.CurioItems.Damaged;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;

import java.util.List;

public class DamagedLaurelCrownOfPlanarShiftsItem extends ClassDamaged{
    Item product = ModItems.Laurel_Crown_Of_Planar_Shifts;
    public DamagedLaurelCrownOfPlanarShiftsItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.laurel_crown_of_planar_shifts.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    public Item getProduct(){
        return product;
    }
}
