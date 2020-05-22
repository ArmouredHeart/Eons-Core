// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.CreatureEntity;

// Forge imports
import net.minecraftforge.common.extensions.IForgeEntity;

// Eons imports

// misc imports

public interface IEonsFlocking<T extends CreatureEntity & IEonsFlocking>{

    // *** Attributes ***

    // *** Methods ***
    public T getGroupLeader();
    public boolean hasGroupLeader();
    public boolean isGroupLeader();
    public boolean canGroupGrow();
    public boolean inRangeOfGroupLeader();
    public void leaveGroup();
    public int getGroupSize();
    public int getMaxGroupSize();

    public void increaseGroupSize();
    public void decreaseGroupSize();
    public void setGroupLeader(T newLeader);
}