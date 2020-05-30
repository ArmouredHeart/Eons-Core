// package
package com.github.armouredheart.eons_core.common.block.core;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
// Forge imports

// Eons imports

// misc imports
public class EonsBigPotBlock extends FlowerPotBlock {

    // *** Attributes ***

    // *** Constructors ***

    /**
    * @param tree Tree that the sapling grows into
    * @param properties
    */
    protected EonsBigPotBlock(@javax.annotation.Nullable java.util.function.Supplier<FlowerPotBlock> emptyPot, java.util.function.Supplier<? extends Block> block_supplier, Block.Properties properties) {
        super(emptyPot, block_supplier, properties);
    }

    // *** Methods ***
        
}