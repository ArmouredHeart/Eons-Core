// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.client.EonsAnimationState;

// misc imports

@OnlyIn(Dist.CLIENT)
public interface IEonsAnimationState {

    // *** Methods ***

    //
    default void setSprinting(boolean sprinting) {}
    default boolean isSprinting() {return false;}

    //
    default void setSneaking(boolean sneaking) {}
    default boolean isSneaking() {return false;}

    //
    default void setThreatening(boolean threatening) {}
    default boolean isThreatening() {return false;}

    //
    default void setGrabbing(boolean grabbing) {}
    default boolean isGrabbing() {return false;}

    //
    default void setSleeping(boolean sleeping) {}
    default boolean isSleeping() {return false;}

    //
    default void setAttacking(boolean attacking) {}
    default boolean isAttacking() {return false;}

    //
    default void setPouncing(boolean pouncing) {}
    default boolean isPouncing() {return false;}

    //
    default void setSwimming(boolean swimming) {}
    default boolean isSwimming() {return false;}

    //
    default void setOnShoulder(boolean onShoulder) {}
    default boolean isOnShoulder() {return false;}

    //
    default void setClimbing(boolean climbing) {}
    default boolean isClimbing() {return false;}

    //
    default void setFlying(boolean flying) {}
    default boolean isFlying() {return false;}

    //
    default void setEating(boolean eating) {}
    default boolean isEating() {return false;}

}   