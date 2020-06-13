// package
package com.github.armouredheart.eons_core.client.model.entity.paleozoic;

// Minecraft imports
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.client.model.entity.EonsEntityModel;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAnomalocarisEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

/**
 * Anomalocaris - Accentaur
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsAnomalocarisModel<T extends EonsAnomalocarisEntity> extends EonsEntityModel<T> {
	 // *** Attributes ***
    public RendererModel body;
    public RendererModel neck;
    public RendererModel body2;
    public RendererModel wingL1;
    public RendererModel wingL2;
    public RendererModel wingR1;
    public RendererModel wingR2;
    public RendererModel head;
    public RendererModel eyesR;
    public RendererModel eyesL;
    public RendererModel joint1;
    public RendererModel joint2;
    public RendererModel shape7R;
    public RendererModel shape7L;
    public RendererModel clawthing1;
    public RendererModel armL1;
    public RendererModel ArmL2;
    public RendererModel ArmL3;
    public RendererModel clawthing2;
    public RendererModel armR1;
    public RendererModel ArmR2;
    public RendererModel ArmR3;
    public RendererModel body3;
    public RendererModel wingL3;
    public RendererModel wingL4;
    public RendererModel wingR3;
    public RendererModel wingR4;
    public RendererModel shape1;
    public RendererModel wingL5;
    public RendererModel wingL6;
    public RendererModel wingR5;
    public RendererModel wingR6;
    public RendererModel tailwingR1;
    public RendererModel tailthingR1;
    public RendererModel tailwingR2;
    public RendererModel tailwingR3;
    public RendererModel tailthingL1;
    public RendererModel tailwingL1;
    public RendererModel tailwingL2;
    public RendererModel tailwingL3;
    public RendererModel wingL7;
    public RendererModel wingR7;

	// *** Constructors ***
    public EonsAnomalocarisModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body3 = new RendererModel(this, 10, 8);
        this.body3.setRotationPoint(0.0F, 0.5F, 3.5F);
        this.body3.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 5, 0.0F);
        this.clawthing1 = new RendererModel(this, 6, 0);
        this.clawthing1.setRotationPoint(0.0F, 0.0F, -0.6F);
        this.clawthing1.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(clawthing1, 0.6829473363053812F, 0.0F, 0.0F);
        this.wingL6 = new RendererModel(this, 1, 18);
        this.wingL6.setRotationPoint(2.5F, 0.0F, 3.5F);
        this.wingL6.addBox(0.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.armR1 = new RendererModel(this, 10, 0);
        this.armR1.setRotationPoint(0.1F, -0.1F, -0.6F);
        this.armR1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(armR1, -1.0016444577195458F, 0.0F, 0.0F);
        this.tailwingR3 = new RendererModel(this, 0, 2);
        this.tailwingR3.setRotationPoint(-1.6F, -0.2F, 6.0F);
        this.tailwingR3.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingR3, 2.41309222380736F, -0.22759093446006054F, -0.7740535232594852F);
        this.neck = new RendererModel(this, 26, 0);
        this.neck.mirror = true;
        this.neck.setRotationPoint(0.0F, 0.5F, -2.0F);
        this.neck.addBox(-2.0F, -1.0F, -6.0F, 4, 2, 6, 0.0F);
        this.wingR4 = new RendererModel(this, -1, 18);
        this.wingR4.mirror = true;
        this.wingR4.setRotationPoint(-2.5F, 0.5F, 3.0F);
        this.wingR4.addBox(-7.0F, 0.0F, -1.5F, 7, 0, 3, 0.0F);
        this.wingL4 = new RendererModel(this, -1, 18);
        this.wingL4.setRotationPoint(2.5F, 0.5F, 3.0F);
        this.wingL4.addBox(0.0F, 0.0F, -1.5F, 7, 0, 3, 0.0F);
        this.shape1 = new RendererModel(this, 38, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 4.1F);
        this.shape1.addBox(-2.0F, -0.5F, 0.0F, 4, 1, 8, 0.0F);
        this.wingR3 = new RendererModel(this, 0, 18);
        this.wingR3.mirror = true;
        this.wingR3.setRotationPoint(-2.5F, 0.5F, 1.0F);
        this.wingR3.addBox(-6.0F, 0.0F, -1.5F, 6, 0, 3, 0.0F);
        this.wingR7 = new RendererModel(this, 2, 18);
        this.wingR7.mirror = true;
        this.wingR7.setRotationPoint(-0.7F, 0.0F, 1.4F);
        this.wingR7.addBox(-4.0F, 0.0F, -1.5F, 4, 0, 3, 0.0F);
        this.ArmL2 = new RendererModel(this, 10, 0);
        this.ArmL2.mirror = true;
        this.ArmL2.setRotationPoint(-0.1F, 1.5F, -0.2F);
        this.ArmL2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ArmL2, 0.7853981633974483F, 0.0F, 0.0F);
        this.wingR1 = new RendererModel(this, 2, 18);
        this.wingR1.mirror = true;
        this.wingR1.setRotationPoint(-2.5F, 0.5F, -1.5F);
        this.wingR1.addBox(-4.0F, 0.0F, -1.5F, 4, 0, 3, 0.0F);
        this.wingL7 = new RendererModel(this, 2, 18);
        this.wingL7.setRotationPoint(1.7F, 0.0F, 1.4F);
        this.wingL7.addBox(0.0F, 0.0F, -1.5F, 4, 0, 3, 0.0F);
        this.eyesR = new RendererModel(this, 0, 0);
        this.eyesR.setRotationPoint(-2.0F, -0.4F, -1.9F);
        this.eyesR.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(eyesR, 2.0488420089161434F, 0.0F, -0.36425021489121656F);
        this.tailwingL3 = new RendererModel(this, 0, 2);
        this.tailwingL3.setRotationPoint(1.4F, -0.2F, 6.0F);
        this.tailwingL3.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingL3, 2.41309222380736F, 0.22759093446006054F, 0.8651597102135892F);
        this.joint1 = new RendererModel(this, 6, 0);
        this.joint1.setRotationPoint(1.2F, 0.4F, -3.0F);
        this.joint1.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.wingL2 = new RendererModel(this, 1, 18);
        this.wingL2.setRotationPoint(2.5F, 0.5F, 0.5F);
        this.wingL2.addBox(0.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.tailwingL1 = new RendererModel(this, 0, 2);
        this.tailwingL1.setRotationPoint(1.4F, -0.2F, 4.0F);
        this.tailwingL1.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingL1, 2.41309222380736F, 0.18203784098300857F, 0.5918411493512771F);
        this.wingL1 = new RendererModel(this, 2, 18);
        this.wingL1.setRotationPoint(2.5F, 0.5F, -1.5F);
        this.wingL1.addBox(0.0F, 0.0F, -1.5F, 4, 0, 3, 0.0F);
        this.armL1 = new RendererModel(this, 10, 0);
        this.armL1.setRotationPoint(-0.1F, -0.1F, -0.6F);
        this.armL1.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(armL1, -1.0016444577195458F, 0.0F, 0.0F);
        this.ArmL3 = new RendererModel(this, 10, 0);
        this.ArmL3.mirror = true;
        this.ArmL3.setRotationPoint(-0.1F, 1.5F, -0.2F);
        this.ArmL3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ArmL3, 0.7853981633974483F, 0.0F, 0.0F);
        this.tailthingR1 = new RendererModel(this, 1, 13);
        this.tailthingR1.setRotationPoint(-1.0F, 0.0F, 7.0F);
        this.tailthingR1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 13, 0.0F);
        this.tailwingL2 = new RendererModel(this, 0, 2);
        this.tailwingL2.setRotationPoint(1.4F, -0.2F, 5.0F);
        this.tailwingL2.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingL2, 2.41309222380736F, 0.22759093446006054F, 0.6373942428283291F);
        this.shape7R = new RendererModel(this, 26, 0);
        this.shape7R.setRotationPoint(-0.7F, -0.4F, 1.3F);
        this.shape7R.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.shape7L = new RendererModel(this, 26, 0);
        this.shape7L.mirror = true;
        this.shape7L.setRotationPoint(-0.7F, -0.4F, 1.3F);
        this.shape7L.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.eyesL = new RendererModel(this, 0, 0);
        this.eyesL.setRotationPoint(1.1F, -0.6F, -1.9F);
        this.eyesL.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(eyesL, 2.0488420089161434F, 0.0F, 0.3490658503988659F);
        this.tailwingR1 = new RendererModel(this, 0, 2);
        this.tailwingR1.setRotationPoint(-1.6F, -0.2F, 4.0F);
        this.tailwingR1.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingR1, 2.41309222380736F, -0.18203784098300857F, -0.40980330836826856F);
        this.wingL5 = new RendererModel(this, 0, 18);
        this.wingL5.setRotationPoint(2.5F, 0.0F, 1.6F);
        this.wingL5.addBox(0.0F, 0.0F, -1.5F, 6, 0, 3, 0.0F);
        this.ArmR3 = new RendererModel(this, 10, 0);
        this.ArmR3.mirror = true;
        this.ArmR3.setRotationPoint(0.1F, 1.5F, -0.2F);
        this.ArmR3.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ArmR3, 0.7853981633974483F, 0.0F, 0.0F);
        this.tailthingL1 = new RendererModel(this, 1, 13);
        this.tailthingL1.setRotationPoint(1.0F, 0.0F, 7.0F);
        this.tailthingL1.addBox(0.0F, -0.5F, 0.0F, 0, 1, 13, 0.0F);
        this.wingR5 = new RendererModel(this, 0, 18);
        this.wingR5.mirror = true;
        this.wingR5.setRotationPoint(-2.5F, 0.0F, 1.6F);
        this.wingR5.addBox(-6.0F, 0.0F, -1.5F, 6, 0, 3, 0.0F);
        this.clawthing2 = new RendererModel(this, 6, 0);
        this.clawthing2.setRotationPoint(0.0F, 0.0F, -0.8F);
        this.clawthing2.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(clawthing2, 0.6829473363053812F, 0.0F, 0.0F);
        this.body = new RendererModel(this, 9, 8);
        this.body.setRotationPoint(0.0F, 18.1F, -5.2F);
        this.body.addBox(-3.0F, -1.0F, -3.0F, 6, 3, 5, 0.0F);
        this.head = new RendererModel(this, 40, 9);
        this.head.setRotationPoint(0.0F, 0.0F, -4.7F);
        this.head.addBox(-2.5F, -1.0F, -4.0F, 5, 2, 4, 0.0F);
        this.joint2 = new RendererModel(this, 6, 0);
        this.joint2.setRotationPoint(-1.2F, 0.4F, -3.0F);
        this.joint2.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1, 0.0F);
        this.wingR6 = new RendererModel(this, 1, 18);
        this.wingR6.mirror = true;
        this.wingR6.setRotationPoint(-2.5F, 0.0F, 3.5F);
        this.wingR6.addBox(-5.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.body2 = new RendererModel(this, 9, 8);
        this.body2.mirror = true;
        this.body2.setRotationPoint(0.0F, 0.1F, 1.5F);
        this.body2.addBox(-3.0F, -1.0F, 0.0F, 6, 3, 5, 0.0F);
        this.ArmR2 = new RendererModel(this, 10, 0);
        this.ArmR2.mirror = true;
        this.ArmR2.setRotationPoint(0.1F, 1.5F, -0.2F);
        this.ArmR2.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(ArmR2, 0.7853981633974483F, 0.0F, 0.0F);
        this.tailwingR2 = new RendererModel(this, 0, 2);
        this.tailwingR2.setRotationPoint(-1.6F, -0.2F, 5.0F);
        this.tailwingR2.addBox(0.0F, 0.0F, -1.0F, 0, 5, 2, 0.0F);
        this.setRotateAngle(tailwingR2, 2.41309222380736F, -0.22759093446006054F, -0.5462880558742251F);
        this.wingR2 = new RendererModel(this, 1, 18);
        this.wingR2.mirror = true;
        this.wingR2.setRotationPoint(-2.5F, 0.5F, 0.5F);
        this.wingR2.addBox(-5.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.wingL3 = new RendererModel(this, 0, 18);
        this.wingL3.setRotationPoint(2.5F, 0.5F, 1.0F);
        this.wingL3.addBox(0.0F, 0.0F, -1.5F, 6, 0, 3, 0.0F);
        this.body2.addChild(this.body3);
        this.joint1.addChild(this.clawthing1);
        this.body3.addChild(this.wingL6);
        this.clawthing2.addChild(this.armR1);
        this.shape1.addChild(this.tailwingR3);
        this.body.addChild(this.neck);
        this.body2.addChild(this.wingR4);
        this.body2.addChild(this.wingL4);
        this.body3.addChild(this.shape1);
        this.body2.addChild(this.wingR3);
        this.shape1.addChild(this.wingR7);
        this.armL1.addChild(this.ArmL2);
        this.body.addChild(this.wingR1);
        this.shape1.addChild(this.wingL7);
        this.head.addChild(this.eyesR);
        this.shape1.addChild(this.tailwingL3);
        this.head.addChild(this.joint1);
        this.body.addChild(this.wingL2);
        this.shape1.addChild(this.tailwingL1);
        this.body.addChild(this.wingL1);
        this.clawthing1.addChild(this.armL1);
        this.ArmL2.addChild(this.ArmL3);
        this.shape1.addChild(this.tailthingR1);
        this.shape1.addChild(this.tailwingL2);
        this.eyesR.addChild(this.shape7R);
        this.eyesL.addChild(this.shape7L);
        this.head.addChild(this.eyesL);
        this.shape1.addChild(this.tailwingR1);
        this.body3.addChild(this.wingL5);
        this.ArmR2.addChild(this.ArmR3);
        this.shape1.addChild(this.tailthingL1);
        this.body3.addChild(this.wingR5);
        this.joint2.addChild(this.clawthing2);
        this.neck.addChild(this.head);
        this.head.addChild(this.joint2);
        this.body3.addChild(this.wingR6);
        this.body.addChild(this.body2);
        this.armR1.addChild(this.ArmR2);
        this.shape1.addChild(this.tailwingR2);
        this.body.addChild(this.wingR2);
        this.body2.addChild(this.wingL3);
    }
	// *** Methods ***

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.body.render(f5);
    }

       @Override
    protected void animationBreathing(T entity, float f, float f1, float f2, float f3, float f4, float f5){
        this.wingR2.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.wingR1.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR6.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.wingR5.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR4.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.wingR3.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingL4.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.wingL3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL2.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.wingL1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
        this.wingR7.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingL7.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL6.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
        this.wingL5.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
         this.tailwingL1.rotateAngleZ = MathHelper.cos(f * 0.3331F) * f1;
         this.tailwingL2.rotateAngleZ = MathHelper.cos(f * 0.50F) * -0.5F * f1;
        this.tailwingL3.rotateAngleZ = MathHelper.cos(f * 0.3331F) * f1;
        this.tailwingR1.rotateAngleX = MathHelper.cos(f * 0.50F) * 0.50F * f1;
        this.tailwingR2.rotateAngleX = MathHelper.cos(f * 0.3331F + (float) Math.PI) * f1;
        this.tailwingR3.rotateAngleX = MathHelper.cos(f * 0.50F) * 0.50F * f1;
    }
  @Override
    protected void animationSwim(T entity, float f, float f1, float f2, float f3, float f4, float f5){
        this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.body.rotateAngleX = MathHelper.cos(f * 0.3331F) * f1;
        this.body3.rotateAngleX = MathHelper.cos(f * 0.25F) * -0.25F * f1;
        this.tailthingL1.rotateAngleX = MathHelper.cos(f * 0.3331F) * f1;
        this.tailthingR1.rotateAngleX = MathHelper.cos(f * 0.3331F) * f1;
        
    }

    @Override
    protected void animationAttack(T entity, float f, float f1, float f2, float f3, float f4, float f5){
        this.joint1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        this.joint2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
        // continue swimming while attacking
        //this.animationSwim(entity, f, f1, f2, f3, f4, f5);
    }
}
