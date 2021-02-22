// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBigFishEntity;
import com.github.armouredheart.eons_core.api.Species;
// misc imports

public class EonsHyneriaEntity extends EonsBigFishEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsHyneriaEntity(final EntityType<? extends EonsBigFishEntity> type, final World world) {
        super(type, world, Species.HYNERIA);
    }
    
    // *** Methods ***
}