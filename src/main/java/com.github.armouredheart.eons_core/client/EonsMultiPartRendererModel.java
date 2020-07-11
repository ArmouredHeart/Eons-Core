// package
package com.github.armouredheart.eons_core.client;

// Minecraft imports
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.entity.Entity;

// Forge imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports

// misc imports

@OnlyIn(Dist.CLIENT)
public class EonsMultiPartRendererModel extends RendererModel {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsMultiPartRendererModel(Model model, String boxNameIn) {
        super(model, boxNameIn);
    }

    /** */
    public EonsMultiPartRendererModel(Model model) {
        super(model);
    }

    /** */
    public EonsMultiPartRendererModel(Model model, int texOffX, int texOffY) {
        super(model, texOffX, texOffY);
    }

    // *** Methods ***

    /** */
    public RendererModel addEonsBox(String partName, float offX, float offY, float offZ, int width, int height, int depth, float delta, int textureOffsetX, int textureOffsetY) {
        return this.func_217178_a(partName, offX, offY, offZ, width, height, depth, delta, textureOffsetX, textureOffsetY);
    }
}