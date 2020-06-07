// package
package com.github.armouredheart.eons_core.client.model.entity.paleozoic;

// Minecraft imports
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.client.model.entity.EonsEntityModel;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsCtenorhabdotusEntity;

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GLX;

/**
 * ctenorhabdotus - Accentaur
 * Created using Tabula 7.1.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsCtenorhabdotusModel<T extends EonsCtenorhabdotusEntity> extends EonsEntityModel<T> {
    
     // *** Attributes ***
    public RendererModel bell;
    public RendererModel shape2;
    public RendererModel shape2_1;
    public RendererModel shape5;
    public RendererModel shape5_1;
    public RendererModel inner;

    // *** Constructors ***

    public EonsCtenorhabdotusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape2_1 = new RendererModel(this, 34, 0);
        this.shape2_1.setRotationPoint(0.0F, 6.2F, 2.0F);
        this.shape2_1.addBox(-3.0F, -1.0F, -0.5F, 6, 2, 1, 0.0F);
        this.inner = new RendererModel(this, 26, 3);
        this.inner.setRotationPoint(0.0F, 0.7F, 0.0F);
        this.inner.addBox(-2.5F, -2.5F, -1.5F, 5, 5, 3, 0.0F);
        this.shape5 = new RendererModel(this, 43, 0);
        this.shape5.setRotationPoint(1.5F, 6.2F, 0.0F);
        this.shape5.addBox(0.5F, -1.0F, -2.5F, 1, 2, 5, 0.0F);
        this.bell = new RendererModel(this, 0, 0);
        this.bell.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.bell.addBox(-3.5F, -3.5F, -3.0F, 7, 9, 6, 0.0F);
        this.shape2 = new RendererModel(this, 20, 0);
        this.shape2.setRotationPoint(0.0F, 6.2F, -2.0F);
        this.shape2.addBox(-3.0F, -1.0F, -0.5F, 6, 2, 1, 0.0F);
        this.shape5_1 = new RendererModel(this, 50, 2);
        this.shape5_1.setRotationPoint(-3.5F, 6.2F, 0.0F);
        this.shape5_1.addBox(0.5F, -1.0F, -2.5F, 1, 2, 5, 0.0F);
        this.bell.addChild(this.shape2_1);
        this.bell.addChild(this.inner);
        this.bell.addChild(this.shape5);
        this.bell.addChild(this.shape2);
        this.bell.addChild(this.shape5_1);
    }

    // *** Methods ***

    @Override
    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.enableBlend();
        //GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);// this is not imported and not formatted for minecraft
        //GlStateManager.colorf(1.0F, 1.0F, 1.0F, 0.45F);
        this.bell.render(f5);
        GlStateManager.disableBlend();
    }
}
