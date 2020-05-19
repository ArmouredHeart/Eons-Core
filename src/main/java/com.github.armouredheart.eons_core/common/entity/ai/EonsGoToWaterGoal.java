// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsMoistness;

// misc imports
import java.util.EnumSet;
import java.lang.Class;

public class EonsGoToWaterGoal extends MoveToBlockGoal {

    // *** Attributes ***
    protected final CreatureEntity creature;
     protected final IEonsMoistness moistCreature;

    // *** Constructors ***
    public EonsGoToWaterGoal(CreatureEntity creature, double speed, int searchLength) {
        super(creature, speed, searchLength);
        this.creature = creature;
        if(isMoist(creature)){
            this.moistCreature = (IEonsMoistness)creature;
        } else {
            this.moistCreature = null;
        }
    }

    // *** Methods ***

    /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
    public boolean shouldContinueExecuting() {
        return !this.creature.isInWater() && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.creature.world, this.destinationBlock);
    }

    /**
    * Returns whether the EntityAIBase should begin execution.
    */
    public boolean shouldExecute() {
        if (this.creature.isChild() && !this.creature.isInWater()) {
            return super.shouldExecute();
        } else if (!this.moistCreature.equals(null)){
            return !this.creature.isInWater() && this.moistCreature.isDryingOut() ? super.shouldExecute() : false;
        } else {
            return !this.creature.isInWater() ? super.shouldExecute() : false;
        }
    }

    public boolean shouldMove() {
        return this.timeoutCounter % 160 == 0;
    }

    /**
    * Return true to set given position as destination
    */
    protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos).getBlock();
        return block == Blocks.WATER;
    }

    /** */
    protected boolean isMoist(CreatureEntity creature) {
        return IEonsMoistness.class.isInstance(creature);
    }
}