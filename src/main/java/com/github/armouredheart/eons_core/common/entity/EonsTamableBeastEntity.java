// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsAnimationHandler;
import com.github.armouredheart.eons_core.api.EonsFieldNotes;
import com.github.armouredheart.eons_core.api.IEonsAnimationEntity;
import com.github.armouredheart.eons_core.api.IEonsBeast;
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;

// misc imports

public abstract class EonsTamableBeastEntity extends TameableEntity implements IEonsBeast, IEonsLifeForm, IEonsSexuallyDimorphic, IEonsAnimationEntity {
    
    // *** Attributes ***
    // data
    private static final DataParameter<Byte> SEX = EntityDataManager.createKey(EonsBeastEntity.class, DataSerializers.BYTE);
    private static final EonsAnimationHandler ANIMATION_HANDLER = new EonsAnimationHandler();
    private final EonsDiet DIET;
    private final boolean IS_NOCTURNAL;
    private final EonsFieldNotes FIELD_NOTES;


    // *** Constructors ***


    protected EonsTamableBeastEntity(EntityType<? extends TameableEntity> type, World worldIn, final EonsFieldNotes fieldNotes, final EonsDiet diet, final int sexRatio, final boolean isNocturnal) {
        super(type, worldIn);
        this.FIELD_NOTES = fieldNotes;
        this.DIET = diet;
        this.IS_NOCTURNAL = isNocturnal;
        this.setCanPickUpLoot(true);
        IEonsSexuallyDimorphic.assignSexByRatio(this, sexRatio);
    }

    // *** Methods ***

    /** */
    @Override
    public void tick() {
        super.tick();
        this.DIET.dietTick();
    } 

    /** */
    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        IEonsLifeForm.addNotesToJournal(this, player, hand);
        return super.processInteract(player, hand);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return this.DIET.isBreedingItem(stack);
    }

    /** */
	@Override
    public EonsAnimationHandler getAnimationHandler() {return EonsTamableBeastEntity.ANIMATION_HANDLER;}

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

    public EntityDataManager getEntityDataManager() {return this.dataManager;}
    public DataParameter<Byte> getSexParameter() {return EonsTamableBeastEntity.SEX;}


}