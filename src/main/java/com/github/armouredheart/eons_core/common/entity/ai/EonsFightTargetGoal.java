// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EonsFightTargetGoal<B extends CreatureEntity> extends MeleeAttackGoal {
    // *** Attributes ***
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsBeastEntity");
    private final B BEAST;
    private final double BASE_CIRCLE_RADIUS;
    private final int BASE_PATIENCE;
    private final float FACING_YAW;
    private final float FACING_PITCH;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private boolean isAttacking;
    private int patience;

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
    public EonsFightTargetGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience, float facingYaw, float facingPitch) {
        super(beast, speedFactor, useLongMemory);
        this.BASE_CIRCLE_RADIUS = circleRadius;
        this.strafingClockwise = true;
        this.FACING_YAW = facingYaw;
        this.FACING_PITCH = facingPitch;
        this.BASE_PATIENCE = patience;
        this.BEAST = beast;
    }

    public EonsFightTargetGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience) {
        this(beast, circleRadius, speedFactor, useLongMemory, patience, 30.0F, 30.0F);
    }

    // *** Methods ***

    /** */
    private void toggleStrafeDirection() {if ((double)this.BEAST.getRNG().nextFloat() < 0.3D) {this.strafingClockwise = !this.strafingClockwise;}}

    /**
    * Returns whether the EntityAIBase should begin execution.
    */
    @Override
    public boolean shouldExecute() {
        boolean execute = super.shouldExecute();
        //LOGGER.debug("Should execute? " + execute);
        return execute;
    }

    /**
    * Execute a one shot task or start executing a continuous task
    */
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.isAttacking = true;
        //LOGGER.debug("Starting Execution...");
    }

    /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
    @Override
    public boolean shouldContinueExecuting() {
        boolean con = super.shouldContinueExecuting();
        //LOGGER.debug("Continue Execution? " + con);
        return con;
    }

    /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
    @Override
    public void resetTask() {
        super.resetTask();
    }

    /**
    * Keep ticking a continuous task that has already been started
    */
    @Override
    public void tick() {
        //
        LivingEntity target = this.BEAST.getAttackTarget();
        boolean beastCanSeePrey = this.BEAST.getEntitySenses().canSee(target);
        boolean targetLookingAway = false; // TODO implement this later
        this.BEAST.getNavigator().tryMoveToEntityLiving(target, 1);

        // Wait for opening
        if(isAttacking) {
            // Execute Melee attack
            //LOGGER.debug("Doing melee!");
            super.tick();

        } else if(beastCanSeePrey) {
            //LOGGER.debug("Circling target!");
            // Circle target like skeleton
            // get distance to target
            double distance = this.getAttackReachSqr(target);

            // set to move backward if too close, set to move forward if too far
            this.strafingBackwards = distance < this.BASE_CIRCLE_RADIUS;

            // toggle strafe direction
            this.toggleStrafeDirection();

            //float speed = this.beast.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
            this.BEAST.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
            this.BEAST.faceEntity(target, this.FACING_YAW, this.FACING_PITCH);

        } else {
            //LOGGER.debug("Looking at target!");
            // look at target
            this.BEAST.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
        }   
    }
}