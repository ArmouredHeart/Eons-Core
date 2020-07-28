// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;

// misc imports

public abstract class EonsBeastAquaticEntity extends EonsBeastEntity {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsBeastAquaticEntity(EntityType<? extends EonsBeastEntity> type, World world, EonsFieldNotes fieldNotes) {
        super(type, world, fieldNotes);
    }

    // *** Methods ***
}