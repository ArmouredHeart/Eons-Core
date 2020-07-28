// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;

// Forge imports

// Eons imports

// misc imports

public interface IEonsToxic {
    // *** Attributes ***

    // *** Methods ***

    /** */
    public static <T extends LivingEntity & IEonsToxic> boolean tryPoisonEntity(T toxicEntity, LivingEntity target, int toxicity) {
        if(toxicity < 1) {return false;} else {
            if (target.attackEntityFrom(DamageSource.causeMobDamage(toxicEntity), (float)(2))) {
                target.addPotionEffect(new EffectInstance(Effects.POISON, 60 * toxicity, 0));
                return true;
            } else {
                return false;
            }
        }
    }
}