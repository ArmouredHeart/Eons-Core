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
import com.github.armouredheart.eons_core.api.IEonsMob;

// misc imports
import java.util.List;
import javax.annotation.Nullable;

public interface IEonsBeast extends IEonsMob {

    // *** Attributes ***
    public static final int MAX_RESOLVE = 100;
    public static final int MIN_RESOLVE = 1;
    public static final int DEFAULT_RESOLVE = 60;
    public static final int DEFAULT_HEALING_TIME = 30;

    // *** Methods ***

    /**
     * 
     * @param beast_entity
     */
    public static <T extends LivingEntity & IEonsBeast> void doBeastTick(T beast_entity) {
        beast_entity.getStomach().stomachTick();
    }

    /**
     * @param entity
     * @return [currentHP, maxHP]
     */
    public static double[] getHealthStatus(LivingEntity entity) {
        return new double[] {entity.getHealth(), entity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getValue()};
    }

    /**
     * @param <T> extends LivingEntity & IEonsBeast
     * @param entity
     * @return true if test passed, false if test failed
     */
    public static <T extends LivingEntity & IEonsBeast> boolean testResolve(T entity) {
        double[] hp = IEonsBeast.getHealthStatus(entity);
        int status = (int)(hp[0]/hp[1]*IEonsBeast.MAX_RESOLVE);
        if(status < IEonsBeast.MIN_RESOLVE) {return false;}
        if(status > IEonsBeast.MAX_RESOLVE) {return true;}
        int resolve = entity.getResolve();
        return status > resolve;
    }

    /** */
    public static int computeThreat(LivingEntity entity) {
        double[] hp = IEonsBeast.getHealthStatus(entity);
        double attack = 0;
        try {
            attack = entity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        } catch(Exception e) {
            // entity does not have attack stat
        }
        //TODO - make this more robust
        return (int)(hp[0]*(attack+1));
    }

    /**
     * Call this when beast is resting to heal its wounds.
     * @param beast extends LivingEntity & IEonsBeast
     * @param seconds healing time in seconds
     * @return Returns false if too hungry to heal.
     */
    public static <T extends LivingEntity & IEonsBeast> boolean setRested(T beast, int seconds) {
        if(!beast.getStomach().isHungry()) {
            // give regeneration effect
            beast.addPotionEffect(new EffectInstance(Effects.REGENERATION, 20 * seconds, 0, false, false));
            return true;
        }
        return false;
    }

    /**
     * Call this when beast is resting to heal its wounds for default healing time @Link{DEFAULT_HEALING_TIME} seconds.
     * @param beast extends LivingEntity & IEonsBeast
     * @return Returns false if too hungry to heal.
     */
    public static <T extends LivingEntity & IEonsBeast> boolean setRested(T beast) {
        return setRested(beast, DEFAULT_HEALING_TIME);
    }

    /** @return integer value between 1 and 100. Higher is better. */
    default public int getResolve() {return IEonsBeast.DEFAULT_RESOLVE;}

    /** */
    default public boolean isBadCondition() {return false;}

    /** */
    public Stomach getStomach();

}
    