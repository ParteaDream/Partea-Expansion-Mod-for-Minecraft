package partea.partea_expansion.CustomItems.CurioItems.Damaged;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;

import java.util.List;

public class DamagedInterastraBigLottoItem extends ClassDamaged{
    Item product = ModItems.Interastra_Big_Lotto;
    public DamagedInterastraBigLottoItem(Settings settings) {
        super(settings);

    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.interastra_big_lotto.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    public Item getProduct(){
        return product;
    }
}
