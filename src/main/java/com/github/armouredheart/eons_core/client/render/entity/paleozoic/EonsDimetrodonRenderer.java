// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsDimetrodonEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsDimetrodonModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsDimetrodonRenderer extends MobRenderer<EonsDimetrodonEntity, EonsDimetrodonModel<EonsDimetrodonEntity>> {

    // *** Attributes ***
    private static final ResourceLocation DIMETRODON_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/dimetrodon/dimetrodon_male.png");
    private static final ResourceLocation DIMETRODON_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/dimetrodon/dimetrodon_female.png");

    // *** Constructors ***

    /** */
    public EonsDimetrodonRenderer(final EntityRendererManager manager) {
        super(manager, new EonsDimetrodonModel<>(), 0.7F);
    }

    // *** Methods ***

    /** */
    @Override
    public ResourceLocation getEntityTexture(EonsDimetrodonEntity entity) {
        if(entity.isMale()) {
            return EonsDimetrodonRenderer.DIMETRODON_TEXTURE_MALE;
        } else {
            return EonsDimetrodonRenderer.DIMETRODON_TEXTURE_FEMALE;
        }
    }
}