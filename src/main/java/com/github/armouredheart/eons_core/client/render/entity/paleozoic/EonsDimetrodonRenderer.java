// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

import com.github.armouredheart.eons_core.api.EonsResourceHelper;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsResourceHelper.EonsGeonFile;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsDimetrodonEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsDimetrodonModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsDimetrodonRenderer extends MobRenderer<EonsDimetrodonEntity, EonsDimetrodonModel<EonsDimetrodonEntity>> {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsDimetrodonRenderer(final EntityRendererManager manager) {
        super(manager, new EonsDimetrodonModel<>(), 0.7F);
    }

    // *** Methods ***

    /** */
    @Override
    public ResourceLocation getEntityTexture(EonsDimetrodonEntity entity) {
        return EonsResourceHelper.getEonsMobTexture(entity, EonsGeonFile.PALEOZOIC);
    }
}