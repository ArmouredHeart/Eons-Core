// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsGroupFishEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsHurdiaEntity extends EonsGroupFishEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsHurdiaEntity(final EntityType<? extends EonsGroupFishEntity> type, final World world) {
        super(type, world, Species.HURDIA);
    }
    
    // *** Methods ***

}