package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UFSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, UnusualFishMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CRAB_CHATTER = createSoundEvent("crab_chatter");
    public static final RegistryObject<SoundEvent> CRAB_SCUTTLING = createSoundEvent("crab_scuttling");
    public static final RegistryObject<SoundEvent> DEEP_WATER = createSoundEvent("deep_water");
    public static final RegistryObject<SoundEvent> GNASHER_IDLE = createSoundEvent("gnasher_idle");
    public static final RegistryObject<SoundEvent> LARGE_FISH = createSoundEvent("large_fish");
    public static final RegistryObject<SoundEvent> MEDIUM_FISH = createSoundEvent("medium_fish");
    public static final RegistryObject<SoundEvent> EVIL_CHATTERING = createSoundEvent("evil_chattering");
    public static final RegistryObject<SoundEvent> SMALL_ENEMY = createSoundEvent("small_enemy");
    public static final RegistryObject<SoundEvent> SMALL_FISH = createSoundEvent("small_fish");
    public static final RegistryObject<SoundEvent> SAWING = createSoundEvent("sawing");
    public static final RegistryObject<SoundEvent> MUSIC_DISC_SEAFOAM = createSoundEvent("seafoam");

    private static RegistryObject<SoundEvent> createSoundEvent(final String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(UnusualFishMod.MOD_ID, name)));
    }

}
