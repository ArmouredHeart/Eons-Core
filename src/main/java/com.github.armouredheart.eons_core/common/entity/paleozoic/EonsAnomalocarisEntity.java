// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
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
import com.github.armouredheart.eons_core.common.entity.paleozoic.EonsParadoxidesEntity;
import com.github.armouredheart.eons_core.common.entity.ai.EonsFightTargetGoal;
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.init.EonsEntityTypes;
import com.github.armouredheart.eons_core.common.entity.EonsBigFishEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes; 
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.client.EonsAnimationState;
import com.github.armouredheart.eons_core.api.IEonsPredator;

// misc imports
import java.util.Arrays;
import java.util.List;

public class EonsAnomalocarisEntity extends EonsBigFishEntity implements IEonsPredator {
    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final List<Class<? extends LivingEntity>> favouritePrey = Arrays.asList(EonsParadoxidesEntity.class);
    private static final EonsDiet DIET = new EonsDiet(5, false, EonsDiet.EonsPreyType.WATER, favouritePrey, null);

    // *** Constructors ***
    
    /** */
    public EonsAnomalocarisEntity(final EntityType<? extends EonsBigFishEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }   

    // *** Methods ***

    /** */
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new EonsFightTargetGoal(this, 5, 1.25F, false, 5));
    }

    @Override
    /** */
    public void tick() {
        super.tick();
        predatorTick(this, 20, 20);
    }

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return EonsSounds.CRACK;
    }
}