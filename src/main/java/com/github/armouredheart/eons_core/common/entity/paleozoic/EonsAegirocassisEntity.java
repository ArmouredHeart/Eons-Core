// package
package com.github.armouredheart.eons_core.common.entity.paleozoic;

// Minecraft imports
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.entity.EonsBeastEntity;
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public class EonsAegirocassisEntity extends EonsBeastEntity {

    public EonsAegirocassisEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world, Species.AEGIROCASSIS);
    }
}