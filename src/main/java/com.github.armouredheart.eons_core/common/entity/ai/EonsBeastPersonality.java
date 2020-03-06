// package
package com.github.armouredheart.eons_core.common.entity.ai;

// Forge imports

// Eons imports

// misc imports

public enum EonsBeastPersonality {
    // Main Personality types
    TIMID (0.6, 1.0, 10),
    CAUTIOUS (0.8, 1.1, 10),
    RELAXED (1.0, 1.2, 10),
    BRAZEN (1.2, 1.3, 10),
    FEARLESS (1.4, 1.4, 10);

    // *** Attributes ***
    private double resolveFactor;
    private double threatFactor;
    private int rageFactor;
    
    // *** Constructors ***

    /** */
    private EonsBeastPersonality(double resolveFactor, double threatFactor, int rageFactor){
        this.resolveFactor = resolveFactor;
        this.threatFactor = threatFactor;
    }

    // *** Methods ***

    /** */
    public double getResolveFactor() {
        return resolveFactor;
    }

    /** */
    public double getThreatFactor() {
        return threatFactor;
    }

    /** */
    public int getRageFactor() {
        return rageFactor;
    }
}