// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;

// Forge imports
import net.minecraftforge.common.PlantType;
// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;

// misc imports
import javax.annotation.Nullable;

public class EonsSeaAnimalBlock extends BushBlock implements IEonsLifeForm, IWaterLoggable {

    // *** Attributes ***
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final EonsFieldNotes fieldNotes;
    private final boolean thermophile;

    // *** Constructors ***

    /** */
    public EonsSeaAnimalBlock(Block.Properties properties, EonsFieldNotes fieldNotes, boolean thermophile) {
        super(properties);
        this.fieldNotes = fieldNotes;
        this.thermophile = thermophile;
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(true)));

    }

    /** */
    public EonsSeaAnimalBlock(Block.Properties properties, EonsFieldNotes fieldNotes) {
        this(properties, fieldNotes, false);
    }

    // *** Methods ***

    /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        if (!blockstate.isAir(worldIn, currentPos)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return blockstate;
    }

    /** */
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {        
        IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
        return ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8 ? super.getStateForPlacement(context) : null;
    }

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    public EonsFieldNotes getFieldNotes() {return this.fieldNotes;}
    
    /** */
    @Override
    protected boolean isValidGround(BlockState blockState, IBlockReader worldIn, BlockPos pos) {
        Block block = blockState.getBlock();
        boolean isThermal = (block == Blocks.MAGMA_BLOCK && this.thermophile) || !this.thermophile;
        return !blockState.getCollisionShape(worldIn, pos).project(Direction.UP).isEmpty() && isThermal;
    }

    /** */
    @Override
    public boolean isValidPosition(BlockState blockState, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos) && !blockState.isAir();
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

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public PlantType getPlantType(IBlockReader world, BlockPos pos) {return PlantType.Water;}
}