// package
package eons_core.api;

// Forge imports
import eons_core.common.EonsEra;
import eons_core.common.EonsTemper;

// Eons imports

// misc imports

public interface IEonsFieldNotes {

    // *** Methods ***

    /** */
    public String[] getTaxanomy();

    /** */
    public String getClade();

    /** */
    public String getBiography();

    /** */
    public EonsEra getEra();

    /** */
    public EonsTemper getTemper();
}