// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsGroupFishEntity;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;

// misc imports

public class EonsHurdiaEntity extends EonsGroupFishEntity {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;

    // *** Constructors ***
    
    /** */
    public EonsHurdiaEntity(final EntityType<? extends EonsGroupFishEntity> type, final World world) {
        super(type, world, FIELDNOTES);
    }
    
    // *** Methods ***

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
    }
}