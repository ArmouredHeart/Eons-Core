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

    /** */
    @OnlyIn(Dist.CLIENT)
    public EonsAnimationState getState();

    /** */
    @OnlyIn(Dist.CLIENT)
    public void setState(EonsAnimationState state);
}   