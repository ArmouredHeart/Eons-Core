// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

// Forge imports

// Eons imports

// misc imports
import java.util.Random;

public abstract class EonsPlantSproutBlock extends Block implements IGrowable {

    // *** Attributes ***

    // *** Constructors ***
    public EonsPlantSproutBlock(Block.Properties builder) {
        super(builder);
    }

    // *** Methods ***

    /**
    * Whether this IGrowable can grow
    */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    /** */
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    /** */
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {

    }
}