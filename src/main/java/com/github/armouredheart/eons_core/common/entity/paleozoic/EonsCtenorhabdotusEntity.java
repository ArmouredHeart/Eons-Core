// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsJellyfishEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsCtenorhabdotusEntity extends EonsJellyfishEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsCtenorhabdotusEntity(final EntityType<? extends EonsJellyfishEntity> type, final World world) {
        super(type, world, Species.CTENORHABDOTUS, 1);

    }
    
    // *** Methods ***
}