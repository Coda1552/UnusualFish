package codyhuh.unusualfishmod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CopperAntennaBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape UP_AABB = Shapes.join(Block.box(7, 0, 7, 9, 6, 9), Block.box(2, 6, 2, 14, 8, 14), BooleanOp.OR);
    protected static final VoxelShape DOWN_AABB = Shapes.join(Block.box(7, 10, 7, 9, 16, 9), Block.box(2, 8, 2, 14, 10, 14), BooleanOp.OR);
    protected static final VoxelShape SOUTH_AABB = Shapes.join(Block.box(7, 7, 0, 9, 9, 6), Block.box(2, 2, 6, 14, 14, 8), BooleanOp.OR);
    protected static final VoxelShape NORTH_AABB = Shapes.join(Block.box(7, 7, 10, 9, 9, 16), Block.box(2, 2, 8, 14, 14, 10), BooleanOp.OR);
    protected static final VoxelShape EAST_AABB = Shapes.join(Block.box(0, 7, 7, 6, 9, 9), Block.box(6, 2, 2, 8, 14, 14), BooleanOp.OR);
    protected static final VoxelShape WEST_AABB = Shapes.join(Block.box(10, 7, 7, 16, 9, 9), Block.box(8, 2, 2, 10, 14, 14), BooleanOp.OR);

    public CopperAntennaBlock(Properties p_221177_) {
        super(p_221177_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, false));
    }

    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        switch (p_154346_.getValue(FACING)) {
            case UP:
            default:
                return UP_AABB;
            case DOWN:
                return DOWN_AABB;
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
                return NORTH_AABB;
        }
    }

    public FluidState getFluidState(BlockState p_153759_) {
        return p_153759_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_153759_);
    }

    public BlockState getStateForPlacement(BlockPlaceContext p_53087_) {
        Direction direction = p_53087_.getClickedFace();
        FluidState fluidstate = p_53087_.getLevel().getFluidState(p_53087_.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;

        return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, flag);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53105_) {
        p_53105_.add(FACING).add(WATERLOGGED);
    }
}
