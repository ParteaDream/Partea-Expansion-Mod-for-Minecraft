package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SilverCoinOfDiscordItem extends ClassCurioItem {
    public SilverCoinOfDiscordItem(Settings settings) {
        super(settings);
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.silver_coin_of_discord.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
