// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsSwimming;
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;

// misc imports

public abstract class EonsAquaticBeastEntity extends EonsBeastEntity implements IEonsSwimming {

    // *** Attributes ***


    // *** Constructors ***

    /** */
    public EonsAquaticBeastEntity(EntityType<? extends EonsBeastEntity> type, World world, EonsFieldNotes fieldNotes) {
        super(type, world, fieldNotes);
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    // *** Methods ***

    @Override
    public boolean canBreatheUnderwater() {return true;}

    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.WATER;}

    @Override
    public boolean isNotColliding(IWorldReader worldIn) {return worldIn.checkNoEntityCollision(this);}

    /**
     * Gets called every tick from main Entity class
    */
    @Override
    public void baseTick() {
        super.baseTick();
        IEonsSwimming.SwimTick(this);
    }

    @Override
    public boolean isPushedByWater() {return false;}

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {return false;}
}