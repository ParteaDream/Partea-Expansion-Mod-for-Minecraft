package partea.partea_expansion.CustomBlocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import partea.partea_expansion.CustomBlocks.entity.ModBlockEntities;
import partea.partea_expansion.CustomBlocks.entity.QualitativeAnalyzerBlockEntity;

public class QualitativeAnalyzer extends BlockWithEntity implements BlockEntityProvider {

    public static final VoxelShape SHAPE = Block.createCuboidShape(0,0,0,16,16,16);

    public QualitativeAnalyzer(Settings settings){
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state){
        return BlockRenderType.MODEL;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        return SHAPE;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new QualitativeAnalyzerBlockEntity(pos, state);
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newstate, boolean moved){
        if(state.getBlock() != newstate.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof QualitativeAnalyzerBlockEntity){
                ItemScatterer.spawn(world,pos,(QualitativeAnalyzerBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state,world,pos,newstate,moved);
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = ((QualitativeAnalyzerBlockEntity) world.getBlockEntity(pos));

            if(screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return  ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.QUALITATIVE_ANALYZER_BLOCK_ENTITY,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
