// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.EonsGroupFishEntity;

// misc imports

public class EonsCephalopodEntity extends EonsGroupFishEntity {
    // *** Attributes ***

    // *** Constructors ***
    public EonsCephalopodEntity(final EntityType<? extends EonsCephalopodEntity> type, final World world, final EonsFieldNotes fieldNotes) {
        super(type, world, fieldNotes);
    }

    // *** Methods ***

}