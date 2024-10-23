package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class UFTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnusualFishMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UF_TAB = CREATIVE_TABS.register("unusual_fish_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.unusual_fish_mod"))
                    .icon(UFItems.RAW_CIRCUS_FISH.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        for (var item : UFItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
}
