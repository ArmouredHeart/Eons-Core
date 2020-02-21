// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.util.SoundEvent;

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

    //
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, EonsCore.MOD_ID);

    // *** Register Sounds ***

    // *** Methods ***

    /**
     * @param sound_event_supplier Minecraft SoundEvent object or subclass object
     * @param sound_event_name String unlocalised name all lowercase
     */
    public static RegistryObject<SoundEvent> registerSoundEvent(String sound_event_name, Supplier<SoundEvent> sound_event_supplier){
        return SOUND_EVENTS.register(sound_event_name, sound_event_supplier);
    }

}