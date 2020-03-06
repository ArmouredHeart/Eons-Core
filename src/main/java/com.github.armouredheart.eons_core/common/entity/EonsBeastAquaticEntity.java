// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.WaterMobEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;
import com.github.armouredheart.eons_core.common.entity.EonsFieldNotes;

// misc imports

public abstract class EonsBeastAquaticEntity extends EonsBeastEntity {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    protected EonsBeastAquaticEntity(EntityType<? extends EonsBeastEntity> type, World world, EonsFieldNotes fieldNotes) {
        super(type, world, fieldNotes);
    }

    // *** Methods ***
}