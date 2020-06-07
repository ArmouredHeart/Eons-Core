// package
package com.github.armouredheart.eons_core.client;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsAnimationState;

// misc imports

@OnlyIn(Dist.CLIENT)
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