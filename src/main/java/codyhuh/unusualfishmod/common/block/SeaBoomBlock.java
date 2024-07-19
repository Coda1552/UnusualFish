package codyhuh.unusualfishmod.common.block;

import codyhuh.unusualfishmod.common.block_entity.SeaBoomBlockEntity;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import codyhuh.unusualfishmod.core.registry.UFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SeaBoomBlock extends BaseEntityBlock {
    public static final BooleanProperty LOADED = BooleanProperty.create("loaded");
    public static final BooleanProperty HOSTILE_ONLY = BooleanProperty.create("hostile_only");

    public SeaBoomBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(LOADED, false).setValue(HOSTILE_ONLY, false));
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return UFBlockEntities.SEA_BOOM.get().create(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult p_60508_) {
        if (player.getItemInHand(hand).is(UFItems.RAW_DUALITY_DAMSELFISH.get())) {
            level.setBlock(pos, state.setValue(LOADED, state.getValue(LOADED)).setValue(HOSTILE_ONLY, !state.getValue(HOSTILE_ONLY)), 3);
            if (!player.getAbilities().instabuild) {
                player.getItemInHand(hand).shrink(1);
            }
            player.swing(hand);
            level.playSound(null, pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.BLOCKS, 0.5F, 2.0F);
        }

        return super.use(state, level, pos, player, hand, p_60508_);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> type) {
        return createTickerHelper(type, UFBlockEntities.SEA_BOOM.get(), SeaBoomBlockEntity::serverTick);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(LOADED).add(HOSTILE_ONLY);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        if (!state.getValue(LOADED) && rand.nextBoolean()) {
            for (Direction dir : Direction.Plane.HORIZONTAL) {
                if (level.getFluidState(pos.relative(dir)).is(FluidTags.WATER)) {
                    level.setBlock(pos, state.setValue(LOADED, true).setValue(HOSTILE_ONLY, state.getValue(HOSTILE_ONLY)), 3);
                }
            }
        }
    }
}
