// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsBelantseaEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsBelantseaModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsBelantseaRenderer extends EonsMobRenderer<EonsBelantseaEntity, EntityModel<EonsBelantseaEntity>> {

    // *** Attributes ***
    private static final ResourceLocation BELANTSEA_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/belantsea/belantsea_male.png");
    private static final ResourceLocation BELANTSEA_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/belantsea/belantsea_female.png");

    // *** Constructors ***

    /** */
    public EonsBelantseaRenderer(final EntityRendererManager manager) {
        super(manager, new EonsBelantseaModel<>(), 0.7F);
    }

    // *** Methods ***

    /** */
    protected ResourceLocation getMaleTexture() {return this.BELANTSEA_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.BELANTSEA_TEXTURE_FEMALE;};
}
