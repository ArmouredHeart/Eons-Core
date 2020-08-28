// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsParadoxidesEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.EonsGeonFile;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphicRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsParadoxidesModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsParadoxidesRenderer extends MobRenderer<EonsParadoxidesEntity, EntityModel<EonsParadoxidesEntity>> implements IEonsSexuallyDimorphicRenderer {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsParadoxidesRenderer(final EntityRendererManager manager) {
        super(manager, new EonsParadoxidesModel<>(), 0.2F);
    }

    // *** Methods ***

    @Override
    public ResourceLocation getEntityTexture(EonsParadoxidesEntity entity) {
        return IEonsSexuallyDimorphicRenderer.getEonsMobTexture(entity, EonsGeonFile.PALEOZOIC);
    }
}