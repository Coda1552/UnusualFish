package codyhuh.unusualfishmod.common.block_entity;

import codyhuh.unusualfishmod.common.block.VoltDetectorBlock;
import codyhuh.unusualfishmod.common.entity.VoltAngler;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import codyhuh.unusualfishmod.core.registry.UFBlocks;
import net.minecraft.core.BlockPos;
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
        return anglersList;
    }

    public void addAnglerToList(VoltAngler obj) {
        anglersList.add(obj);
    }

    public void removeAnglersFromList() {
        for (VoltAngler angler : anglersList) {
            if (!currentList.contains(angler)) {
                currentList.remove(angler);
                anglersList = currentList;
            }
        }
    }

    /*
    1- 2 lists: old and current
    2- if an obj is on old and NOT on current, remove from old
    3- set old to current
     */

    // todo - fix block update not sending a redstone signal (maybe sync the currentList and ANGLERS blockstate property?)

    public static void serverTick(Level level, BlockPos pos, BlockState state, VoltDetectorBlockEntity voltDetector) {
        if (!anglersList.equals(currentList)) {
            currentList = anglersList;
        }

        nearDetector(level, pos, 2.5);

        voltDetector.removeAnglersFromList();

        if (state.is(UFBlocks.VOLT_DETECTOR.get())) {
            int anglers = currentList.size();

            level.setBlock(pos, state.setValue(VoltDetectorBlock.ANGLERS, anglers), 3);
        }

    }

    private static void nearDetector(Level level, BlockPos pos, double radius) {
        AABB aabb = new AABB(pos);
        anglersList = level.getEntitiesOfClass(VoltAngler.class, aabb.inflate(radius));

        BlockPos blockpos = new BlockPos(aabb.minX - radius, aabb.minY - radius, aabb.minZ - radius);
        BlockPos blockpos1 = new BlockPos(aabb.maxX + radius, aabb.maxY + radius, aabb.maxZ + radius);

        if (level.getBlockEntity(pos) instanceof VoltDetectorBlockEntity voltDetector && level.hasChunksAt(blockpos, blockpos1)) {
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            for(int i = blockpos.getX(); i <= blockpos1.getX(); ++i) {
                for(int j = blockpos.getY(); j <= blockpos1.getY(); ++j) {
                    for(int k = blockpos.getZ(); k <= blockpos1.getZ(); ++k) {
                        mutablePos.set(i, j, k);

                        int anglers = voltDetector.getAnglerList().size();

                        if (anglers < 5) {
                            for (VoltAngler angler : anglersList) {
                                if (!voltDetector.getAnglerList().contains(angler)) {
                                    voltDetector.addAnglerToList(angler);
                                    System.out.println(voltDetector.getAnglerList().size());
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
