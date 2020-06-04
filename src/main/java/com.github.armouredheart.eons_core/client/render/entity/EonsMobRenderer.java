// package
package com.github.armouredheart.eons_core.client.render.entity;

// Minecraft imports
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EonsMobRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {

    // *** Attributes ***
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsMobRenderer");

    // *** Constructors ***

    /** */
    public EonsMobRenderer(final EntityRendererManager manager, M model, float shadowSize) {
        super(manager, model, shadowSize);
    }

    // *** Methods ***

    /** This determines what texture is rendered on the mob */
    @Override
	public ResourceLocation getEntityTexture(final MobEntity entity){

        // Handle cases where the mob is sexually dimorphic
        if(entity instanceof IEonsSexuallyDimorphic) {
            IEonsSexuallyDimorphic sexyMob = (IEonsSexuallyDimorphic) entity;
            if(sexyMob.isMale()) {
                return getMaleTexture();
            } else if(sexyMob.isFemale()) {
                return getFemaleTexture();
            }
        }
        return getUnisexTexture();
    }

    /** */
    protected abstract ResourceLocation getMaleTexture();

    /** */
    protected abstract ResourceLocation getUnisexTexture();

    /** */
    protected abstract ResourceLocation getFemaleTexture();
}