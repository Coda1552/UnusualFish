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

// some code that could be consolidated between these two loot mods...oh well, im lazy!
public class BuriedTreasureLootModifier extends LootModifier {

    public BuriedTreasureLootModifier(LootItemCondition[] condition) {
        super(condition);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() > 0.7F) {
            generatedLoot.add(new ItemStack(UFItems.MUSIC_DISC_SEAFOAM.get()));
        }
        return generatedLoot;
    }

    public static final Supplier<Codec<BuriedTreasureLootModifier>> CODEC = () -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, BuriedTreasureLootModifier::new));

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}