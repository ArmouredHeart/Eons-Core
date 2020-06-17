// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsPredator;
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EonsFightTargetGoal<B extends CreatureEntity> extends MeleeAttackGoal {
    // *** Attributes ***
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsBeastEntity");
    private final B beast;
    private final double baseCircleRadius;
    private final int basePatience;
    private final float facingYaw;
    private final float facingPitch;
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
        this.baseCircleRadius = circleRadius;
        this.strafingClockwise = true;
        this.facingYaw = facingYaw;
        this.facingPitch = facingPitch;
        this.basePatience = patience;
        this.beast = beast;
    }

    public EonsFightTargetGoal(B beast, double circleRadius, double speedFactor, boolean useLongMemory, int patience) {
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
        LivingEntity target = this.beast.getAttackTarget();
        boolean beastCanSeePrey = this.beast.getEntitySenses().canSee(target);
        boolean targetLookingAway = false; // TODO implement this later
        this.beast.getNavigator().tryMoveToEntityLiving(target, 1);

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
            this.strafingBackwards = distance < this.baseCircleRadius;

            // toggle strafe direction
            this.toggleStrafeDirection();

            //float speed = this.beast.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();
            this.beast.getMoveHelper().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
            this.beast.faceEntity(target, this.facingYaw, this.facingPitch);

        } else {
            //LOGGER.debug("Looking at target!");
            // look at target
            this.beast.getLookController().setLookPositionWithEntity(target, 30.0F, 30.0F);
        }   
    }
}