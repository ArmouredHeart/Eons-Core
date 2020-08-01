// package
package com.github.armouredheart.eons_core.common.world.biome.pre_cambrian;

// Minecraft imports
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.world.biome.EonsBiome;
import com.github.armouredheart.eons_core.api.EonsFieldNotes.Geon;
import com.github.armouredheart.eons_core.common.world.gen.surfacebuilders.EonsSurfaceBuilders;

// misc imports

public class EonsCryogenianSuperglacierBiome extends EonsBiome {

    // *** Attributes ***
    
    // *** Constructors ***

    /** */
    public EonsCryogenianSuperglacierBiome() {
        super((new Biome.Builder())
            .surfaceBuilder(new ConfiguredSurfaceBuilder(EonsSurfaceBuilders.SUPERGLACIER, EonsSurfaceBuilders.SUPERGLACIER_CONFIG))
            .precipitation(Biome.RainType.SNOW)
            .category(Biome.Category.ICY)
            .depth(7.5F)
            .scale(0.0005F)
            .temperature(-0.7F)
            .downfall(0.5F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .parent((String)null),
            null);

        // structures

        // underground
        DefaultBiomeFeatures.addCarvers(this);

        // surface
        DefaultBiomeFeatures.addFreezeTopLayer(this);

        // entities
    }
}