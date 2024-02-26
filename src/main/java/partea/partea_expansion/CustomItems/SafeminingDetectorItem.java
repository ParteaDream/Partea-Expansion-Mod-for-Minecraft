package partea.partea_expansion.CustomItems;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SafeminingDetectorItem extends Item{
    public SafeminingDetectorItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        if(!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for(int i = blockPos.getY() + 64; i >= 0; i--){
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if(isWrongBlock(state)){
                    outputMessage(player);
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.translatable("item.partea_expansion.safemining_detector.tooltip2"));
            }
        }
        context.getStack().damage(1,context.getPlayer()
                ,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }
    private void outputMessage(PlayerEntity player){
        player.sendMessage(Text.translatable("item.partea_expansion.safemining_detector.tooltip3"), false);
    }
    private boolean isWrongBlock(BlockState state){
        return state.isOf(Blocks.AIR) || state.isOf(Blocks.LAVA);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.safemining_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
