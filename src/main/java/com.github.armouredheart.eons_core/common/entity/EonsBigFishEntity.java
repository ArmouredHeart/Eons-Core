// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
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
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;

// Forge imports
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
import com.github.armouredheart.eons_core.common.entity.ai.EonsSex;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsBigFishEntity extends AbstractFishEntity implements IEonsLifeForm, IEonsSexuallyDimorphic {
    // *** Attributes ***
    private EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
    private EonsSex sex;
    private final EonsDiet diet;
    private final int sexRatio;
    private final boolean isNocturnal;

    // *** Constructors ***

    /**
    * @param type
    * @param world
    * @param fieldNotes
    * @param diet
    * @param sexRatio
    * @param isNocturnal
    */
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final EonsFieldNotes fieldNotes, final EonsDiet diet, final int sexRatio, final boolean isNocturnal) {
        super(type, world);
        this.diet = diet;
        this.sexRatio = sexRatio;
        this.isNocturnal = isNocturnal;
    }

    /** */
    protected EonsBigFishEntity(final EntityType<? extends AbstractFishEntity> type, final World world, final EonsFieldNotes fieldNotes) {
        this(type, world, fieldNotes, new EonsDiet(false, null), 50, false);
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
        this.sex = new EonsSex(this, sexRatio);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    /** */
    public EonsFieldNotes getFieldNotes(){return fieldNotes;}

    /** */
    public boolean isMale() {return this.sex.isMale();}

    /** */
    public boolean isFemale() {return this.sex.isFemale();}

    /** */
    @Override
    protected SoundEvent getFlopSound() {return null;}

    /** */
    @Override
    protected SoundEvent getSwimSound() {return null;}

    /** */
	@Override
	protected ItemStack getFishBucket() {return null;}

}