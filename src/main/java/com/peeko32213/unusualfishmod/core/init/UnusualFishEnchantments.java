package com.peeko32213.unusualfishmod.core.init;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import com.peeko32213.unusualfishmod.common.enchantment.ParalysisEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualFishEnchantments {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
            UnusualFishMod.MODID);

    public static final RegistryObject<Enchantment> PARALYSIS = ENCHANTMENTS.register("paralysis", () -> new ParalysisEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));


}
