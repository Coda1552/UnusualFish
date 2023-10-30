package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block_entity.VoltDetectorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UnusualFishMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<VoltDetectorBlockEntity>> VOLT_DETECTOR = BLOCK_ENTITIES.register("volt_detector", () -> BlockEntityType.Builder.of(VoltDetectorBlockEntity::new, UFBlocks.VOLT_DETECTOR.get()).build(null));
}