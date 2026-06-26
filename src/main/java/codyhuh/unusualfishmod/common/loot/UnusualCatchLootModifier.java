package codyhuh.unusualfishmod.common.loot;

import codyhuh.unusualfishmod.core.registry.UFEnchantments;
import codyhuh.unusualfishmod.core.registry.UFTags;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UnusualCatchLootModifier extends LootModifier {

    public static final MapCodec<UnusualCatchLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, UnusualCatchLootModifier::new));

    public UnusualCatchLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        List<ItemStack> items = BuiltInRegistries.ITEM.getTag(UFTags.UNUSUAL_CATCH_ITEMS).map(holderSet -> holderSet.stream().map(ItemStack::new).toList()).orElse(List.of());

        if (items.isEmpty()) {
            return generatedLoot;
        }
        ItemStack stack = context.getParamOrNull(LootContextParams.TOOL);
        if (stack != null) {
            Holder.Reference<Enchantment> unusualCatch = context.getLevel().holderLookup(Registries.ENCHANTMENT).get(UFEnchantments.UNUSUAL_CATCH).orElse(null);
            if (unusualCatch != null) {
                int enchantmentLevel = EnchantmentHelper.getTagEnchantmentLevel(unusualCatch, stack);
                if (stack.is(Tags.Items.TOOLS_FISHING_ROD) && enchantmentLevel > 0) {
                    ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
                    ret.add(items.get(context.getRandom().nextInt(items.size())));
                    return ret;
                }
            }
        }

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}

