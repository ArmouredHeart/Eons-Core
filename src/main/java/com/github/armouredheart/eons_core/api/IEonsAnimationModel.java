// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsAnimationEntity;
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;

// misc imports

@OnlyIn(Dist.CLIENT)
public interface IEonsAnimationModel<T extends LivingEntity & IEonsAnimationEntity> {

    // *** Methods ***

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    default public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
        renderer.rotateAngleX = x;
        renderer.rotateAngleY = y;
        renderer.rotateAngleZ = z;
    }

    /**
     * @return void; performs animation tasks as directed by EonsAnimationHandler accessed through IEonsAnimationEntity.
     * @param entityIn
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     */
    default public void doAnimations(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        EonsAnimationHandler handler = entityIn.getAnimationHandler();
        // do movements
        switch(handler.getMovementState()) {
            case FLYING: {this.animationFly(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case SWIMMING: {this.animationSwim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case IDLE: {this.animationIdle(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case WALKING: {this.animationWalk(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case RUNNING: {this.animationRun(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case SNEAKING: {this.animationSneak(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case CLIMBING: {this.animationClimb(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case POUNCING: {this.animationPounce(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case SLEEPING: {this.animationSleep(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case ON_SHOULDER: {this.animationOnShoulder(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            default: {break;}
        }

        // do actions
        switch(handler.getActionState()) {
            case EATING: {this.animationEat(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case ATTACKING: {this.animationAttack(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            case THREATENING: {this.animationThreat(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch); break;}
            default: {break;}
        }
    }

    //animationWalk(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    // override these in model to use them

    /**
     * 
     * @param entityIn
     * @param limbSwing
     * @param limbSwingAmount
     * @param ageInTicks
     * @param netHeadYaw
     * @param headPitch
     */
    default public void animationWalk(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationRun(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationSwim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationSneak(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationIdle(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationThreat(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationEat(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationAttack(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationPounce(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationFly(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationClimb(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationOnShoulder(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationSleep(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
    default public void animationBreathing(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {} 
    default public void animationGrab(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}  
}