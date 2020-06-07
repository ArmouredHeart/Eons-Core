// package
package com.github.armouredheart.eons_core.config;

// Minecraft imports

// Forge imports
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EonsConfig {
    // *** Attributes ***
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsConfig");
    public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

    // *** Inner Classes ***

    /** */
    public static class Common {
        // *** Attributes ***
        public final BooleanValue enable_eons_biomes_in_overworld;

        // *** Constructors ***
        
        /** */
        public Common(ForgeConfigSpec.Builder builder) {
            // define config header
            builder.comment("EonsCore Common Config").push("sample text");

            // define config defaults and descriptions
            enable_eons_biomes_in_overworld = builder
                .comment("Determines whether or not Eons biomes generate in the overworld.")
                .translation("EonsCore.configgui.enable_eons_biomes_in_overworld")
                .worldRestart()
                .define("enable_eons_biomes_in_overworld", true);

            // finalize config
            builder.pop();
        }

        // *** Methods ***
    }

    /** */
	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}

    // *** Methods ***

    /** */
	public static void onLoad(final ModConfig.Loading event) {
		
	}
	
	/** */
	public static void onFileChange(final ModConfig.ConfigReloading event) {
		
	}
}