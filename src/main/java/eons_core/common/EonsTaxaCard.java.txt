// package
package eons_core;

// Forge imports

// Eons imports

// misc imports

public class EonsTaxaCard {
    // *** Attributes ***
    private String[] taxa;

    private String description;

    // *** Contructors ***

    /** */
    public EonsTaxaCard(String domain, String kingdom, String phylum, String Eclass, String order, String family,
        String genus, String species, String description){
        //
        this.taxa = new String[]{domain, kingdom, phylum, Eclass, order, family, genus, species};
        this.description = description;
    }

    // *** Methods ***

    /** */
    public String[] getTaxanomy(){
        return this.taxa;
    }

    /** */
    public String getDescription(){
        return this.description;
    }
}