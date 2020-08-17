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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsCtenorhabdotusEntity;

// misc imports
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

/**
 * dimetrodon  - Accentaur
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsCtenorhabdotusModel<T extends EonsCtenorhabdotusEntity> extends EntityModel<T> implements IEonsAnimationModel<T> {
    public ModelRenderer bell;
    public ModelRenderer frontT;
    public ModelRenderer backT;
    public ModelRenderer LeftT;
    public ModelRenderer RighT;
    public ModelRenderer inner;

    public EonsCtenorhabdotusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.inner = new ModelRenderer(this, 26, 3);
        this.inner.setRotationPoint(0.0F, 0.7F, 0.0F);
        this.inner.addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.backT = new ModelRenderer(this, 34, 0);
        this.backT.setRotationPoint(0.0F, 5.3F, 2.0F);
        this.backT.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(backT, -1.7453292129831807E-4F, 0.0F, 0.0F);
        this.LeftT = new ModelRenderer(this, 43, 0);
        this.LeftT.setRotationPoint(2.5F, 5.3F, 0.0F);
        this.LeftT.addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RighT = new ModelRenderer(this, 50, 2);
        this.RighT.setRotationPoint(-2.5F, 5.3F, 0.0F);
        this.RighT.addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.bell = new ModelRenderer(this, 0, 0);
        this.bell.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.bell.addBox(-3.5F, -3.5F, -3.0F, 7.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.frontT = new ModelRenderer(this, 20, 0);
        this.frontT.setRotationPoint(0.0F, 5.3F, -2.0F);
        this.frontT.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.bell.addChild(this.inner);
        this.bell.addChild(this.backT);
        this.bell.addChild(this.LeftT);
        this.bell.addChild(this.RighT);
        this.bell.addChild(this.frontT);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.bell).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override 
    public void animationBreathing(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.bell.rotateAngleY = MathHelper.cos(f * 180F) * f1;
    }

    @Override 
    public void animationSwim(T entity, float f, float f1, float f2, float f3, float f4) { 
        this.frontT.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.LeftT.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
        this.backT.rotateAngleX = MathHelper.cos(f * -0.6662F) * f1;
        this.RighT.rotateAngleZ = MathHelper.cos(f * -1.0F) * 1.0F * f1;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.doAnimations(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
}
