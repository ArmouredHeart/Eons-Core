// package
package eons_core.common.entity.ai.attribute;

// Forge imports
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.IAttribute;

// Eons imports
import eons_core.common.EonsPeriod;

// misc imports
import javax.annotation.Nullable;

public abstract class EonsAttribute extends Attribute {

    // *** Variables ***

    // *** Constructor ***

    /** */
    protected EonsAttribute(@Nullable IAttribute parentIn, String unlocalizedNameIn, double defaultValueIn){
        super(parentIn, unlocalizedNameIn, defaultValueIn);
    }
    
    // *** Methods ***
}