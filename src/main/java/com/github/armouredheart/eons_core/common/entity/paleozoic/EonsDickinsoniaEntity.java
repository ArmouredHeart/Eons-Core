// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.Species;

public class EonsDickinsoniaEntity extends MobEntity implements IEonsLifeForm {

    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsDickinsoniaEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // *** Methods ***
    @Override
    public Species getSpecies() {
        return Species.DICKINSONIA;
    }


    
}

