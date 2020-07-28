// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.world.biome.Biome;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeDictionary;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.common.world.biome.pre_cambrian.*;
//import com.github.armouredheart.eons_core.common.world.biome.paleozoic.*;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsBiomes {

    // *** Attributes ***
    
    //
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, EonsCore.MOD_ID);

    // *** Register Biomes ***
    
    // Pre-Cambrian
    public static final RegistryObject<Biome> CRYOGENIAN_SUPERGLACIER = registerBiome("cryogenian_superglacier", () -> new EonsCryogenianSuperglacierBiome());

    // Paleozoic

    // *** Methods ***

    /**
     * @param biome_supplier Supplier<Biome>
     * @param biome_name String unlocalised name all lowercase 
     */
    private static RegistryObject<Biome> registerBiome(String biome_name, Supplier<Biome> biome_supplier){
        return BIOMES.register(biome_name, biome_supplier);
    }

    /** This is called in `EonsEventSubscriber.java`*/
    public static void registerBiomesToBiomeDictionary() {
        registerBiomeTypes(CRYOGENIAN_SUPERGLACIER, Type.COLD, Type.DEAD, Type.SNOWY, Type.OVERWORLD);
    }

    private static void registerBiomeTypes(RegistryObject<Biome> biome, Type... types) {
        BiomeDictionary.addTypes(biome.get(), types);
    }

}