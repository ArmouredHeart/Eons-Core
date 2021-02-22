// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.goal.GoalSelector;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.Species;

// misc imports
import javax.annotation.Nonnull;

/** @apiNote this is used to automatically build standardised ai loadouts to reduce 
 * the work needed for each mob. */
public interface EonsAIBuilder {

    public static <T extends MobEntity & IEonsBeast> void registerAttributes(T entity) {
        double[] species_attributes = entity.getSpecies().getAttributes();
        for(int i = 0; i < species_attributes.length; i++) {
            if(species_attributes[i] > 0) {
                entity.getAttribute(Species.SPECIES_ATTRIBUTE_MAP[i]).setBaseValue(species_attributes[i]);
            }
        }
    }
    
    public static <T extends LivingEntity & IEonsBeast> GoalSelector registerEonsGoals(@Nonnull Behaviour[] behaviours, @Nonnull GoalSelector goal_selector) {
        for(int i = 0; i < behaviours.length; i++) {
            switch(behaviours[i]) {
                case PREDATOR: {
                    break;
                }
                case HERBIVORE: {
                    break;
                }
                case SCAVENGER: {
                    break;
                }
                default: {break;}
            }
        }
        return goal_selector;
    }
    
    // *** Enumerators ***

    public enum Behaviour {
        // predator mob ai
        PREDATOR,
        
        // herbivore mob ai
        HERBIVORE,
        
        // scavenger
        SCAVENGER,
        
        // temperments
        COWARD, // will try to run away
        AGGRESSIVE, // will attack if given opportunity
        PASSIVE, // will never attack
        DEFENSIVE, // will attack if threatened
        
        // not mobs
        PLANT,
        MUSHROOM;
    }
}
