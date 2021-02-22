// package
package com.github.armouredheart.eons_core.client.model.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsAnimationModel;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAnomalocarisEntity;

// misc imports
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

/**
 * dimetrodon  - Accentaur
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsAnomalocarisModel<T extends EonsAnomalocarisEntity> extends EntityModel<T> implements IEonsAnimationModel<T> {
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer body2;
    public ModelRenderer wingL1;
    public ModelRenderer wingL2;
    public ModelRenderer wingR1;
    public ModelRenderer wingR2;
    public ModelRenderer head;
    public ModelRenderer eyesL;
    public ModelRenderer jointL;
    public ModelRenderer part198;
    public ModelRenderer jointR;
    public ModelRenderer eyesR;
    public ModelRenderer shape7L;
    public ModelRenderer shape7L_1;
    public ModelRenderer clawthingL;
    public ModelRenderer armL1;
    public ModelRenderer part194;
    public ModelRenderer part194_1;
    public ModelRenderer ArmL2;
    public ModelRenderer ArmL3;
    public ModelRenderer part194_2;
    public ModelRenderer part194_3;
    public ModelRenderer part194_4;
    public ModelRenderer part194_5;
    public ModelRenderer clawthingR;
    public ModelRenderer armR1;
    public ModelRenderer part194_6;
    public ModelRenderer part194_7;
    public ModelRenderer armR2;
    public ModelRenderer armR3;
    public ModelRenderer part194_8;
    public ModelRenderer part194_9;
    public ModelRenderer part194_10;
    public ModelRenderer part194_11;
    public ModelRenderer shape7L_2;
    public ModelRenderer shape7L_3;
    public ModelRenderer body3;
    public ModelRenderer wingL3;
    public ModelRenderer wingL4;
    public ModelRenderer wingR3;
    public ModelRenderer wingR4;
    public ModelRenderer tail;
    public ModelRenderer wingL5;
    public ModelRenderer wingL6;
    public ModelRenderer wingR5;
    public ModelRenderer wingR6;
    public ModelRenderer wingL7;
    public ModelRenderer tail1;
    public ModelRenderer wingR7;
    public ModelRenderer tail2;
    public ModelRenderer tailwingL1;
    public ModelRenderer tailwingR1;
    public ModelRenderer tailwingL2;
    public ModelRenderer tailwingL3;
    public ModelRenderer tailantenal;
    public ModelRenderer tailantenar;
    public ModelRenderer tailwingR2;
    public ModelRenderer tailwingR3;

    public EonsAnomalocarisModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.wingL2 = new ModelRenderer(this, 14, 26);
        this.wingL2.setRotationPoint(2.5F, 0.9F, 0.5F);
        this.wingL2.addBox(0.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL2, 0.0F, -0.23457224414434488F, 0.0F);
        this.part194_1 = new ModelRenderer(this, 0, 0);
        this.part194_1.setRotationPoint(0.0F, 1.3F, 0.1F);
        this.part194_1.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.shape7L_2 = new ModelRenderer(this, 34, 0);
        this.shape7L_2.mirror = true;
        this.shape7L_2.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.shape7L_2.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, -0.2F, -0.2F, 0.0F);
        this.setRotateAngle(shape7L_2, 0.0F, 0.0F, 2.385515893794117F);
        this.tailwingL3 = new ModelRenderer(this, 48, 14);
        this.tailwingL3.setRotationPoint(1.2F, 0.0F, 0.3F);
        this.tailwingL3.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, -0.2F, -0.3F, 0.6F);
        this.setRotateAngle(tailwingL3, 0.15620696472454113F, 0.3909537457888271F, 0.0F);
        this.clawthingR = new ModelRenderer(this, 21, 0);
        this.clawthingR.setRotationPoint(0.0F, 0.0F, -0.9F);
        this.clawthingR.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(clawthingR, -1.1154399222864149F, 0.0F, 0.0F);
        this.part194 = new ModelRenderer(this, 0, 2);
        this.part194.setRotationPoint(0.0F, 0.8F, 0.1F);
        this.part194.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 38, 6);
        this.body2.mirror = true;
        this.body2.setRotationPoint(0.0F, 0.0F, 1.5F);
        this.body2.addBox(-3.0F, -1.0F, 0.0F, 6.0F, 3.0F, 5.0F, -0.1F, -0.1F, 0.0F);
        this.neck = new ModelRenderer(this, 22, 0);
        this.neck.mirror = true;
        this.neck.setRotationPoint(0.0F, 0.5F, -2.0F);
        this.neck.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.armR3 = new ModelRenderer(this, 59, 5);
        this.armR3.mirror = true;
        this.armR3.setRotationPoint(0.0F, 1.5F, -0.2F);
        this.armR3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.3F, 0.0F, -0.2F);
        this.setRotateAngle(armR3, 0.7459537515971485F, 0.0F, 0.0F);
        this.wingL1 = new ModelRenderer(this, 0, 26);
        this.wingL1.setRotationPoint(2.5F, 1.0F, -1.5F);
        this.wingL1.addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL1, 0.0F, -0.23457224414434488F, 0.0F);
        this.tailwingR1 = new ModelRenderer(this, 12, 17);
        this.tailwingR1.mirror = true;
        this.tailwingR1.setRotationPoint(-0.9F, 0.0F, 0.5F);
        this.tailwingR1.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 7.0F, -0.2F, -0.3F, 0.2F);
        this.setRotateAngle(tailwingR1, 0.19547687289441354F, -0.7819074915776542F, 0.0F);
        this.jointR = new ModelRenderer(this, 0, 0);
        this.jointR.setRotationPoint(-1.2F, 0.4F, -3.0F);
        this.jointR.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.wingL5 = new ModelRenderer(this, 23, 20);
        this.wingL5.setRotationPoint(2.2F, 0.1F, 1.5F);
        this.wingL5.addBox(0.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL5, 0.0F, -0.23457224414434488F, 0.0F);
        this.head = new ModelRenderer(this, 38, 0);
        this.head.setRotationPoint(0.0F, 0.0F, -3.7F);
        this.head.addBox(-2.5F, -1.0F, -4.0F, 5.0F, 2.0F, 4.0F, 0.0F, 0.1F, 0.0F);
        this.part194_8 = new ModelRenderer(this, 0, 0);
        this.part194_8.setRotationPoint(0.0F, 1.1F, -0.1F);
        this.part194_8.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tailwingR2 = new ModelRenderer(this, 34, 14);
        this.tailwingR2.mirror = true;
        this.tailwingR2.setRotationPoint(-1.5F, 0.0F, 0.4F);
        this.tailwingR2.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, -0.2F, -0.3F, 0.6F);
        this.setRotateAngle(tailwingR2, 0.19547687289441354F, -0.6255260065779288F, 0.0F);
        this.eyesR = new ModelRenderer(this, 17, 0);
        this.eyesR.setRotationPoint(-2.1F, -0.4F, -1.9F);
        this.eyesR.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(eyesR, 1.6880824738342042F, 0.0F, -1.1730357742864224F);
        this.part194_5 = new ModelRenderer(this, 0, 2);
        this.part194_5.setRotationPoint(0.0F, 1.6F, -0.2F);
        this.part194_5.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 0.8F, 0.0F, 0.0F, 0.0F);
        this.wingL6 = new ModelRenderer(this, 41, 20);
        this.wingL6.setRotationPoint(2.3F, 0.0F, 3.4F);
        this.wingL6.addBox(0.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL6, 0.0F, -0.23457224414434488F, 0.0F);
        this.wingR3 = new ModelRenderer(this, 27, 24);
        this.wingR3.mirror = true;
        this.wingR3.setRotationPoint(-2.5F, 0.8F, 1.0F);
        this.wingR3.addBox(-6.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR3, 0.0F, 0.23457224414434488F, 0.0F);
        this.armR2 = new ModelRenderer(this, 56, 3);
        this.armR2.mirror = true;
        this.armR2.setRotationPoint(0.0F, 1.5F, -0.2F);
        this.armR2.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, 0.0F, -0.1F);
        this.setRotateAngle(armR2, 0.7853981633974483F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 55, 8);
        this.tail2.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.tail2.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.part194_6 = new ModelRenderer(this, 0, 2);
        this.part194_6.setRotationPoint(0.0F, 0.8F, 0.1F);
        this.part194_6.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.part194_11 = new ModelRenderer(this, 0, 2);
        this.part194_11.setRotationPoint(0.0F, 1.6F, -0.2F);
        this.part194_11.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 0.8F, 0.0F, 0.0F, 0.0F);
        this.part194_4 = new ModelRenderer(this, 0, 3);
        this.part194_4.setRotationPoint(0.0F, 1.1F, -0.2F);
        this.part194_4.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 0.8F, 0.0F, 0.0F, 0.0F);
        this.wingL3 = new ModelRenderer(this, 27, 24);
        this.wingL3.setRotationPoint(2.5F, 0.8F, 1.0F);
        this.wingL3.addBox(0.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL3, 0.0F, -0.23457224414434488F, 0.0F);
        this.tailwingR3 = new ModelRenderer(this, 48, 14);
        this.tailwingR3.mirror = true;
        this.tailwingR3.setRotationPoint(-1.2F, 0.0F, 0.3F);
        this.tailwingR3.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, -0.2F, -0.3F, 0.6F);
        this.setRotateAngle(tailwingR3, 0.15620696472454113F, -0.3909537457888271F, 0.0F);
        this.tail1 = new ModelRenderer(this, 29, 12);
        this.tail1.setRotationPoint(0.0F, 0.0F, 3.9F);
        this.tail1.addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.wingR2 = new ModelRenderer(this, 14, 26);
        this.wingR2.mirror = true;
        this.wingR2.setRotationPoint(-2.5F, 0.9F, 0.5F);
        this.wingR2.addBox(-5.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR2, 0.0F, 0.23457224414434488F, 0.0F);
        this.tail = new ModelRenderer(this, 15, 8);
        this.tail.setRotationPoint(0.0F, 0.0F, 4.6F);
        this.tail.addBox(-2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.3F, 0.0F);
        this.clawthingL = new ModelRenderer(this, 21, 0);
        this.clawthingL.setRotationPoint(0.0F, 0.0F, -0.9F);
        this.clawthingL.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(clawthingL, -1.1154399222864149F, 0.0F, 0.0F);
        this.shape7L_1 = new ModelRenderer(this, 34, 0);
        this.shape7L_1.mirror = true;
        this.shape7L_1.setRotationPoint(0.0F, 0.0F, 0.6F);
        this.shape7L_1.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, -0.4F, -0.4F, -0.2F);
        this.wingR7 = new ModelRenderer(this, 17, 13);
        this.wingR7.mirror = true;
        this.wingR7.setRotationPoint(-1.7F, -0.1F, 1.4F);
        this.wingR7.addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR7, 0.0F, 0.23457224414434488F, 0.0F);
        this.ArmL3 = new ModelRenderer(this, 59, 5);
        this.ArmL3.mirror = true;
        this.ArmL3.setRotationPoint(0.0F, 1.5F, -0.2F);
        this.ArmL3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.3F, 0.0F, -0.2F);
        this.setRotateAngle(ArmL3, 0.7459537515971485F, 0.0F, 0.0F);
        this.tailantenar = new ModelRenderer(this, 0, 15);
        this.tailantenar.setRotationPoint(-0.4F, 0.0F, 2.0F);
        this.tailantenar.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 10.0F, -0.4F, -0.4F, 0.0F);
        this.part198 = new ModelRenderer(this, 31, 6);
        this.part198.setRotationPoint(0.0F, 0.8F, -1.8F);
        this.part198.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, -0.3F, -0.3F, -0.3F);
        this.wingR4 = new ModelRenderer(this, 42, 25);
        this.wingR4.mirror = true;
        this.wingR4.setRotationPoint(-2.5F, 0.7F, 3.0F);
        this.wingR4.addBox(-7.0F, -0.5F, -1.5F, 7.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR4, 0.0F, 0.23457224414434488F, 0.0F);
        this.body3 = new ModelRenderer(this, 0, 8);
        this.body3.setRotationPoint(0.0F, 0.5F, 4.5F);
        this.body3.addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F, 0.0F, 0.2F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 19.1F, -5.0F);
        this.body.addBox(-3.0F, -1.0F, -3.0F, 6.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.wingR1 = new ModelRenderer(this, 0, 26);
        this.wingR1.mirror = true;
        this.wingR1.setRotationPoint(-2.5F, 1.0F, -1.5F);
        this.wingR1.addBox(-4.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR1, 0.0F, 0.23457224414434488F, 0.0F);
        this.wingR5 = new ModelRenderer(this, 23, 20);
        this.wingR5.mirror = true;
        this.wingR5.setRotationPoint(-2.2F, 0.1F, 1.5F);
        this.wingR5.addBox(-6.0F, -0.5F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR5, 0.0F, 0.23457224414434488F, 0.0F);
        this.jointL = new ModelRenderer(this, 0, 0);
        this.jointL.setRotationPoint(1.2F, 0.4F, -3.0F);
        this.jointL.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.armR1 = new ModelRenderer(this, 58, 0);
        this.armR1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armR1.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1F, 0.0F, 0.0F);
        this.setRotateAngle(armR1, -0.024260076353049827F, 0.0F, 0.0F);
        this.part194_7 = new ModelRenderer(this, 0, 0);
        this.part194_7.setRotationPoint(0.0F, 1.3F, 0.1F);
        this.part194_7.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tailwingL2 = new ModelRenderer(this, 34, 14);
        this.tailwingL2.setRotationPoint(1.5F, 0.0F, 0.4F);
        this.tailwingL2.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, -0.2F, -0.3F, 0.6F);
        this.setRotateAngle(tailwingL2, 0.19547687289441354F, 0.6255260065779288F, 0.0F);
        this.part194_10 = new ModelRenderer(this, 0, 3);
        this.part194_10.setRotationPoint(0.0F, 1.1F, -0.2F);
        this.part194_10.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 0.8F, 0.0F, 0.0F, 0.0F);
        this.part194_9 = new ModelRenderer(this, 1, 0);
        this.part194_9.setRotationPoint(0.0F, 1.6F, -0.1F);
        this.part194_9.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.shape7L_3 = new ModelRenderer(this, 34, 0);
        this.shape7L_3.mirror = true;
        this.shape7L_3.setRotationPoint(0.0F, 0.0F, 0.6F);
        this.shape7L_3.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, -0.4F, -0.4F, -0.2F);
        this.wingL4 = new ModelRenderer(this, 42, 25);
        this.wingL4.setRotationPoint(2.5F, 0.7F, 3.0F);
        this.wingL4.addBox(0.0F, -0.5F, -1.5F, 7.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL4, 0.0F, -0.23457224414434488F, 0.0F);
        this.wingR6 = new ModelRenderer(this, 41, 20);
        this.wingR6.mirror = true;
        this.wingR6.setRotationPoint(-2.2F, 0.0F, 3.4F);
        this.wingR6.addBox(-5.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingR6, 0.0F, 0.23457224414434488F, 0.0F);
        this.part194_2 = new ModelRenderer(this, 0, 0);
        this.part194_2.setRotationPoint(0.0F, 1.1F, -0.1F);
        this.part194_2.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tailwingL1 = new ModelRenderer(this, 12, 17);
        this.tailwingL1.setRotationPoint(0.9F, 0.0F, 0.5F);
        this.tailwingL1.addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 7.0F, -0.2F, -0.3F, 0.2F);
        this.setRotateAngle(tailwingL1, 0.19547687289441354F, 0.7819074915776542F, 0.0F);
        this.armL1 = new ModelRenderer(this, 58, 0);
        this.armL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armL1.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.1F, 0.0F, 0.0F);
        this.setRotateAngle(armL1, -0.024260076353049827F, 0.0F, 0.0F);
        this.ArmL2 = new ModelRenderer(this, 56, 3);
        this.ArmL2.mirror = true;
        this.ArmL2.setRotationPoint(0.0F, 1.5F, -0.2F);
        this.ArmL2.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, 0.0F, -0.1F);
        this.setRotateAngle(ArmL2, 0.7853981633974483F, 0.0F, 0.0F);
        this.shape7L = new ModelRenderer(this, 34, 0);
        this.shape7L.mirror = true;
        this.shape7L.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.shape7L.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, -0.2F, -0.2F, 0.0F);
        this.setRotateAngle(shape7L, 0.0F, 0.0F, 2.385515893794117F);
        this.eyesL = new ModelRenderer(this, 17, 0);
        this.eyesL.setRotationPoint(2.1F, -0.4F, -1.9F);
        this.eyesL.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(eyesL, 1.6880824738342042F, 0.0F, 1.1730357742864224F);
        this.wingL7 = new ModelRenderer(this, 17, 13);
        this.wingL7.setRotationPoint(1.7F, -0.1F, 1.4F);
        this.wingL7.addBox(0.0F, -0.5F, -1.5F, 4.0F, 1.0F, 3.0F, 0.0F, -0.3F, 0.0F);
        this.setRotateAngle(wingL7, 0.0F, -0.23457224414434488F, 0.0F);
        this.part194_3 = new ModelRenderer(this, 1, 0);
        this.part194_3.setRotationPoint(0.0F, 1.6F, -0.1F);
        this.part194_3.addBox(-0.1F, -0.1F, 0.0F, 0.2F, 0.2F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tailantenal = new ModelRenderer(this, 0, 15);
        this.tailantenal.setRotationPoint(0.4F, 0.0F, 2.0F);
        this.tailantenal.addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 10.0F, -0.4F, -0.4F, 0.0F);
        this.body.addChild(this.wingL2);
        this.armL1.addChild(this.part194_1);
        this.eyesR.addChild(this.shape7L_2);
        this.tail2.addChild(this.tailwingL3);
        this.jointR.addChild(this.clawthingR);
        this.armL1.addChild(this.part194);
        this.body.addChild(this.body2);
        this.body.addChild(this.neck);
        this.armR2.addChild(this.armR3);
        this.body.addChild(this.wingL1);
        this.tail1.addChild(this.tailwingR1);
        this.head.addChild(this.jointR);
        this.body3.addChild(this.wingL5);
        this.neck.addChild(this.head);
        this.armR2.addChild(this.part194_8);
        this.tail2.addChild(this.tailwingR2);
        this.head.addChild(this.eyesR);
        this.ArmL3.addChild(this.part194_5);
        this.body3.addChild(this.wingL6);
        this.body2.addChild(this.wingR3);
        this.armR1.addChild(this.armR2);
        this.tail1.addChild(this.tail2);
        this.armR1.addChild(this.part194_6);
        this.armR3.addChild(this.part194_11);
        this.ArmL3.addChild(this.part194_4);
        this.body2.addChild(this.wingL3);
        this.tail2.addChild(this.tailwingR3);
        this.tail.addChild(this.tail1);
        this.body.addChild(this.wingR2);
        this.body3.addChild(this.tail);
        this.jointL.addChild(this.clawthingL);
        this.shape7L.addChild(this.shape7L_1);
        this.tail.addChild(this.wingR7);
        this.ArmL2.addChild(this.ArmL3);
        this.tail2.addChild(this.tailantenar);
        this.head.addChild(this.part198);
        this.body2.addChild(this.wingR4);
        this.body2.addChild(this.body3);
        this.body.addChild(this.wingR1);
        this.body3.addChild(this.wingR5);
        this.head.addChild(this.jointL);
        this.clawthingR.addChild(this.armR1);
        this.armR1.addChild(this.part194_7);
        this.tail2.addChild(this.tailwingL2);
        this.armR3.addChild(this.part194_10);
        this.armR2.addChild(this.part194_9);
        this.shape7L_2.addChild(this.shape7L_3);
        this.body2.addChild(this.wingL4);
        this.body3.addChild(this.wingR6);
        this.ArmL2.addChild(this.part194_2);
        this.tail1.addChild(this.tailwingL1);
        this.clawthingL.addChild(this.armL1);
        this.armL1.addChild(this.ArmL2);
        this.eyesL.addChild(this.shape7L);
        this.head.addChild(this.eyesL);
        this.tail.addChild(this.wingL7);
        this.ArmL2.addChild(this.part194_3);
        this.tail2.addChild(this.tailantenal);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override 
    public void animationBreathing(T entity, float f, float f1, float f2, float f3, float f4) {
        this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
    }
 
    @Override 
    public void animationSwim(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.wingL1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL2.rotateAngleZ = MathHelper.cos(f * 0.6672F) * f1;
        this.wingL3.rotateAngleZ = MathHelper.cos(f * 0.6682F) * f1;
        this.wingL4.rotateAngleZ = MathHelper.cos(f * 0.6692F) * f1;
        this.wingL5.rotateAngleZ = MathHelper.cos(f * 0.6682F) * f1;
        this.wingL6.rotateAngleZ = MathHelper.cos(f * 0.6672F) * f1;
        this.wingL7.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;

        this.wingR1.rotateAngleZ = MathHelper.cos(f * -0.6662F) * f1;
        this.wingR2.rotateAngleZ = MathHelper.cos(f * -0.6672F) * f1;
        this.wingR3.rotateAngleZ = MathHelper.cos(f * -0.6682F) * f1;
        this.wingR4.rotateAngleZ = MathHelper.cos(f * -0.6692F) * f1;
        this.wingR5.rotateAngleZ = MathHelper.cos(f * -0.6682F) * f1;
        this.wingR6.rotateAngleZ = MathHelper.cos(f * -0.6672F) * f1;
        this.wingR7.rotateAngleZ = MathHelper.cos(f * -0.6662F) * f1;

        this.body.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.body2.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
        this.tail.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.tailantenal.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.tailantenar.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
    }

    @Override 
    public void animationAttack(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.jointL.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.jointR.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
    }

    @Override  
    public void animationEat(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.setRotateAngle(jointL, 0.0F, 0.82F, 0.0F);
        this.setRotateAngle(jointR, 0.0F, 0.82F, 0.0F);
        this.setRotateAngle(ArmL2, 0.0F, 0.69F, 0.0F);
        this.setRotateAngle(armR2, 0.0F, 0.69F, 0.0F);
        this.head.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
    }

    @Override  
    public void animationGrab(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.setRotateAngle(jointL, 0.0F, 0.82F, 0.0F);
        this.setRotateAngle(jointR, 0.0F, 0.82F, 0.0F);
        this.setRotateAngle(ArmL2, 0.0F, 0.69F, 0.0F);
        this.setRotateAngle(armR2, 0.0F, 0.69F, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.doAnimations(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
}
