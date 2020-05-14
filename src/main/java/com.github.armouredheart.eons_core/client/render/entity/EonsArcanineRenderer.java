// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsArcanineEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.entity.model.EonsAraxocerasModel;

// misc imports

public class EonsArcanineRenderer extends EonsMobRenderer<EonsArcanineEntity, EntityModel<EonsArcanineEntity>> {

    // *** Attributes ***
    private static final ResourceLocation ARCANINE_TEXTURE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/arcanine/arcanine.png");

    // *** Constructors ***

    /** */
    public EonsArcanineRenderer(final EntityRendererManager manager) {
        super(manager, new EonsAraxocerasModel<>(), 0.7F);
        this.setEntityTexture(ARCANINE_TEXTURE);
    }

    // *** Methods ***
}
