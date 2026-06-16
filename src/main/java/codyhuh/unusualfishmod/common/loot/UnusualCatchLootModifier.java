package codyhuh.unusualfishmod.common.loot;

import codyhuh.unusualfishmod.core.registry.UFEnchantments;
import codyhuh.unusualfishmod.core.registry.UFTags;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class UnusualCatchLootModifier extends LootModifier {

    public UnusualCatchLootModifier(LootItemCondition[] condition) {
        super(condition);
    }

    // TODO: Chakyl test this
    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
//        var tagOptional = BuiltInRegistries.ITEM.getOrCreateTag(UFTags.UNUSUAL_CATCH_ITEMS);
//        var items = tagOptional.stream().map(Holder::value).toList();
//        int size = items.size();
//
//        ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
//        ItemStack stack = context.getParamOrNull(LootContextParams.TOOL);
//
//        if (stack != null) {
//            Optional<Holder.Reference<Enchantment>> unusualCatch = context.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).get(UFEnchantments.UNUSUAL_CATCH);
//            int i = 0;
//            if (unusualCatch.isPresent()) {
//                i = EnchantmentHelper.getItemEnchantmentLevel(unusualCatch.get(), stack);
//            }
//            if (stack.is(ItemTags.FISHING_ENCHANTABLE) && i > 0) {
//                ret.add(new ItemStack(items.get(context.getRandom().nextInt(size))));
//            }
//            else {
//                ret = generatedLoot;
//            }
//        }
        return new ObjectArrayList<>();
    }

    public static final MapCodec<UnusualCatchLootModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, UnusualCatchLootModifier::new));

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}