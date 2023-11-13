package codyhuh.unusualfishmod.common.block_entity;

import codyhuh.unusualfishmod.common.block.VoltDetectorBlock;
import codyhuh.unusualfishmod.common.entity.VoltAngler;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import codyhuh.unusualfishmod.core.registry.UFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public class VoltDetectorBlockEntity extends BlockEntity {
    private static List<VoltAngler> anglersList = new ArrayList<>(5);
    private static List<VoltAngler> currentList = new ArrayList<>(5);

    public VoltDetectorBlockEntity(BlockPos pos, BlockState state) {
        super(UFBlockEntities.VOLT_DETECTOR.get(), pos, state);
    }

    public final List<VoltAngler> getAnglerList() {
        return currentList;
    }

    public void addAnglerToList(VoltAngler obj) {
        currentList.add(obj);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, VoltDetectorBlockEntity voltDetector) {
        if (!anglersList.equals(currentList)) {
            currentList = anglersList;
        }

        double radius = 2.5D;

        for (Direction dir : Direction.values()) {
            if (level.getBlockState(pos.relative(dir)).is(UFBlocks.COPPER_ANTENNA.get())) {
                radius = 5.0D;
            }
        }

        nearDetector(level, pos, radius);

        System.out.println(radius);

        int anglers = currentList.size();

        if (level.hasChunksAt(pos, pos) && state.is(UFBlocks.VOLT_DETECTOR.get()) && !level.getBlockState(pos).isAir() && level.getBlockState(pos).getValue(VoltDetectorBlock.ANGLERS) != anglers) {
            level.setBlock(pos, state.setValue(VoltDetectorBlock.ANGLERS, anglers), 3);
            ((VoltDetectorBlock)state.getBlock()).updateNeighbours(level, pos);
        }

        if (anglers != 0) {
            System.out.println(anglers);
        }
    }

    private static void nearDetector(Level level, BlockPos pos, double radius) {
        AABB aabb = new AABB(pos);
        currentList = level.getEntitiesOfClass(VoltAngler.class, aabb.inflate(radius));

        BlockPos blockpos = new BlockPos(aabb.minX - radius, aabb.minY - radius, aabb.minZ - radius);
        BlockPos blockpos1 = new BlockPos(aabb.maxX + radius, aabb.maxY + radius, aabb.maxZ + radius);

        if (level.getBlockEntity(pos) instanceof VoltDetectorBlockEntity voltDetector && level.hasChunksAt(blockpos, blockpos1)) {
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for(int i = blockpos.getX(); i <= blockpos1.getX(); ++i) {
                for(int j = blockpos.getY(); j <= blockpos1.getY(); ++j) {
                    for(int k = blockpos.getZ(); k <= blockpos1.getZ(); ++k) {
                        mutablePos.set(i, j, k);

                        int anglers = currentList.size();

                        if (anglers < 5) {
                            for (VoltAngler angler : currentList) {
                                if (!currentList.contains(angler)) {
                                    voltDetector.addAnglerToList(angler);
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
