package codyhuh.unusualfishmod.common.block;

import codyhuh.unusualfishmod.common.block_entity.VoltDetectorBlockEntity;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class VoltDetectorBlock extends BaseEntityBlock {

    public VoltDetectorBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public boolean isSignalSource(BlockState p_60571_) {
        return true;
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction dir) {
        if (level.getBlockEntity(pos) instanceof VoltDetectorBlockEntity voltDetector && !voltDetector.getAnglerList().isEmpty()) {
            return Math.min(voltDetector.getAnglerList().size() * 3, 15);
        }
        else {
            return 0;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return UFBlockEntities.VOLT_DETECTOR.get().create(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153213_, BlockEntityType<T> type) {
        return createTickerHelper(type, UFBlockEntities.VOLT_DETECTOR.get(), VoltDetectorBlockEntity::serverTick);
    }
}
