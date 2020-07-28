// package
package com.github.armouredheart.eons_core.client.render.entity.paleozoic;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsMazothairosEntity;
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.client.render.entity.EonsMobRenderer;
import com.github.armouredheart.eons_core.client.model.entity.paleozoic.EonsMazothairosModel;

// misc imports
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EonsMazothairosRenderer extends EonsMobRenderer<EonsMazothairosEntity, EntityModel<EonsMazothairosEntity>> {

    // *** Attributes ***
    private static final ResourceLocation MAZOTHAIROS_TEXTURE_MALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/mazothairos/mazothairos_male.png");
    private static final ResourceLocation MAZOTHAIROS_TEXTURE_FEMALE = new ResourceLocation(EonsCore.MOD_ID, "textures/entity/paleozoic/mazothairos/mazothairos_female.png");

    // *** Constructors ***

    /** */
    public EonsMazothairosRenderer(final EntityRendererManager manager) {
        super(manager, new EonsMazothairosModel<>(), 0.7F);
    }

    // *** Methods ***
        
    /** */
    protected ResourceLocation getMaleTexture() {return this.MAZOTHAIROS_TEXTURE_MALE;}

    /** */
    protected ResourceLocation getUnisexTexture() {return null;}

    /** */
    protected ResourceLocation getFemaleTexture() {return this.MAZOTHAIROS_TEXTURE_FEMALE;};
}