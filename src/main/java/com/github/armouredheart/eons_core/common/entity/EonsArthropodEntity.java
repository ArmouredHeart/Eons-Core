// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;
import com.github.armouredheart.eons_core.common.entity.ai.EonsGoToWaterGoal;
import com.github.armouredheart.eons_core.api.IEonsMoistness;
import com.github.armouredheart.eons_core.api.IEonsArthropod;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports

public abstract class EonsArthropodEntity extends EonsAmphibianEntity implements IEonsArthropod {
    // *** Attributes ***

    // *** Constructors ***

    /** */
    protected EonsArthropodEntity(final EntityType<? extends EonsBeastEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, int sexRatio, boolean isNocturnal) {
        super(type, world, fieldNotes, diet, sexRatio, isNocturnal);
        this.baseMoistness = 1200;
    }

    // *** Methods ***

    // *** Inner Classes ***

    /** Baby arthrpods must stay in water */
    public class EonsArthropodGoToWaterGoal<T extends CreatureEntity & IEonsMoistness, IEonsArthropod> extends EonsGoToWaterGoal {
        
        // *** Constructors ***

        /** */
        EonsArthropodGoToWaterGoal(T creature, double speed, int searchLength) {
            super(creature, speed, searchLength);
        }

        // *** Methods ***

        /** */
        @Override
        public boolean shouldExecute() {
            if(!this.creature.isInWater()){
                return this.creature.isChild();
            } else {return false;}
        }
    }

}