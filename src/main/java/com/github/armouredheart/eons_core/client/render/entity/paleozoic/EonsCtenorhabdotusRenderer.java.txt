// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.MobEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsCtenorhabdotusEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsCtenorhabdotusModel;
//import com.github.armouredheart.eons_core.client.render.entity.EonsBioluminescentLayer;
import com.github.armouredheart.eons_core.client.model.entity.EonsEntityModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsCtenorhabdotusRenderer extends EonsMobRenderer<EonsCtenorhabdotusEntity, EntityModel<EonsCtenorhabdotusEntity>> {

    // *** Attributes ***
    private static final ResourceLocation CTENORHABDOTUS_TEXTURE_UNISEX = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/ctenorhabdotus/ctenorhabdotus_unisex.png");
    private static final ResourceLocation CTENORHABDOTUS_TEXTURE_GLOW = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/ctenorhabdotus/ctenorhabdotus_glow.png");

    // *** Constructors ***

    /** */
    public EonsCtenorhabdotusRenderer(final EntityRendererManager manager) {
        super(manager, new EonsCtenorhabdotusModel<>(), 0.4F);
        //this.addLayer(new EonsBioluminescentLayer<T, M>(this, false, CTENORHABDOTUS_TEXTURE_GLOW));
    }

    // *** Methods ***
        
    /** */
    protected ResourceLocation getMaleTexture() {return null;}

    /** */
    protected ResourceLocation getUnisexTexture() {return this.CTENORHABDOTUS_TEXTURE_UNISEX;}

    /** */
    protected ResourceLocation getFemaleTexture() {return null;}
}
