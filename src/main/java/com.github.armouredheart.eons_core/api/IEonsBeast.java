// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;
import com.github.armouredheart.eons_core.common.entity.ai.EonsDiet;
// misc imports

public interface IEonsBeast extends IEonsLifeForm {

    // *** Methods ***

    /** @return int Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
    public int getThreat();

    /** @return int Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
    public int getResolve();

    /** @return true when mob is wounded to the point that it must either win the fight or run away. */
    public boolean isWounded();

    /** */
    public void setRested();

    /** */
    public boolean isHungry();

    /** */
    public boolean isNocturnal();

    /** */
    public EonsDiet getDiet();
}
    