package codyhuh.unusualfishmod.common.block_entity;

import codyhuh.unusualfishmod.common.entity.ambient.deep.VoltAngler;
import codyhuh.unusualfishmod.core.registry.UFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

// todo - fix
public class VoltDetectorBlockEntity extends BlockEntity {
    private static List<VoltAngler> list = new ArrayList<>(5);

    public VoltDetectorBlockEntity(BlockPos pos, BlockState state) {
        super(UFBlockEntities.VOLT_DETECTOR.get(), pos, state);
    }

    public final List<VoltAngler> getAnglerList() {
        return list;
    }

    public static void addAnglerToList(VoltAngler obj) {
        list.add(obj);
    }

    public static void removeAnglerFromList(VoltAngler obj) {
        list.remove(obj);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, VoltDetectorBlockEntity voltDetector) {
        if (list.size() < 6) {
            nearDetector(level, pos, 5);
        }
    }

    private static void nearDetector(Level level, BlockPos pos, int radius) {
        AABB boundingBox = new AABB(pos);
        list = level.getEntitiesOfClass(VoltAngler.class, boundingBox.inflate(radius));

        for (VoltAngler angler : list) {
            if (level.getBlockEntity(pos) instanceof VoltDetectorBlockEntity voltDetector && !voltDetector.getAnglerList().contains(angler)) {
                addAnglerToList(angler);
                System.out.println(voltDetector.getAnglerList().size());
            }
        }
    }
}
