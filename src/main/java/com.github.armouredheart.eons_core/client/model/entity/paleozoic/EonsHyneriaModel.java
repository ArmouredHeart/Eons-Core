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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsHyneriaEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

@OnlyIn(Dist.CLIENT)
public class EonsHyneriaModel<T extends EonsHyneriaEntity> extends EonsEntityModel<T> {

    // *** Attributes ***
    public RendererModel body;
    public RendererModel tail1;
    public RendererModel JointN;
    public RendererModel Larm;
    public RendererModel topfin;
    public RendererModel Rarm;
    public RendererModel tail2;
    public RendererModel Lleg;
    public RendererModel topfin_1;
    public RendererModel topfin_2;
    public RendererModel Lleg_1;
    public RendererModel shape67;
    public RendererModel Bfin;
    public RendererModel tailfin;
    public RendererModel tailfin_1;
    public RendererModel tailfin_2;
    public RendererModel bottomfin;
    public RendererModel Larmfin;
    public RendererModel Larmfin_1;
    public RendererModel head;
    public RendererModel shape3;
    public RendererModel shape43;
    public RendererModel shape3_1;
    public RendererModel shape43_1;
    public RendererModel jaw;
    public RendererModel shape43_2;
    public RendererModel Larmfin_2;
    public RendererModel Larmfin_3;

    // *** Constructors ***
    public EonsHyneriaModel() {
        this.textureWidth = 100;
        this.textureHeight = 100;
        this.topfin_2 = new RendererModel(this, 47, 0);
        this.topfin_2.setRotationPoint(0.0F, -4.8F, 10.2F);
        this.topfin_2.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 2, 0.0F);
        this.Larmfin = new RendererModel(this, 43, 5);
        this.Larmfin.setRotationPoint(0.0F, 1.6F, 0.8F);
        this.Larmfin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(Larmfin, -0.9560913642424937F, 0.0F, 0.0F);
        this.shape43_1 = new RendererModel(this, 61, 42);
        this.shape43_1.setRotationPoint(0.0F, -1.0F, -6.4F);
        this.shape43_1.addBox(-2.5F, 0.0F, 0.0F, 5, 2, 7, 0.0F);
        this.topfin = new RendererModel(this, 11, 0);
        this.topfin.setRotationPoint(0.0F, -4.8F, 6.0F);
        this.topfin.addBox(-0.5F, -3.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(topfin, -0.36425021489121656F, 0.0F, 0.0F);
        this.jaw = new RendererModel(this, 36, 36);
        this.jaw.setRotationPoint(0.0F, 2.0F, 6.5F);
        this.jaw.addBox(-3.5F, -1.0F, -6.0F, 7, 2, 6, 0.0F);
        this.shape43 = new RendererModel(this, 16, 30);
        this.shape43.mirror = true;
        this.shape43.setRotationPoint(0.0F, 1.6F, -6.4F);
        this.shape43.addBox(-3.5F, 0.0F, 0.0F, 7, 1, 6, 0.0F);
        this.setRotateAngle(shape43, -0.136659280431156F, 0.0F, 0.0F);
        this.tail2 = new RendererModel(this, 40, 20);
        this.tail2.setRotationPoint(0.0F, -1.3F, 11.5F);
        this.tail2.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 10, 0.0F);
        this.Larmfin_3 = new RendererModel(this, 43, 5);
        this.Larmfin_3.setRotationPoint(0.0F, 2.5F, 0.8F);
        this.Larmfin_3.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(Larmfin_3, -0.9560913642424937F, 0.0F, 0.0F);
        this.Bfin = new RendererModel(this, 53, 0);
        this.Bfin.setRotationPoint(0.0F, 2.2F, 2.0F);
        this.Bfin.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Bfin, 0.9105382707654417F, 0.0F, 0.0F);
        this.tailfin_2 = new RendererModel(this, 33, 6);
        this.tailfin_2.setRotationPoint(0.0F, -6.6F, 1.3F);
        this.tailfin_2.addBox(-0.5F, -3.0F, -2.5F, 1, 5, 3, 0.0F);
        this.setRotateAngle(tailfin_2, -0.7285004297824331F, 0.0F, 0.0F);
        this.shape43_2 = new RendererModel(this, 75, 32);
        this.shape43_2.setRotationPoint(-2.0F, -2.0F, -12.5F);
        this.shape43_2.addBox(0.0F, 1.0F, 0.0F, 4, 2, 8, 0.0F);
        this.shape3_1 = new RendererModel(this, 58, 20);
        this.shape3_1.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.shape3_1.addBox(-2.5F, 0.0F, -4.0F, 5, 2, 3, 0.0F);
        this.setRotateAngle(shape3_1, 0.22759093446006054F, 0.0F, 0.0F);
        this.Rarm = new RendererModel(this, 1, 0);
        this.Rarm.setRotationPoint(-4.0F, 3.0F, -6.0F);
        this.Rarm.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotateAngle(Rarm, 0.36425021489121656F, 0.0F, 0.0F);
        this.Lleg_1 = new RendererModel(this, 33, 0);
        this.Lleg_1.setRotationPoint(-3.0F, 3.0F, 2.0F);
        this.Lleg_1.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Lleg_1, 0.6829473363053812F, 0.0F, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 16.3F, -13.0F);
        this.body.addBox(-4.0F, -5.0F, -8.5F, 8, 10, 17, 0.0F);
        this.bottomfin = new RendererModel(this, 43, 5);
        this.bottomfin.setRotationPoint(0.0F, 1.8F, 0.6F);
        this.bottomfin.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(bottomfin, -1.2747884856566583F, 0.0F, 0.0F);
        this.tail1 = new RendererModel(this, 50, 0);
        this.tail1.setRotationPoint(0.0F, 0.7F, 6.5F);
        this.tail1.addBox(-3.0F, -5.0F, 0.0F, 6, 8, 12, 0.0F);
        this.tailfin_1 = new RendererModel(this, 7, 5);
        this.tailfin_1.setRotationPoint(0.0F, 1.4F, 2.4F);
        this.tailfin_1.addBox(-0.5F, 0.0F, -2.5F, 1, 5, 4, 0.0F);
        this.setRotateAngle(tailfin_1, 0.40980330836826856F, 0.0F, 0.0F);
        this.shape3 = new RendererModel(this, 0, 27);
        this.shape3.mirror = true;
        this.shape3.setRotationPoint(0.0F, -2.1F, -5.1F);
        this.shape3.addBox(-3.0F, 0.0F, -5.0F, 6, 4, 5, 0.0F);
        this.setRotateAngle(shape3, 0.07086036763096977F, 0.0F, 0.0F);
        this.Larmfin_1 = new RendererModel(this, 43, 5);
        this.Larmfin_1.setRotationPoint(0.0F, 1.6F, 0.8F);
        this.Larmfin_1.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(Larmfin_1, -0.9560913642424937F, 0.0F, 0.0F);
        this.Larm = new RendererModel(this, 1, 0);
        this.Larm.setRotationPoint(4.0F, 3.0F, -6.0F);
        this.Larm.addBox(-1.0F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotateAngle(Larm, 0.36425021489121656F, 0.0F, 0.0F);
        this.shape67 = new RendererModel(this, 74, 0);
        this.shape67.setRotationPoint(0.0F, 0.0F, 9.2F);
        this.shape67.addBox(-1.0F, -2.5F, 0.0F, 2, 5, 6, 0.0F);
        this.setRotateAngle(shape67, 0.31869712141416456F, 0.0F, 0.0F);
        this.tailfin = new RendererModel(this, 86, 6);
        this.tailfin.setRotationPoint(0.0F, -0.6F, 3.0F);
        this.tailfin.addBox(-0.5F, -7.0F, -2.5F, 1, 7, 5, 0.0F);
        this.setRotateAngle(tailfin, -1.0471975511965976F, 0.0F, 0.0F);
        this.JointN = new RendererModel(this, 0, 0);
        this.JointN.setRotationPoint(0.0F, 0.0F, -8.4F);
        this.JointN.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.topfin_1 = new RendererModel(this, 41, 0);
        this.topfin_1.setRotationPoint(0.0F, -4.8F, 8.0F);
        this.topfin_1.addBox(-0.5F, -5.0F, -0.5F, 1, 5, 2, 0.0F);
        this.setRotateAngle(topfin_1, -0.5918411493512771F, 0.0F, 0.0F);
        this.Larmfin_2 = new RendererModel(this, 43, 5);
        this.Larmfin_2.setRotationPoint(0.0F, 2.5F, 0.8F);
        this.Larmfin_2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(Larmfin_2, -0.9560913642424937F, 0.0F, 0.0F);
        this.Lleg = new RendererModel(this, 33, 0);
        this.Lleg.setRotationPoint(3.0F, 3.0F, 2.0F);
        this.Lleg.addBox(-1.0F, 0.0F, -1.5F, 2, 4, 2, 0.0F);
        this.setRotateAngle(Lleg, 0.6829473363053812F, 0.0F, 0.0F);
        this.head = new RendererModel(this, 68, 20);
        this.head.setRotationPoint(0.0F, -1.5F, 0.8F);
        this.head.addBox(-3.5F, -2.5F, -6.0F, 7, 5, 6, 0.0F);
        this.tail1.addChild(this.topfin_2);
        this.Lleg.addChild(this.Larmfin);
        this.shape43.addChild(this.shape43_1);
        this.body.addChild(this.topfin);
        this.shape43.addChild(this.jaw);
        this.head.addChild(this.shape43);
        this.tail1.addChild(this.tail2);
        this.Rarm.addChild(this.Larmfin_3);
        this.tail2.addChild(this.Bfin);
        this.tailfin.addChild(this.tailfin_2);
        this.jaw.addChild(this.shape43_2);
        this.shape3.addChild(this.shape3_1);
        this.body.addChild(this.Rarm);
        this.tail1.addChild(this.Lleg_1);
        this.Bfin.addChild(this.bottomfin);
        this.body.addChild(this.tail1);
        this.shape67.addChild(this.tailfin_1);
        this.head.addChild(this.shape3);
        this.Lleg_1.addChild(this.Larmfin_1);
        this.body.addChild(this.Larm);
        this.tail2.addChild(this.shape67);
        this.shape67.addChild(this.tailfin);
        this.body.addChild(this.JointN);
        this.tail1.addChild(this.topfin_1);
        this.Larm.addChild(this.Larmfin_2);
        this.tail1.addChild(this.Lleg);
        this.JointN.addChild(this.head);
    }

    // *** Methods ***

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translatef(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scaled(1.5D, 1.5D, 1.5D);
        GlStateManager.translatef(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translatef(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
    }
}
