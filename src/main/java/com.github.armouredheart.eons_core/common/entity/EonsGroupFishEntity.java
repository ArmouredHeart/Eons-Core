// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.ItemStack;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public abstract class EonsGroupFishEntity extends AbstractGroupFishEntity implements IEonsLifeForm, IEonsSexuallyDimorphic {

	// *** Attributes ***
	private EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform
	private boolean isMale = true;

	// *** Constructors ***

	/** */
	public EonsGroupFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World world, EonsFieldNotes fieldNotes) {
		super(type, world);
		//TODO Auto-generated constructor stub
	}

    // *** Methods ***

	/** */
	@Override
	protected SoundEvent getFlopSound(){return null;}

	@Override
	protected ItemStack getFishBucket(){return null;}

	/** */
    public EonsFieldNotes getFieldNotes(){return fieldNotes;}

	/** */
	public boolean isMale() {return isMale;}

	/** */
	public boolean isFemale() {return !isMale;}
}