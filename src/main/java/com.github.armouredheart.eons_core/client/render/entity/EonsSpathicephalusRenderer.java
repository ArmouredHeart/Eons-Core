// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsSpathicephalusEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.EonsSpathicephalusModel;

// misc imports

public class EonsSpathicephalusRenderer extends EonsMobRenderer<EonsSpathicephalusEntity, EntityModel<EonsSpathicephalusEntity>> {

    // *** Attributes ***
    private static final ResourceLocation[] Spathicephalus_TEXTURE = {
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/spathicephalus/spathicephalus_male.png"),
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/spathicephalus/spathicephalus_female.png")
    };

    // *** Constructors ***

    /** */
    public EonsSpathicephalusRenderer(final EntityRendererManager manager) {
        super(manager, new EonsSpathicephalusModel<>(), 0.3F);
        this.setEntityTexture(Spathicephalus_TEXTURE);
    }

    // *** Methods ***
}
