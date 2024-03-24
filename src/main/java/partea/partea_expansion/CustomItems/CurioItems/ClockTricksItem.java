package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.tick.TickManager;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.ModItems;

import java.util.List;

public class ClockTricksItem extends ClassCurioItem{

    public ClockTricksItem(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.clock_tricks.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        TickManager tickManager = world.getTickManager();
        if (tickManager.isFrozen() || tickManager.getTickRate() > 20){
            if (tickManager.getTickRate() > 20) {
                tickManager.setTickRate(20);
                user.getItemCooldownManager().set(this, 200);
                itemStack.setDamage(itemStack.getDamage() + 1);
                if (itemStack.getDamage() == itemStack.getMaxDamage()){
                    itemStack.decrement(1);
                    ItemEntity dropCoins = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.Damaged_Clock_Tricks, 1));
                    user.getWorld().spawnEntity(dropCoins);
                }
            }
            if (tickManager.isFrozen()){
                user.getItemCooldownManager().set(this, 100);
                tickManager.setFrozen(false);
                itemStack.setDamage(itemStack.getDamage() + 1);
                if (itemStack.getDamage() == itemStack.getMaxDamage()){
                    itemStack.decrement(1);
                    ItemEntity dropCoins = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(ModItems.Damaged_Clock_Tricks, 1));
                    user.getWorld().spawnEntity(dropCoins);
                }
            }
        }else{
            if (user.isSneaking()){
                tickManager.setTickRate(600);
            }else {
                tickManager.setFrozen(true);
            }
        }
        return TypedActionResult.success(itemStack);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
