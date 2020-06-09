// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;

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
    private static final EonsDiet DIET = new EonsDiet(4, false, Arrays.asList(Items.SWEET_BERRIES));

    // *** Constructors ***
    
    /** */
    public EonsSpathicephalusEntity(final EntityType<? extends EonsAmphibianEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }
    
    // *** Methods ***

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }

    /** */
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new EonsEatBerriesGoal(this, this.getSpeed(), 48));
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, this.getSpeed()));
    }
}