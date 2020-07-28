// package
package com.github.armouredheart.eons_core.common.world.gen.surfacebuilders;

// Minecraft imports
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

// Forge imports

// Eons imports

// misc imports
import java.util.Random;
import java.util.function.Function;
import com.mojang.datafixers.Dynamic;

public class EonsSuperGlacierSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsSuperGlacierSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
        super(function);
    }

    // *** Methods ***

    /** */
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
    }

    /** int j = (int)(noise / 3.0D + 160.0D + random.nextDouble() * 0.25D); */
    protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
        
    }
}