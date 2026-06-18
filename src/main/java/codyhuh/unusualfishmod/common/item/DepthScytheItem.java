package codyhuh.unusualfishmod.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DepthScytheItem extends SwordItem {

    public DepthScytheItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return super.getDestroySpeed(stack, state);
        }
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (state.getDestroySpeed(worldIn, pos) != 0.0F) {
            stack.hurtAndBreak(2, entityLiving, EquipmentSlot.MAINHAND);
        }

        return true;
    }

/*    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (Enchantments.SWEEPING_EDGE.allowedInCreativeTab(this, tab)) {
            ItemStack stack = new ItemStack(this);
            stack.enchant(Enchantments.SWEEPING_EDGE, 5);
            list.add(stack);
        }
    }*/

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        level.holderLookup(Registries.ENCHANTMENT).get(Enchantments.SWEEPING_EDGE).ifPresent(enchant -> stack.enchant(enchant, 5));
        super.onCraftedBy(stack, level, player);
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 1;
    }
}
