// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.MobEntity;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsMob;
// misc imports

public interface IEonsMoistness extends IEonsMob {

    // *** Attributes ***
    public static final int DEFAULT_BASE_MOISTNESS = 2400;
    public static final float DEFAULT_HIGH_TEMPERATURE = 0.95F;
    // *** Methods ***

    public static <T extends MobEntity & IEonsMoistness> void moistureTick(T moist_entity, boolean in_daylight, int base_moistness) {
        if (!moist_entity.isAIDisabled()) {
            int damage_points = 0;
            //check how much moistness to remove
            if (moist_entity.isInWaterRainOrBubbleColumn()) {
                moist_entity.setMoistness(base_moistness); // restore moistness to full
            } else if (in_daylight) {
                damage_points++;
            }
            //normally moistness is only lost while in direct sunlight, but high temperature will dry out faster even in shade!
            if (IEonsMob.getLocalTemperature(moist_entity) > IEonsMoistness.DEFAULT_HIGH_TEMPERATURE) {
                damage_points++;
            }
            // do the dryout
            moist_entity.setMoistness(moist_entity.getMoistness() - damage_points);

            // dryout damage
            if (moist_entity.getMoistness() < 1) {moist_entity.attackEntityFrom(DamageSource.DRYOUT, 1.0F);}
        }
    }

    public static <T extends MobEntity & IEonsMoistness> void registerMoistureData(EntityDataManager data_manager) {
        
    }

    public static <T extends MobEntity & IEonsMoistness> boolean isDryingOut(T moist_entity, int base_moistness) {
        return (moist_entity.getMoistness() < (int)(base_moistness/3));
    }

    public int getMoistness();
    public void setMoistness(int moistness);
    public boolean isDryingOut();
}