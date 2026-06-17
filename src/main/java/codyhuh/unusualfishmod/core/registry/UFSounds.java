package codyhuh.unusualfishmod.core.registry;

import codyhuh.unusualfishmod.UnusualFishMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static codyhuh.unusualfishmod.UnusualFishMod.loc;

public class UFSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, UnusualFishMod.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> CRAB_CHATTER = createSoundEvent("crab_chatter");
    public static final DeferredHolder<SoundEvent, SoundEvent> CRAB_SCUTTLING = createSoundEvent("crab_scuttling");
    public static final DeferredHolder<SoundEvent, SoundEvent> DEEP_WATER = createSoundEvent("deep_water");
    public static final DeferredHolder<SoundEvent, SoundEvent> GNASHER_IDLE = createSoundEvent("gnasher_idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> EVIL_CHATTERING = createSoundEvent("evil_chattering");
    public static final DeferredHolder<SoundEvent, SoundEvent> SMALL_ENEMY = createSoundEvent("small_enemy");
    public static final DeferredHolder<SoundEvent, SoundEvent> SAWING = createSoundEvent("sawing");
    public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_DISC_SEAFOAM = createSoundEvent("seafoam");

    public static final ResourceKey<JukeboxSong> SEAFOAM_SONG = ResourceKey.create( Registries.JUKEBOX_SONG, UnusualFishMod.loc("seafoam"));

    private static DeferredHolder<SoundEvent, SoundEvent> createSoundEvent(final String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(loc(name)));
    }

}
