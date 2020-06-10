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
    public boolean isSprinting();
    public boolean isSneaking();
    public boolean isSwimming();
    default boolean isWalking() {return false;}
        
}   