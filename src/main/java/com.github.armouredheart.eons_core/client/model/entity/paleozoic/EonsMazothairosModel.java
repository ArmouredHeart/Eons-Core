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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsMazothairosEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

/**
 * Mazothairos - Accentaur
 * Created using Tabula 7.1.0
 */

@OnlyIn(Dist.CLIENT)
public class EonsMazothairosModel<T extends EonsMazothairosEntity> extends EonsEntityModel<T> {
    // *** Attributes ***
    public RendererModel body1;
    public RendererModel body2;
    public RendererModel head;
    public RendererModel LWING1;
    public RendererModel Rleeg;
    public RendererModel Lleeg;
    public RendererModel RWING1;
    public RendererModel body3;
    public RendererModel LWING2;
    public RendererModel LWING3;
    public RendererModel Rleeg_1;
    public RendererModel Lleeg_1;
    public RendererModel Rleeg_2;
    public RendererModel Lleeg_2;
    public RendererModel RWING3;
    public RendererModel RWING2;
    public RendererModel tail1;
    public RendererModel tail1_1;
    public RendererModel umknown2;
    public RendererModel umknown2_1;

	 // *** Constructors ***
    public EonsMazothairosModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.RWING1 = new RendererModel(this, 0, 10);
        this.RWING1.setRotationPoint(-0.5F, -0.4F, -0.4F);
        this.RWING1.addBox(-2.0F, 0.0F, -0.5F, 2, 0, 1, 0.0F);
        this.setRotateAngle(RWING1, -0.004886921905584123F, -0.36425021489121656F, 0.0F);
        this.umknown2 = new RendererModel(this, 0, 21);
        this.umknown2.setRotationPoint(0.1F, 0.0F, -0.2F);
        this.umknown2.addBox(0.0F, -0.5F, -3.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(umknown2, -0.5462880558742251F, -0.5462880558742251F, 0.0F);
        this.umknown2_1 = new RendererModel(this, 0, 21);
        this.umknown2_1.setRotationPoint(0.1F, 0.0F, -0.2F);
        this.umknown2_1.addBox(0.0F, -0.5F, -3.0F, 0, 1, 3, 0.0F);
        this.setRotateAngle(umknown2_1, -0.5462880558742251F, 0.5462880558742251F, 0.0F);
        this.RWING2 = new RendererModel(this, 0, 7);
        this.RWING2.mirror = true;
        this.RWING2.setRotationPoint(-1.1F, -0.4F, 0.6F);
        this.RWING2.addBox(-6.0F, 0.0F, -0.9F, 6, 0, 2, 0.0F);
        this.setRotateAngle(RWING2, 0.0F, -0.091106186954104F, 0.0F);
        this.LWING3 = new RendererModel(this, 0, 12);
        this.LWING3.setRotationPoint(1.0F, -0.4F, 2.2F);
        this.LWING3.addBox(0.0F, 0.0F, -1.0F, 5, 0, 2, 0.0F);
        this.setRotateAngle(LWING3, 0.0F, -0.22759093446006054F, 0.0F);
        this.RWING3 = new RendererModel(this, 0, 12);
        this.RWING3.mirror = true;
        this.RWING3.setRotationPoint(-1.0F, -0.4F, 2.2F);
        this.RWING3.addBox(-5.0F, 0.0F, -1.0F, 5, 0, 2, 0.0F);
        this.setRotateAngle(RWING3, 0.0F, 0.22759093446006054F, 0.0F);
        this.LWING1 = new RendererModel(this, 0, 10);
        this.LWING1.setRotationPoint(0.5F, -0.4F, -0.4F);
        this.LWING1.addBox(0.0F, 0.0F, -0.5F, 2, 0, 1, 0.0F);
        this.setRotateAngle(LWING1, -0.004886921905584123F, 0.36425021489121656F, 0.0F);
        this.body3 = new RendererModel(this, 16, 0);
        this.body3.setRotationPoint(0.1F, 0.0F, 3.9F);
        this.body3.addBox(-1.0F, -0.5F, 0.1F, 2, 1, 4, 0.0F);
        this.setRotateAngle(body3, -0.18203784098300857F, 0.0F, 0.0F);
        this.Rleeg_2 = new RendererModel(this, 16, 9);
        this.Rleeg_2.setRotationPoint(-1.1F, -0.1F, 0.6F);
        this.Rleeg_2.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Rleeg_2, 0.36425021489121656F, 0.0F, 0.5918411493512771F);
        this.Lleeg_2 = new RendererModel(this, 16, 9);
        this.Lleeg_2.setRotationPoint(1.1F, -0.1F, 2.3F);
        this.Lleeg_2.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Lleeg_2, 0.36425021489121656F, 0.0F, -0.5918411493512771F);
        this.body2 = new RendererModel(this, 2, 0);
        this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body2.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 4, 0.0F);
        this.body1 = new RendererModel(this, 0, 0);
        this.body1.setRotationPoint(0.0F, 21.9F, 0.0F);
        this.body1.addBox(-0.9F, -0.5F, -1.0F, 2, 1, 1, 0.0F);
        this.Rleeg = new RendererModel(this, 16, 9);
        this.Rleeg.setRotationPoint(-0.6F, 0.0F, 0.2F);
        this.Rleeg.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Rleeg, -0.7632324818971202F, 0.0F, 0.40980330836826856F);
        this.tail1 = new RendererModel(this, 0, 18);
        this.tail1.setRotationPoint(-0.5F, 0.1F, 3.6F);
        this.tail1.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
        this.setRotateAngle(tail1, 0.0F, -0.5201081170943103F, 0.0F);
        this.LWING2 = new RendererModel(this, 0, 7);
        this.LWING2.setRotationPoint(1.1F, -0.4F, 0.6F);
        this.LWING2.addBox(0.0F, 0.0F, -0.9F, 6, 0, 2, 0.0F);
        this.setRotateAngle(LWING2, 0.0F, 0.091106186954104F, 0.0F);
        this.Lleeg_1 = new RendererModel(this, 16, 9);
        this.Lleeg_1.setRotationPoint(1.1F, -0.1F, 0.6F);
        this.Lleeg_1.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Lleeg_1, 0.36425021489121656F, 0.0F, -0.5918411493512771F);
        this.Lleeg = new RendererModel(this, 16, 9);
        this.Lleeg.setRotationPoint(0.8F, 0.0F, 0.2F);
        this.Lleeg.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Lleeg, -0.7632324818971202F, 0.0F, -0.40980330836826856F);
        this.Rleeg_1 = new RendererModel(this, 16, 9);
        this.Rleeg_1.setRotationPoint(-1.1F, -0.1F, 2.3F);
        this.Rleeg_1.addBox(0.0F, 0.0F, -0.5F, 0, 3, 1, 0.0F);
        this.setRotateAngle(Rleeg_1, 0.4468042885105484F, 0.0F, 0.6373942428283291F);
        this.head = new RendererModel(this, 12, 0);
        this.head.setRotationPoint(0.0F, 0.0F, -1.1F);
        this.head.addBox(-0.5F, -0.5F, -0.7F, 1, 1, 1, 0.0F);
        this.setRotateAngle(head, 0.22759093446006054F, 0.0F, 0.0F);
        this.tail1_1 = new RendererModel(this, 0, 18);
        this.tail1_1.setRotationPoint(0.5F, 0.1F, 3.6F);
        this.tail1_1.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
        this.setRotateAngle(tail1_1, 0.0F, 0.5201081170943103F, 0.0F);
        this.body1.addChild(this.RWING1);
        this.head.addChild(this.umknown2);
        this.head.addChild(this.umknown2_1);
        this.body2.addChild(this.RWING2);
        this.body2.addChild(this.LWING3);
        this.body2.addChild(this.RWING3);
        this.body1.addChild(this.LWING1);
        this.body2.addChild(this.body3);
        this.body2.addChild(this.Rleeg_2);
        this.body2.addChild(this.Lleeg_2);
        this.body1.addChild(this.body2);
        this.body1.addChild(this.Rleeg);
        this.body3.addChild(this.tail1);
        this.body2.addChild(this.LWING2);
        this.body2.addChild(this.Lleeg_1);
        this.body1.addChild(this.Lleeg);
        this.body2.addChild(this.Rleeg_1);
        this.body1.addChild(this.head);
        this.body3.addChild(this.tail1_1);
    }

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body1.render(f5);
    }

    /*protected void animationFly(){
        this.haed.rotateAngleY = f3 / (180f / (float) Math.PI);
        this.haed.rotateAngleX = f4 / (180f / (float) Math.PI);
        this.LWING1.rotateAngleZ = MathHelper. cos( f * 1.0F) * -1.0F * f1;
        this.LWING2.rotateAngleZ = MathHelper. cos( f * 1.0F) * -1.0F * f1;
        this.LWING3.rotateAngleZ = MathHelper. cos( f * 1.0F) * -1.0F * f1;
        this.RWING1.rotateAngleZ = MathHelper. cos( f * -1.0F) * 1.0F * f1;
        this.RWING2.rotateAngleZ = MathHelper. cos( f * -1.0F) * 1.0F * f1;
        this.RWING3.rotateAngleZ = MathHelper. cos( f * -1.0F) * 1.0F * f1;
    }*/
}
