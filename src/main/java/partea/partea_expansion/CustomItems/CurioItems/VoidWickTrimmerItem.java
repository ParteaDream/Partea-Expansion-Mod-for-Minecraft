package partea.partea_expansion.CustomItems.CurioItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.CustomItems.CurioItems.Damaged.ClassDamaged;
import partea.partea_expansion.ModItems;

import java.util.List;

public class VoidWickTrimmerItem extends ClassCurioItem{
    public VoidWickTrimmerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.getEquippedStack(EquipmentSlot.MAINHAND).getItem() == ModItems.Void_Wick_Trimmer && user.getEquippedStack(EquipmentSlot.OFFHAND).getItem() instanceof ClassDamaged){
            ItemStack stack = user.getEquippedStack(EquipmentSlot.OFFHAND);
            Item newItem = getNewItem(stack);
            if (newItem != null){
                ItemEntity drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(newItem, 1));
                user.getWorld().spawnEntity(drop);
                itemStack.decrement(1);
                stack.decrement(1);
                return TypedActionResult.consume(itemStack);
            }
            return TypedActionResult.fail(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Nullable
    private static Item getNewItem(ItemStack stack) {
        Item newItem = null;
        if (stack.getItem() == ModItems.Damaged_Clock_Tricks){
            newItem = ModItems.Clock_Tricks;
        } else if (stack.getItem() == ModItems.Damaged_Galaxy_Lotto) {
            newItem = ModItems.Galaxy_Lotto;
        } else if (stack.getItem() == ModItems.Damaged_Interastra_Big_Lotto) {
            newItem = ModItems.Interastra_Big_Lotto;
        } else if (stack.getItem() == ModItems.Damaged_Laurel_Crown_Of_Planar_Shifts) {
            newItem = ModItems.Laurel_Crown_Of_Planar_Shifts;
        } else if (stack.getItem() == ModItems.Damaged_Totem_Of_Equilibrium) {
            newItem = ModItems.Totem_Of_Equilibrium;
        }
        return newItem;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.void_wick_trimmer.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
