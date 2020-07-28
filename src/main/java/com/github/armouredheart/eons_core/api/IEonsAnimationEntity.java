// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;

// misc imports

public interface IEonsAnimationEntity {
    
    // *** Methods ***

    /** */
    public EonsAnimationHandler getAnimationHandler();
}