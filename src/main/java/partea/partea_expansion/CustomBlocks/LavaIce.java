package partea.partea_expansion.CustomBlocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LavaIce extends TranslucentBlock {
    public static final MapCodec<LavaIce> CODEC = createCodec(LavaIce::new);

    public MapCodec<? extends LavaIce> getCodec() {
        return CODEC;
    }
    public LavaIce(AbstractBlock.Settings settings) {
        super(settings);
    }
    public static BlockState getMeltedState() {
        return Blocks.LAVA.getDefaultState();
    }

    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.blocksMovement() || blockState.isLiquid()) {
            world.setBlockState(pos, getMeltedState());
        }
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) >= 0) {
            this.melt(state, world, pos);
        }
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, getMeltedState());
        world.updateNeighbor(pos, getMeltedState().getBlock(), pos);
    }
}
