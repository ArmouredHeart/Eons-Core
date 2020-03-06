// package
package com.github.armouredheart.eons_core.common.entity;

// Minecraft imports
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;

// misc imports

public abstract class EonsGroupFishEntity extends AbstractGroupFishEntity implements IEonsLifeForm {

	// *** Attributes ***

	// *** Constructors ***

	/** */
	public AbstractEonsGroupFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World world) {
		super(type, world);
		//TODO Auto-generated constructor stub
	}

    // *** Methods ***

}