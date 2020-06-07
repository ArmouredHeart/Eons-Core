// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsParadoxidesEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsParadoxidesModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsParadoxidesRenderer extends EonsMobRenderer<EonsParadoxidesEntity, EntityModel<EonsParadoxidesEntity>> {

    // *** Attributes ***
    private static final ResourceLocation PARADOXIDES_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/paradoxides/paradoxides_male.png");
    private static final ResourceLocation PARADOXIDES_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/paradoxides/paradoxides_female.png");

    // *** Constructors ***

    /** */
    public EonsParadoxidesRenderer(final EntityRendererManager manager) {
        super(manager, new EonsParadoxidesModel<>(), 0.4F);
    }

    // *** Methods ***
    
    /** */
    protected ResourceLocation getMaleTexture() {return this.PARADOXIDES_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.PARADOXIDES_TEXTURE_FEMALE;}
}