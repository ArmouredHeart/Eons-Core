// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextMainCatagory;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextModifier;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextSubCatagory;

// misc imports
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public enum Geon {
    // EONS
    HADEAN (null, 4600, 4031),
    ARCHEAN (null, 4031 ,2420),
    PROTEROZOIC (null, 2420, 541),
    PHANEROZOIC (null, 541, 0),

    // ERAS
    CHAOTIAN (HADEAN, 4600, 4404),
    ZIRCONIAN (HADEAN, 4404, 4031),
    PALEOARCHEAN (ARCHEAN, 4031, 3490),
    MESOARCHEAN (ARCHEAN, 3490, 2780),
    NEOARCHEAN (ARCHEAN, 2780, 2420),
    PALEOPROTEROZOIC (PROTEROZOIC, 2420, 1780),
    MESOPROTEROZOIC (PROTEROZOIC, 1780, 850),
    NEOPROTEROZOIC (PROTEROZOIC, 850, 541),
    PALEOZOIC (PHANEROZOIC, 541, 251.902),
    MESOZOIC (PHANEROZOIC, 251.902, 66),
    CENOZOIC (PHANEROZOIC, 66, 0),

    // PERIODS
    ACASTIAN(PALEOARCHEAN, 4031, 3810),
    ISUAN (PALEOARCHEAN, 3810, 3490),
    VAALBARAN (MESOARCHEAN, 3490, 3020),
    PONGOLAN (MESOARCHEAN, 3020, 2780),
    METHANIAN (NEOARCHEAN, 2780, 2630),
    SIDERIAN (NEOARCHEAN, 2630, 2420),
    OXYGENIAN (PALEOPROTEROZOIC, 2420, 2250),
    EUKAYIAN (OXYGENIAN, 2250, 2060),
    COLUMBIAN (OXYGENIAN, 2060, 1780),
    RODINIAN (MESOPROTEROZOIC, 1780, 850),
    CRYOGENIAN (NEOPROTEROZOIC, 850, 630), // very cold!
    EDIACARAN (NEOPROTEROZOIC, 630, 541),
    CAMBRIAN (PALEOZOIC, 541, 485.4), // explosion!
    ORDOVICIAN (PALEOZOIC, 485.4, 443.8), 
    SILURIAN (PALEOZOIC, 443.8, 419.2),
    DEVONIAN (PALEOZOIC, 419.2, 358.9), // age of fishes!
    CARBONIFEROUS (PALEOZOIC, 358.9, 298.9), // age of insects!
    PERMIAN (PALEOZOIC, 298.9, 251.902),
    TRIASSIC (MESOZOIC, 251.902, 201.3), // age of dinosaurs!
    JURASSIC (MESOZOIC, 201.3, 145),
    CRETACEOUS (MESOZOIC, 145, 66),
    PALEOGENE (CENOZOIC, 66, 23.03), // age of mammals!
    NEOGENE (CENOZOIC, 23.03, 2.58),
    QUATERNARY (CENOZOIC, 2.58, 0),
    TODAY(CENOZOIC, 0.0, 0);

    // *** Attributes ***
    private final double START_TIME;
    private final double END_TIME;
    private final Geon PARENT_GEON;

    // *** Constructors ***

    /**
     * @param start_time double when geon started in millions of years ago.
     * @param parent_geon parent geon, null if has no parent
     * @param end_time double when geon ended in millions of years ago.
     */
    private Geon(final @Nullable Geon parent_geon, final double start_time, final double end_time) {
        this.PARENT_GEON = parent_geon;
        this.START_TIME = start_time;
        this.END_TIME = end_time;
    }

    // *** Methods ***

    /**@return double[start, end] in millions of years ago. (inclusive)*/
    public double[] getTemporalRange() {return new double[]{this.START_TIME, this.END_TIME};}

    /**@return string name of geon.*/
    public String getName() {return super.toString();}

    /**@return TranslationTextComponent description of geon*/
    public TranslationTextComponent getLocalisedDescription() {
        return EonsResourceHelper.getLocalisedText(ResourceTextMainCatagory.EDUCATION, ResourceTextSubCatagory.GEON, this.getName().toLowerCase(), ResourceTextModifier.DESC);
    }

    /**@return List parents in order [Period, Era, Eon] */
    public List<Geon> getFullRange() {
        List<Geon> range = new ArrayList<>();
        return getFullRangeRecursive(range);
    }   

    /** recursive helper method */
    private List<Geon> getFullRangeRecursive(List<Geon> range) {
        range.add(this);
        if(this.PARENT_GEON == null) {return range;} else {return this.PARENT_GEON.getFullRangeRecursive(range);}
    }
}
