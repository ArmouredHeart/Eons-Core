// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAraxocerasEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsAraxocerasModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsAraxocerasRenderer extends EonsMobRenderer<EonsAraxocerasEntity, EntityModel<EonsAraxocerasEntity>> {

    // *** Attributes ***
    private static final ResourceLocation ARAXOCERAS_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/araxoceras/araxoceras_male.png");
    private static final ResourceLocation ARAXOCERAS_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/araxoceras/araxoceras_female.png");

    // *** Constructors ***

    /** */
    public EonsAraxocerasRenderer(final EntityRendererManager manager) {
        super(manager, new EonsAraxocerasModel<>(), 0.4F);
    }

    // *** Methods ***
    
    /** */
    protected ResourceLocation getMaleTexture() {return this.ARAXOCERAS_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.ARAXOCERAS_TEXTURE_FEMALE;};
}
