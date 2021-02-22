// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;

// misc imports

public class EonsMazothairosEntity extends EonsBeastEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsMazothairosEntity(final EntityType<? extends EonsBeastEntity> type, final World world) {
        super(type, world, Species.MAZOTHAIROS);
    }
    
    // *** Methods ***
}