// package
package com.github.armouredheart.eons_core.api;

// Minecraft imports
import net.minecraft.util.text.TranslationTextComponent;

// Forge imports

// Eons imports
import com.github.armouredheart.eons_core.EonsCore;
import com.github.armouredheart.eons_core.api.Habitat;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextMainCatagory;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextModifier;
import com.github.armouredheart.eons_core.api.EonsResourceHelper.ResourceTextSubCatagory;
import com.github.armouredheart.eons_core.api.EonsResourceHelper;

// misc imports

/** @apiNote this enumerator is used as a lookup table for all species related 
 * information in this mod, including the automatic assignment of ai to mobs 
 * and texture resource lookup.*/
public enum Species {
    TIKTAALIK(
        buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.CHORDATA, "", "", ""),
        new String[] {EonsClade.STEGOCEPHALIA.toString()},
        new Geon[] {Geon.DEVONIAN},
        new Habitat[] {},
        new Behaviour[] {},
        new int[] {}
    ),
    ANOMALOCARIS(
        buildTaxanomy(EonsDomain.EUKARYOTA, EonsKingdom.ANIMALIA, EonsPhylum.ARTHROPODA, EonsClass.DINOCARIDIDA.toString(), "RADIODONTA", "ANOMALOCARIDIDAE"),
        new String[] {EonsClade.NOT_DEFINED.toString()},
        new Geon[] {Geon.CAMBRIAN}, 
        new Habitat[] {}, 
        new Behaviour[] {Behaviour.PREDATOR, Behaviour.AGGRESSIVE},
        new int[] {}
    );

    //
    private final String[] TAXANOMY;
    private final Geon[] PERIODS;
    private final String[] CLADES;
    private final Habitat[] HABITATS;
    private final Behaviour[] BEHAVIOURS;
    private final int[] EGG_COLOURS;

    //

    /**
     * @param taxanomy
     * @param clades
     * @param periods
     * @param habitats
     * @param behaviours
     */
    private Species(String[] taxanomy, String[] clades, Geon[] periods, Habitat[] habitats, Behaviour[] behaviours, int[] egg_colours) {
        this.TAXANOMY = taxanomy;
        this.CLADES = clades;
        this.PERIODS = periods;
        this.HABITATS = habitats;
        this.BEHAVIOURS = behaviours;
        this.EGG_COLOURS = egg_colours;
    }

    /**
     * @param domain
     * @param kingdom
     * @param phylum
     * @param taxaClass
     * @param order
     * @param family
     */
    private static String[] buildTaxanomy(EonsDomain domain, EonsKingdom kingdom, EonsPhylum phylum, String taxaClass, String order, String family) {
        return new String[] {domain.toString(), kingdom.toString(), phylum.toString(), taxaClass, order, family};
    }

    // *** Methods ***

    public String[] getTaxanomy() {return this.TAXANOMY;}

    public TranslationTextComponent getLocalisedName() {
        return EonsResourceHelper.getLocalisedText(ResourceTextMainCatagory.EDUCATION, ResourceTextSubCatagory.SPECIES, super.toString());
    }

    public TranslationTextComponent getLocalisedBiography() {
        return EonsResourceHelper.getLocalisedText(ResourceTextMainCatagory.EDUCATION, ResourceTextSubCatagory.SPECIES, super.toString(), ResourceTextModifier.BIOGRAPHY);
    }

    // taxonomy enumerators - these are just to help cut down on repeated string typing for common taxa 
    public enum EonsDomain {
        BACTERIA,
        ARCHAEA,
        EUKARYOTA;
    }

    public enum EonsKingdom {
        ANIMALIA,
        PLANTAE,
        FUNGI,
        PROTISTA;
    }

    public enum EonsPhylum {
        ARTHROPODA,
        CHORDATA;
    }

    public enum EonsClass {
        MAMMALIA,
        DINOCARIDIDA;
    }

    public enum EonsClade {
        DINOCARIDIDA,
        DINOSAURIA,
        THEROPODA,
        SAURISCHIA,
        STEGOCEPHALIA,
        NOT_DEFINED;
    }
}
