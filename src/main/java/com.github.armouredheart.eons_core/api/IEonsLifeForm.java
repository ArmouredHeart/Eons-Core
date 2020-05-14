// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public interface IEonsLifeForm {

    // *** Methods ***

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    public EonsFieldNotes getFieldNotes();
}