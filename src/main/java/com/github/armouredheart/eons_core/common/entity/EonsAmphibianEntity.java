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
import com.github.armouredheart.eons_core.common.entity.ai.EonsGoToWaterGoal;
import com.github.armouredheart.eons_core.api.IEonsMoistness;
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.common.entity.ai.EonsEatBerriesGoal;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsAmphibianEntity extends EonsBeastEntity implements IEonsMoistness {
    // *** Attributes ***
    private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(EonsAmphibianEntity.class, DataSerializers.VARINT);
    protected final int BASE_MOISTNESS;

    // *** Constructors ***

    /**
     * custom moistness
     * @param type
     * @param world
     * @param species
     * @param base_moistness
     */
    protected EonsAmphibianEntity(final EntityType<? extends EonsBeastEntity> type, final World world, final Species species, final int base_moistness) {
        super(type, world, species);
        this.BASE_MOISTNESS = base_moistness;
    }

    /**
     * default
     * @param type
     * @param world
     * @param species
     */
    protected EonsAmphibianEntity(final EntityType<? extends EonsBeastEntity> type, final World world, final Species species) {
        this(type, world, species, IEonsMoistness.DEFAULT_BASE_MOISTNESS);
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
        this.goalSelector.addGoal(0, new EonsGoToWaterGoal<EonsAmphibianEntity>(this, 1.0F, 48));
    }

    /** */
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setMoistness(this.BASE_MOISTNESS);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    public void tick() {
        super.tick();
        IEonsMoistness.moistureTick(this, this.isInDaylight(), this.BASE_MOISTNESS);
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
        this.dataManager.register(MOISTNESS, this.BASE_MOISTNESS);
    }

    /** */
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Moistness", this.getMoistness());
    }

    @Override
    public boolean isDryingOut() {
        return IEonsMoistness.isDryingOut(this, this.BASE_MOISTNESS);
    }
}