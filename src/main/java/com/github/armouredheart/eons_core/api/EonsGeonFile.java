//package
package com.github.armouredheart.eons_core.api;

/**
 * @apiNote This exists purely to help automate resource lookup.
 */
public enum EonsGeonFile {
    // list of geon file names
    PALEOZOIC(),
    MESOZOIC(),
    CENOZOIC();

    // *** Attributes ***

    // *** Constructors ***
    private EonsGeonFile() {}

    // *** Methods ***

    @Override
    public String toString() {return super.toString().toLowerCase();}
}