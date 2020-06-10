// package
package com.github.armouredheart.eons_core.client.model.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsAnimationState;
import com.github.armouredheart.eons_core.client.EonsAnimationState;

// misc imports

@OnlyIn(Dist.CLIENT)
public abstract class EonsEntityModel<T extends Entity & IEonsAnimationState> extends EntityModel<T> {
    
    // *** Attributes ***
    private float partialTicks;
    // *** Constructors ***

    // *** Methods ***  

    /** */
    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        // movement render
        if(entityIn.isSprinting()){this.animationRun(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);}
        else if(entityIn.isSneaking()){this.animationSneak(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);}
        else if(entityIn.isSwimming()){this.animationSwim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);}
        else if(entityIn.isWalking()) {this.animationWalk(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);}

        // do animations
        //this.doMovementAnimations(movingState, entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
        //this.doActionAnimations(actionState, entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }

    /** This is called in the living animations tick, and performs the animation matching the defined state in the enitity. */
    public void doMovementAnimations(EonsAnimationState state, T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        switch(state) {
            case FLYING: {this.animationFly(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case SWIMMING: {this.animationSwim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case IDLE: {this.animationIdle(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case WALKING: {this.animationWalk(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case RUNNING: { break;}
            case SNEAKING: {this.animationSneak(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case CLIMBING: {this.animationClimb(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case POUNCING: {this.animationPounce(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case SLEEPING: {this.animationSleep(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case ON_SHOULDER: {this.animationOnShoulder(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
        }
    }

    /** This is called in the living animations tick, and performs the animation matching the defined state in the enitity. */
    public void doActionAnimations(EonsAnimationState state, T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        switch(state) {
            case EATING: {this.animationEat(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case ATTACKING: {this.animationAttack(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case THREATENING: {this.animationThreat(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
        }
    }
    
    // override these in model to use them
    protected void animationWalk(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationRun(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSwim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSneak(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationIdle(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationThreat(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationEat(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationAttack(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationPounce(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationFly(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationClimb(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationOnShoulder(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSleep(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}

}