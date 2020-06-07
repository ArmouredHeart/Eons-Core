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

// misc imports
import com.mojang.blaze3d.platform.GlStateManager;

/**
 * dickinsonia  - Accentaur
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EonsDickinsoniaModel<T extends Entity> extends EonsEntityModel<T> {
	// *** Attributes ***
    public RendererModel body;
    public RendererModel foot;
    public RendererModel shape3;
    public RendererModel shape3_1;
    public RendererModel shape5;
    public RendererModel shape5_1;

	// *** Constructors ***
    public EonsDickinsoniaModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape3 = new RendererModel(this, 24, 22);
        this.shape3.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.shape3.addBox(-6.0F, 0.0F, 0.0F, 12, 1, 2, 0.0F);
        this.shape5_1 = new RendererModel(this, 17, 51);
        this.shape5_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5_1.addBox(-5.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
        this.shape3_1 = new RendererModel(this, 30, 44);
        this.shape3_1.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.shape3_1.addBox(-7.0F, 0.0F, -2.0F, 14, 1, 2, 0.0F);
        this.shape5 = new RendererModel(this, 43, 31);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-4.0F, 0.0F, -1.0F, 8, 1, 1, 0.0F);
        this.foot = new RendererModel(this, 0, 0);
        this.foot.setRotationPoint(0.0F, 0.05F, 0.0F);
        this.foot.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.body = new RendererModel(this, 0, 28);
        this.body.setRotationPoint(0.0F, 23.4F, 0.0F);
        this.body.addBox(-1.0F, -1.0F, -6.5F, 2, 2, 13, 0.0F);
        this.foot.addChild(this.shape3);
        this.shape3_1.addChild(this.shape5_1);
        this.foot.addChild(this.shape3_1);
        this.shape3.addChild(this.shape5);
        this.body.addChild(this.foot);
    }

    // *** Methods ***
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }
}
