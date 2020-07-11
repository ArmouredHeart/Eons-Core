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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAraxocerasEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

@OnlyIn(Dist.CLIENT)
public class EonsAraxocerasModel<T extends EonsAraxocerasEntity> extends EonsEntityModel<T> {

    // *** Attributes ***
    public RendererModel shell;
    public RendererModel dome;
    public RendererModel head;
    public RendererModel roll1;
    public RendererModel eye;
    public RendererModel tentical;
    public RendererModel tentical_1;
    public RendererModel tentical_2;
    public RendererModel tentical_3;
    public RendererModel tentical_4;
    public RendererModel tentical_5;
    public RendererModel eye_1;
    public RendererModel roll2;
    public RendererModel roll3;
    public RendererModel roll4;

    // *** Constructors ***
    public EonsAraxocerasModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.roll3 = new RendererModel(this, 45, 4);
        this.roll3.setRotationPoint(0.0F, -0.1F, 2.8F);
        this.roll3.addBox(-3.0F, 0.0F, -0.5F, 6, 3, 1, 0.0F);
        this.roll4 = new RendererModel(this, 16, 5);
        this.roll4.setRotationPoint(0.0F, 2.2F, -2.7F);
        this.roll4.addBox(-3.0F, 0.0F, -0.8F, 6, 1, 4, 0.0F);
        this.tentical_4 = new RendererModel(this, 36, 0);
        this.tentical_4.setRotationPoint(-0.5F, 0.5F, -3.0F);
        this.tentical_4.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical_4, 0.31869712141416456F, 0.27314402793711257F, 0.0F);
        this.eye_1 = new RendererModel(this, 18, 0);
        this.eye_1.mirror = true;
        this.eye_1.setRotationPoint(-1.0F, -0.1F, -0.7F);
        this.eye_1.addBox(-2.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(eye_1, 0.0F, -0.40980330836826856F, 0.0F);
        this.eye = new RendererModel(this, 18, 0);
        this.eye.setRotationPoint(1.0F, -0.1F, -0.7F);
        this.eye.addBox(0.0F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotateAngle(eye, 0.0F, 0.40980330836826856F, 0.0F);
        this.tentical = new RendererModel(this, 36, 0);
        this.tentical.setRotationPoint(1.5F, 0.0F, -3.0F);
        this.tentical.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical, 0.0F, -0.27314402793711257F, 0.0F);
        this.roll1 = new RendererModel(this, 30, 0);
        this.roll1.setRotationPoint(0.0F, -1.7F, -1.3F);
        this.roll1.addBox(-2.0F, 0.0F, -0.5F, 4, 2, 1, 0.0F);
        this.roll2 = new RendererModel(this, 42, 0);
        this.roll2.setRotationPoint(0.0F, 0.0F, -0.2F);
        this.roll2.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
        this.shell = new RendererModel(this, 0, 0);
        this.shell.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.shell.addBox(-1.5F, -2.5F, -2.5F, 3, 5, 5, 0.0F);
        this.head = new RendererModel(this, 21, 0);
        this.head.setRotationPoint(0.0F, 1.0F, -1.8F);
        this.head.addBox(-1.5F, -1.0F, -3.0F, 3, 2, 3, 0.0F);
        this.tentical_3 = new RendererModel(this, 36, 0);
        this.tentical_3.setRotationPoint(0.5F, -0.5F, -3.0F);
        this.tentical_3.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical_3, -0.31869712141416456F, -0.27314402793711257F, 0.0F);
        this.tentical_1 = new RendererModel(this, 36, 0);
        this.tentical_1.setRotationPoint(-1.5F, 0.0F, -3.0F);
        this.tentical_1.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical_1, 0.0F, 0.27314402793711257F, 0.0F);
        this.tentical_2 = new RendererModel(this, 36, 0);
        this.tentical_2.setRotationPoint(-0.5F, -0.5F, -3.0F);
        this.tentical_2.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical_2, -0.31869712141416456F, 0.27314402793711257F, 0.0F);
        this.tentical_5 = new RendererModel(this, 36, 0);
        this.tentical_5.setRotationPoint(0.5F, 0.5F, -3.0F);
        this.tentical_5.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(tentical_5, 0.31869712141416456F, -0.27314402793711257F, 0.0F);
        this.dome = new RendererModel(this, 11, 0);
        this.dome.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.dome.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(dome, 0.7740535232594852F, 0.0F, 0.0F);
        this.roll2.addChild(this.roll3);
        this.roll3.addChild(this.roll4);
        this.head.addChild(this.tentical_4);
        this.head.addChild(this.eye_1);
        this.head.addChild(this.eye);
        this.head.addChild(this.tentical);
        this.shell.addChild(this.roll1);
        this.roll1.addChild(this.roll2);
        this.shell.addChild(this.head);
        this.head.addChild(this.tentical_3);
        this.head.addChild(this.tentical_1);
        this.head.addChild(this.tentical_2);
        this.head.addChild(this.tentical_5);
        this.shell.addChild(this.dome);
    }

    // *** Methods ***

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.shell.offsetX, this.shell.offsetY, this.shell.offsetZ);
        GlStateManager.translatef(this.shell.rotationPointX * f5, this.shell.rotationPointY * f5, this.shell.rotationPointZ * f5);
        GlStateManager.scaled(0.7D, 0.7D, 0.7D);
        GlStateManager.translatef(-this.shell.offsetX, -this.shell.offsetY, -this.shell.offsetZ);
        GlStateManager.translatef(-this.shell.rotationPointX * f5, -this.shell.rotationPointY * f5, -this.shell.rotationPointZ * f5);
        this.shell.render(f5);
        GlStateManager.popMatrix();
    }
    
    @Override
    protected void animationSwim(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.tentical_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.tentical_4.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
        this.tentical_3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.tentical_5.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
        this.tentical.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.tentical_1.rotateAngleY = MathHelper.cos (f * 1.0F) * -1.0F * f1;
    }
}
