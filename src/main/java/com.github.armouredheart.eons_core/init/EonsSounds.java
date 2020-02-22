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

    // namespace under which sound resources are stored
    private static final String namespace = "com.github.armouredheart.eons_core";

    //
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, EonsCore.MOD_ID);

    // *** Register Sounds ***

    //
    public static final SoundEvent EONS_MUSIC_PRIMAL_AGE = registerSoundEvent("music.eons_music_primal_age");

    // *** Methods ***

    /**
     * @param sound_event_supplier Minecraft SoundEvent supplier
     * @param sound_event_name String unlocalised name all lowercase
     * @return RegistryObject<SoundEvent> that was registered
     */
    public static RegistryObject<SoundEvent> registerSoundEvent(String sound_event_name, Supplier<SoundEvent> sound_event_supplier){
        return SOUND_EVENTS.register(sound_event_name, sound_event_supplier);
    }

    /** 
     * @param sound_event_name String unlocalised name all lowercase matching sound event entry in @Link{sounds.json} file
     * @param context String name of file to look in. Example: sounds/context/sound_event_name
     * @return SoundEvent the sound event that was registered
    */
    public static SoundEvent registerSoundEvent(String sound_event_name){
        SoundEvent event = new SoundEvent(new ResourceLocation(EonsCore.MOD_ID, sound_event_name));
        registerSoundEvent(sound_event_name, () -> event);
        return event;
    }
}