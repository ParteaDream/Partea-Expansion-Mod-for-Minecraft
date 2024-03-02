package partea.partea_expansion.CustomBlocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class CustomDoomedDeathFlameBlock extends AbstractFireBlock {
    public static final MapCodec<CustomDoomedDeathFlameBlock> CODEC = createCodec(CustomDoomedDeathFlameBlock::new);

    public MapCodec<CustomDoomedDeathFlameBlock> getCodec() {
        return CODEC;
    }
    public CustomDoomedDeathFlameBlock(Settings settings) {
        super(settings, 0);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
