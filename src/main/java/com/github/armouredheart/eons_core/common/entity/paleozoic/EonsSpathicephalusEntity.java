// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsSpathicephalusEntity extends EonsAmphibianEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsSpathicephalusEntity(final EntityType<? extends EonsAmphibianEntity> type, final World world) {
        super(type, world, Species.SPATHICEPHALUS);
    }
    
    // *** Methods ***

}