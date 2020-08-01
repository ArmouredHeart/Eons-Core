// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;

// misc imports
import javax.annotation.Nullable;

public class EonsTreeSaplingBlock extends SaplingBlock implements IEonsLifeForm{

    // *** Attributes ***
    private final EonsFieldNotes fieldNotes;
    private final Block[] validGroundBlocks;

    // *** Constructors ***

    /**
    * @param tree Tree that the sapling grows into
    * @param properties
    */
    protected EonsTreeSaplingBlock(Tree tree, Block.Properties properties, EonsFieldNotes fieldNotes, @Nullable Block[] validGroundBlocks) {
        super(tree, properties);
        this.fieldNotes = fieldNotes;
        this.validGroundBlocks = validGroundBlocks;
    }

    // *** Methods ***

    /** */
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        if(this.validGroundBlocks != null && this.validGroundBlocks.length > 0) {
            Block block = state.getBlock();
            for(Block validGroundBlock : this.validGroundBlocks) {
                if(block == validGroundBlock) {return true;}
            }
        }
        return super.isValidGround(state, worldIn, pos);
    }

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    public EonsFieldNotes getFieldNotes() {return this.fieldNotes;}
        
}