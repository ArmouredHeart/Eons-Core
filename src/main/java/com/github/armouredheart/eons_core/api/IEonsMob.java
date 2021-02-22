// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.MobEntity;
import net.minecraft.network.datasync.EntityDataManager;

// Forge imports
import net.minecraftforge.common.extensions.IForgeEntity;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;

// misc imports

public interface IEonsMob extends IForgeEntity, IEonsLifeForm {

    public static <T extends MobEntity & IEonsMob> float getLocalTemperature(T mob_entity) {
        return 0.5F;//TODO actually implement this
    }
}   
