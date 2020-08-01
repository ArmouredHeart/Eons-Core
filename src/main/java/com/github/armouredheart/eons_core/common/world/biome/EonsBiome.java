// package
package com.github.armouredheart.eons_core.common.world.biome;

// Minecraft imports
import net.minecraft.world.biome.Biome;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsFieldNotes.Geon;

// misc imports

public class EonsBiome extends Biome {

    // *** Attributes ***
    private final Geon GEON;

    // *** Constructors ***

    /** */
    protected EonsBiome(Builder biomeBuilder, final Geon GEON) {
        super(biomeBuilder);
        this.GEON = GEON;
    }

    // *** Methods ***
}