// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsDimetrodonEntity extends EonsBeastEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsDimetrodonEntity(final EntityType<? extends EonsBeastEntity> type, final World world) {
        super(type, world, Species.DIMETRODON);
    }
    
    // *** Methods ***

}