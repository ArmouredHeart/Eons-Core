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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsHurdiaEntity;

// misc imports
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

@OnlyIn(Dist.CLIENT)
public class EonsHurdiaModel<T extends EonsHurdiaEntity> extends EntityModel<T> implements IEonsAnimationModel<T>  {
    public float[] modelScale = new float[] { 0.5F, 0.5F, 0.5F };
    public ModelRenderer shape1;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer wingL1;
    public ModelRenderer wingL2;
    public ModelRenderer wingL3;
    public ModelRenderer wingL4;
    public ModelRenderer wingR1;
    public ModelRenderer wingR2;
    public ModelRenderer wingR3;
    public ModelRenderer wingR4;
    public ModelRenderer shape3;
    public ModelRenderer wingL5;
    public ModelRenderer wingL6;
    public ModelRenderer wingL7;
    public ModelRenderer shape3_1;
    public ModelRenderer wingR5;
    public ModelRenderer wingR7;
    public ModelRenderer wingR6;
    public ModelRenderer shape5;
    public ModelRenderer armL1;
    public ModelRenderer eyestockL;
    public ModelRenderer armR1;
    public ModelRenderer eyestockR;
    public ModelRenderer shape6;
    public ModelRenderer shape6_1;
    public ModelRenderer shape22;
    public ModelRenderer shape23;
    public ModelRenderer shape24;
    public ModelRenderer armL2;
    public ModelRenderer arm;
    public ModelRenderer eyeL1;
    public ModelRenderer eyeL2;
    public ModelRenderer armR2;
    public ModelRenderer armR3;
    public ModelRenderer eyeL1_1;
    public ModelRenderer eyeL2_1;

    public EonsHurdiaModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.eyeL2 = new ModelRenderer(this, 0, 2);
        this.eyeL2.setRotationPoint(1.0F, -0.2F, 0.0F);
        this.eyeL2.addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, -0.2F, 0.0F);
        this.armR3 = new ModelRenderer(this, 0, 0);
        this.armR3.setRotationPoint(0.0F, -0.2F, -0.7F);
        this.armR3.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.3F, -0.2F, 0.0F);
        this.setRotateAngle(armR3, 0.6373942508178124F, 0.0F, 0.0F);
        this.wingR3 = new ModelRenderer(this, 0, 14);
        this.wingR3.mirror = true;
        this.wingR3.setRotationPoint(-0.5F, 0.0F, 0.5F);
        this.wingR3.addBox(-3.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingR3, 0.0F, 0.0F, -0.46914448828868976F);
        this.wingR2 = new ModelRenderer(this, 0, 14);
        this.wingR2.mirror = true;
        this.wingR2.setRotationPoint(-0.5F, 0.0F, -0.5F);
        this.wingR2.addBox(-3.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingR2, 0.0F, 0.0F, -0.46914448828868976F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 20.5F, 0.7F);
        this.shape1.addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 4.0F, -0.1F, 0.0F, 0.0F);
        this.armL2 = new ModelRenderer(this, 46, 2);
        this.armL2.setRotationPoint(0.0F, -0.2F, -1.5F);
        this.armL2.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.2F, -0.1F, 0.0F);
        this.setRotateAngle(armL2, 0.9105382388075086F, 0.0F, 0.0F);
        this.eyeL1_1 = new ModelRenderer(this, 21, 0);
        this.eyeL1_1.mirror = true;
        this.eyeL1_1.setRotationPoint(-1.0F, 0.2F, 0.0F);
        this.eyeL1_1.addBox(-1.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, -0.2F, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 32, 0);
        this.shape3_1.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.shape3_1.addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape3_1, 0.0F, 0.4098033003787853F, 0.0F);
        this.armR2 = new ModelRenderer(this, 46, 2);
        this.armR2.setRotationPoint(0.0F, -0.2F, -1.5F);
        this.armR2.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.2F, -0.1F, 0.0F);
        this.setRotateAngle(armR2, 0.9105382388075086F, 0.0F, 0.0F);
        this.wingL3 = new ModelRenderer(this, 0, 14);
        this.wingL3.setRotationPoint(0.5F, 0.0F, 0.5F);
        this.wingL3.addBox(0.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingL3, 0.0F, 0.0F, 0.46914448828868976F);
        this.shape23 = new ModelRenderer(this, 21, 4);
        this.shape23.setRotationPoint(0.0F, 1.0F, -5.2F);
        this.shape23.addBox(-2.0F, -0.5F, 0.0F, 4.0F, 2.0F, 3.0F, -0.4F, 0.0F, 0.2F);
        this.wingL4 = new ModelRenderer(this, 0, 14);
        this.wingL4.setRotationPoint(0.5F, 0.0F, 1.5F);
        this.wingL4.addBox(0.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingL4, 0.0F, 0.0F, 0.46931902520863084F);
        this.wingL6 = new ModelRenderer(this, 0, 20);
        this.wingL6.setRotationPoint(0.5F, 0.0F, 1.0F);
        this.wingL6.addBox(0.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingL6, 0.0F, 0.0F, 0.46914448828868976F);
        this.eyestockR = new ModelRenderer(this, 46, 0);
        this.eyestockR.setRotationPoint(-1.0F, 0.0F, -1.7F);
        this.eyestockR.addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 14, 0);
        this.tail.setRotationPoint(0.0F, 0.2F, 2.0F);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.eyeL1 = new ModelRenderer(this, 21, 0);
        this.eyeL1.setRotationPoint(1.0F, 0.2F, 0.0F);
        this.eyeL1.addBox(0.0F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, -0.2F, 0.0F);
        this.eyeL2_1 = new ModelRenderer(this, 0, 2);
        this.eyeL2_1.mirror = true;
        this.eyeL2_1.setRotationPoint(-1.0F, -0.2F, 0.0F);
        this.eyeL2_1.addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, -0.2F, 0.0F);
        this.wingR7 = new ModelRenderer(this, 0, 20);
        this.wingR7.mirror = true;
        this.wingR7.setRotationPoint(-0.5F, 0.0F, 2.0F);
        this.wingR7.addBox(-2.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingR7, 0.0F, 0.0F, -0.46914448828868976F);
        this.shape22 = new ModelRenderer(this, 55, 0);
        this.shape22.setRotationPoint(0.0F, 0.6F, -6.7F);
        this.shape22.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.wingL2 = new ModelRenderer(this, 0, 14);
        this.wingL2.setRotationPoint(0.5F, 0.0F, -0.5F);
        this.wingL2.addBox(0.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingL2, 0.0F, 0.0F, 0.46914448828868976F);
        this.wingR4 = new ModelRenderer(this, 0, 14);
        this.wingR4.mirror = true;
        this.wingR4.setRotationPoint(-0.5F, 0.0F, 1.5F);
        this.wingR4.addBox(-3.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingR4, 0.0F, 0.0F, -0.46914448828868976F);
        this.armL1 = new ModelRenderer(this, 10, 0);
        this.armL1.setRotationPoint(0.7F, 0.0F, -2.0F);
        this.armL1.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, -0.1F, 0.0F, 0.0F);
        this.setRotateAngle(armL1, 1.3658947098950176F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 32, 0);
        this.shape3.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.shape3.addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape3, 0.0F, -0.4098033003787853F, 0.0F);
        this.wingR1 = new ModelRenderer(this, 0, 14);
        this.wingR1.mirror = true;
        this.wingR1.setRotationPoint(-0.5F, 0.0F, -1.5F);
        this.wingR1.addBox(-3.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingR1, 0.0F, 0.0F, -0.46914448828868976F);
        this.shape6 = new ModelRenderer(this, 50, 0);
        this.shape6.setRotationPoint(0.0F, 0.2F, -4.9F);
        this.shape6.addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape6, 0.04555309164612875F, 0.0F, 0.0F);
        this.arm = new ModelRenderer(this, 0, 0);
        this.arm.setRotationPoint(0.0F, -0.2F, -0.7F);
        this.arm.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, -0.3F, -0.2F, 0.0F);
        this.setRotateAngle(arm, 0.6373942508178124F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(this, 35, 0);
        this.shape5.setRotationPoint(0.0F, -1.4F, 0.0F);
        this.shape5.addBox(-1.5F, -0.5F, -5.0F, 3.0F, 2.0F, 5.0F, 0.3F, 0.0F, 0.0F);
        this.setRotateAngle(shape5, -0.006283185556850939F, -0.012566371113701878F, -0.003490658556003524F);
        this.armR1 = new ModelRenderer(this, 10, 0);
        this.armR1.setRotationPoint(-0.7F, 0.0F, -2.0F);
        this.armR1.addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, -0.1F, 0.0F, 0.0F);
        this.setRotateAngle(armR1, 1.3658947098950176F, 0.0F, 0.0F);
        this.wingL7 = new ModelRenderer(this, 0, 20);
        this.wingL7.setRotationPoint(0.5F, 0.0F, 2.0F);
        this.wingL7.addBox(0.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingL7, 0.0F, 0.0F, 0.46914448828868976F);
        this.eyestockL = new ModelRenderer(this, 46, 0);
        this.eyestockL.setRotationPoint(1.0F, 0.0F, -1.7F);
        this.eyestockL.addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 24, 0);
        this.head.setRotationPoint(0.0F, 0.2F, -1.8F);
        this.head.addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, 0.0911061832922575F, 0.0F, 0.0F);
        this.wingL1 = new ModelRenderer(this, 0, 14);
        this.wingL1.setRotationPoint(0.5F, 0.0F, -1.5F);
        this.wingL1.addBox(0.0F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, 0.0F, -0.7F, -0.3F);
        this.setRotateAngle(wingL1, 0.0F, 0.0F, 0.46914448828868976F);
        this.wingL5 = new ModelRenderer(this, 0, 20);
        this.wingL5.setRotationPoint(0.5F, 0.0F, 0.2F);
        this.wingL5.addBox(0.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingL5, 0.0F, 0.0F, 0.46914448828868976F);
        this.shape6_1 = new ModelRenderer(this, 32, 2);
        this.shape6_1.setRotationPoint(0.0F, 0.6F, -4.9F);
        this.shape6_1.addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(shape6_1, -0.0911061832922575F, 0.0F, 0.0F);
        this.wingR6 = new ModelRenderer(this, 0, 20);
        this.wingR6.mirror = true;
        this.wingR6.setRotationPoint(-0.5F, 0.0F, 1.0F);
        this.wingR6.addBox(-2.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingR6, 0.0F, 0.0F, -0.4639085138485122F);
        this.shape24 = new ModelRenderer(this, 41, 5);
        this.shape24.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.shape24.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.wingR5 = new ModelRenderer(this, 0, 20);
        this.wingR5.mirror = true;
        this.wingR5.setRotationPoint(-0.5F, 0.0F, 0.2F);
        this.wingR5.addBox(-2.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, -0.7F, -0.4F);
        this.setRotateAngle(wingR5, 0.0F, 0.0F, -0.46914448828868976F);
        this.eyestockL.addChild(this.eyeL2);
        this.armR2.addChild(this.armR3);
        this.shape1.addChild(this.wingR3);
        this.shape1.addChild(this.wingR2);
        this.armL1.addChild(this.armL2);
        this.eyestockR.addChild(this.eyeL1_1);
        this.tail.addChild(this.shape3_1);
        this.armR1.addChild(this.armR2);
        this.shape1.addChild(this.wingL3);
        this.shape5.addChild(this.shape23);
        this.shape1.addChild(this.wingL4);
        this.tail.addChild(this.wingL6);
        this.head.addChild(this.eyestockR);
        this.shape1.addChild(this.tail);
        this.eyestockL.addChild(this.eyeL1);
        this.eyestockR.addChild(this.eyeL2_1);
        this.tail.addChild(this.wingR7);
        this.shape5.addChild(this.shape22);
        this.shape1.addChild(this.wingL2);
        this.shape1.addChild(this.wingR4);
        this.head.addChild(this.armL1);
        this.tail.addChild(this.shape3);
        this.shape1.addChild(this.wingR1);
        this.shape5.addChild(this.shape6);
        this.armL2.addChild(this.arm);
        this.head.addChild(this.shape5);
        this.head.addChild(this.armR1);
        this.tail.addChild(this.wingL7);
        this.head.addChild(this.eyestockL);
        this.shape1.addChild(this.head);
        this.shape1.addChild(this.wingL1);
        this.tail.addChild(this.wingL5);
        this.shape5.addChild(this.shape6_1);
        this.tail.addChild(this.wingR6);
        this.shape6_1.addChild(this.shape24);
        this.tail.addChild(this.wingR5);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        matrixStackIn.push();
        matrixStackIn.scale(modelScale[0], modelScale[1], modelScale[2]);
        ImmutableList.of(this.shape1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
        matrixStackIn.pop();
    }

    @Override 
    public void animationSwim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.wingL1.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL2.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL3.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL4.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL5.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL6.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
        this.wingL7.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;

        this.wingR1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR2.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR3.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR4.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR5.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR6.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.wingR7.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;

        this.tail.rotateAngleX = MathHelper.cos (f * 1.0F) * -1.0F * f1;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.doAnimations(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
}
