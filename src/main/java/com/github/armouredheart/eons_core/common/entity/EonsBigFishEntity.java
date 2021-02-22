// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
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
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.api.IEonsAnimationEntity;
import com.github.armouredheart.eons_core.api.Species;
import com.github.armouredheart.eons_core.api.Stomach;
import com.github.armouredheart.eons_core.api.Diet;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBigFishEntity extends AbstractFishEntity implements IEonsBeast, IEonsLifeForm, IEonsSexuallyDimorphic, IEonsAnimationEntity {
    // *** Attributes ***
    // DATA
    private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);

    private static final EonsAnimationHandler ANIMATION_HANDLER = new EonsAnimationHandler();
    private final Species SPECIES;
    private final Stomach STOMACH;

    // *** Constructors ***

    /**
    * @param type
    * @param world
    * @param species
    * @param diet
    * @param sexRatio
    * @param isNocturnal
    */
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final Species species) {
        super(type, world);
        this.SPECIES = species;
        this.STOMACH = new Stomach(this.SPECIES);
        this.setCanPickUpLoot(true);
        IEonsSexuallyDimorphic.assignSexByRatio(this, this.SPECIES);
    }

    // *** Methods ***

    /** */
    @Override
    public void tick() {
        super.tick();

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
    }

    /** */
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		return super.processInteract(player, hand);
	}

    /** */
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    public Species getSpecies(){return this.SPECIES;}

    /** */
    @Override
    protected SoundEvent getFlopSound() {return null;}

    /** */
    @Override
    protected SoundEvent getSwimSound() {return SoundEvents.ENTITY_DOLPHIN_SWIM;}

    /** */
	@Override
	protected ItemStack getFishBucket() {return null;}

    /** */
    public Stomach getStomach() {return this.STOMACH;}

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
    public EonsAnimationHandler getAnimationHandler() {return EonsBigFishEntity.ANIMATION_HANDLER;}

    public EntityDataManager getEntityDataManager() {return this.dataManager;}
    public DataParameter<Byte> getSexParameter() {return EonsBigFishEntity.SEX;}
}