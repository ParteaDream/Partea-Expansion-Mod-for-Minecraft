package partea.partea_expansion.CustomItems;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import partea.partea_expansion.util.randomCurioTools;

public class CurioTreasureBagItem extends Item {

    public CurioTreasureBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.decrement(1);
        ItemEntity drop = new ItemEntity(user.getWorld(), user.getX(), user.getY(), user.getZ(), new ItemStack(randomCurioTools.randomCurio(), 1));
        user.getWorld().spawnEntity(drop);
        return TypedActionResult.success(itemStack);
    }
}
