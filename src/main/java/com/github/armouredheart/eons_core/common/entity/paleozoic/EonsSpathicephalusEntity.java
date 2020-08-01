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
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.api.IEonsPredator;
import com.github.armouredheart.eons_core.common.entity.ai.EonsFightTargetGoal;

// misc imports
import java.util.List;
import java.util.Arrays;

public class EonsSpathicephalusEntity extends EonsAmphibianEntity implements IEonsPredator {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(3, false, EonsDiet.EonsPreyType.ALL, null, null);

    // *** Constructors ***
    
    /** */
    public EonsSpathicephalusEntity(final EntityType<? extends EonsAmphibianEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }
    
    // *** Methods ***

    @Override
    /** */
    public void tick() {
        super.tick();
        predatorTick(this, 20, 10);
    }

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    /** */
    protected void registerGoals() {
        super.registerGoals();
        //this.goalSelector.addGoal(2, new EonsFightTargetGoal(this, 3, 1.25F, false, 5));
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 1));
    }
}