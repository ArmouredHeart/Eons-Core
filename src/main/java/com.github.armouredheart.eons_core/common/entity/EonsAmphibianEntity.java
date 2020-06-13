// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.RestrictSunGoal;
import net.minecraft.entity.ai.goal.FindWaterGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsGoToWaterGoal;
import com.github.armouredheart.eons_core.api.IEonsMoistness;
import com.github.armouredheart.eons_core.common.entity.ai.EonsEatBerriesGoal;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsAmphibianEntity extends EonsBeastEntity implements IEonsMoistness {
    // *** Attributes ***
    private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(EonsAmphibianEntity.class, DataSerializers.VARINT);
    protected int baseMoistness;

    // *** Constructors ***
    protected EonsAmphibianEntity(final EntityType<? extends EonsBeastEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, int sexRatio, boolean isNocturnal) {
        super(type, world, fieldNotes, diet, sexRatio, isNocturnal);
        this.baseMoistness = 2400;
    }
    
    // *** Methods ***

    /** */
    @Override
    public boolean isPushedByWater() {return false;}

    /** */
    protected void registerAttributes() {
        super.registerAttributes();
    }

    /** */
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new EonsGoToWaterGoal(this, this.getSpeed(), 48));
        this.goalSelector.addGoal(5, new RestrictSunGoal(this));
    }

    /** */
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setMoistness(this.baseMoistness);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    public void tick() {
        super.tick();
        if (!this.isAIDisabled()) {
            //check how much moistness to remove
            //normally moistness is only lost while in direct sunlight, but high temperature will dry out faster even in shade!
            if (this.isInWaterRainOrBubbleColumn()) {this.setMoistness(this.baseMoistness);} 
            else  
            if (this.isInDaylight()) {
                this.dryOut(1);
                if (this.getLocalTemperature() > 0.95F) {this.dryOut(2);}
            }

            // dryout damage
            if (this.getMoistness() <= 0) {this.attackEntityFrom(DamageSource.DRYOUT, 1.0F);}
        }
    }

    /** */
    protected void dryOut(int points){
        this.setMoistness(this.getMoistness() - points);
    }

    /** */
    @Override
    public boolean canBreatheUnderwater() {return true;}

    /** */
    @Override
    public CreatureAttribute getCreatureAttribute() {return CreatureAttribute.WATER;}

    /** */
    public int getMoistness() {return this.dataManager.get(MOISTNESS);}

    /** */
    public void setMoistness(int moistness) {this.dataManager.set(MOISTNESS, moistness);}

    /** */
    protected void registerData() {
        super.registerData();
        this.dataManager.register(MOISTNESS, this.baseMoistness);
    }

    /** */
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Moistness", this.getMoistness());
    }

    /** */
    public boolean isDryingOut() {int moist = this.getMoistness(); return moist < 600;}
}