// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;

// Forge imports
import net.minecraftforge.event.ForgeEventFactory;

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.IEonsBeast;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EonsEatBerriesGoal<T extends CreatureEntity & IEonsBeast> extends MoveToBlockGoal{
    // *** Attributes ***
    //private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsEatBerriesGoal");
    protected T creature;
    private int harvestRange;
    private final World world;

    // *** Constructors ***

    /** */
    public EonsEatBerriesGoal(T creature, double speed, int searchRadius) {
        super(creature, speed, searchRadius);
        this.harvestRange = harvestRange;
        this.world = creature.world;
        this.creature = creature;
    }

    // *** Methods ***

    /** Simulate right clicking a berry bush to drop berries */
    protected void eatBerriesOnBush() {
        if(ForgeEventFactory.getMobGriefingEvent(this.world, this.creature)) {
            BlockState blockstate = creature.world.getBlockState(this.destinationBlock);
            if(isOnTargetList(blockstate)) {
                // simulate activation of SweetBerryBush block
                int age = blockstate.get(SweetBerryBushBlock.AGE);
                int berries = 1 + this.world.rand.nextInt(2) + (age == 3 ? 1 : 0);
                blockstate.with(SweetBerryBushBlock.AGE, Integer.valueOf(1));

                // drop berry items from bush
                SweetBerryBushBlock.spawnAsEntity(this.world, this.destinationBlock, this.getBerryItems(this.destinationBlock, blockstate, berries));

                // play sounds of harvesting
                this.creature.playSound(SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, 1.0F, 1.0F);
                this.world.setBlockState(this.destinationBlock, blockstate.with(SweetBerryBushBlock.AGE, Integer.valueOf(1)), 2);
            }
        }
    }
    
    @Override
    public double getTargetDistanceSq() {
        return 2.25D;
    }

    /**  */
    private ItemStack getBerryItems(BlockPos bushPos, BlockState blockstate, int numBerries) {
        
        return new ItemStack(blockstate.getBlock().getItem(this.world, bushPos, blockstate).getItem(), numBerries);
    }

    /** */
    protected boolean isOnTargetList(BlockState blockstate) {
        return blockstate.getBlock() instanceof SweetBerryBushBlock;
    }

    /**
    * Returns whether the EntityAIBase should begin execution.
    */
    public boolean shouldExecute() {
        //
        if(this.creature.isHungry()) {
            return super.shouldExecute();
        } else {
            return false;
        }
    }

    /**
    * Execute a one shot task or start executing a continuous task
    */
    public void startExecuting() {
        super.startExecuting();
    }

    /**
    * Keep ticking a continuous task that has already been started
    */
    public void tick() {
        if(getIsAboveDestination()){
            this.eatBerriesOnBush();
        }
        super.tick();
    }

    /**
     * Return true to set given position as destination
     */
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        // find a berry bush that is old enough to have berries
        BlockState blockstate = worldIn.getBlockState(pos);
        return isOnTargetList(blockstate) && blockstate.get(SweetBerryBushBlock.AGE) >= 2;
    }
}