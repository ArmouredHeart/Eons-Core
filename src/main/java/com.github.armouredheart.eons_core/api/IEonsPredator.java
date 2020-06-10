// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.EntityPredicates;
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
import java.util.function.Predicate;

public interface IEonsPredator extends IEonsBeast {

    // *** Methods ***

    /** 
    * @return true if prey target is found
    * TODO Not elegant, can be improved in the future
    */
    default <P extends MobEntity & IEonsPredator> boolean scanForPreyTarget(P predator, double boundingBoxX, double boundingBoxY) {
        List<Entity> entities = predator.world.getEntitiesInAABBexcluding(predator, predator.getBoundingBox().grow(boundingBoxX, boundingBoxY, boundingBoxX), null);
        List<LivingEntity> living = new ArrayList<>();
        for(Entity entity : entities) {
            if(entity instanceof LivingEntity) {
                LivingEntity alive = (LivingEntity)entity;
                living.add(alive);
            }
        }
        predator.setAttackTarget(choosePreyTarget(predator, living));
        return predator.getAttackTarget() != null;
    }

    /** */
    default <P extends MobEntity & IEonsPredator> @Nullable LivingEntity choosePreyTarget(P predator, List<LivingEntity> creatures) {
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