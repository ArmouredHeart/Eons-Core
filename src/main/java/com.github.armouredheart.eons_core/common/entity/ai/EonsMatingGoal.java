// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.passive.AnimalEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;

// misc imports

public class EonsMatingGoal<B extends AnimalEntity & IEonsSexuallyDimorphic> extends BreedGoal {

    // *** Attributes ***
    private final boolean layEggs;

    // *** Constructors ***

    /** 
    * @param beast
    * @param speed
    * @param layEggs
    */
    public EonsMatingGoal(B beast, double speed, boolean layEggs) {
        super(beast, speed);
        this.layEggs = layEggs;
    }

    // *** Methods ***

    /**
    * Spawns a baby animal of the same type.
    */
    @Override
    protected void spawnBaby() {
        if(this.layEggs) {
            // do egg laying 
        } else {
            super.spawnBaby();
        }
    }
}