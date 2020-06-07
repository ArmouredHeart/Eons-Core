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

    /** This is called in the living animations tick, and performs the animation matching the defined state in the enitity. */
    public <A extends Entity & IEonsAnimationState> void doAnimations(A entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        switch(entity.getState()) {
            case FLYING: {this.animationFly(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case SWIMMING: {this.animationSwim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case IDLE: {this.animationIdle(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case WALKING: {this.animationWalk(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case RUNNING: {this.animationRun(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case SNEAKING: {this.animationSneak(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case CLIMBING: {this.animationClimb(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case POUNCING: {this.animationPounce(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case EATING: {this.animationEat(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case SLEEPING: {this.animationSleep(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case ATTACKING: {this.animationAttack(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case THREATENING: {this.animationThreat(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            case ON_SHOULDER: {this.animationOnShoulder(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale); break;}
            default: {/** Possible invalid animation state? */break;}
        }
    }
    
    // override these in model to use them
    protected void animationWalk(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationRun(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSwim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSneak(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationIdle(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationThreat(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationEat(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationAttack(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationPounce(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationFly(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationClimb(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationOnShoulder(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}
    protected void animationSleep(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {}

}