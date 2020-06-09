// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.SharedMonsterAttributes;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;

// misc imports

public class EonsMeleeAttackGoal<B extends CreatureEntity & IEonsBeast> extends MeleeAttackGoal {
    // *** Attributes ***
    protected final B beast;
    private final int basePatience;
    private int patienceTicks;

    /** 
    * @param beast
    * @param circleRadius
    * @param speedFactor
    * @param useLongMemory
    * @param patience
    */
    public EonsMeleeAttackGoal(B beast, double speedFactor, boolean useLongMemory, int patience) {
        super(beast, beast.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue() * speedFactor, useLongMemory);
        this.beast = beast;
        this.basePatience = patience * 20;
        this.resetPatienceTicks();
    }

    // *** Methods ***

    /** */
    protected void resetPatienceTicks() {this.patienceTicks = this.beast.world.rand.nextInt(300) + this.basePatience;}

    /** */
    protected boolean outOfPatience() {return this.patienceTicks < 0;}

    /** */
    protected void reducePatienceTicks() {--this.patienceTicks;}

    /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
    @Override
    public boolean shouldContinueExecuting() {
        LivingEntity target = beast.getAttackTarget();
        // make sure there is still a target
        if(target != null && target.isAlive()) { 
            return super.shouldContinueExecuting();
        } else {
            return false;
        }   
    }

    /**
    * Execute a one shot task or start executing a continuous task
    */
    @Override
    public void startExecuting() {
        this.resetPatienceTicks();
        super.startExecuting();
    }

    /**
    * Keep ticking a continuous task that has already been started
    */
    @Override
    public void tick() {
        this.reducePatienceTicks();
        super.tick();
    }

}