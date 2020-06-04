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

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

@OnlyIn(Dist.CLIENT)
public class EonsSpathicephalusModel<T extends Entity> extends EonsEntityModel<T> {

    // *** Attributes ***
    public RendererModel shape1;
    public RendererModel neck;
    public RendererModel tale;
    public RendererModel Larm;
    public RendererModel Lleg;
    public RendererModel Larm_1;
    public RendererModel Lleg_1;
    public RendererModel shape3;
    public RendererModel jaw;
    public RendererModel eyes;
    public RendererModel tale_1;
    public RendererModel tale_2;

    // *** Constructors ***
    public EonsSpathicephalusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Lleg = new RendererModel(this, 38, 0);
        this.Lleg.setRotationPoint(2.0F, 0.5F, 3.0F);
        this.Lleg.addBox(0.0F, -1.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(Lleg, 0.0F, 0.0F, -0.22759093446006054F);
        this.jaw = new RendererModel(this, 38, 6);
        this.jaw.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.jaw.addBox(-2.5F, -0.5F, -5.0F, 5, 1, 5, 0.0F);
        this.Larm = new RendererModel(this, 0, 0);
        this.Larm.setRotationPoint(2.0F, 0.5F, -3.0F);
        this.Larm.addBox(0.0F, -1.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(Larm, 0.0F, 0.0F, -0.22759093446006054F);
        this.Larm_1 = new RendererModel(this, 0, 0);
        this.Larm_1.setRotationPoint(-2.0F, 0.5F, -3.0F);
        this.Larm_1.addBox(-1.0F, -1.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(Larm_1, 0.0F, 0.0F, 0.22759093446006054F);
        this.Lleg_1 = new RendererModel(this, 38, 0);
        this.Lleg_1.setRotationPoint(-2.0F, 0.5F, 3.0F);
        this.Lleg_1.addBox(-1.0F, -1.0F, -1.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(Lleg_1, 0.0F, 0.0F, 0.22759093446006054F);
        this.shape1 = new RendererModel(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 22.5F, 0.0F);
        this.shape1.addBox(-2.5F, -1.5F, -5.0F, 5, 3, 10, 0.0F);
        this.neck = new RendererModel(this, 20, 0);
        this.neck.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.neck.addBox(-2.0F, -1.0F, -1.5F, 4, 2, 2, 0.0F);
        this.tale_1 = new RendererModel(this, 25, 8);
        this.tale_1.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tale_1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(tale_1, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape3 = new RendererModel(this, 43, 0);
        this.shape3.setRotationPoint(0.0F, -0.4F, -1.0F);
        this.shape3.addBox(-2.5F, -0.5F, -5.0F, 5, 1, 5, 0.0F);
        this.eyes = new RendererModel(this, 0, 5);
        this.eyes.setRotationPoint(0.0F, -0.4F, -1.3F);
        this.eyes.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.tale = new RendererModel(this, 27, 0);
        this.tale.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tale.addBox(-1.5F, -1.0F, -0.5F, 3, 2, 5, 0.0F);
        this.setRotateAngle(tale, -0.22759093446006054F, 0.0F, 0.0F);
        this.tale_2 = new RendererModel(this, 34, 12);
        this.tale_2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.tale_2.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 5, 0.0F);
        this.shape1.addChild(this.Lleg);
        this.shape3.addChild(this.jaw);
        this.shape1.addChild(this.Larm);
        this.shape1.addChild(this.Larm_1);
        this.shape1.addChild(this.Lleg_1);
        this.shape1.addChild(this.neck);
        this.tale.addChild(this.tale_1);
        this.neck.addChild(this.shape3);
        this.shape3.addChild(this.eyes);
        this.shape1.addChild(this.tale);
        this.tale_1.addChild(this.tale_2);
    }

    // *** Methods ***

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GlStateManager.translatef(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GlStateManager.scaled(0.7D, 0.7D, 0.7D);
        GlStateManager.translatef(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GlStateManager.translatef(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GlStateManager.popMatrix();
    }
}
