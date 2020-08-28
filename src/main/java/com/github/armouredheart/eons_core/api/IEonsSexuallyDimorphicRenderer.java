// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.MobEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.EonsGeonFile;
// misc imports
import javax.annotation.Nonnull;

public interface IEonsSexuallyDimorphicRenderer {

    // *** Methods ***

    /**
     * @param <E> extends {@link net.minecraft.entity.MobEntity} & {@link com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic}
     * @param entity
     * @param geonFolder
     * @param name
     * @return non null resource location of mob texture to use
     */
    public static <E extends MobEntity & IEonsSexuallyDimorphic> @Nonnull ResourceLocation getEonsMobTexture(E entity, EonsGeonFile geonFolder) {
        String name = entity.getEntityString().toLowerCase();
        return new ResourceLocation(EonsCore.MOD_ID, "textures/entity/" + geonFolder.toString() + "/" + name + "/" + name + "_" + entity.getSex().toString().toLowerCase() + ".png");
    }

}
