// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.LivingEntity;

// Forge imports

// Eons imports

// misc imports
import javax.annotation.Nullable;

public interface IEonsSexuallyDimorphic {
    
    // *** Methods ***

    /** */
    public static <E extends LivingEntity & IEonsSexuallyDimorphic> void assignSex(E creature, int sexRatio) {
        if(sexRatio < 0) {
            // sexless, set to unisex
            creature.setUnisex();
        } else {
            // randomise sex based on input ratio
            int roll = creature.world.rand.nextInt(100);
            if(sexRatio < roll) {
                creature.setMale();
            } else {
                creature.setFemale();
            }
        }
    }

    /** Returns true if entity is of opposite sex or if this entity is unisex. */
    default boolean isOppositeSex(IEonsSexuallyDimorphic entity) {return (this.isMale() && entity.isFemale()) || (this.isFemale() && entity.isMale()) || (!this.isMale() && !this.isFemale());}

    /** */
    default boolean isMale() {return this.getSexByteData() == (byte) 1;}

    /** */
    default boolean isFemale() {return this.getSexByteData() == (byte) 2;}

    /** */
    default void setUnisex() {this.setSexByteData((byte) 0);}

    /** */
    default void setMale() {this.setSexByteData((byte) 1);}

    /** */
    default void setFemale() {this.setSexByteData((byte) 2);}

    /** */
    public byte getSexByteData();

    /** */
    public void setSexByteData(byte data);

}