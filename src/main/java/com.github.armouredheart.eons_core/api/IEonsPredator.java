// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Nullable;

public interface IEonsPredator {

    // *** Methods ***

    /** */
    public static <P extends IEonsPredator, B extends IEonsPredator & IEonsBeast> @Nullable LivingEntity choosePreyTarget(P predator, List<LivingEntity> creatures) {
        List<LivingEntity> preyList = new ArrayList<>();
        LivingEntity target = null;
        EonsDiet diet = predator.getDiet();
        if(diet.isPredator()) {
            // add preferred prey items
            if(diet.hasFavouredPrey()) {
                // 
                for(LivingEntity creature : creatures) {
                    if(diet.isFavouredPrey(creature)) {
                        preyList.add(creature);
                    }
                }
            }

            // add acceptable prey items
            if(preyList.isEmpty()) {
                for(LivingEntity creature : creatures) {
                    if(diet.isAcceptablePrey(creature)) {
                        preyList.add(creature);
                    }
                }
            }

            if(!preyList.isEmpty()) {
                // predator extends IEonsBeast?
                if(predator instanceof IEonsBeast) {
                    B beast = (B) predator;
                    target = IEonsBeast.getLeastThreatening(beast, preyList);
                } else {
                    // otherwise just pick the first entity in the array
                    target = preyList.get(0);
                }
            } else {
                target = null;
            }
        }
        return target;
    }

    /** */
    public EonsDiet getDiet();
}