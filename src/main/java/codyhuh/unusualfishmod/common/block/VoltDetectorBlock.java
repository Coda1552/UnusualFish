package codyhuh.unusualfishmod.common.block;

import codyhuh.unusualfishmod.common.block_entity.VoltDetectorBlockEntity;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class VoltDetectorBlock extends BaseEntityBlock {
    public static final IntegerProperty ANGLERS = IntegerProperty.create("anglers", 0, 5);

    public VoltDetectorBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(ANGLERS, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(ANGLERS);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return UFBlockEntities.VOLT_DETECTOR.get().create(pos, state);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        this.updateNeighbours(level, pos);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> type) {
        return createTickerHelper(type, UFBlockEntities.VOLT_DETECTOR.get(), VoltDetectorBlockEntity::serverTick);
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState state1, boolean flag) {
        if (!flag && !state.is(state1.getBlock())) {
            BlockEntity tile = level.getBlockEntity(pos);

            if (tile instanceof VoltDetectorBlockEntity voltDetector && voltDetector.getAnglerList().size() > 0) {
                this.updateNeighbours(level, pos);
            }

            super.onRemove(state, level, pos, state1, flag);
        }
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public void updateNeighbours(Level level, BlockPos pos) {
        level.updateNeighborsAt(pos, this);
        for (Direction dir : Direction.values()) {
            level.updateNeighborsAt(pos.relative(dir), this);
        }
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction dir) {
        BlockEntity tile = level.getBlockEntity(pos);

        return tile instanceof VoltDetectorBlockEntity detector ? detector.getAnglerList().size() * 3 : 0;
    }
}
