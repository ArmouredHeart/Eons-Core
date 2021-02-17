// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsResourceHelper.EonsGeonFile;
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsAnomalocarisEntity;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphicRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsAnomalocarisModel;
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsAnomalocarisRenderer extends MobRenderer<EonsAnomalocarisEntity, EntityModel<EonsAnomalocarisEntity>> implements IEonsSexuallyDimorphicRenderer{

    // *** Attributes ***
    
    // *** Constructors ***

    /** */
    public EonsAnomalocarisRenderer(final EntityRendererManager manager) {
        super(manager, new EonsAnomalocarisModel<>(), 0.4F);
    }

    // *** Methods ***

    @Override
    public ResourceLocation getEntityTexture(EonsAnomalocarisEntity entity) {
        return IEonsSexuallyDimorphicRenderer.getEonsMobTexture(entity, EonsGeonFile.PALEOZOIC);
    }
}