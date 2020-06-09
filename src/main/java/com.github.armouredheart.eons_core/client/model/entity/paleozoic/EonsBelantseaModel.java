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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsBelantseaEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

@OnlyIn(Dist.CLIENT)
public class EonsBelantseaModel<T extends EonsBelantseaEntity> extends EonsEntityModel<T> {
    public RendererModel body;
    public RendererModel tail1;
    public RendererModel head;
    public RendererModel sail1;
    public RendererModel FinL;
    public RendererModel FinR;
    public RendererModel tail2;
    public RendererModel sail2;
    public RendererModel Bsail1;
    public RendererModel tail3;
    public RendererModel shape4;

    public EonsBelantseaModel() {

        // *** Attributes ***
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.tail2 = new RendererModel(this, 10, 0);
        this.tail2.setRotationPoint(0.0F, -0.5F, 4.0F);
        this.tail2.addBox(-0.5F, -1.0F, 0.0F, 1, 2, 2, 0.0F);
        this.head = new RendererModel(this, 26, 0);
        this.head.setRotationPoint(0.0F, 0.8F, -1.4F);
        this.head.addBox(-1.0F, -2.0F, -2.5F, 2, 3, 3, 0.0F);
        this.setRotateAngle(head, -0.5009094953223726F, 0.0F, 0.0F);
        this.tail3 = new RendererModel(this, 11, 9);
        this.tail3.setRotationPoint(0.0F, 0.7F, 1.0F);
        this.tail3.addBox(0.0F, -1.0F, 0.0F, 0, 2, 4, 0.0F);
        this.setRotateAngle(tail3, 0.4553564018453205F, 0.0F, 0.0F);
        this.tail1 = new RendererModel(this, 14, 0);
        this.tail1.setRotationPoint(0.0F, 0.5F, 2.0F);
        this.tail1.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 4, 0.0F);
        this.Bsail1 = new RendererModel(this, 0, 25);
        this.Bsail1.setRotationPoint(0.0F, 1.3F, 3.0F);
        this.Bsail1.addBox(0.0F, 0.0F, -1.5F, 0, 2, 3, 0.0F);
        this.setRotateAngle(Bsail1, 0.5918411493512771F, 0.0F, 0.0F);
        this.sail2 = new RendererModel(this, 0, 19);
        this.sail2.setRotationPoint(0.0F, -2.0F, 3.0F);
        this.sail2.addBox(0.0F, -2.0F, -1.5F, 0, 3, 4, 0.0F);
        this.setRotateAngle(sail2, -0.31869712141416456F, 0.0F, 0.0F);
        this.shape4 = new RendererModel(this, 33, 0);
        this.shape4.setRotationPoint(0.0F, 1.0F, 0.2F);
        this.shape4.addBox(-1.0F, -0.3F, -2.2F, 2, 1, 2, 0.0F);
        this.setRotateAngle(shape4, 0.36425021489121656F, 0.0F, 0.0F);
        this.sail1 = new RendererModel(this, 0, 12);
        this.sail1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.sail1.addBox(0.0F, -3.0F, -1.5F, 0, 4, 4, 0.0F);
        this.setRotateAngle(sail1, -0.18203784098300857F, 0.0F, 0.0F);
        this.FinR = new RendererModel(this, 0, 7);
        this.FinR.setRotationPoint(-1.5F, 2.0F, 0.0F);
        this.FinR.addBox(0.0F, 0.0F, -2.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(FinR, 0.0F, 0.0F, 0.6829473363053812F);
        this.FinL = new RendererModel(this, 0, 7);
        this.FinL.setRotationPoint(1.5F, 2.0F, 0.0F);
        this.FinL.addBox(0.0F, 0.0F, -2.0F, 0, 3, 4, 0.0F);
        this.setRotateAngle(FinL, 0.0F, 0.0F, -0.6829473363053812F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 20.8F, 0.0F);
        this.body.addBox(-1.5F, -2.5F, -2.0F, 3, 5, 4, 0.0F);
        this.tail1.addChild(this.tail2);
        this.body.addChild(this.head);
        this.tail2.addChild(this.tail3);
        this.body.addChild(this.tail1);
        this.tail1.addChild(this.Bsail1);
        this.tail1.addChild(this.sail2);
        this.head.addChild(this.shape4);
        this.body.addChild(this.sail1);
        this.body.addChild(this.FinR);
        this.body.addChild(this.FinL);
    }

    // *** Methods ***

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translatef(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scaled(0.7D, 0.7D, 0.7D);
        GlStateManager.translatef(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translatef(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
    }
}
