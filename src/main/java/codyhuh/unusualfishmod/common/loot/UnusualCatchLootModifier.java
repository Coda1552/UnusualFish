package codyhuh.unusualfishmod.common.loot;

import codyhuh.unusualfishmod.core.registry.UFEnchantments;
import codyhuh.unusualfishmod.core.registry.UFTags;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class UnusualCatchLootModifier extends LootModifier {

    public UnusualCatchLootModifier(LootItemCondition[] condition) {
        super(condition);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        var items = ForgeRegistries.ITEMS.tags().getTag(UFTags.RAW_UNUSUAL_FISH).stream().toList();
        int size = items.size();

        ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
        ItemStack stack = context.getParamOrNull(LootContextParams.TOOL);

        if (stack != null) {
            int i = EnchantmentHelper.getTagEnchantmentLevel(UFEnchantments.UNUSUAL_CATCH.get(), stack);

            if (stack.is(Tags.Items.TOOLS_FISHING_RODS) && i > 0) {
                ret.add(new ItemStack(items.get(context.getRandom().nextInt(size))));
            }
            else {
                ret = generatedLoot;
            }
        }
        return ret;
    }

    public static final Supplier<Codec<UnusualCatchLootModifier>> CODEC = () -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, UnusualCatchLootModifier::new));

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

}