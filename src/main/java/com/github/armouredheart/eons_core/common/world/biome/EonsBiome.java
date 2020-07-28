// package
package com.github.armouredheart.eons_core.common.world.biome;

// Minecraft imports
import net.minecraft.world.biome.Biome;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsPeriod;

// misc imports

public class EonsBiome extends Biome {

    // *** Attributes ***
    private final EonsPeriod period;

    // *** Constructors ***

    /** */
    protected EonsBiome(Builder biomeBuilder, EonsPeriod period) {
        super(biomeBuilder);
        this.period = period;
    }

    // *** Methods ***
}