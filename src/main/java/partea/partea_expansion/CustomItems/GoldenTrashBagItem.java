package partea.partea_expansion.CustomItems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.util.randomCurioTools;

import java.util.List;
import java.util.Random;

public class GoldenTrashBagItem extends Item {
    public GoldenTrashBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.decrement(1);
        Random random = new Random();
        ItemEntity drop;
        float r = random.nextFloat();
        if (r > 0.4){
            drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(randomCurioTools.randomGoldenTrashbag(), 1));
        }else if (r < 0.2){
            drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(Items.BONE, random.nextInt(1,4)));
        }else{
            drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(Items.ROTTEN_FLESH, random.nextInt(1,4)));
        }
        user.getWorld().spawnEntity(drop);
        return super.use(world, user, hand);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.trash_bag.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
