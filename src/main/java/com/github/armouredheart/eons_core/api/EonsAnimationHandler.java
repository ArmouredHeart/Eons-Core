// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports

// misc imports

public class EonsAnimationHandler {
    // *** Attributes ***
    private EonsAnimationState move_state;
    private EonsAnimationState action_state;
    
    // *** Constructors ***

    //
    public EonsAnimationHandler() {
        this.resetStates();
    }

    // *** Methods ***

    //
    public EonsAnimationState getMovementState() {
        return this.move_state;
    }

    //
    public void setMovementState(EonsAnimationState state) {
        this.move_state = state;
    }

    //
    public EonsAnimationState getActionState() {
        return this.action_state;
    }

    //
    public void setActionState(EonsAnimationState state) {
        this.action_state = state;
    }

    //
    public void resetStates() {
        this.setActionState(EonsAnimationState.IDLE);
        this.setMovementState(EonsAnimationState.IDLE);
    }

    // *** Inner Classes ***

    //
    public enum EonsAnimationState {
        FLYING(),
        SWIMMING(),
        IDLE(),
        WALKING(),
        RUNNING(),
        SNEAKING(),
        CLIMBING(),
        POUNCING(),
        EATING(),
        ATTACKING(),
        THREATENING(),
        SLEEPING(),
        ON_SHOULDER();
    
        // *** Attributes ***
    
        // *** Constructors ***
    
        /** */
        private EonsAnimationState() {}
    
        // *** Methods ***
    }
}