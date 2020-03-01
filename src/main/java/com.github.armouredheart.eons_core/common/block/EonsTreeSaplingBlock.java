// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.trees.Tree;

// Forge imports

// Eons imports

// misc imports
public class EonsTreeSaplingBlock extends SaplingBlock{

    // *** Attributes ***

    // *** Constructors ***

    /**
    * @param tree Tree that the sapling grows into
    * @param properties
    */
    protected EonsTreeSaplingBlock(Tree tree, Block.Properties properties) {
        super(tree, properties);
    }

    // *** Methods ***
        
}