// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public interface IEonsLifeForm {

    protected final static EonsFieldNotes fieldNotes; // pointer to educational notes about lifeform

    // *** Methods ***

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    protected EonsFieldNotes getFieldNotes();
}