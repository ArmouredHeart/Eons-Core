// package
package eons_core.common;

// Forge imports

// Eons imports
import eons_core.common.EonsEra;
import eons_core.common.EonsTemper;
import eons_core.api.IEonsFieldNotes;
// misc imports

public class EonsFieldNotes implements IEonsFieldNotes {
    // *** Attributes ***
    // taxanomy in format: [domain, kingdom, phylum, taxaClass, order, family, genus, species]
    protected String[] taxanomy;
    protected String clade;
    protected String biography;
    protected EonsEra era;
    protected EonsTemper temper;

    // *** Contructors ***

    /** domain, kingdom, phylum, taxaClass, order, family, genus, species*/
    public EonsFieldNotes(String domain, String kingdom, String phylum, String taxaClass, String order, String family,
        String genus, String species, String biography, EonsEra era, EonsTemper temper){
        //

        //
        this.taxanomy = new String[]{domain, kingdom, phylum, taxaClass, order, family, genus, species};
        this.biography = biography;
    }

    /** */
    public EonsFieldNotes(String[] taxanomy, String clade, String biography, EonsEra era, EonsTemper temper){
        this.taxanomy = taxanomy;
        this.clade = clade;
        this.biography = biography;
    }

    // *** Methods ***

    /** */
    public String[] getTaxanomy(){
        return this.taxanomy;
    }

    /** */
    public String getClade(){
        return this.clade;
    }

    /** */
    public String getBiography(){
        return this.biography;
    }

    /** */
    public EonsEra getEra() {
        // TODO Auto-generated method stub
        return null;
    }

    /** */
    public EonsTemper getTemper() {
        // TODO Auto-generated method stub
        return null;
    }
}