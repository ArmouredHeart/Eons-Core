// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.ai.goal.GoalSelector;
// Forge imports

// Eons imports

// misc imports
import javax.annotation.Nullable;
import java.util.List;

public class EonsAiPresets {
    // *** Methods ***

    /** 
     * @param behaviours
    */
    public static boolean registerBehaviours(GoalSelector selector, List<Behaviour> behaviours) {
        boolean success = true;

        for(Behaviour behaviour : behaviours) {
            switch(behaviour) {
				default:{break;}
            }
        }

        return success;
    }

    /** */

    // *** Inner Classes ***

    /** */
    public enum Behaviour {
        
        ;
    
        // *** Attributes ***
        @Nullable private Behaviour[] behaviours;
    
        // *** Constructors ***
    
        /** */
        private Behaviour(@Nullable Behaviour[] behaviours) {
            this.behaviours = behaviours;
        }
    
        // *** Methods ***
    
        /** */
        public @Nullable Behaviour[] getBehaviours() {return this.behaviours;}

    }
}




