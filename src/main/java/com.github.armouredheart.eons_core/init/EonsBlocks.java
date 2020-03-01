// package
package com.github.armouredheart.eons_core.init;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

// Forge imports
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import java.util.function.Supplier;

/** */
public final class EonsBlocks {

    // *** Attributes ***
    
    //
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EonsCore.MOD_ID);

    // *** Register Blocks ***

    // *** Methods ***

    /**
     * @param block_supplier Supplier<Block>
     * @param block_name String unlocalised name all lowercase 
     */
    public static RegistryObject<Block> registerBlock(String block_name, Supplier<Block> block_supplier){
        return BLOCKS.register(block_name, block_supplier);
    }
}