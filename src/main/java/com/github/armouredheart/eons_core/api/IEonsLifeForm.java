// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsFieldNotes;

// misc imports

public interface IEonsLifeForm {

    // *** Methods ***

    /** @return EonsFieldNotes object containing educational notes about lifeform.*/
    public EonsFieldNotes getFieldNotes();

    /** @return returns true if notes can be added to journal.*/
    public static boolean addNotesToJournal(IEonsLifeForm lifeForm, PlayerEntity player, Hand hand) {
        /**TODO implement this interaction*/
        return false;
    }
}