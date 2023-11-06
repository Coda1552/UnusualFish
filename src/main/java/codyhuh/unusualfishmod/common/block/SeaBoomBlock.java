package codyhuh.unusualfishmod.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class SeaBoomBlock extends Block {
    public static final BooleanProperty LOADED = BooleanProperty.create("loaded");

    public SeaBoomBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LOADED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(LOADED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!state.getValue(LOADED) && rand.nextBoolean()) {
            level.setBlock(pos, state.setValue(LOADED, true), 3);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        for (Direction dir : Direction.values()) {
            if (context.getLevel().getBlockState(context.getClickedPos().relative(dir)).getFluidState().is(FluidTags.WATER)) {
                return this.defaultBlockState().setValue(LOADED, true);
            }
        }
        return this.defaultBlockState();
    }
}
