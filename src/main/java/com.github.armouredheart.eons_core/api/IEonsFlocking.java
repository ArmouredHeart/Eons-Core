// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.CreatureEntity;

// Forge imports
import net.minecraftforge.common.extensions.IForgeEntity;

// Eons imports

// misc imports
import javax.annotation.Nullable;

public interface IEonsFlocking<T extends CreatureEntity & IEonsFlocking> {
    // *** Methods ***
    
    /** */
    default boolean canGroupGrow() {return this.getGroupSize() < this.getMaxGroupSize();}

    /** */
    default void leaveGroup() {this.setGroupSize(0); this.setGroupLeader(null);}

    /** Use this instead of `setGroupSize`. */
    default void increaseGroupSize() {
        int size = this.getGroupSize();
        int maxSize = this.getMaxGroupSize();
        if(size < maxSize) {
            this.setGroupSize(size + 1);
        } else {
            this.setGroupSize(maxSize);
        }
    }

    /** Use this instead of `setGroupSize`. */
    default void decreaseGroupSize() {
        int size = this.getGroupSize();
        if(size > 0) {
            this.setGroupSize(size - 1);
        } else {
            this.setGroupSize(0);
        }
    }

    public @Nullable T getGroupLeader();
    public boolean hasGroupLeader();
    public boolean isGroupLeader();
    public boolean inRangeOfGroupLeader();
    public int getGroupSize();
    public int setGroupSize(int size);
    public int getMaxGroupSize();
    public void setGroupLeader(@Nullable T newLeader);
}