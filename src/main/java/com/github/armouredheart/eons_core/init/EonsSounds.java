// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsSounds {
    
    // *** Attributes ***

    //
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, EonsCore.MOD_ID);

    // *** Register Sounds ***

    // music
    public static final SoundEvent MUSIC_EONS_PRIMAL_AGE = createSoundEvent("music.eons_primal_age");

    // misc
    public static final SoundEvent ZAP = createSoundEvent("misc.zap");
    public static final SoundEvent CRACK= createSoundEvent("misc.crack");

    // arthropod
    public static final SoundEvent MARINE_ARTHROPOD_CRAWLING = createSoundEvent("arthropod.marine_arthropod_crawling");

    // amphibian


    // *** Methods ***

    /** 
     * @param sound_event_name String unlocalised name all lowercase matching sound event entry in sounds.json file
     * @return SoundEvent the sound event that was registered
    */
    private static SoundEvent createSoundEvent(final String sound_event_name){
        final ResourceLocation location = new ResourceLocation(EonsCore.MOD_ID, sound_event_name);
        final SoundEvent event = new SoundEvent(location);
        SOUND_EVENTS.register(sound_event_name, () -> event);
        return event;
    }
}