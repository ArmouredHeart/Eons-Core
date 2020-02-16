// package
package eons_core.api;

// Forge imports
import eons_core.common.EonsPeriod;

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
    public EonsPeriod getPeriod();
}