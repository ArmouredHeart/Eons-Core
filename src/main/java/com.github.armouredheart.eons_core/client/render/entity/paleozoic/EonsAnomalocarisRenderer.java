// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAnomalocarisEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsAnomalocarisModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsAnomalocarisRenderer extends EonsMobRenderer<EonsAnomalocarisEntity, EntityModel<EonsAnomalocarisEntity>> {

    // *** Attributes ***
    private static final ResourceLocation ANOMALOCARIS_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/anomalocaris/anomalocaris_male.png");
    private static final ResourceLocation ANOMALOCARIS_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/anomalocaris/anomalocaris_female.png");

    // *** Constructors ***

    /** */
    public EonsAnomalocarisRenderer(final EntityRendererManager manager) {
        super(manager, new EonsAnomalocarisModel<>(), 0.4F);
    }

    // *** Methods ***
    
    /** */
    protected ResourceLocation getMaleTexture() {return this.ANOMALOCARIS_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.ANOMALOCARIS_TEXTURE_FEMALE;}
}