// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastMultiPartEntity;

// misc imports
import javax.annotation.Nullable;

public class EonsBeastPartEntity extends Entity{
    // *** Attributes ***
    private static final DataParameter<Integer> SHELL = EntityDataManager.createKey(EonsBeastPartEntity.class, DataSerializers.VARINT);
    private final EonsBeastMultiPartEntity beast;
    private final String partName;
    private final EntitySize size;
    private final int baseShell;
    private final int shellToughness;
    private boolean shellBroken;

    // *** Constructors ***

    /** */
    /*public EonsBeastPartEntity(EonsBeastMultiPartEntity beast, String partName, float width, float height) {
        EonsBeastPartEntity(beast, partName, width, height, 0, 1, false);
    }*/

    /** */
    /*
    public EonsBeastPartEntity(EonsBeastMultiPartEntity beast, String partName, float width, float height, int baseShell) {
        EonsBeastPartEntity(beast, partName, width, height, baseShell, 1, false);
    }*/

    /** */
    public EonsBeastPartEntity(EonsBeastMultiPartEntity beast, String partName, float width, float height, int baseShell, int shellToughness, boolean isBug) {
        super(beast.getType(), beast.world);
        this.size = EntitySize.flexible(width, height);
        this.recalculateSize();
        this.beast = beast;
        this.partName = partName;
        this.baseShell = baseShell;
        this.shellToughness = shellToughness;
        this.shellBroken = false;
    }

    // *** Methods ***

    /** */
    public int getShell() {return this.dataManager.get(SHELL);}

    /** */
    public void setShell(int shell) {this.dataManager.set(SHELL, shell);}

    /** */
    public void restoreShell() {this.setShell(this.baseShell);}

    /** */
    public String getPartName() {return partName;}

    /** */
    public EonsBeastMultiPartEntity getBeast() {return this.beast;}

    /** */
    protected void registerData() {
        this.dataManager.register(SHELL, this.baseShell);
    }

    /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
    protected void readAdditional(CompoundNBT compound) {}

    protected void writeAdditional(CompoundNBT compound) {
        compound.putInt("Shell", this.getShell());
    }

    /**
    * Returns true if other Entities should be prevented from moving through this Entity.
    */
    public boolean canBeCollidedWith() {return true;}

    /**
    * Called when the entity is attacked.
    */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        //
        if(!this.isInvulnerableTo(source)){
            // shell does not stop fire, magic, or unblockable damage
            if(this.getShell() > 0 && !source.isUnblockable() && !source.isFireDamage() && !source.isMagicDamage()){
                if(source.isExplosion()) {
                    // explosions shred shell
                    this.setShell(0);
                    
                } else if(amount > this.shellToughness){
                    // shell is only reduced if the damage caused is greater than the shellToughness of the shell
                    // default is 1.
                    this.setShell(this.getShell() - 1);
                }
                
                // should play shield broken effects
                if(this.isShellBroken() && !this.shellBroken){
                    this.shellBroken = true;
                    this.beast.setShellBroken();
                }

                // attack damage is nullified
                return this.beast.attackEntityFrom(source, 0.0F);
            } else {
                return this.beast.attackEntityFrom(source, amount);
            }

        } else {
            return false;
        }
    }

    /** */
    private boolean isShellBroken(){
        if(this.baseShell > 0 && !(this.getShell() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void playShellBrokenEffect() {

    }

    /** */
    private void sprayBlood() {

    }

    /**
    * Returns true if Entity argument is equal to this Entity
    */
    public boolean isEntityEqual(Entity entityIn) {
        return this == entityIn || this.beast == entityIn;
    }

    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }

    public EntitySize getSize(Pose poseIn) {
        return this.size;
    }

    /** */
    public boolean processInteract(PlayerEntity player, Hand hand) {
      return this.beast.processInteract(player, hand);
    }
}