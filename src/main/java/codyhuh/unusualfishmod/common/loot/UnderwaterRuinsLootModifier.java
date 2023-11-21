package codyhuh.unusualfishmod.common.loot;

import codyhuh.unusualfishmod.core.registry.UFItems;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class UnderwaterRuinsLootModifier extends LootModifier {

    public UnderwaterRuinsLootModifier(LootItemCondition[] condition) {
        super(condition);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() > 0.8F) {
            generatedLoot.add(new ItemStack(UFItems.WEAPON_PARTS.get()));
        }
        return generatedLoot;
    }

    public static final Supplier<Codec<UnderwaterRuinsLootModifier>> CODEC = () -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, UnderwaterRuinsLootModifier::new));

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}