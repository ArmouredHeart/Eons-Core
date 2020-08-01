// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
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
import com.github.armouredheart.eons_core.init.EonsSounds;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.api.IEonsToxic;

// misc imports

public abstract class EonsJellyfishEntity extends EonsGroupFishEntity implements IEonsToxic{

    // *** Attributes ***
    private final int toxicity;

    // *** Constructors ***

    /** @param toxicity value of 0 is non-toxic, and 1 is equal to a puffer fish. Bigger number, longer poison effect */
    protected EonsJellyfishEntity(EntityType<? extends  EonsGroupFishEntity> type, World world, EonsFieldNotes fieldNotes, final int sexRatio, final int toxicity) {
        super(type, world, fieldNotes, sexRatio);
        this.toxicity = toxicity;
    }

    // *** Methods ***

    /** */
    private void attack(MobEntity mobEntity) {
        if(IEonsToxic.tryPoisonEntity(this, mobEntity, this.toxicity)) {
            this.playStingEffect(); 
        }
    }

    /**
    * Called by a player entity when they collide with an entity
    */
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        if (entityIn instanceof ServerPlayerEntity && IEonsToxic.tryPoisonEntity(this, entityIn, this.toxicity)){
            this.playStingEffect();
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
    protected void playStingEffect() {this.playSound(EonsSounds.ZAP, 1.0F, 1.0F);}
}