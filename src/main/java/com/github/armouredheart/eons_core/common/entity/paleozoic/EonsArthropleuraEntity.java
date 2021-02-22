// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBigBeastEntity;
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.common.entity.EonsBeastPartEntity;

// misc imports

public class EonsArthropleuraEntity extends EonsBigBeastEntity {

    // *** Attributes ***

    // *** Constructors ***
    public EonsArthropleuraEntity(final EntityType<? extends EonsBigBeastEntity> type, final World world) {
        super(type, world, Species.ARTHROPLEURA);
        this.addPart(new EonsBeastPartEntity<EonsArthropleuraEntity>(this, "head", 2.0F, 1.0F));
        this.addPart(new EonsBeastPartEntity<EonsArthropleuraEntity>(this, "tail", 2.0F, 1.0F));
    }

    // *** Methods ***

}