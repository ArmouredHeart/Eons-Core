// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

import com.github.armouredheart.eons_core.api.Species;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsCephalopodEntity;

// misc imports

public class EonsAraxocerasEntity extends EonsCephalopodEntity {

    // *** Attributes ***

    // *** Constructors ***
    
    public EonsAraxocerasEntity(final EntityType<? extends EonsCephalopodEntity> type, final World world) {
        super(type, world, Species.ARAXOCERAS);

    }
    
    // *** Methods ***
}