// package
package com.github.armouredheart.eons_core.common.block;

// Minecraft imports
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.Block;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.EonsFieldNotes;

// misc imports

public class EonsFossilBlock extends Block {

    // *** Attributes ***
    private final EonsFieldNotes fieldNotes;

    // *** Constructors ***

    /** */
    protected EonsFossilBlock(Block.Properties properties, EonsFieldNotes fieldNotes) {
        super(properties);
        this.fieldNotes = fieldNotes;
    }

    // *** Methods ***

    /** */
    public EonsFieldNotes getFieldNotes() {
        return this.fieldNotes;
    }



}