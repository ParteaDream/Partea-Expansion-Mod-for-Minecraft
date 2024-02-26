package partea.partea_expansion.CustomItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import partea.partea_expansion.util.ModTags;

import java.util.List;

public class DiamondProspectorItem extends Item {
    public DiamondProspectorItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        if(!world.isClient()){
            BlockPos blockPos = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for(int i = -64; i <= blockPos.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(blockPos.down(i));
                if(isRightBlock(state)){
                    outputMessage(blockPos.down(i),player,state.getBlock());
                    foundBlock = true;
                }
            }
            if(!foundBlock){
                player.sendMessage(Text.translatable("item.partea_expansion.diamond_prospector.tooltip2"));
            }
        }
        context.getStack().damage(1,context.getPlayer()
                ,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        return ActionResult.SUCCESS;
    }
    private void outputMessage(BlockPos down, PlayerEntity player, Block block){
        player.sendMessage(Text.literal("Found" + block.asItem().getName().getString() + "at"
                + "(" + down.getX() + "," + down.getY() + "," + down.getZ() + ")!"), false);
    }
    private boolean isRightBlock(BlockState state){
        return state.isIn(ModTags.Blocks.DIAMOND_PROSPECTOR_LIST);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.partea_expansion.diamond_prospector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
