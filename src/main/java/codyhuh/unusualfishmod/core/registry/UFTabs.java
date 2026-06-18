package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UFTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnusualFishMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UF_TAB = CREATIVE_TABS.register("unusual_fish_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.unusual_fish_mod"))
                    .icon(() -> UFItems.RAW_SNEEP_SNORP.get().getDefaultInstance())
                    .displayItems((displayParams, output) -> {
                        for (var item : UFItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                    })
                    .build()
    );
}
