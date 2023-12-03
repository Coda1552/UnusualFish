package codyhuh.unusualfishmod.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class UnusualCatchEnchantment extends Enchantment {

    public UnusualCatchEnchantment(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, EnchantmentCategory.FISHING_ROD, slots);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return stack.getItem() instanceof FishingRodItem;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTradeable() {
        return true;
    }

    @Override
    public boolean isDiscoverable() {
        return true;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }
}
