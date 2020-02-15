// package
package main.java.eons_core.common.entity;

// Forge imports
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;

// Eons imports
import main.java.eons_core.api.IEonsFieldNotes;

// misc imports

public abstract class AbstractEonsGroupFishEntity extends AbstractGroupFishEntity implements IEonsFieldNotes {

	public AbstractEonsGroupFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World worldIn) {
		super(type, worldIn);
		//TODO Auto-generated constructor stub
	}

    // *** Methods ***

}