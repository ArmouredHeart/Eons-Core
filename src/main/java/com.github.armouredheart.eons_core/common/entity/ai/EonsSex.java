// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Minecraft imports
import net.minecraft.entity.LivingEntity;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsSexuallyDimorphic;

// misc imports

public class EonsSex<E extends LivingEntity, IEonsSexuallyDimorphic> {
    // *** Attributes ***
    private boolean isMale;
    private boolean isFemale;

    // *** Constructors ***
    
    /** */
    public EonsSex(E livingEntity, int sexRatio) {
        if(sexRatio < 0) {
            this.isMale = false;
            this.isFemale = false;
        } else {
            int roll = livingEntity.world.rand.nextInt(100);
            if(sexRatio < roll) {
                setMale();
            } else {
                setFemale();
            }
        }
    }

    // *** Methods ***

    /** */
    public boolean isMale() {return this.isMale;}

    /** */
    public boolean isFemale() {return this.isFemale;}

    /** */
    public void setMale() {this.isMale = true;this.isFemale = false;}

    /** */
    public void setFemale() {this.isMale = false;this.isFemale = true;}
}
