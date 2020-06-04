// package
package com.github.armouredheart.eons_core.client.model.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports

// misc imports

@OnlyIn(Dist.CLIENT)
public abstract class EonsEntityModel<T extends Entity> extends EntityModel<T> {
    
    // *** Attributes ***

    // *** Constructors ***

    // *** Methods ***

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }
    
    //protected abstract void animationWalk();

    //protected abstract void animationIdle();

    //protected abstract void animationRun();

    //protected abstract void animationSwim();
    
    //protected abstract void animationFly();

    //protected abstract void animationClimb();

    //protected abstract void animationJump();

    //protected abstract void animationSneak();

    //protected abstract void animationThreat();

    //protected abstract void animationEat();

    //protected abstract void animationAttack();

}