// package
package com.github.armouredheart.eons_core.client.model.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.RenderType;

// Forge imports

// Eons imports

// misc imports
import com.google.common.base.Function;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

public abstract class EonsAdvancedAgeableModel<T extends AgeableEntity> extends EntityModel<T> {

    // *** Attributes ***
    private final float[][] CHILD_STAGES; // first array is younger stage
    private final boolean IS_CHILD_HEAD_SCALED;
    private int age;
    private final int MAX_AGE;

    // *** Constructors ***

    /**
     * @param isChildHeadScaled
     * @param childStages
     */
    public EonsAdvancedAgeableModel(final boolean isChildHeadScaled, final float[][] childStages) {
        this(RenderType::getEntityCutoutNoCull, isChildHeadScaled, childStages);
    }    

    /**
     * @param renderTypeIn
     * @param isChildHeadScaled
     * @param childStages
     */
    public EonsAdvancedAgeableModel(Function<ResourceLocation, RenderType> renderTypeIn, final boolean isChildHeadScaled, final float[][] childStages) {
        super(renderTypeIn);
        this.IS_CHILD_HEAD_SCALED = isChildHeadScaled;
        this.CHILD_STAGES = childStages;
        this.MAX_AGE = this.CHILD_STAGES.length;
        // 
        if(this.isChild) {this.age = 0;} else {this.age = this.MAX_AGE;}
    }

    /**
     * @param renderTypeIn
     * @param isChildHeadScaled
     * @param childHeadOffsetY
     * @param childHeadOffsetZ
     * @param childHeadScale
     * @param childBodyScale
     * @param childBodyOffsetY
     */
    public EonsAdvancedAgeableModel(Function<ResourceLocation, RenderType> renderTypeIn, boolean isChildHeadScaled, float childHeadOffsetY, float childHeadOffsetZ, float childHeadScale, float childBodyScale, float childBodyOffsetY) {
        this(renderTypeIn, isChildHeadScaled, new float[][] {{childHeadOffsetY, childHeadOffsetZ, childHeadScale, childBodyScale, childBodyOffsetY}});
    }

    // *** Methods ***

    private float[] getChildStage() {
        return this.CHILD_STAGES[this.age];
    }
    
    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (this.isChild) {
            float[] stage = this.getChildStage();
            matrixStackIn.push();
            
            // do tabula compatibility
            doTabulaScaling(matrixStackIn);

            if (this.IS_CHILD_HEAD_SCALED) {
                float f = 1.5F / stage[0];
                matrixStackIn.scale(f, f, f);
            }

            matrixStackIn.translate(0.0D, (double)(stage[1] / 16.0F), (double)(stage[2] / 16.0F));
            this.getHeadParts().forEach((head_part) -> {
                head_part.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
            matrixStackIn.push();
            float f1 = 1.0F / stage[3];
            matrixStackIn.scale(f1, f1, f1);
            matrixStackIn.translate(0.0D, (double)(stage[4] / 16.0F), 0.0D);
            this.getBodyParts().forEach((body_part) -> {
                body_part.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        } else {
            matrixStackIn.push();
            // do tabula compatibility
            doTabulaScaling(matrixStackIn);

            this.getHeadParts().forEach((head_part) -> {
                head_part.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            this.getBodyParts().forEach((body_part) -> {
                body_part.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
        }
    }

    protected void syncAge(T entity) {

    }

    protected int getAge() {return age;}

    /**
     * @param newAge
     * @return true if successful
     */
    protected boolean setAge(int newAge) {
        if(-1 < newAge && newAge <= this.MAX_AGE) {
            this.age = newAge;
            return true;
        } else {
            return false;
        }
    }

    protected void increaseAge() {this.setAge(this.age + 1);}

    protected abstract Iterable<ModelRenderer> getHeadParts();

    protected abstract Iterable<ModelRenderer> getBodyParts();

    /** 
     * @return modelScale variable as seen in tabula. Returns unit vector `{1.0F, 1.0F, 1.0F}` by default.
    */
    protected float[] getModelScale() {return new float[]{1.0F, 1.0F, 1.0F};}

    /**
     * Tabula compatibility method
     * @param matrixStackIn
     * @return false if getModelScale is wrong length
     */
    protected boolean doTabulaScaling(MatrixStack matrixStackIn) {
        float[] modelScale = this.getModelScale();
        if(modelScale.length == 3) {
            matrixStackIn.scale(modelScale[0], modelScale[1], modelScale[2]);
            return true;
        } else {
            return false;
        }
    }
}