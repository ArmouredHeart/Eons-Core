/** 
 * Project: Eons-Core
 * Started: 10/02/2020
 * Author: ArmouredHeart
 * Discord: ArmouredHeart#1208
 * GitHub: https://github.com/ArmouredHeart/Eons-Core
 * CurseForge: 
 * Licence: GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007
 * Notice: Please refer to original source if you create any derived works.
 * I want to see what you can create!
 * Please enjoy this mod!
*/

// package
package eons_core.common;

// Forge imports
import net.minecraft.server.dedicated.ServerProperties;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

// Eons imports

// misc imports


/** */
@Mod(value = EonsCore.MOD_ID)
public class EonsCore {
    //
    public static final String MOD_ID = "eons_core";
    public static final String MOD_NAME = "Eons: Core";
    public static final String MOD_VERSION = "0.0.1";
    public static final String ACCEPTED_VERSION = "[1.14.4]";
    public static final String CLIENT_PROXY_CLASS = "";
    public static final String COMMON_PROXY_CLASS = "";
    public static Common_Proxy proxy = DistExecutor.runForDist(() -> Client_Proxy::new, () -> Common_Proxy::new);
    //
    public static Logger logger = LogManager.getLogger(MOD_ID);
    public static EonsCore instance;

    /** */
    public EonsCore() {
        instance = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        MinecraftForge.EVENT_BUS.addListener(this::serverStarting);
    }

    /** */
    public void dedicatedServerSetup(FMLDedicatedServerSetupEvent event) {
    
    }

    /** */
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    /** */
    private void clientSetup(final FMLClientSetupEvent event) {

    }

    /** */
    private void loadComplete(final FMLLoadCompleteEvent event) {
    
    }

    /** */
    public void serverStarting(FMLServerStartingEvent event) {

    }
}