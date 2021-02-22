// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.datasync.DataParameter;

// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Eons imports
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;
import com.github.armouredheart.eons_core.api.IEonsAnimationEntity;
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.Species;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsGroupFishEntity extends AbstractGroupFishEntity implements IEonsLifeForm, IEonsSexuallyDimorphic, IEonsAnimationEntity {

	// *** Attributes ***
	// DATA 
	private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);

	private final EonsAnimationHandler ANIMATION_HANDLER;
	private final Species SPECIES; // pointer to educational notes about lifeform

	// *** Constructors ***

	/**
    * @param type
    * @param world
    * @param species
    * @param sexRatio
    */
	protected EonsGroupFishEntity(final EntityType<? extends AbstractGroupFishEntity> type, final World world, final Species species) {
		super(type, world);
		this.SPECIES = species;
		IEonsSexuallyDimorphic.assignSexByRatio(this, this.SPECIES);
		this.ANIMATION_HANDLER = new EonsAnimationHandler();
	}

    // *** Methods ***
	
	/** */
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		return super.processInteract(player, hand);
	}

	/** */
	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected ItemStack getFishBucket(){return null;}

	/** */
    public Species getSpecies(){return this.SPECIES;}

	@Override
    protected SoundEvent getAmbientSound() {return null;}

    @Override
    protected SoundEvent getDeathSound() {return null;}

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return null;}

    @Override
    protected SoundEvent getFlopSound() {return SoundEvents.ENTITY_SALMON_FLOP;}

	@Override
    protected void registerData() {
        super.registerData();
        IEonsSexuallyDimorphic.registerSexData(this);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        // entity data
        IEonsSexuallyDimorphic.writeSexToNBT(this, compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        // entity data
        IEonsSexuallyDimorphic.readSexFromNBT(this, compound);
    }

	/** */
	@Override
	public EonsAnimationHandler getAnimationHandler() {return this.ANIMATION_HANDLER;}
	
	public EntityDataManager getEntityDataManager() {return this.dataManager;}
	public DataParameter<Byte> getSexParameter() {return EonsGroupFishEntity.SEX;}

}