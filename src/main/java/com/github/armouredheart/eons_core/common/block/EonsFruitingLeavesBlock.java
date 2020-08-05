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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundEvent;

// Forge imports

// Eons imports

// misc imports
import java.util.Random;
import javax.annotation.Nullable;

public class EonsFruitingLeavesBlock extends LeavesBlock implements IGrowable {
    // *** Attributes ***
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private final SoundEvent pickSound;
    private final Item fruitItem;

    // *** Constructors ***

    /** */
    public EonsFruitingLeavesBlock(Block.Properties properties, Item fruitItem, SoundEvent pickSound) {
        super(properties);
        this.pickSound = pickSound;
        this.fruitItem = fruitItem;
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(1)));
    }

    /** Default setting (apples) */
    public EonsFruitingLeavesBlock(Block.Properties properties) {
        this(properties, Items.APPLE, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH);
    }

    // *** Methods ***

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.tick(state, worldIn, pos, random);
        int i = state.get(AGE);
        if (i < 3 && worldIn.getLightSubtracted(pos.up(), 0) >= 9
                && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }

    /** */
    protected SoundEvent getPickSound() {
        return this.pickSound;
    }

    /** */
    protected Item getFruitItem() {
        return this.fruitItem;
    }

    /** */
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        int ripe = state.get(AGE);
        if (ripe > 1) {
            int j = 1 + worldIn.rand.nextInt(ripe - 1);
            spawnAsEntity(worldIn, pos, new ItemStack(this.getFruitItem(), j));
            worldIn.playSound((PlayerEntity) null, pos, this.getPickSound(), SoundCategory.BLOCKS, 1.0F,
                    0.8F + worldIn.rand.nextFloat() * 0.4F);
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(1)), 2);
            return ActionResultType.SUCCESS;
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit); // depreciated by mojang?
        }
    }

    /** */
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    /**
     * Whether this IGrowable can grow
     */
    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(AGE) < 3;
    }

    /** */
    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        int i = Math.min(3, state.get(AGE) + 1);
        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
    }

    /** */
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(AGE);
    }
}