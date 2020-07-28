// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsSpathicephalusEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsSpathicephalusModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsSpathicephalusRenderer extends EonsMobRenderer<EonsSpathicephalusEntity, EntityModel<EonsSpathicephalusEntity>> {

    // *** Attributes ***
    private static final ResourceLocation SPATHICEPALUS_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/spathicephalus/spathicephalus_male.png");
    private static final ResourceLocation SPATHICEPALUS_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/spathicephalus/spathicephalus_female.png");

    // *** Constructors ***

    /** */
    public EonsSpathicephalusRenderer(final EntityRendererManager manager) {
        super(manager, new EonsSpathicephalusModel<>(), 0.3F);
    }

    // *** Methods ***

    /** */
    protected ResourceLocation getMaleTexture() {return this.SPATHICEPALUS_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.SPATHICEPALUS_TEXTURE_FEMALE;};
}
