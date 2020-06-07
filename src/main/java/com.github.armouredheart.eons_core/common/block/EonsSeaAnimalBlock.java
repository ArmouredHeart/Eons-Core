// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public class EonsSeaAnimalBlock extends BushBlock implements IEonsLifeForm, IWaterLoggable {

    // *** Attributes ***
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final EonsFieldNotes fieldNotes;

    // *** Constructors ***

    /** */
    public EonsSeaAnimalBlock(Block.Properties properties, EonsFieldNotes fieldNotes) {
        super(properties);
        this.fieldNotes = fieldNotes;
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(true)));
    }

    // *** Methods ***

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    public EonsFieldNotes getFieldNotes() {return this.fieldNotes;}
    
    /** */
    @Override
    protected boolean isValidGround(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        return !blockState.getCollisionShape(worldIn, pos).project(Direction.UP).isEmpty();
    }

    /** */
    @Override
    public boolean isValidPosition(BlockState blockState, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    /** */
    protected boolean isInBadEnvironment(BlockState blockState) {
        return !blockState.get(WATERLOGGED);
    }

    /** Here for compatibilty reasons */
    @Override
    public int getLightValue(BlockState blockState) {
        return blockState.getLightValue();
    }

    public IFluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}