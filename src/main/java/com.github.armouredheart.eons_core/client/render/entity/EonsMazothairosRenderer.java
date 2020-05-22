// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsMazothairosEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.EonsMazothairosModel;

// misc imports

public class EonsMazothairosRenderer extends EonsMobRenderer<EonsMazothairosEntity, EntityModel<EonsMazothairosEntity>> {

    // *** Attributes ***
    private static final ResourceLocation[] Mazothairos_TEXTURE = {
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/mazothairos/mazothairos_male.png"),
        new ResourceLocation(EonsCore.MOD_ID, "textures/entity/mazothairos/mazothairos_female.png")
    };

    // *** Constructors ***

    /** */
    public EonsMazothairosRenderer(final EntityRendererManager manager) {
        super(manager, new EonsMazothairosModel<>(), 0.7F);
        this.setEntityTexture(Mazothairos_TEXTURE);
    }

    // *** Methods ***
}