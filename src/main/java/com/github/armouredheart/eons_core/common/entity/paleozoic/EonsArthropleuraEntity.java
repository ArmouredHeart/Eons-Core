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
import com.github.armouredheart.eons_core.common.entity.EonsBigBeastEntity;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.common.entity.EonsBeastPartEntity;

// misc imports

public class EonsArthropleuraEntity extends EonsBigBeastEntity {

    // *** Attributes ***
    private static final EonsFieldNotes FIELDNOTES = null;
    private static final EonsDiet DIET = new EonsDiet(10, false, null);

    // *** Constructors ***
    public EonsArthropleuraEntity(final EntityType<? extends EonsBigBeastEntity> type, final World world) {
        super(type, world, FIELDNOTES, DIET, 50, false);
        this.addPart(new EonsBeastPartEntity<EonsArthropleuraEntity>(this, "head", 2.0F, 1.0F));
        this.addPart(new EonsBeastPartEntity<EonsArthropleuraEntity>(this, "tail", 2.0F, 1.0F));
    }

    // *** Methods ***

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.ARTHROPOD;}

    /** */
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
    }

}