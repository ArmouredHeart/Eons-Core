// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.IGrowable;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateContainer;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;


// Forge imports
import net.minecraftforge.common.IShearable;

// Eons imports
import com.github.armouredheart.eons_core.common.block.EonsSeaAnimalBlock;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports
import java.util.Random;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class EonsGrowingSeaAnimalBlock extends EonsSeaAnimalBlock implements IGrowable {

    // *** Attributes ***
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private final SoundEvent pickSound;
    private final Item dropItem;

    // *** Constructors ***

    /** */
    public EonsGrowingSeaAnimalBlock(Block.Properties properties, EonsFieldNotes fieldNotes, boolean thermophile, @Nullable Item dropItem, @Nullable SoundEvent pickSound) {
        super(properties, fieldNotes, thermophile);
        this.pickSound = pickSound;
        this.dropItem = dropItem;
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(1)));
    }

    // *** Methods ***

    /** */
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        return blockstate;
    }

    /** */
    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int ripe = state.get(AGE);
        if (player.getHeldItem(handIn).getItem() == Items.BONE_MEAL) {
            return false;
        } else if(ripe > 2) {
            int j = 1 + worldIn.rand.nextInt(ripe - 1);
            worldIn.playSound((PlayerEntity)null, pos, this.pickSound, SoundCategory.BLOCKS, 1.0F, 0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
            spawnAsEntity(worldIn, pos, new ItemStack(this.dropItem, j));
            return true;
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }
    }

    /** */
    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        super.tick(state, worldIn, pos, random);
        int i = state.get(AGE);
        if (i < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    /** */
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(AGE);
    }

    /** */
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {return true;}

    /**
    * Whether this IGrowable can grow
    */
    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    }

    /** */
    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.get(AGE) + 1);
        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
    }

}