// package
package com.github.armouredheart.eons_core.api;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.api.IEonsLifeForm;

// misc imports

public interface IEonsBeast extends IEonsLifeForm{

    // *** Attributes ***
    protected final static int threatBoost;// how scary (or non-threatening) the beast is. Can be negative.
    protected final static EonsBeastPersonality personality;// assigned personality

    // *** Methods ***

    /** Calculated using remaining HP, Personality and Attack damage plus threatBoost.*/
    public int getThreat();

    /** Calculated using remaining HP and Personality reduced by threat of opponent(s).*/
    protected int getResolve();

    /** */
    protected boolean isHungry();

    /** */
    protected boolean isEnraged();

    /** */
    protected setEnraged();

    /** */
    protected setCalm();

    /** */
    protected boolean resolveCheck(int threat);

    /** Checks if beast becomes enraged.*/
    protected boolean rageCheck();

    /** Checks if beast calms down.*/
    protected boolean calmCheck();
}