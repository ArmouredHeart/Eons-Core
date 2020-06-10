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

public class EonsFightPreyGoal<B extends CreatureEntity> extends EonsMeleeAttackGoal {
    // *** Attributes ***
    private final double baseCircleRadius;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private final float facingYaw;
    private final float facingPitch;

    // *** Constructors ***

    /** 
    * @param beast
    * @param circleRadius
    * @param speedFactor
    * @param useLongMemory
    * @param patience int number of seconds minimum to circle before attacking
    * @param facingYaw
    * @param facingPitch
    */
    public EonsFightPreyGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience, float facingYaw, float facingPitch) {
        super(beast, speedFactor, useLongMemory, patience);
        this.baseCircleRadius = circleRadius;
        this.strafingClockwise = true;
        this.facingYaw = facingYaw;
        this.facingPitch = facingPitch;
    }

    public EonsFightPreyGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience) {
        this(beast, circleRadius, speedFactor, useLongMemory, patience, 30.0F, 30.0F);
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
                return true;
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
        LivingEntity target = this.beast.getAttackTarget();
        this.reducePatienceTicks();
        boolean beastCanSeePrey = this.beast.getEntitySenses().canSee(target);
        boolean targetLookingAway = false; // TODO implement this later

        this.beast.getNavigator().tryMoveToEntityLiving(target, 1);
        

        // Wait for opening
        if(beastCanSeePrey && (targetLookingAway || this.outOfPatience()) && super.shouldExecute()) {
            // Execute Melee attack
            this.resetPatienceTicks();
            super.startExecuting();
        } else if(beastCanSeePrey) {
            // Circle target like skeleton
            // get distance to target
            double distance = this.beast.getDistanceSq(target.posX, target.getBoundingBox().minY, target.posZ);

            // set to move backward if too close, set to move forward if too far
            this.strafingBackwards = distance > this.baseCircleRadius;

            // toggle strafe direction
            this.toggleStrafeDirection();

            //float speed = this.beast.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
            this.beast.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
            this.beast.faceEntity(target, this.facingYaw, this.facingPitch);

        } else {
            // look at target
            this.beast.getLookController().setLookPositionWithEntity(target, this.facingYaw, this.facingPitch);
        }   
    }
}