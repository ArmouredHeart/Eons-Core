// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsHyneriaEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsHyneriaModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsHyneriaRenderer extends EonsMobRenderer<EonsHyneriaEntity, EntityModel<EonsHyneriaEntity>> {

    // *** Attributes ***
    private static final ResourceLocation HYNERIA_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/hyneria/hyneria_male.png");
    private static final ResourceLocation HYNERIA_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/hyneria/hyneria_female.png");

    // *** Constructors ***

    /** */
    public EonsHyneriaRenderer(final EntityRendererManager manager) {
        super(manager, new EonsHyneriaModel<>(), 0.7F);
    }

    // *** Methods ***

    /** */
    protected ResourceLocation getMaleTexture() {return this.HYNERIA_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.HYNERIA_TEXTURE_FEMALE;};
}
