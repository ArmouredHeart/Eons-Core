// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;

// misc imports
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;



public class EonsFieldNotes {
    // *** Attributes ***
    // taxanomy in format: [domain, kingdom, phylum, taxaClass, order, family, genus, species]
    private final String[] TAXANOMY;
    private final String CLADE;
    private final TranslationTextComponent BIOGRAPHY;
    private final Geon[] PERIODS;
    private final EonsHabitat[] HABITATS;

    // *** Contructors ***

    /** 
     * @param domain
     * @param kingdom
     * @param phylum
     * @param taxaClass
     * @param order
     * @param family
     * @param genus
     * @param species
     * @param clade
     * @param biography
     * @param periods
     * */
    public EonsFieldNotes(String domain, String kingdom, String phylum, String taxaClass, String order, String family,
        String genus, String species, String clade, TranslationTextComponent biography, Geon[] periods, EonsHabitat[] habitats){
        this(new String[]{domain, kingdom, phylum, taxaClass, order, family, genus, species}, clade, biography, periods, habitats);
    }

    /** */
    public EonsFieldNotes(String[] taxanomy, String clade, TranslationTextComponent biography, Geon[] periods, EonsHabitat[] habitats){
        this.TAXANOMY = taxanomy;
        this.CLADE = clade;
        this.BIOGRAPHY = biography;
        this.PERIODS = periods;
        this.HABITATS = habitats;
    }

    // *** Methods ***

    /** */
    public String[] getTaxanomy(){return this.TAXANOMY;}

    /** */
    public String getClade(){return this.CLADE;}

    /** */
    public TranslationTextComponent getBiography(){return this.BIOGRAPHY;}

    /** */
    public Geon[] getPeriods() {return this.PERIODS;}

    /** */
    public EonsHabitat[] getHabitats() {return this.HABITATS;}

    // *** Inner Classes ***

    /** */
    public enum EonsHabitat {
        ;
        // *** Attributes ***
        // *** Contructors ***
        private EonsHabitat() {

        }
        // *** Methods ***
    }

    /** */
    public enum Geon {
        // EONS
        HADEAN ("HADEAN", null, 4600, 4031),
        ARCHEAN ("ARCHEAN", null, 4031 ,2420),
        PROTEROZOIC ("PROTEROZOIC", null, 2420, 541),
        PHANEROZOIC ("PHANEROZOIC", null, 541, 0),

        // ERAS
        CHAOTIAN ("CHAOTIAN", HADEAN, 4600, 4404),
        ZIRCONIAN ("ZIRCONIAN", HADEAN, 4404, 4031),
        PALEOARCHEAN ("PALEOARCHEAN", ARCHEAN, 4031, 3490),
        MESOARCHEAN ("MESOARCHEAN", ARCHEAN, 3490, 2780),
        NEOARCHEAN ("NEOARCH", ARCHEAN, 2780, 2420),
        PALEOPROTEROZOIC ("PALEOPROTEROZOIC", PROTEROZOIC, 2420, 1780),
        MESOPROTEROZOIC ("MESOPROTEROZOIC", PROTEROZOIC, 1780, 850),
        NEOPROTEROZOIC ("NEOPROTEROZOIC", PROTEROZOIC, 850, 541),
        PALEOZOIC ("PALEOZOIC", PHANEROZOIC, 541, 251.902),
        MESOZOIC ("MESOZOIC", PHANEROZOIC, 251.902, 66),
        CENOZOIC ("CENOZOIC", PHANEROZOIC, 66, 0),

        // PERIODS
        ACASTIAN("ACASTIAN", PALEOARCHEAN, 4031, 3810),
        ISUAN ("ISUAN", PALEOARCHEAN, 3810, 3490),
        VAALBARAN ("VAALBARAN", MESOARCHEAN, 3490, 3020),
        PONGOLAN ("PONGOLAN", MESOARCHEAN, 3020, 2780),
        METHANIAN ("METHANIAN", NEOARCHEAN, 2780, 2630),
        SIDERIAN ("SIDERIAN", NEOARCHEAN, 2630, 2420),
        OXYGENIAN ("OXYGENIAN", PALEOPROTEROZOIC, 2420, 2250),
        EUKAYIAN ("EUKAYIAN", OXYGENIAN, 2250, 2060),
        COLUMBIAN ("COLUMBIAN", OXYGENIAN, 2060, 1780),
        RODINIAN ("RODINIAN", MESOPROTEROZOIC, 1780, 850),
        CRYOGENIAN ("CRYOGENIAN", NEOPROTEROZOIC, 850, 630),
        EDIACARAN ("EDIACARAN", NEOPROTEROZOIC, 630, 541),
        CAMBRIAN ("CAMBRIAN", PALEOZOIC, 541, 485.4), // explosion!
        ORDOVICIAN ("ORDOVICIAN", PALEOZOIC, 485.4, 443.8), 
        SILURIAN ("SILURIAN", PALEOZOIC, 443.8, 419.2),
        DEVONIAN ("DEVONIAN", PALEOZOIC, 419.2, 358.9), // age of fishes!
        CARBONIFEROUS ("CARBONIFEROUS", PALEOZOIC, 358.9, 298.9), // age of insects!
        PERMIAN ("PERMIAN", PALEOZOIC, 298.9, 251.902),
        TRIASSIC ("TRIASSIC", MESOZOIC, 251.902, 201.3), // age of dinosaurs!
        JURASSIC ("JURASSIC", MESOZOIC, 201.3, 145),
        CRETACEOUS ("CRETACEOUS", MESOZOIC, 145, 66),
        PALEOGENE ("PALEOGENE", CENOZOIC, 66, 23.03), // age of mammals!
        NEOGENE ("NEOGENE", CENOZOIC, 23.03, 2.58),
        QUATERNARY ("QUATERNARY", CENOZOIC, 2.58, 0); // modern day!
    
        // *** Attributes ***
        private final String NAME;
        private final double START_TIME;
        private final double END_TIME;
        private final Geon PARENT_GEON;
    
        // *** Constructors ***
    
        /**
         * @param name String name of geon
         * @param start_time double when geon started in millions of years ago.
         * @param parent_geon parent geon, null if has no parent
         * @param end_time double when geon ended in millions of years ago.
         */
        private Geon(final String name, final @Nullable Geon parent_geon, final double start_time, final double end_time) {
            this.NAME = name;
            this.PARENT_GEON = parent_geon;
            this.START_TIME = start_time;
            this.END_TIME = end_time;
        }
    
        // *** Methods ***
    
        /**@return double[start, end] in millions of years ago.*/
        public double[] getTemporalRange() {return new double[]{this.START_TIME, this.END_TIME};}
    
        /**@return TranslationTextComponent name of geon.*/
        public String getName() {return this.NAME;}

        /**@return TranslationTextComponent description of geon*/
        public TranslationTextComponent getDescription() {return new TranslationTextComponent("education." + EonsCore.MOD_ID + ".geon." + this.NAME.toLowerCase() + "desc");}

        /** @return List parents in order [Period, Era, Eon] */
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

}