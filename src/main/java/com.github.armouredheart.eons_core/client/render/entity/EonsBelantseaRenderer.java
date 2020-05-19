// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsBelantseaEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.EonsBelantseaModel;

// misc imports

public class EonsBelantseaRenderer extends EonsMobRenderer<EonsBelantseaEntity, EntityModel<EonsBelantseaEntity>> {

    // *** Attributes ***
    private static final ResourceLocation[] Belantsea_TEXTURE = {
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/belantsea/belantsea_male.png"),
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/belantsea/belantsea_female.png")
    };

    // *** Constructors ***

    /** */
    public EonsBelantseaRenderer(final EntityRendererManager manager) {
        super(manager, new EonsBelantseaModel<>(), 0.7F);
        this.setEntityTexture(Belantsea_TEXTURE);
    }

    // *** Methods ***
}
