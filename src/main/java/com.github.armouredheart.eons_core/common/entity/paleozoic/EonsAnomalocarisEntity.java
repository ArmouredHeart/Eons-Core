// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
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
import com.github.armouredheart.eons_core.common.entity.EonsBigFishEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes; 
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.client.EonsAnimationState;

// misc imports

public class EonsAnomalocarisEntity extends EonsBigFishEntity {
    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(4, false, null);

    // *** Constructors ***
    
    /** */
    public EonsAnomalocarisEntity(final EntityType<? extends EonsBigFishEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
    }

    // *** Methods ***

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return EonsSounds.CRACK;
    }
}