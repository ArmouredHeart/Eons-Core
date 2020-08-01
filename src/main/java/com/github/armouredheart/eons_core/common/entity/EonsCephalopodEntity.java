// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.EonsGroupFishEntity;

// misc imports

public class EonsCephalopodEntity extends EonsGroupFishEntity {
    // *** Attributes ***

    // *** Constructors ***
    public EonsCephalopodEntity(final EntityType<? extends EonsCephalopodEntity> type, final World world, final EonsFieldNotes fieldNotes) {
        super(type, world, fieldNotes);
    }

    // *** Methods ***

    /** */
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
    }

    /**
    * Called when the entity is attacked.
    */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        // 
        if (super.attackEntityFrom(source, amount) && this.getRevengeTarget() != null) {
            this.squirtInk();
            return true;
        } else {
            return false;
        }
    }

    /** Pulled from squid class */
    private void squirtInk() {
        this.playSound(SoundEvents.ENTITY_SQUID_SQUIRT, this.getSoundVolume(), this.getSoundPitch());
        /*Vec3d vec3d = this.getTilt(new Vec3d(0.0D, -1.0D, 0.0D)).add(this.posX, this.posY, this.posZ);
        for(int i = 0; i < 30; ++i) {
            Vec3d vec3d1 = this.getTilt(new Vec3d((double)this.rand.nextFloat() * 0.6D - 0.3D, -1.0D, (double)this.rand.nextFloat() * 0.6D - 0.3D));
            Vec3d vec3d2 = vec3d1.scale(0.3D + (double)(this.rand.nextFloat() * 2.0F));
            ((ServerWorld)this.world).spawnParticle(ParticleTypes.SQUID_INK, vec3d.x, vec3d.y + 0.5D, vec3d.z, 0, vec3d2.x, vec3d2.y, vec3d2.z, (double)0.1F);
        }*/
    }

    /** */
    private Vec3d getTilt(Vec3d tilt) {
      Vec3d vec3d = tilt.rotatePitch(this.rotationPitch * ((float)Math.PI / 180F));
      vec3d = vec3d.rotateYaw(-this.prevRenderYawOffset * ((float)Math.PI / 180F));
      return vec3d;
   }

}