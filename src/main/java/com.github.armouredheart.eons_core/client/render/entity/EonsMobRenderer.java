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
import com.github.armouredheart.eons_core.common.entity.testmobs.EonsArcanineEntity;
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EonsMobRenderer<T extends MobEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {

    // *** Attributes ***
    private static final Logger LOGGER = LogManager.getLogger(EonsCore.MOD_ID + " EonsMobRenderer");
    private ResourceLocation[] EONS_MOB_TEXTURE;

    // *** Constructors ***

    /** */
    public EonsMobRenderer(final EntityRendererManager manager, M model, float shadowSize) {
        super(manager, model, shadowSize);
    }

    // *** Methods ***

    protected boolean setEntityTexture(final ResourceLocation EONS_MOB_TEXTURE) {
        return setEntityTexture(new ResourceLocation[]{EONS_MOB_TEXTURE});
    }

    /** */
    protected boolean setEntityTexture(final ResourceLocation[] EONS_MOB_TEXTURE) {
        try{this.EONS_MOB_TEXTURE = EONS_MOB_TEXTURE;}catch(Exception e){return false;}
        return true;
    }

    @Override
	public ResourceLocation getEntityTexture(final MobEntity entity){
        return getEntityTexture(entity, 0);
	}
    
    /** */
	public ResourceLocation getEntityTexture(final MobEntity entity, int index){
        try{return EONS_MOB_TEXTURE[index];}catch(Exception e){
            LOGGER.debug("No texture ResourceLocation specified at index '" + index + "'!");
            return null;
        }
	}
}