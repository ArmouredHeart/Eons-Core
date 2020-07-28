// package
package com.github.armouredheart.eons_core.common.world.gen.surfacebuilders;

// Minecraft imports
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

// Forge imports
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

// Eons imports
import com.github.armouredheart.eons_core.common.world.gen.surfacebuilders.EonsSuperGlacierSurfaceBuilder;
import com.github.armouredheart.eons_core.EonsCore;

// misc imports

public class EonsSurfaceBuilders {
    // *** Blockstate Holders ***
    public static final BlockState SAND = Blocks.SAND.getDefaultState();
    public static final BlockState RED_SAND = Blocks.RED_SAND.getDefaultState();
    public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
    public static final BlockState STONE = Blocks.STONE.getDefaultState();
    public static final BlockState DIRT = Blocks.DIRT.getDefaultState();
    public static final BlockState COARSE_DIRT = Blocks.COARSE_DIRT.getDefaultState();
    public static final BlockState SNOW = Blocks.SNOW_BLOCK.getDefaultState();
    public static final BlockState BLUE_ICE = Blocks.BLUE_ICE.getDefaultState();
    public static final BlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();

    // *** Configs ***
    public static final SurfaceBuilderConfig SUPERGLACIER_CONFIG = new SurfaceBuilderConfig(SNOW, PACKED_ICE, BLUE_ICE);

    // *** SurfaceBuilders ***
    public static final SurfaceBuilder<SurfaceBuilderConfig> SUPERGLACIER = new EonsSuperGlacierSurfaceBuilder(SurfaceBuilderConfig::deserialize);

    // *** Methods ***

    /** Not using deferred register to ensure that surfaces register before biomes. Called in `EonsEventSubscriber.java` */
    public static void registerEonsSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        registerEonsSurfaceBuilder(SUPERGLACIER, "superglacier", event);
    }

    private static void registerEonsSurfaceBuilder(SurfaceBuilder<SurfaceBuilderConfig> builder, String name, RegistryEvent.Register<SurfaceBuilder<?>> event) {
        event.getRegistry().register(builder.setRegistryName(EonsCore.MOD_ID, name));
    }
}