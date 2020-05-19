// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;

// misc imports

public interface IEonsBeast extends IEonsLifeForm {

    // *** Methods ***

    /** Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
    public int getThreat();

    /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
    public int getResolve();
}
    