// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsPredator;
import com.github.armouredheart.eons_core.common.entity.ai.EonsMeleeAttackGoal;
// misc imports

public class EonsFightPreyGoal<B extends CreatureEntity & IEonsBeast & IEonsPredator> extends EonsMeleeAttackGoal {
    // *** Attributes ***
    private final double baseCircleRadius;
    private boolean strafingClockwise;
    private boolean strafingBackwards;

    // *** Constructors ***

    /** 
    * @param beast
    * @param circleRadius
    * @param speedFactor
    * @param useLongMemory
    * @param patience int number of seconds minimum to circle before attacking
    */
    public EonsFightPreyGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience) {
        super(beast, speedFactor, useLongMemory, patience);
        this.baseCircleRadius = circleRadius;
        this.strafingClockwise = true;
    }

    // *** Methods ***

    /** */
    private void toggleStrafeDirection() {if ((double)this.beast.getRNG().nextFloat() < 0.3D) {this.strafingClockwise = !this.strafingClockwise;}}

    /**
    * Returns whether the EntityAIBase should begin execution.
    */
    @Override
    public boolean shouldExecute() {
        LivingEntity target = this.beast.getAttackTarget();
        if(target != null) {
            if(target.isAlive()) {

            }
        }
        return false;
    }

    /**
    * Execute a one shot task or start executing a continuous task
    */
    @Override
    public void startExecuting() {
        this.resetPatienceTicks();
        this.beast.setAggroed(true);
    }

    /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }

    /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
    @Override
    public void resetTask() {
        super.resetTask();
        this.beast.setAggroed(false);
    }

    /**
    * Keep ticking a continuous task that has already been started
    */
    @Override
    public void tick() {
        //
        LivingEntity prey = this.beast.getAttackTarget();
        this.reducePatienceTicks();
        boolean beastCanSeePrey = this.beast.getEntitySenses().canSee(prey);
        boolean preyLookingAway = false; // 

        this.beast.getNavigator().tryMoveToEntityLiving(prey, 1);
        

        // Wait for opening
        if(beastCanSeePrey && (preyLookingAway || this.outOfPatience()) && super.shouldExecute()) {
            // Execute Melee attack
            this.resetPatienceTicks();
            super.startExecuting();
        } else if(beastCanSeePrey) {
            // Circle prey like skeleton
            // get distance to prey
            double distance = this.beast.getDistanceSq(prey.posX, prey.getBoundingBox().minY, prey.posZ);

            // set to move backward if too close, set to move forward if too far
            this.strafingBackwards = distance > this.baseCircleRadius;

            // toggle strafe direction
            this.toggleStrafeDirection();

            //float speed = this.beast.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
            this.beast.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
            this.beast.faceEntity(prey, 30.0F, 30.0F);

        } else {
            // look at prey
            this.beast.getLookController().setLookPositionWithEntity(prey, 30.0F, 30.0F);
        }   
    }
}