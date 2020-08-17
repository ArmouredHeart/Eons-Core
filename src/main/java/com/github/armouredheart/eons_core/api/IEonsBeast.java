// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import java.util.List;
import javax.annotation.Nullable;

public interface IEonsBeast {

    // *** Attributes ***
    // modifiers 
    public static final int DEFAULT_HEALING_TIME = 30;
    public static final int GIANT_HEALTH = 80;
    public static final double WOUNDED_PERCENTAGE = 0.4;
    public static final double PREDATOR_THREAT_BONUS = 1.5;
    public static final double WOUNDED_RESOLVE_PENALTY = -0.5;
    public static final double HUNGRY_RESOLVE_PENALTY = 0.2;
    public static final double STARVING_RESOLVE_BONUS = 0.5;
    public static final double PROTECTING_YOUNG_RESOLVE_BONUS = 1.5;

    // *** Methods ***

    /** @return true if beast1 should run away from entity2, and false if it should not. */
    public static <T extends LivingEntity & IEonsBeast> boolean shouldRunAwayFrom(T beast, LivingEntity entity) {
        //TODO redo this
        return true;
    } 

    /** */
    public static <T extends LivingEntity & IEonsBeast> @Nullable LivingEntity getLeastThreatening(T beast, List<LivingEntity> entityList) {
        if(!entityList.isEmpty()) {
            EonsDiet diet = beast.getDiet();
            LivingEntity wimp = entityList.get(0);
            for(int i = 1; i < entityList.size(); i++) {
                if(computeModifiedThreat(beast, diet) > computeThreat(entityList.get(i))) {
                    wimp = entityList.get(i);
                }   
            }
            return wimp;
        } else {return null;}
    }

    public static <T extends LivingEntity & IEonsBeast> int computeModifiedThreat(T beast, EonsDiet diet) {
        double factor = 1;
        //TODO apply modifiers
        return (int) (computeThreat(beast) * factor); // casting to int rounds down by truncation
    }

    /** */
    public static int computeThreat(LivingEntity entity) {
        double threat = entity.getHealth();
        return (int) threat; 
    }

    /** @return true if beast1 holds thier groud or false if beast1 fails the check and should run away */
    public static <T extends LivingEntity & IEonsBeast> boolean resolveCheck(T beast, int threatRatio) {
        // if threatRatio is greater than 0, beast1 will not run away (because beast1 is more threatening than beast2)
        if(threatRatio > 0) {return true;} else {
            // perform a resolve check
            // resolve needs to be higher than the threat of the other beast to avoid running away
            return computeModifiedResolve(beast) > Math.abs(threatRatio);
        }   
    }
    
    /** */
    public static <T extends LivingEntity & IEonsBeast> int computeModifiedResolve(T beast) {
        double factor = 1;
        //TODO apply modifiers
        return (int) (computeThreat(beast) * factor); // casting to int rounds down by truncation
    }

    /** 
     * @param entity
     * @param minPercentHealth
     * @param badCondition
     * @return @return true when entity is below the minPercentHealth and in bad condition.
    */
    public static <T extends LivingEntity & IEonsBeast> boolean testForWounds(T entity, boolean badCondition) {
        return testForWounds(entity) && badCondition;
    }

    /** 
     * @param entity
     * @param minPercentHealth
     * @return true when entity is below the minPercentHealth.
    */
    public static boolean testForWounds(LivingEntity entity) {
        double maxHP = entity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getValue();
        double currentHP = entity.getHealth();
        if(maxHP < GIANT_HEALTH) {
            return ((double) currentHP/maxHP) < WOUNDED_PERCENTAGE; // normal mob health range
        } else {
            return currentHP < GIANT_HEALTH * WOUNDED_PERCENTAGE/2; // min hp cap for giant mobs with loads of hp
        }
        
    }

    /** @return true when mob is wounded to the point that it must either win the fight or run away. Default is below 40% hp. */
    public static boolean isWounded(LivingEntity entity) {
        if(entity instanceof IEonsBeast) {
            return IEonsBeast.testForWounds(entity);
        } else {
            return IEonsBeast.testForWounds(entity);
        }   
        
    }

    /**
     * Call this when beast is resting to beast it heal its wounds.
     * @param beast extends LivingEntity & IEonsBeast
     * @param seconds healing time in seconds
     * @return Returns false if too hungry to heal.
     */
    public static <T extends LivingEntity & IEonsBeast> boolean setRested(T beast, int seconds) {
        if(!beast.getDiet().isHungry()) {
            // give regeneration effect
            beast.addPotionEffect(new EffectInstance(Effects.REGENERATION, 20 * seconds, 0, false, false));
            return true;
        } else {return false;}
    }

    /**
     * Call this when beast is resting to beast it heal its wounds for default healing time @Link{DEFAULT_HEALING_TIME} seconds.
     * @param beast extends LivingEntity & IEonsBeast
     * @return Returns false if too hungry to heal.
     */
    public static <T extends LivingEntity & IEonsBeast> boolean setRested(T beast) {
        return setRested(beast, DEFAULT_HEALING_TIME);
    }

    /** */
    public boolean isNocturnal();

    /** Most cases will be false, override in beasts that can be enraged. */
    default boolean isEnraged() {return false;}

    /** */
    public EonsDiet getDiet();

    /** */
    default public boolean isBadCondition() {return false;}

    /** Most cases will be false, override in beasts that protect thier young. */
    default boolean isProtectingYoung() {return false;}

    /** Most cases will be 0, override in beasts that can have allies. */
    default int getBackup() {return 0;}
}
    