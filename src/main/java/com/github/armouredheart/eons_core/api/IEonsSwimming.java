// package
package com.github.armouredheart.eons_core.api;

// Minecraft Imports
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;

// Forge imports

// Eons imports

// misc imports

public interface IEonsSwimming {

    // *** Methods ***

    /**
     * 
     * @param <E> extends LivingEntity & IEonsSwimming
     * @param entity <E>
     */
    public static <E extends LivingEntity & IEonsSwimming> void SwimTick(E entity) {
        updateAir(entity);
        
    }

    public static <E extends LivingEntity & IEonsSwimming> void updateAir(E entity) {
        int air = entity.getAir();
        if (entity.isAlive() && !entity.isInWaterOrBubbleColumn()) {
            entity.setAir(air - 1);
            if (entity.getAir() == -20) {
                entity.setAir(0);
                entity.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            entity.setAir(300);
        }
    }
    
}