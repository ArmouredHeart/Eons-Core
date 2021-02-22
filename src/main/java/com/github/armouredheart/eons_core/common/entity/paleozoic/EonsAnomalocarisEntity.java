// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.util.SoundEvent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.common.entity.EonsBigFishEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsAnomalocarisEntity extends EonsBigFishEntity {
    // *** Attributes ***

    // *** Constructors ***
    
    /** */
    public EonsAnomalocarisEntity(final EntityType<? extends EonsBigFishEntity> type, final World world) {
        super(type, world, Species.ANOMALOCARIS);
    }   

    // *** Methods ***

    @Override
    protected SoundEvent getDeathSound() {
        return EonsSounds.CRACK;
    }
}