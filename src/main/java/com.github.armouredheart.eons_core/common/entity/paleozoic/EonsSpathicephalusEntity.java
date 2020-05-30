// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.Item;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes; 
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.common.entity.ai.EonsEatBerriesGoal;

// misc imports
import java.util.List;
import java.util.Arrays;

public class EonsSpathicephalusEntity extends EonsAmphibianEntity {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(false, Arrays.asList(Items.SWEET_BERRIES));

    // *** Constructors ***
    
    /** */
    public EonsSpathicephalusEntity(final EntityType<? extends EonsSpathicephalusEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }
    
    // *** Methods ***

    /** */
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new EonsEatBerriesGoal(this, this.getSpeed(), 32));
    }
}