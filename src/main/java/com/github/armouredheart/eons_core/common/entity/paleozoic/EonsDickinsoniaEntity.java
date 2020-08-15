// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.api.IEonsLifeForm;

public class EonsDickinsoniaEntity extends MobEntity implements IEonsLifeForm {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;

    // *** Constructors ***

    /** */
    public EonsDickinsoniaEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // *** Methods ***

    @Override
    public EonsFieldNotes getFieldNotes() {return EonsDickinsoniaEntity.FIELDNOTES;}
    
}

