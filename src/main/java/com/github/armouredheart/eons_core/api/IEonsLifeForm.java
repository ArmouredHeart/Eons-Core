// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.Species;

// misc imports

public interface IEonsLifeForm {

    /** @return Species enumerator containing educational notes about lifeform.*/
    public Species getSpecies();
}