// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.common.entity.EonsAmphibianEntity;

// misc imports

public class EonsParadoxidesEntity extends EonsAmphibianEntity {
    // *** Attributes ***

    // *** Constructors ***

    /** */
    public EonsParadoxidesEntity(final EntityType<? extends EonsAmphibianEntity> type, final World world) {
        super(type, world, Species.PARADOXIDES, 600);
    }

    // *** Methods ***


    @Override
    protected SoundEvent getDeathSound() {
        return EonsSounds.CRACK;
    }
    
    /** */
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {this.playSound(EonsSounds.MARINE_ARTHROPOD_CRAWLING, 1.0F, 1.0F);}

}