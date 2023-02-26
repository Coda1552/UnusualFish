package com.peeko32213.unusualfishmod.core.init;

import com.peeko32213.unusualfishmod.UnusualFishMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = UnusualFishMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnusualFishSounds {

    public static final SoundEvent CRAB_CHATTER = createSoundEvent("crab_chatter");
    public static final SoundEvent CRAB_SCUTTLING = createSoundEvent("crab_scuttling");


    public static final SoundEvent DEEP_WATER = createSoundEvent("deep_water");


    public static final SoundEvent GNASHER_IDLE = createSoundEvent("gnasher_idle");


    public static final SoundEvent LARGE_FISH = createSoundEvent("large_fish");


    public static final SoundEvent MEDIUM_FISH = createSoundEvent("medium_fish");


    public static final SoundEvent EVIL_CHATTERING = createSoundEvent("evil_chattering");
    public static final SoundEvent EVIL_SCUTTLING = createSoundEvent("evil_scuttling");


    public static final SoundEvent SMALL_ENEMY = createSoundEvent("small_enemy");


    public static final SoundEvent SMALL_FISH = createSoundEvent("small_fish");

    public static final SoundEvent ABYSSAL_BLAST = createSoundEvent("abyssal_blast");

    public static final SoundEvent WHIP_CRACK = createSoundEvent("whip_crack");

    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(UnusualFishMod.MODID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    @SubscribeEvent
    public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
        try {
            for (Field f : UnusualFishMod.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof SoundEvent) {
                    event.getRegistry().register((SoundEvent) obj);
                } else if (obj instanceof SoundEvent[]) {
                    for (SoundEvent soundEvent : (SoundEvent[]) obj) {
                        event.getRegistry().register(soundEvent);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
