// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import java.util.List;
import java.util.ArrayList;
import javax.annotation.Nullable;

public interface IEonsPredator<P extends MobEntity & IEonsPredator<P>> extends IEonsBeast {
    // *** Methods ***

    /** Call this every tick in a predator. */
    default void predatorTick(P predator, double scanRangeX, double scanRangeY) {
        if(predator.getDiet().isHungry()){scanForPreyTarget(predator, scanRangeX, scanRangeY);}
    }

    /** 
    * @return true if prey target is found
    * TODO Not elegant, can be improved in the future
    */
    default boolean scanForPreyTarget(P predator, double scanRangeX, double scanRangeY) {
        List<Entity> entities = predator.world.getEntitiesInAABBexcluding(predator, predator.getBoundingBox().grow(scanRangeX, scanRangeY, scanRangeX), null);
        List<LivingEntity> living = new ArrayList<>();
        for(Entity entity : entities) {
            if(entity instanceof LivingEntity) {
                LivingEntity alive = (LivingEntity)entity;
                living.add(alive);
            }
        }
        LivingEntity prey = choosePreyTarget(predator, living);
        predator.setAttackTarget(prey);
        return predator.getAttackTarget() != null;
    }

    /** */
    default @Nullable LivingEntity choosePreyTarget(P predator, List<LivingEntity> creatures) {
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
                target = predator.getLeastThreatening(preyList);
            } else {
                target = null;
            }
        }
        return target;
    }
}