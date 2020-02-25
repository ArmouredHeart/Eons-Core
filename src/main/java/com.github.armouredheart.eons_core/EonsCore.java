/** 
 * Project: Eons-Core
 * Started: 10/02/2020
 * @author: ArmouredHeart
 * Discord: ArmouredHeart#1208
 * GitHub: https://github.com/ArmouredHeart/Eons-Core
 * CurseForge: 
 * Licence: GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Notice: Please refer to original source if you create any derived works.
 * I want to see what you can create!
 * Please enjoy this mod!
*/

// package
package com.github.armouredheart.eons_core;

// Forge imports
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// Eons imports
import com.github.armouredheart.eons_core.init.EonsBlocks;
import com.github.armouredheart.eons_core.init.EonsItems;
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.api.IEonsCore;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Declare entry point */
@Mod(value = EonsCore.MOD_ID)
public class EonsCore implements IEonsCore {
    // *** Attributes ***
    public static final String MOD_ID = "eons_core";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    // *** Constructors ***

    /** */
    public EonsCore() {
        LOGGER.debug("Creating instance of Eons-Core...");

        //
        final ModLoadingContext eonsLoadingContext = ModLoadingContext.get();
        final IEventBus eonsEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register DeferredRegisters
        EonsSounds.SOUND_EVENTS.register(eonsEventBus);
        EonsBlocks.BLOCKS.register(eonsEventBus);
        EonsItems.ITEMS.register(eonsEventBus);
        
        // Register Configs

    }

    // *** Methods ***
}