// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
// misc imports

public interface IEonsBeast extends IEonsLifeForm {

    // *** Attributes ***
    // modifiers 
    public static final double predatorThreatBonus = 1.5;
    public static final double woundedResolvePenalty = -0.5;
    public static final double hungryResolveBonus = 0.2;
    public static final double starvingResolveBonus = 0.5;
    public static final double protectingYoungResolveBonus = 1.5;

    // *** Methods ***

    /** @return true if beast1 should run away from entity2, and false if it should not. */
    public static <T extends LivingEntity & IEonsBeast> boolean shouldRunAwayFrom(T beast1, LivingEntity entity2) {
        int threatRatio;
        double threat1 = beast1.getThreat();// get base threat
        EonsDiet diet1 = beast1.getDiet();
        double threat2;

        //
        if(entity2 instanceof IEonsBeast) {
            // get base threat
            T beast2 = (T) entity2;
            threat2 = beast2.getThreat();
            EonsDiet diet2 = beast2.getDiet();

            // account for predator-prey relationship
            if(diet1.isPredator() && !diet2.isPredator()) {threat1 = threat1*predatorThreatBonus;} 
            else if(!diet1.isPredator() && diet2.isPredator()) {threat2 = threat2*predatorThreatBonus;}

        } else {
            // the comparison is a little wonky with vanilla mobs, but it works
            if(diet1.isPredator()) {threat1 = threat1*predatorThreatBonus;}
            threat2 = computeVanillaMobThreat(entity2);
        }

        // positive integer if beast1 is more threatening than beast2, or negative if vice versa */
        threatRatio = (int)(threat1 - threat2);
        return !resolveCheck(beast1, threatRatio);
    }

    /** */
    public static int computeVanillaMobThreat(LivingEntity entity) {
        double threat = entity.getHealth() * entity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue() / entity.getAttribute(SharedMonsterAttributes.ATTACK_SPEED).getValue();
        return (int) threat; 
    }

    /** @return true if beast1 holds thier groud or false if beast1 fails the check and should run away */
    public static <T extends LivingEntity & IEonsBeast> boolean resolveCheck(T beast1, int threatRatio) {
        // if threatRatio is greater than 0, beast1 will not run away (because beast1 is more threatening than beast2)
        if(threatRatio > 0) {return true;} else {
            // perform a resolve check
            // resolve needs to be higher than the threat of the other beast to avoid running away
            return computeModifiedResolve(beast1) > Math.abs(threatRatio);
        }   
    }
    
    /** */
    public static <T extends LivingEntity & IEonsBeast> int computeModifiedResolve(T beast1) {
        // base resolve modifier and diet
        double resolveMod = 1.0D;
        EonsDiet diet = beast1.getDiet();

        // apply wounded penalty
        if(beast1.isWounded()) {resolveMod = resolveMod + woundedResolvePenalty;}

        // apply starving/hunger bonus (only applies to predators)
        if(diet.isStarving() && diet.isPredator()) {resolveMod = resolveMod + starvingResolveBonus;} 
        else if(diet.isHungry() && diet.isPredator()) {resolveMod = resolveMod + hungryResolveBonus;}
        
        // apply resolve bonus if protecting young
        if(beast1.isProtectingYoung()) {resolveMod = resolveMod + protectingYoungResolveBonus;}

        double resolve = beast1.getResolve() * resolveMod;
        return (int) resolve;
    }

    /** @return int Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
    public int getThreat();

    /** @return int Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
    public int getResolve();

    /** @return true when mob is wounded to the point that it must either win the fight or run away. */
    public boolean isWounded();

    /** */
    public void setRested();

    /** */
    public boolean isNocturnal();

    /** Most cases will be false, override in beasts that can be enraged. */
    default boolean isEnraged() {return false;}

    /** */
    public EonsDiet getDiet();

    /** Most cases will be false, override in beasts that protect thier young. */
    default boolean isProtectingYoung() {return false;}
}
    