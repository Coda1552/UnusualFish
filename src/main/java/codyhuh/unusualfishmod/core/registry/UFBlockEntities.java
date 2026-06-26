package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import codyhuh.unusualfishmod.common.block_entity.SeaBoomBlockEntity;
import codyhuh.unusualfishmod.common.block_entity.VoltDetectorBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UnusualFishMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VoltDetectorBlockEntity>> VOLT_DETECTOR = BLOCK_ENTITIES.register("volt_detector", () -> BlockEntityType.Builder.of(VoltDetectorBlockEntity::new, UFBlocks.VOLT_DETECTOR.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SeaBoomBlockEntity>> SEA_BOOM = BLOCK_ENTITIES.register("sea_boom", () -> BlockEntityType.Builder.of(SeaBoomBlockEntity::new, UFBlocks.SEA_BOOM.get()).build(null));
}