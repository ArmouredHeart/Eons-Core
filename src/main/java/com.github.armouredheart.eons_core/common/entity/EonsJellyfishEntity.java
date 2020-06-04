// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public abstract class EonsJellyfishEntity extends EonsGroupFishEntity {

    // *** Attributes ***
    private final int toxicity;

    // *** Constructors ***

    /** @param toxicity value of 0 is non-toxic, and 2 is equal to a puffer fish. Bigger number, longer poison effect */
    protected EonsJellyfishEntity(EntityType<? extends  EonsGroupFishEntity> type, World world, EonsFieldNotes fieldNotes, final int sexRatio, final int toxicity) {
        super(type, world, fieldNotes, sexRatio);
        this.toxicity = toxicity;
    }

    // *** Methods ***

    /** */
    private void attack(MobEntity mobEntity) {
        if(tryPoisonEntity(mobEntity)) {
            // do something here I guess? 
        }
    }

    /** */
    protected boolean tryPoisonEntity(LivingEntity livingEntity) {
        if(this.toxicity < 1) {return false;} else {
            if (livingEntity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(2))) {
                livingEntity.addPotionEffect(new EffectInstance(Effects.POISON, 30 * this.toxicity, 0));
                this.playStingEffect();
                return true;
            } else {
                return false;
            }
        }
    }

    /**
    * Called by a player entity when they collide with an entity
    */
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        if (entityIn instanceof ServerPlayerEntity && tryPoisonEntity(entityIn)){
            ((ServerPlayerEntity)entityIn).connection.sendPacket(new SChangeGameStatePacket(9, 0.0F));
        }
        super.onCollideWithPlayer(entityIn);
    }

    @Override
    protected SoundEvent getAmbientSound() {return null;}

    @Override
    protected SoundEvent getDeathSound() {return null;}

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return null;}

    @Override
    protected SoundEvent getFlopSound() {return null;}

    /** */
    protected void playStingEffect() {this.playSound(SoundEvents.ENTITY_PUFFER_FISH_STING, 1.0F, 1.0F);}
}