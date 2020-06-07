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
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.CompoundNBT;

// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsSex;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsGroupFishEntity extends AbstractGroupFishEntity implements IEonsLifeForm, IEonsSexuallyDimorphic {

	// *** Attributes ***
	private final EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
	private EonsSex sex;

	// *** Constructors ***

	/**
    * @param type
    * @param world
    * @param fieldNotes
    * @param sexRatio
    */
	protected EonsGroupFishEntity(final EntityType<? extends AbstractGroupFishEntity> type, final World world, final EonsFieldNotes fieldNotes, final int sexRatio) {
		super(type, world);
		this.fieldNotes = fieldNotes;
        this.sex = new EonsSex(this, sexRatio);
	}

	/** */
	protected EonsGroupFishEntity(final EntityType<? extends AbstractGroupFishEntity> type, final World world, final EonsFieldNotes fieldNotes) {
		this(type, world, fieldNotes, 50);
	}

    // *** Methods ***
	
	/** */
	@Override
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if(false) {
			//TODO collect field notes if holding notebook
		}
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
    public EonsFieldNotes getFieldNotes(){return fieldNotes;}

    /** */
    public boolean isMale() {return this.sex.isMale();}

    /** */
    public boolean isFemale() {return this.sex.isFemale();}

	@Override
    protected SoundEvent getAmbientSound() {return null;}

    @Override
    protected SoundEvent getDeathSound() {return null;}

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return null;}

    @Override
    protected SoundEvent getFlopSound() {return null;}

}