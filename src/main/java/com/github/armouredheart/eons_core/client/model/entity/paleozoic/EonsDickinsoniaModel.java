// package
package com.github.armouredheart.eons_core.client.model.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsDickinsoniaEntity;

// misc imports
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

/**
 * dimetrodon  - Accentaur
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsDickinsoniaModel<T extends EonsDickinsoniaEntity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer foot;
    public ModelRenderer shape3;
    public ModelRenderer shape3_1;
    public ModelRenderer foot_1;
    public ModelRenderer shape5;
    public ModelRenderer shape5_1;
    public ModelRenderer shape3_2;
    public ModelRenderer shape3_3;
    public ModelRenderer shape5_2;
    public ModelRenderer shape5_3;

    public EonsDickinsoniaModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.foot = new ModelRenderer(this, 0, 0);
        this.foot.setRotationPoint(0.0F, 0.15F, 0.0F);
        this.foot.addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.shape3_3 = new ModelRenderer(this, 30, 44);
        this.shape3_3.setRotationPoint(0.0F, 0.0F, 7.5F);
        this.shape3_3.addBox(-7.0F, 0.0F, -1.0F, 14.0F, 1.0F, 2.0F, -0.7F, 0.0F, -0.5F);
        this.shape5_2 = new ModelRenderer(this, 43, 31);
        this.shape5_2.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.shape5_2.addBox(-4.0F, 0.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 30, 44);
        this.shape3_1.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.shape3_1.addBox(-7.0F, 0.0F, -2.0F, 14.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(this, 43, 31);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-4.0F, 0.0F, -1.0F, 8.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.shape5_1 = new ModelRenderer(this, 17, 51);
        this.shape5_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5_1.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.shape3_2 = new ModelRenderer(this, 24, 22);
        this.shape3_2.setRotationPoint(0.0F, 0.0F, -8.5F);
        this.shape3_2.addBox(-6.0F, 0.0F, 0.0F, 12.0F, 1.0F, 2.0F, -0.7F, 0.0F, -0.5F);
        this.shape5_3 = new ModelRenderer(this, 17, 51);
        this.shape5_3.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.shape5_3.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 28);
        this.body.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.body.addBox(-1.0F, -1.0F, -6.5F, 2.0F, 2.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 24, 22);
        this.shape3.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.shape3.addBox(-6.0F, 0.0F, 0.0F, 12.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.foot_1 = new ModelRenderer(this, 0, 0);
        this.foot_1.setRotationPoint(0.0F, -0.75F, 0.0F);
        this.foot_1.addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F, -0.7F, 0.0F, -1.0F);
        this.body.addChild(this.foot);
        this.foot_1.addChild(this.shape3_3);
        this.shape3_2.addChild(this.shape5_2);
        this.foot.addChild(this.shape3_1);
        this.shape3.addChild(this.shape5);
        this.shape3_1.addChild(this.shape5_1);
        this.foot_1.addChild(this.shape3_2);
        this.shape3_3.addChild(this.shape5_3);
        this.foot.addChild(this.shape3);
        this.foot.addChild(this.foot_1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}
