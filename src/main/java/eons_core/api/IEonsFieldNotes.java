// package
package eons_core.api;

// Forge imports

// Eons imports

// misc imports

public interface IEonsFieldNotes {

    // *** Methods ***

    /** */
    public String[] getTaxanomy();

    /** */
    public String[] getClade();

    /** */
    public String getBiography();

    /** */
    public EonsEra getEra();

    /** */
    public EonsEra getTemper();
}