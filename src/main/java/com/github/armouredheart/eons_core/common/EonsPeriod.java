// package
package com.github.armouredheart.eons_core.common;

// Forge imports

// Eons imports

// misc imports

public enum EonsPeriod {
    // PALEOZOIC periods
    CAMBRIAN ("PALEOZOIC", 541, 485.4),
    ORDOVICIAN ("PALEOZOIC", 485.4, 443.8),
    SILURIAN ("PALEOZOIC", 443.8, 419.2),
    DEVONIAN ("PALEOZOIC", 419.2, 358.9),
    CARBONIFEROUS ("PALEOZOIC", 358.9, 298.9),
    PERMIAN ("PALEOZOIC", 298.9, 251.902),
    // MESOZOIC periods
    TRIASSIC ("MESOZOIC", 251.902, 201.3),
    JURASSIC ("MESOZOIC", 201.3, 145),
    CRETACEOUS ("MESOZOIC", 145, 66),
    // CENOZOIC periods
    PALEOGENE ("CENOZOIC", 66, 23.03),
    NEOGENE ("CENOZOIC", 23.03, 2.58),
    QUATERNARY ("CENOZOIC", 2.58, 0);

    // *** Attributes ***
    private final String era;
    private final double start;
    private final double end;

    // *** Constructors ***

    /**
     * @param era String name of Era period belongs in.
     * @param start double when period started in millions of years ago.
     * @param end double when period ended in millions of years ago.
     */
    private EonsPeriod(final String era, final double start, final double end) {
        this.era = era;
        this.start = start;
        this.end = end;
    }

    // *** Methods ***

    /**@return double[start, end] in millions of years ago.*/
    public double[] getTemporalRange(){
        return new double[]{this.start, this.end};
    }

    /**@return String name of Era that this period belongs in.*/
    public String getEraName(){
        return this.era;
    }
}