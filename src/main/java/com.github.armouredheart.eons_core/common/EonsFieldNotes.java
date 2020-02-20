// package
package com.github.armouredheart.eons_core.common;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.common.EonsPeriod;
import com.github.armouredheart.eons_core.api.IEonsFieldNotes;

// misc imports

public class EonsFieldNotes implements IEonsFieldNotes {
    // *** Attributes ***
    // taxanomy in format: [domain, kingdom, phylum, taxaClass, order, family, genus, species]
    protected String[] taxanomy;
    protected String clade;
    protected String biography;
    protected EonsPeriod period;

    // *** Contructors ***

    /** domain, kingdom, phylum, taxaClass, order, family, genus, species*/
    public EonsFieldNotes(String domain, String kingdom, String phylum, String taxaClass, String order, String family,
        String genus, String species, String biography, EonsPeriod period){
        //

        //
        this.taxanomy = new String[]{domain, kingdom, phylum, taxaClass, order, family, genus, species};
        this.biography = biography;
    }

    /** */
    public EonsFieldNotes(String[] taxanomy, String clade, String biography, EonsPeriod period){
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
    public EonsPeriod getPeriod() {
        return this.period;
    }
}