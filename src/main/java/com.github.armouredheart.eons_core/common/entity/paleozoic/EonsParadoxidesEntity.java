// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes; 
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.api.IEonsAnimationState;
import com.github.armouredheart.eons_core.client.EonsAnimationState;

// misc imports

public class EonsParadoxidesEntity extends EonsAmphibianEntity {
    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(4, false, null);

    // *** Constructors ***

    /** */
    public EonsParadoxidesEntity(final EntityType<? extends EonsAmphibianEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
        this.baseMoistness = 600;
    }

    // *** Methods ***

    /** */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, this.getSpeed()));
    }

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return EonsSounds.CRACK;
    }
    
    /** */
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {this.playSound(EonsSounds.MARINE_ARTHROPOD_CRAWLING, 1.0F, 1.0F);}

}