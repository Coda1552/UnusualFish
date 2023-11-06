package codyhuh.unusualfishmod.common.block;

import codyhuh.unusualfishmod.common.entity.util.AgeableWaterAnimal;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FrogspawnBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class SquidEggsBlock extends FrogspawnBlock implements SimpleWaterloggedBlock {
    private final Supplier<EntityType<? extends AgeableWaterAnimal>> entityType;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape UP_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    protected static final VoxelShape DOWN_AABB = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(0, 0, 0, 16, 16, 6);
    protected static final VoxelShape NORTH_AABB = Block.box(0, 0, 10, 16, 16, 16);
    protected static final VoxelShape EAST_AABB = Block.box(0, 0, 0, 6, 16, 16);
    protected static final VoxelShape WEST_AABB = Block.box(10, 0, 0, 16, 16, 16);


    public SquidEggsBlock(Supplier<EntityType<? extends AgeableWaterAnimal>> tadpole, Properties p_221177_) {
        super(p_221177_);
        entityType = tadpole;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(WATERLOGGED, true));
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
        return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, true);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53105_) {
        p_53105_.add(FACING).add(WATERLOGGED);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())).isCollisionShapeFullBlock(level, pos) && level.getFluidState(pos).is(FluidTags.WATER);
    }

    public void spawnTadpoles(ServerLevel p_221221_, BlockPos p_221222_, RandomSource p_221223_) {
        int i = p_221223_.nextInt(2, 6);

        for(int j = 1; j <= i; ++j) {
            AgeableWaterAnimal squid = entityType.get().create(p_221221_);
            double d0 = (double)p_221222_.getX() + this.getRandomTadpolePositionOffset(p_221223_);
            double d1 = (double)p_221222_.getZ() + this.getRandomTadpolePositionOffset(p_221223_);
            int k = p_221223_.nextInt(1, 361);
            squid.moveTo(d0, (double)p_221222_.getY() - 0.5D, d1, (float)k, 0.0F);
            squid.setPersistenceRequired();
            p_221221_.addFreshEntity(squid);
        }
    }

    private double getRandomTadpolePositionOffset(RandomSource p_221225_) {
        double d0 = 0.125D;
        return Mth.clamp(p_221225_.nextDouble(), d0, 1.0D - d0);
    }
}
