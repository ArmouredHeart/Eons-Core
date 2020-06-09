// package
package com.github.armouredheart.eons_core.client.model.entity.cenozoic;

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
/**
 * Yellow perch - Accentaur
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsYellowPerchModel<T extends Entity> extends EonsEntityModel<T> {
// *** Attributes ***
    public RendererModel shape1;
    public RendererModel shape2;
    public RendererModel shape5;
    public RendererModel shape5_1;
    public RendererModel shape7;
    public RendererModel shape5_2;
    public RendererModel shape7_1;
    public RendererModel tail;
    public RendererModel tailfin;

// *** Constructors ***

    public EonsYellowPerchModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1 = new RendererModel(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 22.3F, 0.0F);
        this.shape1.addBox(-1.0F, -2.0F, -2.5F, 2, 4, 4, 0.0F);
        this.shape5 = new RendererModel(this, 0, 16);
        this.shape5.setRotationPoint(0.0F, -1.8F, -0.7F);
        this.shape5.addBox(0.0F, -2.0F, -1.0F, 0, 2, 2, 0.0F);
        this.shape5_2 = new RendererModel(this, 5, 11);
        this.shape5_2.setRotationPoint(0.0F, 1.2F, 1.0F);
        this.shape5_2.addBox(0.0F, 0.0F, -0.5F, 0, 2, 1, 0.0F);
        this.setRotateAngle(shape5_2, 0.31869712141416456F, 0.0F, 0.0F);
        this.shape7_1 = new RendererModel(this, 5, 8);
        this.shape7_1.setRotationPoint(-1.0F, 1.0F, -1.5F);
        this.shape7_1.addBox(0.0F, -1.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(shape7_1, 0.40980330836826856F, -0.7853981633974483F, 0.0F);
        this.tail = new RendererModel(this, 8, 0);
        this.tail.setRotationPoint(0.0F, -0.5F, 3.7F);
        this.tail.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.shape2 = new RendererModel(this, 0, 0);
        this.shape2.setRotationPoint(0.0F, 0.5F, -2.4F);
        this.shape2.addBox(-0.5F, -1.5F, -1.0F, 1, 3, 1, 0.0F);
        this.shape5_1 = new RendererModel(this, 0, 13);
        this.shape5_1.setRotationPoint(0.0F, -1.3F, 1.5F);
        this.shape5_1.addBox(0.0F, -2.0F, -1.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(shape5_1, -0.31869712141416456F, 0.0F, 0.0F);
        this.shape7 = new RendererModel(this, 5, 8);
        this.shape7.setRotationPoint(1.0F, 1.0F, -1.5F);
        this.shape7.addBox(0.0F, -1.0F, 0.0F, 0, 2, 1, 0.0F);
        this.setRotateAngle(shape7, 0.40980330836826856F, 0.7853981633974483F, 0.0F);
        this.tailfin = new RendererModel(this, 0, 7);
        this.tailfin.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.tailfin.addBox(0.0F, -2.0F, -0.5F, 0, 4, 2, 0.0F);
        this.shape1.addChild(this.shape5);
        this.shape1.addChild(this.shape5_2);
        this.shape1.addChild(this.shape7_1);
        this.shape2.addChild(this.tail);
        this.shape1.addChild(this.shape2);
        this.shape1.addChild(this.shape5_1);
        this.shape1.addChild(this.shape7);
        this.tail.addChild(this.tailfin);
    }

   // *** Methods ***
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GlStateManager.translatef(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GlStateManager.scaled(0.8D, 0.5D, 1.0D);
        GlStateManager.translatef(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GlStateManager.translatef(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(RendererModel rendererModel, float x, float y, float z) {
        rendererModel.rotateAngleX = x;
        rendererModel.rotateAngleY = y;
        rendererModel.rotateAngleZ = z;
    }
}
