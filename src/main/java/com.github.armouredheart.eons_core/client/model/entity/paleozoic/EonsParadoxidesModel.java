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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsParadoxidesEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

/**
 * Paradoxides - Accentaur, ArmouredHeart
 * Created using Tabula 7.0.0
 */
public class EonsParadoxidesModel<T extends EonsParadoxidesEntity> extends EonsEntityModel<T> {
    // *** Attributes ***
    public RendererModel body;
    public RendererModel head;
    public RendererModel torso;
    public RendererModel segment1;
    public RendererModel segment2;
    public RendererModel llegs;
    public RendererModel rlegs;
    public RendererModel head2;
    public RendererModel snout;
    public RendererModel Rhadespikes;
    public RendererModel antennaR;
    public RendererModel Lhadespikes;
    public RendererModel antennaL;
    public RendererModel shape4;
    public RendererModel shape4_1;
    public RendererModel antennaR2;
    public RendererModel antennaR3;
    public RendererModel shape4_2;
    public RendererModel shape4_3;
    public RendererModel antennaL2;
    public RendererModel antennaL3;
    public RendererModel end;
    public RendererModel segmeant3;
    public RendererModel segment4;
    public RendererModel llegs2;
    public RendererModel rlegs2;
    public RendererModel segment5;
    public RendererModel segment6;
    public RendererModel Ltailstart;
    public RendererModel segment7;
    public RendererModel Rtailstart;
    public RendererModel Rtailantenna;
    public RendererModel Ltailantenna;
    public RendererModel llegs3;
    public RendererModel Llegs3;
    public RendererModel Rplat5;
    public RendererModel Lplat5;
    public RendererModel Rplate6;
    public RendererModel Lplate6;
    public RendererModel Ltailend;
    public RendererModel shape4_4;
    public RendererModel shape4_5;
    public RendererModel Rtailend;
    public RendererModel Rplate3;
    public RendererModel Lplate3;
    public RendererModel Rplate4;
    public RendererModel Lplate4;
    public RendererModel Rplate1;
    public RendererModel Lplate1;
    public RendererModel Rplate2;
    public RendererModel Lplate2;

	// *** Constructors ***
    public EonsParadoxidesModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.antennaL2 = new RendererModel(this, 0, 37);
        this.antennaL2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaL2.addBox(0.0F, -0.5F, 0.0F, 0, 1, 5, 0.0F);
        this.setRotateAngle(antennaL2, 0.0F, -1.1383037381507017F, 0.0F);
        this.shape4_4 = new RendererModel(this, 30, 16);
        this.shape4_4.setRotationPoint(1.9F, 0.7F, 1.5F);
        this.shape4_4.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(shape4_4, 0.0F, -2.504198410761464F, 0.40142572795869574F);
        this.shape4_1 = new RendererModel(this, 48, 19);
        this.shape4_1.mirror = true;
        this.shape4_1.setRotationPoint(1.3F, 0.0F, -0.1F);
        this.shape4_1.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(shape4_1, 0.0F, -0.22759093446006054F, 0.0F);
        this.llegs2 = new RendererModel(this, 0, 50);
        this.llegs2.setRotationPoint(-2.4F, 1.4F, 0.0F);
        this.llegs2.addBox(0.0F, 0.0F, -0.5F, 0, 1, 7, 0.0F);
        this.Ltailantenna = new RendererModel(this, 0, 35);
        this.Ltailantenna.setRotationPoint(0.0F, 0.7F, 6.0F);
        this.Ltailantenna.addBox(0.0F, -0.5F, 0.0F, 0, 1, 7, 0.0F);
        this.setRotateAngle(Ltailantenna, 0.0F, -0.15603243512829304F, 0.0F);
        this.Lplate2 = new RendererModel(this, 49, 37);
        this.Lplate2.setRotationPoint(-4.9F, 0.2F, 1.8F);
        this.Lplate2.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Lplate2, 0.0F, -2.276432943376204F, -0.40980330836826856F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(0.0F, 23.5F, -1.0F);
        this.body.addBox(-2.0F, -1.5F, -4.0F, 4, 3, 8, 0.0F);
        this.Lplate6 = new RendererModel(this, 54, 4);
        this.Lplate6.setRotationPoint(-2.3F, 0.5F, 1.5F);
        this.Lplate6.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Lplate6, 0.0F, -2.1855012893472994F, -0.40142572795869574F);
        this.Rplate2 = new RendererModel(this, 49, 37);
        this.Rplate2.setRotationPoint(4.9F, 0.2F, 1.8F);
        this.Rplate2.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Rplate2, 0.0F, -2.276432943376204F, 0.40980330836826856F);
        this.Rplat5 = new RendererModel(this, 40, 19);
        this.Rplat5.setRotationPoint(2.6F, 0.3F, 1.6F);
        this.Rplat5.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Rplat5, 0.0F, -2.1855012893472994F, 0.40142572795869574F);
        this.shape4_2 = new RendererModel(this, 30, 17);
        this.shape4_2.mirror = true;
        this.shape4_2.setRotationPoint(0.2F, -0.2F, 7.7F);
        this.shape4_2.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
        this.setRotateAngle(shape4_2, 0.0F, -0.6829473363053812F, 0.0F);
        this.segment2 = new RendererModel(this, 0, 46);
        this.segment2.setRotationPoint(0.0F, -0.5F, -0.2F);
        this.segment2.addBox(-4.5F, 0.0F, 0.0F, 9, 2, 4, 0.0F);
        this.snout = new RendererModel(this, 24, 5);
        this.snout.setRotationPoint(0.0F, 1.4F, -1.9F);
        this.snout.addBox(-2.0F, -0.5F, -2.0F, 4, 1, 4, 0.0F);
        this.head = new RendererModel(this, 16, 0);
        this.head.setRotationPoint(0.0F, -0.5F, -4.4F);
        this.head.addBox(-6.5F, -1.0F, -2.5F, 13, 2, 3, 0.0F);
        this.Llegs3 = new RendererModel(this, 0, 51);
        this.Llegs3.setRotationPoint(2.0F, 1.4F, 0.0F);
        this.Llegs3.addBox(0.0F, 0.0F, -0.5F, 0, 1, 7, 0.0F);
        this.shape4_5 = new RendererModel(this, 30, 16);
        this.shape4_5.setRotationPoint(-1.9F, 0.7F, 1.5F);
        this.shape4_5.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(shape4_5, 0.0F, -2.504198410761464F, -0.40142572795869574F);
        this.Rtailend = new RendererModel(this, 30, 19);
        this.Rtailend.mirror = true;
        this.Rtailend.setRotationPoint(-0.4F, 0.0F, 2.5F);
        this.Rtailend.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Rtailend, 0.0F, 0.7740535232594852F, 0.0F);
        this.Rplate1 = new RendererModel(this, 49, 37);
        this.Rplate1.setRotationPoint(5.3F, 0.2F, 1.8F);
        this.Rplate1.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Rplate1, 0.0F, -2.276432943376204F, 0.40980330836826856F);
        this.Rplate4 = new RendererModel(this, 49, 37);
        this.Rplate4.setRotationPoint(4.3F, 0.2F, 1.8F);
        this.Rplate4.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Rplate4, 0.0F, -2.276432943376204F, 0.40980330836826856F);
        this.llegs = new RendererModel(this, 0, 47);
        this.llegs.setRotationPoint(-2.4F, 1.4F, 0.0F);
        this.llegs.addBox(0.0F, 0.0F, -4.5F, 0, 1, 9, 0.0F);
        this.Ltailstart = new RendererModel(this, 0, 0);
        this.Ltailstart.mirror = true;
        this.Ltailstart.setRotationPoint(0.0F, 0.7F, 6.1F);
        this.Ltailstart.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Ltailstart, 0.0F, -0.8196066167365371F, 0.0F);
        this.Lplate3 = new RendererModel(this, 49, 37);
        this.Lplate3.setRotationPoint(-4.6F, 0.2F, 1.8F);
        this.Lplate3.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Lplate3, 0.0F, -2.276432943376204F, -0.40980330836826856F);
        this.Ltailend = new RendererModel(this, 0, 4);
        this.Ltailend.mirror = true;
        this.Ltailend.setRotationPoint(-0.4F, 0.0F, 2.5F);
        this.Ltailend.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Ltailend, 0.0F, 0.7740535232594852F, 0.0F);
        this.segment6 = new RendererModel(this, 46, 33);
        this.segment6.setRotationPoint(0.0F, 0.5F, 1.6F);
        this.segment6.addBox(-2.5F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
        this.Rtailantenna = new RendererModel(this, 0, 35);
        this.Rtailantenna.setRotationPoint(0.0F, 0.7F, 6.0F);
        this.Rtailantenna.addBox(0.0F, -0.5F, 0.0F, 0, 1, 7, 0.0F);
        this.setRotateAngle(Rtailantenna, 0.0F, 0.15603243512829304F, 0.0F);
        this.Rhadespikes = new RendererModel(this, 40, 10);
        this.Rhadespikes.setRotationPoint(-1.5F, -0.5F, -1.6F);
        this.Rhadespikes.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 8, 0.0F);
        this.setRotateAngle(Rhadespikes, 0.0F, -0.8196066167365371F, 0.0F);
        this.segment7 = new RendererModel(this, 16, 5);
        this.segment7.setRotationPoint(0.0F, 0.0F, 4.6F);
        this.segment7.addBox(-2.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
        this.shape4 = new RendererModel(this, 30, 17);
        this.shape4.mirror = true;
        this.shape4.setRotationPoint(-0.2F, -0.2F, 7.7F);
        this.shape4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 8, 0.0F);
        this.setRotateAngle(shape4, 0.0F, 0.6829473363053812F, 0.0F);
        this.segment4 = new RendererModel(this, 0, 31);
        this.segment4.setRotationPoint(0.0F, -0.4F, 3.2F);
        this.segment4.addBox(-3.5F, 0.0F, 0.0F, 7, 2, 4, 0.0F);
        this.head2 = new RendererModel(this, 0, 15);
        this.head2.setRotationPoint(0.0F, -0.4F, -1.4F);
        this.head2.addBox(-3.5F, 0.0F, -3.0F, 7, 2, 3, 0.0F);
        this.Rplate6 = new RendererModel(this, 54, 4);
        this.Rplate6.setRotationPoint(2.3F, 0.5F, 1.5F);
        this.Rplate6.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Rplate6, 0.0F, -2.1855012893472994F, 0.40142572795869574F);
        this.antennaR3 = new RendererModel(this, 0, 27);
        this.antennaR3.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaR3.addBox(0.0F, -0.5F, 0.0F, 0, 1, 15, 0.0F);
        this.setRotateAngle(antennaR3, 3.141592653589793F, -2.5178119789270195F, 0.0F);
        this.antennaR2 = new RendererModel(this, 0, 37);
        this.antennaR2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaR2.addBox(0.0F, -0.5F, 0.0F, 0, 1, 5, 0.0F);
        this.setRotateAngle(antennaR2, 0.0F, 1.1383037381507017F, 0.0F);
        this.Lplate4 = new RendererModel(this, 49, 37);
        this.Lplate4.setRotationPoint(-4.3F, 0.2F, 1.8F);
        this.Lplate4.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Lplate4, 0.0F, -2.276432943376204F, -0.40980330836826856F);
        this.segmeant3 = new RendererModel(this, 34, 26);
        this.segmeant3.setRotationPoint(0.0F, -0.5F, -0.6F);
        this.segmeant3.addBox(-4.0F, 0.0F, 0.0F, 8, 2, 4, 0.0F);
        this.Lhadespikes = new RendererModel(this, 40, 10);
        this.Lhadespikes.setRotationPoint(1.5F, -0.5F, -1.6F);
        this.Lhadespikes.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 8, 0.0F);
        this.setRotateAngle(Lhadespikes, 0.0F, 0.8196066167365371F, 0.0F);
        this.shape4_3 = new RendererModel(this, 48, 19);
        this.shape4_3.mirror = true;
        this.shape4_3.setRotationPoint(-1.3F, 0.0F, -0.1F);
        this.shape4_3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(shape4_3, 0.0F, 0.22759093446006054F, 0.0F);
        this.Rplate3 = new RendererModel(this, 49, 37);
        this.Rplate3.setRotationPoint(4.6F, 0.2F, 1.8F);
        this.Rplate3.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Rplate3, 0.0F, -2.276432943376204F, 0.40980330836826856F);
        this.Lplate1 = new RendererModel(this, 49, 37);
        this.Lplate1.setRotationPoint(-5.3F, 0.2F, 1.8F);
        this.Lplate1.addBox(-1.5F, 0.5F, -1.5F, 3, 1, 3, 0.0F);
        this.setRotateAngle(Lplate1, 0.0F, -2.276432943376204F, -0.40980330836826856F);
        this.torso = new RendererModel(this, 41, 0);
        this.torso.setRotationPoint(0.0F, 0.1F, 4.0F);
        this.torso.addBox(-1.5F, -1.5F, -0.5F, 3, 3, 7, 0.0F);
        this.Lplat5 = new RendererModel(this, 40, 19);
        this.Lplat5.setRotationPoint(-2.6F, 0.7F, 1.6F);
        this.Lplat5.addBox(-1.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Lplat5, 0.0F, -2.1855012893472994F, -0.40142572795869574F);
        this.rlegs = new RendererModel(this, 0, 47);
        this.rlegs.setRotationPoint(2.4F, 1.4F, 0.0F);
        this.rlegs.addBox(0.0F, 0.0F, -4.5F, 0, 1, 9, 0.0F);
        this.segment5 = new RendererModel(this, 31, 32);
        this.segment5.setRotationPoint(0.0F, 0.0F, -0.5F);
        this.segment5.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 3, 0.0F);
        this.antennaL3 = new RendererModel(this, 0, 27);
        this.antennaL3.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.antennaL3.addBox(0.0F, -0.5F, 0.0F, 0, 1, 15, 0.0F);
        this.setRotateAngle(antennaL3, 3.141592653589793F, 2.5178119789270195F, 0.0F);
        this.end = new RendererModel(this, 18, 25);
        this.end.setRotationPoint(0.0F, 0.1F, 6.5F);
        this.end.addBox(-1.0F, -1.5F, 0.0F, 2, 2, 6, 0.0F);
        this.segment1 = new RendererModel(this, 20, 10);
        this.segment1.setRotationPoint(0.0F, -0.5F, -4.2F);
        this.segment1.addBox(-5.0F, 0.0F, 0.0F, 10, 2, 4, 0.0F);
        this.llegs3 = new RendererModel(this, 0, 51);
        this.llegs3.setRotationPoint(-2.0F, 1.4F, 0.0F);
        this.llegs3.addBox(0.0F, 0.0F, -0.5F, 0, 1, 7, 0.0F);
        this.antennaL = new RendererModel(this, 0, 37);
        this.antennaL.setRotationPoint(1.5F, 0.0F, -0.9F);
        this.antennaL.addBox(0.0F, -0.5F, 0.0F, 0, 1, 5, 0.0F);
        this.setRotateAngle(antennaL, 0.0F, 2.2689280275926285F, 0.0F);
        this.antennaR = new RendererModel(this, 0, 37);
        this.antennaR.setRotationPoint(-1.5F, 0.0F, -0.9F);
        this.antennaR.addBox(0.0F, -0.5F, 0.0F, 0, 1, 5, 0.0F);
        this.setRotateAngle(antennaR, 0.0F, -2.2689280275926285F, 0.0F);
        this.Rtailstart = new RendererModel(this, 54, 0);
        this.Rtailstart.mirror = true;
        this.Rtailstart.setRotationPoint(0.0F, 0.8F, 6.1F);
        this.Rtailstart.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Rtailstart, 3.141592653589793F, -2.321986036853256F, 0.0F);
        this.rlegs2 = new RendererModel(this, 0, 50);
        this.rlegs2.setRotationPoint(2.4F, 1.4F, 0.0F);
        this.rlegs2.addBox(0.0F, 0.0F, -0.5F, 0, 1, 7, 0.0F);
        this.antennaL.addChild(this.antennaL2);
        this.segment7.addChild(this.shape4_4);
        this.shape4.addChild(this.shape4_1);
        this.torso.addChild(this.llegs2);
        this.end.addChild(this.Ltailantenna);
        this.segment2.addChild(this.Lplate2);
        this.segment6.addChild(this.Lplate6);
        this.segment2.addChild(this.Rplate2);
        this.segment5.addChild(this.Rplat5);
        this.Lhadespikes.addChild(this.shape4_2);
        this.body.addChild(this.segment2);
        this.head2.addChild(this.snout);
        this.body.addChild(this.head);
        this.end.addChild(this.Llegs3);
        this.segment7.addChild(this.shape4_5);
        this.Rtailstart.addChild(this.Rtailend);
        this.segment1.addChild(this.Rplate1);
        this.segment4.addChild(this.Rplate4);
        this.body.addChild(this.llegs);
        this.end.addChild(this.Ltailstart);
        this.segmeant3.addChild(this.Lplate3);
        this.Ltailstart.addChild(this.Ltailend);
        this.end.addChild(this.segment6);
        this.end.addChild(this.Rtailantenna);
        this.snout.addChild(this.Rhadespikes);
        this.end.addChild(this.segment7);
        this.Rhadespikes.addChild(this.shape4);
        this.torso.addChild(this.segment4);
        this.head.addChild(this.head2);
        this.segment6.addChild(this.Rplate6);
        this.antennaR2.addChild(this.antennaR3);
        this.antennaR.addChild(this.antennaR2);
        this.segment4.addChild(this.Lplate4);
        this.torso.addChild(this.segmeant3);
        this.snout.addChild(this.Lhadespikes);
        this.shape4_2.addChild(this.shape4_3);
        this.segmeant3.addChild(this.Rplate3);
        this.segment1.addChild(this.Lplate1);
        this.body.addChild(this.torso);
        this.segment5.addChild(this.Lplat5);
        this.body.addChild(this.rlegs);
        this.end.addChild(this.segment5);
        this.antennaL2.addChild(this.antennaL3);
        this.torso.addChild(this.end);
        this.body.addChild(this.segment1);
        this.end.addChild(this.llegs3);
        this.snout.addChild(this.antennaL);
        this.snout.addChild(this.antennaR);
        this.end.addChild(this.Rtailstart);
        this.torso.addChild(this.rlegs2);
    }
	// *** Methods ***
    
    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translatef(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translatef(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scaled(-0.35D, 0.25D, 0.25D);
        GlStateManager.translatef(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translatef(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
    }

    @Override
    protected void animationWalk(T entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.torso.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
        this.end.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}

}
