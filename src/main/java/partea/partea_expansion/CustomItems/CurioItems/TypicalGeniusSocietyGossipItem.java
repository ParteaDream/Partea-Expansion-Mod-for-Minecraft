package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TypicalGeniusSocietyGossipItem extends ClassCurioItem {
    public TypicalGeniusSocietyGossipItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.typical_genius_society_gossip.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
