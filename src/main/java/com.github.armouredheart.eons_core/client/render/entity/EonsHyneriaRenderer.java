// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsHyneriaEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.EonsHyneriaModel;

// misc imports

public class EonsHyneriaRenderer extends EonsMobRenderer<EonsHyneriaEntity, EntityModel<EonsHyneriaEntity>> {

    // *** Attributes ***
    private static final ResourceLocation[] Hyneria_TEXTURE = {
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/hyneria/hyneria_male.png"),
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/hyneria/hyneria_female.png")
    };

    // *** Constructors ***

    /** */
    public EonsHyneriaRenderer(final EntityRendererManager manager) {
        super(manager, new EonsHyneriaModel<>(), 0.7F);
        this.setEntityTexture(Hyneria_TEXTURE);
    }

    // *** Methods ***
}
